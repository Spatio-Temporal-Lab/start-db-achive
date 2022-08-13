/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.executor

import org.apache.calcite.sql.ddl.{SqlColumnExtendedDeclaration, SqlCreateTable}
import org.geotools.data.DataStoreFinder
import org.geotools.feature.simple.SimpleFeatureTypeBuilder
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.metadata.entity.{Field, Table}
import org.urbcomp.start.db.transformer.{RoadSegmentAndGeomesaTransformer, TrajectoryAndFeatureTransformer}
import org.urbcomp.start.db.util.{DataTypeUtils, MetadataUtil}

import scala.collection.mutable.ListBuffer

case class CreateTableExecutor(n: SqlCreateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val user = MetadataAccessUtil.getUser(userName)
    val db = MetadataAccessUtil.getDatabase(user.getId, dbName)
    val existedTable = MetadataAccessUtil.getTable(db.getId, tableName)
    if (existedTable != null) {
      if (n.ifNotExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table already exist " + tableName)
      }
    }

    var affectedRows = 0L
    MetadataAccessUtil.withRollback(
      _ => {
        affectedRows =
          MetadataAccessUtil.insertTable(new Table(0L /* unused */, db.getId, tableName, "hbase"))
        val createdTable = MetadataAccessUtil.getTable(db.getId, tableName)
        val tableId = createdTable.getId
        val sfb = new SimpleFeatureTypeBuilder
        val schemaName = MetadataUtil.makeSchemaName(tableId)
        sfb.setName(schemaName)

        val indices = new ListBuffer[String]()
        n.columnList.forEach(column => {
          val node = column.asInstanceOf[SqlColumnExtendedDeclaration]
          val name = node.name.names.get(0)
          val dataType = node.dataType.getTypeName.names.get(0)
          val classType = DataTypeUtils.getClass(dataType)
          val indexType = node.getIndexType
          if (DataTypeUtils.isGeometry(dataType)) {
            sfb.add(name, classType, 4326)
          } else {
            sfb.add(name, classType)
          }
          if (indexType != null) {
            indices += indexType.getIndexName + ",attr:name:" + name;
          }
          MetadataAccessUtil.insertField(new Field(0, tableId, name, dataType, 0))
        })

        val params = ExecutorUtil.getDataStoreParams(userName, dbName)
        val dataStore = DataStoreFinder.getDataStore(params)
        val schema = dataStore.getSchema(schemaName)
        if (schema != null) {
          throw new IllegalStateException("schema already exist " + schemaName)
        }

        var sft = sfb.buildFeatureType()
        sft = new TrajectoryAndFeatureTransformer().getGeoMesaSFT(sft)
        sft = new RoadSegmentAndGeomesaTransformer().getGeoMesaSFT(sft)

        // allow mixed geometry types for support start-db type `Geometry`
        sft.getUserData.put("geomesa.mixed.geometries", java.lang.Boolean.TRUE)
        indices.foreach(index => { sft.getUserData.put("geomesa.indices.enabled", index) })

        dataStore.createSchema(sft)
      },
      classOf[Exception]
    )

    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

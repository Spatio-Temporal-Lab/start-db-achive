/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.executor

import org.apache.calcite.sql.ddl.{SqlColumnDeclaration}
import org.geotools.data.DataStoreFinder
import org.geotools.feature.simple.SimpleFeatureTypeBuilder
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.metadata.entity.{Field, Table}
import org.urbcomp.cupid.db.parser.ddl.SqlCupidCreateTable
import org.urbcomp.cupid.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.cupid.db.util.{DataTypeUtils, MetadataUtil}

case class CreateTableExecutor(n: SqlCupidCreateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val db = MetadataAccessUtil.getDatabase(userName, dbName)
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

        n.columnList.forEach(column => {
          val node = column.asInstanceOf[SqlColumnDeclaration]
          val name = node.name.names.get(0)
          val dataType = node.dataType.getTypeName.names.get(0)
          val classType = DataTypeUtils.getClass(dataType)
          if (DataTypeUtils.isGeometry(dataType)) {
            sfb.add(name, classType, 4326)
          } else {
            sfb.add(name, classType)
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

        // allow mixed geometry types for support cupid-db type `Geometry`
        sft.getUserData.put("geomesa.mixed.geometries", java.lang.Boolean.TRUE)
        dataStore.createSchema(sft)
      },
      classOf[Exception]
    )

    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

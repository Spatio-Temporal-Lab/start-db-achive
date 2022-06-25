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

import org.apache.calcite.sql.ddl.{SqlColumnDeclaration, SqlCreateTable}
import org.geotools.data.DataStoreFinder
import org.geotools.feature.simple.SimpleFeatureTypeBuilder
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.entity.{Field, Table}
import org.urbcomp.start.db.metadata.{AccessorFactory, SqlSessionUtil}
import org.urbcomp.start.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.start.db.util.{DataTypeUtils, MetadataUtil}
import org.urbcomp.start.db.metadata.{AccessorFactory, MetadataCacheTableMap, SqlSessionUtil}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.start.db.util.MetadataUtil

import java.util

case class CreateTableExecutor(n: SqlCreateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true)
    val tableAccessor = AccessorFactory.getTableAccessor
    val existedTable = tableAccessor.selectByFidAndName(db.getId, tableName, false)
    if (existedTable != null) {
      if (n.ifNotExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table already exist " + tableName)
      }
    }

    val affectedRows =
      tableAccessor.insert(new Table(0L /* unused */, db.getId, tableName, "hbase"), false)
    val createdTable = tableAccessor.selectByFidAndName(db.getId, tableName, false)
    val tableId = createdTable.getId
    val fieldAccessor = AccessorFactory.getFieldAccessor
    val sfb = new SimpleFeatureTypeBuilder
    val schemaName = MetadataUtil.makeSchemaName(tableId)
    sfb.setName(schemaName)

    n.columnList.forEach(column => {
      val node = column.asInstanceOf[SqlColumnDeclaration]
      val name = node.name.names.get(0)
      // TODO: unify typename when parse sql
      val dataType = node.dataType.getTypeName.names.get(0)
      val classType = DataTypeUtils.getClass(dataType)
      if (DataTypeUtils.isGeometry(dataType)) {
        sfb.add(name, classType, 4326)
      } else {
        sfb.add(name, classType)
      }
      fieldAccessor.insert(new Field(0, tableId, name, dataType, 1), false)
    })

    val params: util.Map[String, String] = new util.HashMap[String, String]
    val CATALOG: String = userName + "." + dbName
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(schemaName)
    if (schema != null) {
      throw new IllegalStateException("schema already exist " + schemaName)
    }

    // TODO transform start db type
    var sft = sfb.buildFeatureType()
    sft = new TrajectoryAndFeatureTransformer().getGeoMesaSFT(sft)
    sft = new RoadSegmentAndGeomesaTransformer().getGeoMesaSFT(sft)

    // allow mixed geometry types for support start-db type `Geometry`
    sft.getUserData.put("geomesa.mixed.geometries", java.lang.Boolean.TRUE)
    dataStore.createSchema(sft)

    tableAccessor.commit()
    fieldAccessor.commit()
    // HOTFIX: session should end here
    SqlSessionUtil.clearCache()
    MetadataCacheTableMap.addTableCache(
      MetadataUtil.combineUserDbTableKey(userName, dbName, tableName)
    );
    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

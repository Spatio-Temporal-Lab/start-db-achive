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
import org.locationtech.geomesa.utils.geotools.SimpleFeatureTypes
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.entity.{Field, Table}

import java.util

case class CreateTableExecutor(n: SqlCreateTable) extends BaseExecutor {
  override def execute(): MetadataResult[Int] = {
    val userName = "start_db";
    val envDbName = "db_test";

    val targetTable = n.name
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }

    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)

    // TODO dbName context
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true);
    val tableAccessor = AccessorFactory.getTableAccessor
    val table = tableAccessor.selectByFidAndName(db.getId, tableName, true);
    if (table != null) {
      throw new IllegalStateException("table exist " + tableName);
    }

    tableAccessor.insert(new Table(0L /* table Id */, db.getId, tableName, "hbase"), false);
    val createdTable = tableAccessor.selectByFidAndName(db.getId, tableName, false);
    val tableId = createdTable.getId
    val fieldAccessor = AccessorFactory.getFieldAccessor
    var spec = List[String]()
    n.columnList.forEach(column => {
      val node = column.asInstanceOf[SqlColumnDeclaration]
      val name = node.name.names.get(0);
      // TODO: data type mapping
      val dataType = node.dataType.getTypeName.names.get(0);
      if (dataType == "Point" || dataType == "LineString") {
        spec = spec :+ "%s:%s:srid=4326".format(name, dataType);
      } else {
        spec = spec :+ "%s:%s".format(name, dataType);
      }
      fieldAccessor
        .insert(new Field(0, tableId, name, dataType, 1), false)
    })

    val params: util.Map[String, String] = new util.HashMap[String, String]
    val CATALOG: String = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(tableName);
    if (schema != null) {
      throw new IllegalStateException("table already exist " + tableName);
    }
    val sft = SimpleFeatureTypes.createType(tableName, spec.mkString(","));
    dataStore.createSchema(sft);

    tableAccessor.commit()
    fieldAccessor.commit()
    MetadataResult.buildDDLResult(1)
  }
}

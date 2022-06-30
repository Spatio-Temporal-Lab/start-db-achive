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

import java.util

import org.apache.calcite.sql.ddl.SqlDropTable
import org.geotools.data.DataStoreFinder
import org.urbcomp.start.db.common.ConfigProvider
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{AccessorFactory, MetadataCacheTableMap, SqlSessionUtil}
import org.urbcomp.start.db.util.MetadataUtil

case class DropTableExecutor(n: SqlDropTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true)
    val tableAccessor = AccessorFactory.getTableAccessor
    val fieldAccessor = AccessorFactory.getFieldAccessor
    val existedTable = tableAccessor.selectByFidAndName(db.getId, tableName, false)

    if (existedTable == null) {
      if (n.ifExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table does not exist " + tableName)
      }
    }

    val tableId = existedTable.getId
    val affectedRows =
      tableAccessor.deleteById(tableId, true)
    fieldAccessor.deleteByFid(tableId, true)
    val schemaName = MetadataUtil.makeSchemaName(tableId)

    val params: util.Map[String, String] = new util.HashMap[String, String]
    val CATALOG: String = userName + "." + dbName
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", ConfigProvider.getHBaseZookeepers)
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(schemaName)
    if (schema == null) {
      throw new IllegalStateException("schema does not exist " + schemaName)
    }

    // TODO transform start db type

    tableAccessor.commit()
    fieldAccessor.commit()
    // HOTFIX: session should end here
    SqlSessionUtil.clearCache()
    MetadataCacheTableMap.dropTableCache(
      MetadataUtil.combineUserDbTableKey(userName, dbName, tableName)
    )
    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

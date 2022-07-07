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

import org.geotools.data.DataStoreFinder
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{AccessorFactory, MetadataCacheTableMap, SqlSessionUtil}
import org.urbcomp.start.db.parser.ddl.SqlTruncateTable
import org.urbcomp.start.db.util.MetadataUtil

case class TruncateTableExecutor(n: SqlTruncateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.getTableName
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true)
    val tableAccessor = AccessorFactory.getTableAccessor
    val existedTable = tableAccessor.selectByFidAndName(db.getId, tableName, true)
    if (existedTable == null) {
      throw new IllegalStateException("table does not exist " + tableName)
    }

    val tableId = existedTable.getId
    val schemaName = MetadataUtil.makeSchemaName(tableId)
    val params = ExecutorUtil.getDataStoreParams(userName, dbName)
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(schemaName)
    if (schema == null) {
      throw new IllegalStateException("schema does not exist " + schemaName)
    }

    val newSchema = schema
    dataStore.removeSchema(schemaName)
    dataStore.createSchema(newSchema)

    // HOTFIX: session should end here
    SqlSessionUtil.clearCache()
    MetadataResult.buildDDLResult(0)
  }
}

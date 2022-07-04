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

import org.apache.calcite.sql.{SqlDelete, SqlIdentifier}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.geotools.filter.text.ecql.ECQL
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataVerifyUtil
import org.urbcomp.start.db.util.MetadataUtil

/**
  * delete executor
  * @author Wang Bohong
  * @param n one SqlNode(SqlDelete) instance
  */
case class DeleteExecutor(n: SqlDelete) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)
    // metadata Verify
    val table = MetadataVerifyUtil.getTable(userName, dbName, tableName)
    if (table == null) {
      throw new RuntimeException("There is no corresponding table!")
    }

    // Analytic filter condition
    val condition = if (n.getCondition != null) n.getCondition.toString.replace("`", "") else null

    // remove value
    var affectRows = 0
    val params = ExecutorUtil.getDataStoreParams(userName, dbName)
    val dataStore = DataStoreFinder.getDataStore(params)
    val filter = if (condition != null) ECQL.toFilter(condition) else ECQL.toFilter("INCLUDE")
    val schemaName = MetadataUtil.makeSchemaName(table.getId)
    WithClose(dataStore.getFeatureWriter(schemaName, filter, Transaction.AUTO_COMMIT)) { writer =>
      {
        while (writer.hasNext) {
          writer.next()
          affectRows += 1
          writer.remove()
        }
      }
    }
    dataStore.dispose()
    MetadataResult.buildDDLResult(affectRows)
  }

}

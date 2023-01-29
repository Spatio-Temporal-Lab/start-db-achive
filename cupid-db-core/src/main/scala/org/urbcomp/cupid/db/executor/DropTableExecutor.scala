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

import org.apache.calcite.sql.ddl.SqlDropTable
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.{MetadataAccessUtil, MetadataCacheTableMap}
import org.urbcomp.cupid.db.util.MetadataUtil

case class DropTableExecutor(n: SqlDropTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val existedTable = MetadataAccessUtil.getTable(userName, dbName, tableName)

    if (existedTable == null) {
      if (n.ifExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table does not exist " + tableName)
      }
    }

    val affectedRows = MetadataAccessUtil.dropTable(userName, dbName, tableName)

    // TODO transform start db type

    MetadataCacheTableMap.dropTableCache(
      MetadataUtil.combineUserDbTableKey(userName, dbName, tableName)
    )
    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

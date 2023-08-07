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

import org.apache.calcite.sql.ddl.SqlDropIndex
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.util.SqlParam

case class DropIndexExecutor(node: SqlDropIndex) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val param = SqlParam.CACHE.get()
    val targetTable = node.getRelation
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)
    // 判断该表是否已经存在
    val user = MetadataAccessUtil.getUser(userName)
    val db = MetadataAccessUtil.getDatabase(user.getId, dbName)
    val existedTable = MetadataAccessUtil.getTable(db.getId, tableName)
    if (existedTable == null) {
      throw new IllegalArgumentException("table doesn't exist " + tableName)
    }
    // 具体的删除索引逻辑

  }
}

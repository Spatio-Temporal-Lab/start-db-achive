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

package org.urbcomp.start.db.executor

import org.apache.calcite.sql.ddl.SqlDropSchema
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.util.SqlParam

case class DropDatabaseExecutor(n: SqlDropSchema) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val dbName = n.name.names.get(0)
    val existed = MetadataAccessUtil.getDatabase(userName, dbName)
    if (existed == null) {
      if (n.ifExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("database does not exist " + dbName)
      }
    }

    val affectedRows = MetadataAccessUtil.dropDatabase(userName, dbName)

    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

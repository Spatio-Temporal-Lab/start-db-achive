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

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.metadata.entity.Database
import org.urbcomp.start.db.parser.ddl.SqlCreateDatabase
import org.urbcomp.start.db.util.SqlParam

case class CreateDatabaseExecutor(n: SqlCreateDatabase) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val user = MetadataAccessUtil.getUser(userName)
    val dbName = n.getDatabaseName.names.get(0)
    val existed = MetadataAccessUtil.getDatabase(user.getId, dbName)
    if (existed != null) {
      if (n.isIfNotExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("database already exist " + dbName)
      }
    }
    MetadataResult.buildDDLResult(
      MetadataAccessUtil.insertDatabase(new Database(-1, user.getId, dbName)).toInt
    )
  }
}

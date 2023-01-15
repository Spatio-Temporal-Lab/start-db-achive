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
import org.urbcomp.start.db.parser.ddl.SqlUseDatabase
import org.urbcomp.start.db.util.SqlParam

/**
  * use db
  * update cache
  *
  * @author jimo
  * */
case class UseDbExecutor(n: SqlUseDatabase) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val param = SqlParam.CACHE.get()
    // check db exists
    val dbName = n.getFullDatabaseName
    val db = MetadataAccessUtil.getDatabase(param.getUserName, dbName)
    if (db == null) {
      throw new IllegalArgumentException(s"db[$dbName] not exists")
    }
    param.setDbName(dbName)
    MetadataResult.buildDDLResult(1)
  }
}

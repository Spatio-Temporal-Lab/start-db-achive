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

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor
import org.urbcomp.start.db.parser.dql.SqlShowTables
import org.urbcomp.start.db.util.SqlParam

import scala.collection.JavaConverters.asScalaBufferConverter

/**
  * show tables
  *
  * @author jimo
  * */
case class ShowTablesExecutor(n: SqlShowTables) extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val dbName = param.getDbName
    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)

    val databaseAccessor: DatabaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true)

    val tableAccessor = AccessorFactory.getTableAccessor
    val tables = tableAccessor.selectAllByFid(db.getId, true)
    val tableNames = tables.asScala.map(d => Array(d.getName.asInstanceOf[AnyRef])).toArray
    MetadataResult
      .buildResult(Array("Tables"), java.util.Arrays.asList(tableNames: _*))
      .asInstanceOf[MetadataResult[Array]]
  }
}

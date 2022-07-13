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
import org.urbcomp.start.db.metadata.MetadataAccessUtil
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

    val tables = MetadataAccessUtil.getTables(userName, dbName)
    val tableNames = tables.asScala.map(d => Array(d.getName.asInstanceOf[AnyRef])).toArray
    MetadataResult
      .buildResult(Array("Tables"), java.util.Arrays.asList(tableNames: _*))
      .asInstanceOf[MetadataResult[Array]]
  }
}

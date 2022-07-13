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

import org.apache.calcite.sql.SqlDescribeTable
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataAccessUtil

import scala.collection.JavaConverters.asScalaBufferConverter

case class DescribeTableExecutor(n: SqlDescribeTable) extends BaseExecutor {
  override def execute[Array](): MetadataResult[Array] = {
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(n.getTable)
    val table = MetadataAccessUtil.getTable(userName, dbName, tableName)
    if (table == null) {
      throw new RuntimeException("table not exist " + tableName)
    }
    val fields = MetadataAccessUtil.getFields(userName, dbName, tableName)
    val rows = fields.asScala
      .map(
        field =>
          Array[Object](
            field.getName,
            field.getType,
            if (field.getIsPrimary == 1) "PRI"
            else ""
          )
      )
      .toArray
    MetadataResult
      .buildResult(Array("Field", "Type", "Key"), java.util.Arrays.asList(rows: _*))
      .asInstanceOf[MetadataResult[Array]]
  }
}

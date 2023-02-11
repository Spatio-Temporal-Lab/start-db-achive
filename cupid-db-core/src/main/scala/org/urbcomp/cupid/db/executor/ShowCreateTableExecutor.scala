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

import org.apache.calcite.sql.ddl.SqlDdlNodes
import org.apache.calcite.sql.parser.SqlParserPos
import org.apache.calcite.sql.{
  SqlDataTypeSpec,
  SqlIdentifier,
  SqlNodeList,
  SqlUserDefinedTypeNameSpec
}
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.parser.SqlHelper
import org.urbcomp.cupid.db.parser.ddl.{SqlCupidCreateTable, SqlIndexDeclaration}
import org.urbcomp.cupid.db.parser.dql.SqlShowCreateTable
import org.urbcomp.cupid.db.schema.IndexType

import java.util
import scala.collection.JavaConverters.{asScalaBufferConverter, seqAsJavaListConverter}
import scala.language.higherKinds

/**
  * @author jimo
  * */
case class ShowCreateTableExecutor(n: SqlShowCreateTable) extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    val targetTable = n.getTableName
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)
    val fields = MetadataAccessUtil.getFields(userName, dbName, tableName)
    if (fields == null) {
      throw new IllegalArgumentException("table not exist " + tableName);
    }

    val pos = SqlParserPos.ZERO
    val sqlTableName = new SqlIdentifier(util.Arrays.asList(tableName), pos)
    val columnList = fields.asScala
      .map { field =>
        val fieldName = new SqlIdentifier(util.Arrays.asList(field.getName), pos)
        val typeSpec = new SqlUserDefinedTypeNameSpec(new SqlIdentifier(field.getType, pos), pos)
        SqlDdlNodes.column(pos, fieldName, new SqlDataTypeSpec(typeSpec, pos), null, null)
      }
      .toList
      .asJava
    val sqlColumnList = new SqlNodeList(columnList, pos)

    val indexes = MetadataAccessUtil.getIndexes(userName, dbName, tableName)
    val indexList = indexes.asScala
      .map(idx => {
        val fields = idx.getFieldsIdList
          .split(",")
          .map(name => new SqlIdentifier(util.Arrays.asList(name), pos))
          .toList
          .asJava
        new SqlIndexDeclaration(pos, IndexType.valueOf(idx.getIndexType), fields)
      })
      .toList
      .asJava
    val sqlIndexList = new SqlNodeList(indexList, pos)
    val sqlNode =
      new SqlCupidCreateTable(pos, false, false, sqlTableName, sqlColumnList, sqlIndexList, null)

    MetadataResult
      .buildResult(
        Array("Table", "Create Table"),
        java.util.Arrays.asList(Array(sqlNode.name.toString, SqlHelper.toSqlString(sqlNode)))
      )
      .asInstanceOf[MetadataResult[Array]]
  }
}

/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
import org.urbcomp.cupid.db.parser.ddl.SqlCupidCreateTable
import org.urbcomp.cupid.db.parser.dql.SqlShowCreateTable

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

    val sqlNode =
      new SqlCupidCreateTable(pos, false, false, sqlTableName, sqlColumnList, null, null)

    MetadataResult
      .buildResult(
        Array("Table", "Create Table"),
        java.util.Arrays.asList(Array(sqlNode.name.toString, SqlHelper.toSqlString(sqlNode)))
      )
      .asInstanceOf[MetadataResult[Array]]
  }
}

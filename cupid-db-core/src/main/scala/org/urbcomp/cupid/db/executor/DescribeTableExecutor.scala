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

import org.apache.calcite.sql.SqlDescribeTable
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil

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

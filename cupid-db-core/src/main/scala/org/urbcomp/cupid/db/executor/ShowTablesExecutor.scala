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

import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.parser.dql.SqlShowTables
import org.urbcomp.cupid.db.util.SqlParam

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

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
import org.urbcomp.cupid.db.metadata.entity.Database
import org.urbcomp.cupid.db.parser.ddl.SqlCreateDatabase
import org.urbcomp.cupid.db.util.SqlParam

case class CreateDatabaseExecutor(n: SqlCreateDatabase) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val user = MetadataAccessUtil.getUser(userName)
    val dbName = n.getDatabaseName.names.get(0)
    val existed = MetadataAccessUtil.getDatabase(userName, dbName)
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

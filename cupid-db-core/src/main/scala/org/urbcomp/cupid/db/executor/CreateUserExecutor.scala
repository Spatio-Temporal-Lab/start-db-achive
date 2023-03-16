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
import org.urbcomp.cupid.db.metadata.entity.{Database, User}
import org.urbcomp.cupid.db.parser.dcl.SqlCreateUser

case class CreateUserExecutor(n: SqlCreateUser) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val userName = n.getUserName.names.get(0)
    val existed = MetadataAccessUtil.getUser(userName)
    if (existed != null) {
      throw new IllegalArgumentException("User already exist " + userName)
    }
    val password = n.getPassword
    checkPassword(password)
    MetadataAccessUtil.insertUser(new User(-1, userName, password))
    val user = MetadataAccessUtil.getUser(userName)
    MetadataAccessUtil.insertDatabase(new Database(-1, user.getId, "default"))
    MetadataResult.buildDDLResult(2)
  }

  // TODO password spec
  def checkPassword(password: String): Unit = {
    if (password == "") {
      throw new IllegalArgumentException("password must not empty")
    }
    if (password.contains(" ") || password.contains("\t") || password.contains("\n")) {
      throw new IllegalArgumentException("password must not contains empty characters")
    }
  }
}

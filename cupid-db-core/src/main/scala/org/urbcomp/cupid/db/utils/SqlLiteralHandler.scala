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
package org.urbcomp.cupid.db.utils

import org.apache.calcite.sql.{SqlBasicCall, SqlCharStringLiteral, SqlNode, SqlUnresolvedFunction}

object SqlLiteralHandler {

  def handleLiteral(node: SqlNode): String = node match {
    case s: SqlCharStringLiteral =>
      s"""
         |'${s.getStringValue}'
         |""".stripMargin
    case s: SqlBasicCall if s.getOperator.isInstanceOf[SqlUnresolvedFunction] =>
      s"${s.getOperator.getName}(${s.operands.map(handleLiteral).mkString(", ")})"
    case j => j.toString
  }

}

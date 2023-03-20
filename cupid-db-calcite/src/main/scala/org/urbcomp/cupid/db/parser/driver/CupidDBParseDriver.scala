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
package org.urbcomp.cupid.db.parser.driver

import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}
import org.apache.calcite.sql.SqlNode
import org.urbcomp.cupid.db.parser.parser.{CupidDBSqlLexer, CupidDBSqlParser}
import org.urbcomp.cupid.db.parser.visitor.CupidDBVisitor
import org.urbcomp.cupid.db.util.SqlParam

/**
  * Cupid DB parse driver
  *
  * @author : zaiyuan
  */
object CupidDBParseDriver {
  def parseSql(sql: String): SqlNode = {
    val charStream: CharStream = CharStreams.fromString(sql)
    val lexer = new CupidDBSqlLexer(charStream)
    lexer.removeErrorListeners()
    val parser = new CupidDBSqlParser(new CommonTokenStream(lexer))
    parser.removeErrorListeners()
    val tree = parser.program()
    val param = SqlParam.CACHE.get()
    val visitor = new CupidDBVisitor(param.getUserName, param.getDbName)
    visitor.visitProgram(tree)
  }
}

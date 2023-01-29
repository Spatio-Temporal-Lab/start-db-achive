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

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

package org.urbcomp.start.db.parser.driver

import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}
import org.apache.calcite.sql.SqlNode
import org.urbcomp.start.db.parser.parser.{StartDBSqlLexer, StartDBSqlParser}
import org.urbcomp.start.db.parser.visitor.StartDBVisitor

/**
 * Start DB parse driver
 *
 * @author : zaiyuan
 */
object StartDBParseDriver {
  def parseSql(sql: String): SqlNode = {
    val charStream: CharStream = CharStreams.fromString(sql)
    val lexer = new StartDBSqlLexer(charStream)
    lexer.removeErrorListeners()
    val parser = new StartDBSqlParser(new CommonTokenStream(lexer))
    parser.removeErrorListeners()
    val tree = parser.program()
    val visitor = new StartDBVisitor
    visitor.visitProgram(tree)
  }
}

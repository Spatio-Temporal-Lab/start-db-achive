package org.urbcomp.start.db.parser.visitor

import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}
import org.apache.calcite.sql.SqlNode
import org.urbcomp.start.db.parser.parser.{StartDBSqlLexer, StartDBSqlParser}

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

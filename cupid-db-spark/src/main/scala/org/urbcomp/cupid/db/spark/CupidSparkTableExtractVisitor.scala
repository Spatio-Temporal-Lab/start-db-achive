package org.urbcomp.cupid.db.spark

import org.antlr.v4.runtime.{CharStream, CharStreams, CommonTokenStream}
import org.urbcomp.cupid.db.parser.parser.{CupidDBSqlBaseVisitor, CupidDBSqlLexer, CupidDBSqlParser}
import org.urbcomp.cupid.db.parser.parser.CupidDBSqlParser.FromTableNameClauseContext
import org.urbcomp.cupid.db.util.SqlParam

import java.util
import scala.collection.JavaConverters._
import scala.collection.mutable

class CupidSparkTableExtractVisitor extends CupidDBSqlBaseVisitor[Unit] {

  val tableList = new util.ArrayList[String]()

  override def visitFromTableNameClause(ctx: FromTableNameClauseContext): Unit = {
    val names = ctx.tableName().ident()
    if (names.identItem().size() == 1) {
      tableList.add(s"${SqlParam.CACHE.get().getDbName}.${names.getText}")
    } else {
      tableList.add(s"${names.identItem(0).getText}.${names.identItem(1).getText}")
    }
  }
}

object CupidSparkTableExtractVisitor {
  def getTableList(sql: String): mutable.Buffer[String] = {
    val charStream: CharStream = CharStreams.fromString(sql)
    val lexer = new CupidDBSqlLexer(charStream)
    lexer.removeErrorListeners()
    val parser = new CupidDBSqlParser(new CommonTokenStream(lexer))
    parser.removeErrorListeners()
    val tree = parser.program()
    val visitor = new CupidSparkTableExtractVisitor
    visitor.visitProgram(tree)
    visitor.tableList.asScala
  }
}

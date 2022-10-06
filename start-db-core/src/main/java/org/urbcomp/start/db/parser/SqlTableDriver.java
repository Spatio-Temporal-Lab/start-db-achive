package org.urbcomp.start.db.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.urbcomp.start.db.parser.parser.StartDBSqlLexer;
import org.urbcomp.start.db.parser.parser.StartDBSqlParser;

import java.util.List;

public class SqlTableDriver {

    public List<String> apply(String sql) {
        CharStream input = CharStreams.fromString(sql);
        StartDBSqlLexer lexer = new StartDBSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        StartDBSqlParser parser = new StartDBSqlParser(tokenStream);
        SqlVisitor<String> visitor = new SqlVisitor<String>();
        visitor.visit(parser.program());

        return visitor.getTableList();
    }
}

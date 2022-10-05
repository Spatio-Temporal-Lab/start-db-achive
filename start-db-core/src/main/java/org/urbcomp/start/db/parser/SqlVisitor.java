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

package org.urbcomp.start.db.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.urbcomp.start.db.parser.parser.StartDBSqlBaseVisitor;
import org.urbcomp.start.db.parser.parser.StartDBSqlLexer;
import org.urbcomp.start.db.parser.parser.StartDBSqlParser;
import org.urbcomp.start.db.parser.parser.StartDBSqlVisitor;

/**
 * @author stan
 * @date 2022/10/5 10:15
 */
public class SqlVisitor<T> extends StartDBSqlBaseVisitor<String> {

    @Override
    public String visitProgram(StartDBSqlParser.ProgramContext ctx) {
        return visitStmt(ctx.stmt());
    }

    @Override
    public String visitDropDatabaseStmt(StartDBSqlParser.DropDatabaseStmtContext ctx) {
        return ctx.dbName.getText();
    }

    @Override
    public String visitCreateDatabaseStmt(StartDBSqlParser.CreateDatabaseStmtContext ctx) {
        return ctx.dbName.getText();
    }

    @Override
    public String visitUseStmt(StartDBSqlParser.UseStmtContext ctx) {
        return ctx.dbName.getText();
    }

    @Override
    public String visitFromTableClause(StartDBSqlParser.FromTableClauseContext ctx) {
        return ctx.start.getText();
    }

    @Override
    public String visitStmt(StartDBSqlParser.StmtContext ctx) {
        ParseTree stmt = ctx.getChild(0);
        if (stmt instanceof StartDBSqlParser.CreateDatabaseStmtContext) {
            return visitCreateDatabaseStmt((StartDBSqlParser.CreateDatabaseStmtContext) stmt);
        } else if (stmt instanceof StartDBSqlParser.DropDatabaseStmtContext) {
            return visitDropDatabaseStmt((StartDBSqlParser.DropDatabaseStmtContext) stmt);
        } else if (stmt instanceof StartDBSqlParser.SelectStmtContext) {
            return visitSelectStmt((StartDBSqlParser.SelectStmtContext) stmt);
        } else if (stmt instanceof StartDBSqlParser.UseStmtContext) {
            return visitUseStmt((StartDBSqlParser.UseStmtContext) stmt);
        } else if (stmt instanceof StartDBSqlParser.FromTableClauseContext) {
            return visitFromTableClause((StartDBSqlParser.FromTableClauseContext) stmt);
        } else {
            return null;
        }
    }

    public String apply(String sql) {
        CharStream input = CharStreams.fromString(sql);
        StartDBSqlLexer lexer = new StartDBSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        StartDBSqlParser parser = new StartDBSqlParser(tokenStream);
        StartDBSqlVisitor<String> visitor = new SqlVisitor<String>();

        return visitor.visit(parser.program());
    }
}

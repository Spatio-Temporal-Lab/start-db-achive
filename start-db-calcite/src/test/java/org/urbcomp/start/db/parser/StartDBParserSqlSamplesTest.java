/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.start.db.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.urbcomp.start.db.parser.parser.StartDBSqlBaseVisitor;
import org.urbcomp.start.db.parser.parser.StartDBSqlLexer;
import org.urbcomp.start.db.parser.parser.StartDBSqlParser;
import org.urbcomp.start.db.parser.parser.StartDBSqlParser.CreateDatabaseStmtContext;
import org.urbcomp.start.db.parser.parser.StartDBSqlVisitor;

import static org.junit.Assert.assertEquals;

/**
 * Test parser can accept basic create/delete/drop/insert sql statement samples.
 */
public class StartDBParserSqlSamplesTest {

    @Test
    public void testCreateDatabaseSql() {
        CharStream input = CharStreams.fromString(StartDBSQLSamples.CREATE_DATABASE_SAMPLE);
        StartDBSqlLexer lexer = new StartDBSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        StartDBSqlParser parser = new StartDBSqlParser(tokenStream);
        StartDBSqlVisitor<String> visitor = new TestVisitor<String>() {
            @Override
            public String visitCreateDatabaseStmt(CreateDatabaseStmtContext ctx) {
                return ctx.dbName.getText();
            }
        };
        assertEquals("database_name", visitor.visit(parser.program()));
    }

    @Test
    public void testDropDatabaseSql() {
        CharStream input = CharStreams.fromString(StartDBSQLSamples.DROP_DATABASE_SAMPLE);
        StartDBSqlLexer lexer = new StartDBSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        StartDBSqlParser parser = new StartDBSqlParser(tokenStream);
        StartDBSqlVisitor<String> visitor = new TestVisitor<String>() {
            @Override
            public String visitDropDatabaseStmt(StartDBSqlParser.DropDatabaseStmtContext ctx) {
                return ctx.dbName.getText();
            }
        };
        assertEquals("database_name", visitor.visit(parser.program()));
    }

    private static class TestVisitor<T> extends StartDBSqlBaseVisitor<T> {
        @Override
        public T visitProgram(StartDBSqlParser.ProgramContext ctx) {
            return visitStmt(ctx.stmt());
        }

        @Override
        public T visitStmt(StartDBSqlParser.StmtContext ctx) {
            ParseTree stmt = ctx.getChild(0);
            if (stmt instanceof CreateDatabaseStmtContext) {
                return visitCreateDatabaseStmt((CreateDatabaseStmtContext) stmt);
            } else if (stmt instanceof StartDBSqlParser.DropDatabaseStmtContext) {
                return visitDropDatabaseStmt((StartDBSqlParser.DropDatabaseStmtContext) stmt);
            } else {
                return null;
            }
        }
    }
}

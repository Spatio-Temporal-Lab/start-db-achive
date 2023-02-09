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

package org.urbcomp.cupid.db.parser.ddl;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.util.ImmutableNullableList;

import java.util.List;
import java.util.Objects;

public class SqlCupidCreateTable extends SqlCreate {

    public final SqlIdentifier name;
    public final SqlNodeList columnList;
    public final SqlNode query;
    public final SqlNodeList indexList;

    private static final SqlOperator OPERATOR = new SqlSpecialOperator(
        "CREATE TABLE",
        SqlKind.CREATE_TABLE
    );

    /** Creates a SqlCreateTable. */
    public SqlCupidCreateTable(
        SqlParserPos pos,
        boolean replace,
        boolean ifNotExists,
        SqlIdentifier name,
        SqlNodeList columnList,
        SqlNodeList indexList,
        SqlNode query
    ) {
        super(OPERATOR, pos, replace, ifNotExists);
        this.name = Objects.requireNonNull(name);
        this.columnList = columnList; // may be null
        this.indexList = indexList; // may be null
        this.query = query; // for "CREATE TABLE ... AS query"; may be null
    }

    public List<SqlNode> getOperandList() {
        return ImmutableNullableList.of(name, columnList, query);
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        writer.keyword("CREATE");
        writer.keyword("TABLE");
        if (ifNotExists) {
            writer.keyword("IF NOT EXISTS");
        }
        name.unparse(writer, leftPrec, rightPrec);
        if (columnList != null) {
            SqlWriter.Frame frame = writer.startList("(", ")");
            for (SqlNode c : columnList) {
                writer.sep(",");
                c.unparse(writer, 0, 0);
            }
            if (indexList != null) {
                for (SqlNode c : indexList) {
                    writer.sep(",");
                    c.unparse(writer, 0, 0);
                }
            }
            writer.endList(frame);
        }

        if (query != null) {
            writer.keyword("AS");
            writer.newlineAndIndent();
            query.unparse(writer, 0, 0);
        }
    }
}

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
import org.urbcomp.cupid.db.schema.IndexType;

import java.util.Collections;
import java.util.List;

public class SqlIndexDeclaration extends SqlCall {
    private static final SqlSpecialOperator OPERATOR = new SqlSpecialOperator(
        "INDEX_DECL",
        SqlKind.OTHER_DDL
    );

    public final IndexType indexType;

    public final SqlIdentifier indexName;

    public final List<SqlIdentifier> columns;

    public final SqlIdentifier indexImplType;

    /**
     * Creates a SqlIndexDeclaration;
     */
    public SqlIndexDeclaration(
        SqlParserPos pos,
        IndexType indexType,
        SqlIdentifier indexName,
        List<SqlIdentifier> columns,
        SqlIdentifier indexImplType
    ) {
        super(pos);
        this.indexType = indexType;
        this.indexName = indexName;
        this.columns = columns;
        this.indexImplType = indexImplType;
    }

    @Override
    public SqlOperator getOperator() {
        return OPERATOR;
    }

    @Override
    public List<SqlNode> getOperandList() {
        return Collections.unmodifiableList(columns);
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        switch (indexType) {
            case SPATIAL:
                writer.keyword("SPATIAL");
                break;
            case ATTRIBUTE:
                writer.keyword("ATTRIBUTE");
                break;
            default:
                throw new AssertionError("unexpected: " + indexType);
        }
        writer.keyword("INDEX");
        if (indexName != null) {
            indexName.unparse(writer, 0, 0);
        }
        SqlWriter.Frame frame = writer.startList("(", ")");
        for (SqlNode c : columns) {
            writer.sep(",");
            c.unparse(writer, 0, 0);
        }
        writer.endList(frame);
    }
}

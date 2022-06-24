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

package org.urbcomp.start.db.parser.dcl;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * CREATE User dcl sql call.
 */
public class SqlCreateUser extends SqlCall {

    public static final SqlSpecialOperator OPERATOR = new SqlSpecialOperator(
        "CREATE USER",
        SqlKind.OTHER
    );

    private final SqlIdentifier userName;

    private final String password;

    public SqlCreateUser(SqlParserPos pos, SqlIdentifier userName, String password) {
        super(pos);
        this.userName = requireNonNull(userName, "userName must not be null");
        this.password = requireNonNull(password, "password must not be null");
    }

    @Nonnull
    @Override
    public SqlOperator getOperator() {
        return OPERATOR;
    }

    @Nonnull
    @Override
    public List<SqlNode> getOperandList() {
        return Collections.emptyList();
    }

    public SqlIdentifier getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        writer.keyword("CREATE USER ");
        userName.unparse(writer, leftPrec, rightPrec);
        writer.print(String.format(" IDENTIFIED BY '%s'", password));
    }

    protected void printIndent(SqlWriter writer) {
        writer.sep(",", false);
        writer.newlineAndIndent();
        writer.print("  ");
    }
}

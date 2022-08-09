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

package org.apache.calcite.sql.ddl;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.urbcomp.start.db.util.StringUtil;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class SqlDropIndex extends SqlDdl {

    private String indexName;

    /**
     * 表名
     */
    private SqlIdentifier relation;

    /**
     * 构造方法
     *
     * @param operator 操作类型
     * @param pos      解析位置
     */
    public SqlDropIndex(SqlOperator operator, SqlParserPos pos) {
        super(operator, pos);
    }

    public SqlDropIndex(SqlParserPos pos, String indexName, SqlIdentifier relation) {
        this(new SqlSpecialOperator("DROP INDEX", SqlKind.DROP_INDEX), pos);
        this.indexName = StringUtil.dropQuota(indexName);
        this.relation = relation;
    }

    @Nonnull
    @Override
    public List<SqlNode> getOperandList() {
        return new ArrayList<>();
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public SqlIdentifier getRelation() {
        return relation;
    }

    public void setRelation(SqlIdentifier relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "SqlDropTableIndex{"
            + "indexName='"
            + indexName
            + '\''
            + ", relation="
            + relation
            + '}';
    }
}

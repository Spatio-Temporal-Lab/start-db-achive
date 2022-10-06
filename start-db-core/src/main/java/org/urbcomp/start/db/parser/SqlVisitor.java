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

import org.urbcomp.start.db.parser.parser.StartDBSqlBaseVisitor;
import org.urbcomp.start.db.parser.parser.StartDBSqlParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stan
 * @date 2022/10/5 10:15
 */
public class SqlVisitor<Object> extends StartDBSqlBaseVisitor<Object> {

    List<String> tableList = new ArrayList<>();

    @Override
    public Object visitFromTableClause(StartDBSqlParser.FromTableClauseContext ctx) {
        tableList.add(ctx.getText());
        return visitFromTableClause(ctx);
    }

    public List<String> getTableList() {
        return tableList;
    }
}

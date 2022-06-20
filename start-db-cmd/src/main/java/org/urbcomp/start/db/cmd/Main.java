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

package org.urbcomp.start.db.cmd;

import sqlline.BuiltInProperty;
import sqlline.SqlLine;
import sqlline.SqlLineOpts;

import java.io.IOException;

/**
 * Entry of CMD
 *
 * @author jimo
 **/
public class Main {

    public static void main(String[] args) throws IOException {
        int i = args.length;
        String[] startArgs = new String[i + 2];
        startArgs[i++] = "-ac";
        startArgs[i] = StartApplication.class.getCanonicalName();
        SqlLine sqlline = new SqlLine();
        final SqlLineOpts sqlLineOpts = new SqlLineOpts(sqlline);
        sqlLineOpts.set(BuiltInProperty.PROMPT, "start-db> ");
        sqlline.setOpts(sqlLineOpts);
        SqlLine.Status status = sqlline.begin(startArgs, null, true);

        if (!Boolean.getBoolean(SqlLineOpts.PROPERTY_NAME_EXIT)) {
            System.exit(status.ordinal());
        }
    }
}

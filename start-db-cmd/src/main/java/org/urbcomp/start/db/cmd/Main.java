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

import org.locationtech.jts.util.Assert;
import sqlline.BuiltInProperty;
import sqlline.SqlLine;
import sqlline.SqlLineOpts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Entry of CMD
 *
 * @author jimo
 **/
public class Main {

    private static class CmdArg {
        String username;
        String password;
        String url = "jdbc:start-db:url=http://127.0.0.1:8000";

        boolean check() {
            return username != null && password != null && url != null;
        }

        @Override
        public String toString() {
            return "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", url='" + url + '\'';
        }
    }

    public static void main(String[] args) throws IOException {
        CmdArg cmdArg = parseArgs(args);
        Assert.isTrue(cmdArg.check(), "missing params: " + cmdArg);
        Map<String, String> paramKv = new HashMap<>(8);
        paramKv.put("-ac", StartApplication.class.getCanonicalName());
        paramKv.put("-n", cmdArg.username);
        paramKv.put("-p", cmdArg.password);
        paramKv.put("-u", cmdArg.url);
        String[] startArgs = new String[paramKv.size() * 2];
        int i = -1;
        for (Map.Entry<String, String> e : paramKv.entrySet()) {
            startArgs[++i] = e.getKey();
            startArgs[++i] = e.getValue();
        }
        SqlLine sqlline = new SqlLine();
        final SqlLineOpts sqlLineOpts = new SqlLineOpts(sqlline);
        sqlLineOpts.set(BuiltInProperty.PROMPT, "start-db> ");
        sqlline.setOpts(sqlLineOpts);
        SqlLine.Status status = sqlline.begin(startArgs, null, true);

        if (!Boolean.getBoolean(SqlLineOpts.PROPERTY_NAME_EXIT)) {
            System.exit(status.ordinal());
        }
    }

    private static CmdArg parseArgs(String[] args) {
        final CmdArg cmdArg = new CmdArg();
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-u":
                    cmdArg.username = args[++i];
                    break;
                case "-p":
                    cmdArg.password = args[++i];
                    break;
                case "-r":
                    cmdArg.url = args[++i];
                    break;
                default:
            }
        }
        return cmdArg;
    }
}

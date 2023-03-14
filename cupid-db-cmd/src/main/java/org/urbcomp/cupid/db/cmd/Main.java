/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.cmd;

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

    private static int SOURCE_BATCH_SIZE = 512;
    private static int TABLE_MAX_WIDTH = 100000;

    private static class CmdArg {
        String username;
        String password;
        String url = "jdbc:cupid-db:url=http://127.0.0.1:8000";
        // set bigger to show full value, bug it's ugly
        int maxWidth = 100000;
        // batch size of source command execute
        int batchSize = 512;

        boolean check() {
            return username != null
                && password != null
                && url != null
                && batchSize > 0
                && maxWidth > 0;
        }

        @Override
        public String toString() {
            return "{"
                + "username='"
                + username
                + '\''
                + ", password='"
                + password
                + '\''
                + ", url='"
                + url
                + '\''
                + ", maxWidth="
                + maxWidth
                + ", batchSize="
                + batchSize
                + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        CmdArg cmdArg = parseArgs(args);
        Assert.isTrue(cmdArg.check(), "missing params: " + cmdArg);
        SOURCE_BATCH_SIZE = cmdArg.batchSize;
        TABLE_MAX_WIDTH = cmdArg.maxWidth;
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
        sqlLineOpts.set(BuiltInProperty.PROMPT, "cupid-db> ");
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
                case "-maxWidth":
                    cmdArg.maxWidth = Integer.parseInt(args[++i]);
                    break;
                case "-batchSize":
                    cmdArg.batchSize = Integer.parseInt(args[++i]);
                    break;
                default:
            }
        }
        return cmdArg;
    }

    public static int getSourceBatchSize() {
        return SOURCE_BATCH_SIZE;
    }

    public static int getTableMaxWidth() {
        return TABLE_MAX_WIDTH;
    }
}

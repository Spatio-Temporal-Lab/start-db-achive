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

package org.urbcomp.start.db.util;

import java.util.HashMap;
import java.util.Map;

/**
 * SqlParams: username, DBName
 *
 * @author Wang Bohong
 * @date 2022-06-14
 */
public class SqlParam {

    public static final ThreadLocal<SqlParam> CACHE = new ThreadLocal<>();
    private static final Map<String, SqlParam> connectionParams = new HashMap<>();

    /**
     * username
     */
    private String userName;

    /**
     * db name
     */
    private String dbName;

    public SqlParam() {}

    public SqlParam(String userName, String dbName) {
        this.userName = userName;
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public static void setParam(String connectionId, SqlParam param) {
        connectionParams.put(connectionId, param);
    }

    public static SqlParam getParam(String connectionId) {
        return connectionParams.get(connectionId);
    }

    public static void removeParam(String connectionId) {
        connectionParams.remove(connectionId);
    }
}

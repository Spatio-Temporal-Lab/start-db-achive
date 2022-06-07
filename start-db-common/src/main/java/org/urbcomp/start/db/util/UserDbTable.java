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

import java.util.Objects;

/**
 * @author jimo
 **/
public class UserDbTable {
    public UserDbTable() {}

    public UserDbTable(String username, String dbName, String tableName) {
        this.username = username;
        this.dbName = dbName;
        this.tableName = tableName;
    }

    /**
     * username
     */
    private String username;
    /**
     * database name
     */
    private String dbName;
    /**
     * table name
     */
    private String tableName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDbTable that = (UserDbTable) o;
        return Objects.equals(username, that.username)
            && Objects.equals(dbName, that.dbName)
            && Objects.equals(tableName, that.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, dbName, tableName);
    }
}

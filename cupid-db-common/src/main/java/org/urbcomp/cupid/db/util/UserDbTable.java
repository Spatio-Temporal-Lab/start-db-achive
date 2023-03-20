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
package org.urbcomp.cupid.db.util;

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

    @Override
    public String toString() {
        return "UserDbTable{"
            + "username='"
            + username
            + '\''
            + ", dbName='"
            + dbName
            + '\''
            + ", tableName='"
            + tableName
            + '\''
            + '}';
    }
}

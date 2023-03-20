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

import org.urbcomp.cupid.db.model.data.DataExportType;

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

    private boolean isLocal;

    private String sql;

    private DataExportType exportType;

    private String sqlId;

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

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public DataExportType getExportType() {
        return exportType;
    }

    public void setExportType(DataExportType exportType) {
        this.exportType = exportType;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }
}

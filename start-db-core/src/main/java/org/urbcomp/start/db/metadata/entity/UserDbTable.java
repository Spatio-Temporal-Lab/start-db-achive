package org.urbcomp.start.db.metadata.entity;

/**
 * @author jimo
 **/
public class UserDbTable {
    public UserDbTable() {
    }

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
}

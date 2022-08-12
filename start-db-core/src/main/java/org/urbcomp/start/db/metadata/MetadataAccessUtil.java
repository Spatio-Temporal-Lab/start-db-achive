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

package org.urbcomp.start.db.metadata;

import org.apache.ibatis.session.SqlSession;
import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor;
import org.urbcomp.start.db.metadata.accessor.FieldAccessor;
import org.urbcomp.start.db.metadata.accessor.TableAccessor;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.util.MetadataUtil;
import org.urbcomp.start.db.util.UserDbTable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * utils of metadata access
 *
 * @author Wang Bohong
 * @date 2022-06-22
 */
public class MetadataAccessUtil {

    private final static ThreadLocal<SqlSession> SQL_SESSION = new ThreadLocal<>();
    /**
     * 2 weeks
     */
    private final static int cleanExpiredTimeS = 14 * 24 * 3600;

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = SQL_SESSION.get();
        if (sqlSession == null) {
            sqlSession = SqlSessionUtil.createSqlSession(true);
            SQL_SESSION.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * check if table exists
     *
     * @param userName  user name
     * @param dbName    db name
     * @param tableName table name
     * @return isValid
     */
    public static boolean tableVerify(String userName, String dbName, String tableName) {
        return getTable(userName, dbName, tableName) != null;
    }

    /**
     * get field list of the table
     *
     * @param userName  user name
     * @param dbName    db name
     * @param tableName table name
     * @return field list
     */
    public static List<Field> getFields(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            Table table = getTable(userName, dbName, tableName);
            if (table == null) return null;
            FieldAccessor fieldAccessor = AccessorFactory.getFieldAccessor();
            List<Field> fields = fieldAccessor.selectAllByFid(table.getId());
            fields.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
            return fields;
        });
    }

    /**
     * get table from metadata
     */
    public static Table getTable(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            final Database database = getDatabase(userName, dbName);
            if (database == null) return null;
            return getTable(database.getId(), tableName);
        });
    }

    public static Table getTable(long dbId, String tableName) {
        return noRollback(v -> {
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            return tableAccessor.selectByFidAndName(dbId, tableName);
        });
    }

    public static long insertTable(Table table) {
        return noRollback(v -> AccessorFactory.getTableAccessor().insert(table));
    }

    public static long insertField(Field field) {
        return noRollback(v -> AccessorFactory.getFieldAccessor().insert(field));
    }

    // TODO cache
    public static User getUser(String userName) {
        return noRollback(
            v -> AccessorFactory.getUserAccessor().selectByFidAndName(-1 /* not used */, userName)
        );
    }

    public static long insertUser(User user) {
        return noRollback(v -> AccessorFactory.getUserAccessor().insert(user));
    }

    public static Database getDatabase(long userId, String dbName) {
        return noRollback(
            v -> AccessorFactory.getDatabaseAccessor().selectByFidAndName(userId, dbName)
        );
    }

    public static Database getDatabase(String userName, String dbName) {
        return noRollback(v -> {
            UserAccessor userAccessor = AccessorFactory.getUserAccessor();
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            User user = userAccessor.selectByFidAndName(0L, userName);
            if (user == null) return null;
            return databaseAccessor.selectByFidAndName(user.getId(), dbName);
        });
    }

    public static long insertDatabase(Database database) {
        return noRollback(v -> AccessorFactory.getDatabaseAccessor().insert(database));
    }

    public static long dropDatabase(String userName, String dbName) {
        return noRollback(v -> {
            final Database db = getDatabase(userName, dbName);
            if (db == null) {
                return 0L;
            }
            final long dbId = db.getId();
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            final long res = databaseAccessor.deleteById(dbId);
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            tableAccessor.deleteByFid(dbId);
            // 移除缓存 TODO
            return res;
        });
    }

    public static long dropTable(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            final Table table = getTable(userName, dbName, tableName);
            if (table == null) {
                return 0L;
            }
            final long tableId = table.getId();
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            final long res = tableAccessor.deleteById(tableId);
            AccessorFactory.getFieldAccessor().deleteByFid(tableId);
            // 清理缓存
            MetadataCacheTableMap.dropTableCache(
                MetadataUtil.combineUserDbTableKey(userName, dbName, tableName)
            );
            return res;
        });
    }

    public static List<Database> getDatabases(String userName) {
        return noRollback(v -> {
            final User user = getUser(userName);
            if (user == null) {
                return new ArrayList<>(1);
            }
            DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor();
            return databaseAccessor.selectAllByFid(user.getId());
        });
    }

    public static List<Table> getTables(String userName, String dbName) {
        return noRollback(v -> {
            final Database database = getDatabase(userName, dbName);
            if (database == null) {
                return new ArrayList<>(1);
            }
            TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            return tableAccessor.selectAllByFid(database.getId());
        });
    }

    public static List<UserDbTable> getUserDbTables() {
        return noRollback(v -> {
            final TableAccessor tableAccessor = AccessorFactory.getTableAccessor();
            return tableAccessor.getAllUserDbTable();
        });
    }

    public static int cleanUser() {
        return noRollback(v -> AccessorFactory.getUserAccessor().clean(cleanExpiredTimeS));
    }

    public static int cleanDatabase() {
        return noRollback(v -> AccessorFactory.getDatabaseAccessor().clean(cleanExpiredTimeS));
    }

    public static int cleanTable() {
        return noRollback(v -> AccessorFactory.getTableAccessor().clean(cleanExpiredTimeS));
    }

    public static int cleanField() {
        return noRollback(v -> AccessorFactory.getFieldAccessor().clean(cleanExpiredTimeS));
    }

    public static int cleanIndex() {
        return noRollback(v -> AccessorFactory.getIndexAccessor().clean(cleanExpiredTimeS));
    }

    public static <T> T noRollback(Function<Void, T> f) {
        SqlSession sqlSession = SQL_SESSION.get();
        if (sqlSession == null) {
            // means no need to rollback, just close
            try (SqlSession session = SqlSessionUtil.createSqlSession(true)) {
                SQL_SESSION.set(session);
                return f.apply(null);
            } finally {
                SQL_SESSION.remove();
            }
        } else {
            return f.apply(null);
        }
    }

    public static <T> T withRollback(Function<Void, T> f, Class<? extends Throwable> exception) {
        SqlSession sqlSession = SqlSessionUtil.createSqlSession(false);
        SQL_SESSION.set(sqlSession);
        try {
            final T res = f.apply(null);
            // commit
            sqlSession.commit();
            return res;
        } catch (Throwable t) {
            if (exception != null && exception.isAssignableFrom(t.getClass())) {
                // rollback
                sqlSession.rollback();
            }
            throw t;
        } finally {
            sqlSession.close();
            SQL_SESSION.remove();
        }
    }
}

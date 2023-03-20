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
package org.urbcomp.cupid.db.metadata;

import org.apache.ibatis.session.SqlSession;
import org.urbcomp.cupid.db.metadata.accessor.IndexAccessor;
import org.urbcomp.cupid.db.metadata.accessor.TableAccessor;
import org.urbcomp.cupid.db.metadata.entity.*;
import org.urbcomp.cupid.db.util.UserDbTable;

import java.util.List;
import java.util.function.Function;

/**
 * utils of metadata access
 *
 * @author Wang Bohong
 * @date 2022-06-22
 */
public class MetadataAccessUtil {

    /**
     * 2 weeks
     */
    private final static int cleanExpiredTimeS = 14 * 24 * 3600;

    private final static IMetadataAccessor ACCESSOR = new MetadataAccessorFromCaffeineCache(
        new MetadataAccessorFromDb()
    );

    /**
     * check if table exists
     *
     * @param userName  user name
     * @param dbName    db name
     * @param tableName table name
     * @return isValid
     */
    public static boolean tableVerify(String userName, String dbName, String tableName) {
        return ACCESSOR.tableVerify(userName, dbName, tableName);
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
        return ACCESSOR.getFields(userName, dbName, tableName);
    }

    /**
     * get index list of the table
     *
     * @param userName  user name
     * @param dbName    db name
     * @param tableName table name
     * @return field list
     */
    public static List<Index> getIndexes(String userName, String dbName, String tableName) {
        return noRollback(v -> {
            Table table = getTable(userName, dbName, tableName);
            if (table == null) return null;
            IndexAccessor indexAccessor = AccessorFactory.getIndexAccessor();
            List<Index> indexes = indexAccessor.selectAllByFid(table.getId());
            indexes.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
            return indexes;
        });
    }

    /**
     * get table from metadata
     */
    public static Table getTable(String userName, String dbName, String tableName) {
        return ACCESSOR.getTable(userName, dbName, tableName);
    }

    public static Table getTable(long dbId, String tableName) {
        return ACCESSOR.getTable(dbId, tableName);
    }

    public static long insertTable(Table table) {
        return ACCESSOR.insertTable(table);
    }

    public static long insertField(Field field) {
        return ACCESSOR.insertField(field);
    }

    public static long insertIndex(Index index) {
        return noRollback(v -> AccessorFactory.getIndexAccessor().insert(index));
    }

    /**
     * query with cache
     */
    public static User getUser(String userName) {
        return ACCESSOR.getUser(userName);
    }

    public static long insertUser(User user) {
        return ACCESSOR.insertUser(user);
    }

    public static Database getDatabase(String userName, String dbName) {
        return ACCESSOR.getDatabase(userName, dbName);
    }

    public static long insertDatabase(Database database) {
        return ACCESSOR.insertDatabase(database);
    }

    public static long dropDatabase(String userName, String dbName) {
        return ACCESSOR.dropDatabase(userName, dbName);
    }

    public static long dropTable(String userName, String dbName, String tableName) {
        return ACCESSOR.dropTable(userName, dbName, tableName);
    }

    public static List<Database> getDatabases(String userName) {
        return ACCESSOR.getDatabases(userName);
    }

    public static List<Table> getTables(String userName, String dbName) {
        return ACCESSOR.getTables(userName, dbName);
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

    private final static ThreadLocal<SqlSession> SQL_SESSION = new ThreadLocal<>();

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = SQL_SESSION.get();
        if (sqlSession == null) {
            sqlSession = SqlSessionUtil.createSqlSession(true);
            SQL_SESSION.set(sqlSession);
        }
        return sqlSession;
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

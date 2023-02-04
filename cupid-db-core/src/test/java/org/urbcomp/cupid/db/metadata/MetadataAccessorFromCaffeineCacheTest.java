package org.urbcomp.cupid.db.metadata;

import org.junit.Test;
import org.urbcomp.cupid.db.metadata.entity.Database;
import org.urbcomp.cupid.db.metadata.entity.Field;
import org.urbcomp.cupid.db.metadata.entity.Table;
import org.urbcomp.cupid.db.metadata.entity.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MetadataAccessorFromCaffeineCacheTest {

    private final static long USER_ID = 1L;
    private final static long DB_ID = 1L;
    private final static long TABLE_ID = 1L;
    private final static String USERNAME = "jimo";
    private final static String DBNAME = "db";
    private final static String TABLE_NAME = "table";

    @Test
    public void testCache() {
        final MetadataAccessorFromCaffeineCache m = new MetadataAccessorFromCaffeineCache(new MockMetadataAccessor());

        final Table table = m.getTable(USERNAME, DBNAME, TABLE_NAME);
        assertEquals(TABLE_ID, table.getId());

        final Database database = m.getDatabase(USERNAME, DBNAME);
        assertEquals(DB_ID, database.getId());

        final User user = m.getUser(USERNAME);
        assertEquals(USER_ID, user.getId());

        assertTrue(m.dropUser(USERNAME) >= 0);
        assertTrue(m.dropDatabase(USERNAME, DBNAME) >= 0);
        assertTrue(m.dropTable(USERNAME, DBNAME, TABLE_NAME) >= 0);
    }

    private static class MockMetadataAccessor implements IMetadataAccessor {

        @Override
        public long insertField(Field field) {
            return 0;
        }

        @Override
        public List<Field> getFields(String userName, String dbName, String tableName) {
            return null;
        }

        @Override
        public Table getTable(String userName, String dbName, String tableName) {
            return new Table(TABLE_ID, DB_ID, TABLE_NAME, "HBase");
        }

        @Override
        public Table getTable(long dbId, String tableName) {
            return new Table(TABLE_ID, DB_ID, TABLE_NAME, "HBase");
        }

        @Override
        public boolean tableVerify(String userName, String dbName, String tableName) {
            return false;
        }

        @Override
        public long insertTable(Table table) {
            return 0;
        }

        @Override
        public long dropTable(String userName, String dbName, String tableName) {
            return 0;
        }

        @Override
        public List<Table> getTables(String userName, String dbName) {
            return null;
        }

        @Override
        public Database getDatabase(String userName, String dbName) {
            return new Database(DB_ID, USER_ID, DBNAME);
        }

        @Override
        public long insertDatabase(Database database) {
            return 0;
        }

        @Override
        public long dropDatabase(String userName, String dbName) {
            return 0;
        }

        @Override
        public List<Database> getDatabases(String userName) {
            return null;
        }

        @Override
        public User getUser(String userName) {
            return new User(USER_ID, USERNAME, "jimo");
        }

        @Override
        public long insertUser(User user) {
            return 0;
        }

        @Override
        public long dropUser(String userName) {
            return 0;
        }
    }
}
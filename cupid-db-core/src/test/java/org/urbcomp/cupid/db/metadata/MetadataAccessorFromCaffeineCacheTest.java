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
        final MetadataAccessorFromCaffeineCache m = new MetadataAccessorFromCaffeineCache(
            new MockMetadataAccessor()
        );

        final Table table = m.getTable(USERNAME, DBNAME, TABLE_NAME);
        assertEquals(TABLE_ID, table.getId());

        final Table table2 = m.getTable(DB_ID, TABLE_NAME);
        assertEquals(TABLE_ID, table2.getId());

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

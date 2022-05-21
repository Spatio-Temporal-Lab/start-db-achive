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

package org.urbancomp.start.db;

import org.junit.Assert;
import org.junit.Test;
import org.urbcomp.start.db.metadata.AccessorFactory;
import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor;
import org.urbcomp.start.db.metadata.accessor.FieldAccessor;
import org.urbcomp.start.db.metadata.accessor.TableAccessor;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.entity.User;
import java.util.List;

/**
 * test for Accessors
 * 
 * @author Wangbohong
 * @date 2022-05-21
 */
public class EntityAccessorTest {

    /**
     * test for userAccessor's basic functions
     */
    @Test
    public void userTest() {
        try (UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            User user1 = userAccessor.selectById(1L);
            User user2 = userAccessor.selectByName("Wangbohong");
            List<User> users = userAccessor.selectAll();
            int size = users.size();
            Assert.assertEquals("wrong", "User{id=1, name='Wangbohong', password='beecorn'}",
                            user1.toString());
            Assert.assertEquals(1, userAccessor.insert(new User(1L, "Wang", "abc123")));
            Assert.assertEquals(1L, userAccessor.update(new User(5L, "Wangbohong02", "beecorn")));
            Assert.assertEquals((long) (size + 1), userAccessor.selectAll().size());
        }
    }

    /**
     * test for user's DCL sentence.
     */
    @Test
    public void userDCLTest() {
        try (UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            int start = userAccessor.selectAll(false).size();
            Assert.assertEquals(1, userAccessor.insert(new User(1L, "Wang", "abc123"), false));
            userAccessor.rollback();
            int end = userAccessor.selectAll(false).size();
            Assert.assertEquals(start, end);
            Assert.assertEquals(1, userAccessor.insert(new User(1L, "Wang", "abc123"), false));
            userAccessor.commit();
            end = userAccessor.selectAll().size();
            Assert.assertEquals(start, end - 1);
            userAccessor.close();
        }
    }

    /**
     * test for DatabaseAccessor
     * 
     * @throws Exception
     */
    @Test
    public void databaseTest() throws Exception {
        try (DatabaseAccessor dbAccessor = AccessorFactory.getDatabaseAccessor()) {
            String name = "test";
            Database db1 = dbAccessor.selectById(1L);
            System.out.println(db1);
            Database db2 = dbAccessor.selectByName("test");
            List<Database> databases = dbAccessor.selectAll();
            int size = databases.size();
            Assert.assertEquals("wrong", "Database{id=1, name='test', userId=1}", db1.toString());
            Assert.assertEquals(1, dbAccessor.insert(new Database(1L, 1L, name)));
            Assert.assertEquals(1L, dbAccessor.update(new Database(2L, 1L, name + "_tmp")));
            Assert.assertEquals((long) (size + 1), dbAccessor.selectAll().size());
        }
    }

    /**
     * test for constraint
     * 
     * @throws Exception
     */
    @Test
    public void databaseConstraintTest() throws Exception {
        Database testForeign = new Database(1L, (long) Integer.MAX_VALUE, "testForeign");
        Database testInner = new Database(1L, 1L, "test");
        try (DatabaseAccessor databaseAccessor = AccessorFactory.getDatabaseAccessor()) {
            long res = databaseAccessor.insert(testForeign);
            res += databaseAccessor.insert(testInner);
            Assert.assertEquals(-2, res);
        }
    }

    /**
     * Test for TableAccessor
     * 
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        try (TableAccessor tableAccessor = AccessorFactory.getTableAccessor()) {
            String name = "test_tmp";
            Table table1 = tableAccessor.selectById(1L, true);
            Table test01 = tableAccessor.selectByName("test01");
            List<Table> tables = tableAccessor.selectAll();
            int size = tables.size();
            Assert.assertEquals("wrong",
                            "Table{id=1, name='test', dbId=1, storageEngine='default'}",
                            table1.toString());
            Assert.assertEquals(1, tableAccessor.insert(new Table(1L, 1L, name, "default")));
            Assert.assertEquals(1L,
                            tableAccessor.update(new Table(2L, 1L, name + "_tmp", "default")));
            Assert.assertEquals((long) (size + 1), tableAccessor.selectAll().size());
        }
    }

    /**
     * test for Field Accessor
     * 
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Field testForeign = new Field(1L, (long) Integer.MAX_VALUE, "testForeign", "varchar", 0);
        Field testInner = new Field(1L, 1L, "table_id", "varchar", 0);
        try (FieldAccessor fieldAccessor = AccessorFactory.getFieldAccessor()) {
            long res = fieldAccessor.insert(testForeign);
            res += fieldAccessor.insert(testInner);
            Assert.assertEquals(-2, res);
        }
    }
}

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
package org.urbcomp.cupid.db.jdbc;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.*;

@Ignore
public class DriverTest {

    @Test
    public void testDriver() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000;db=default",
                "cupid_db",
                "cupid-db"
            )
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("select count(1) from t_test");
            rs.next();
            assertTrue(rs.getInt(1) >= 0);
        }
    }

    @Test
    public void testQuery() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000",
                "cupid_db",
                "cupid-db"
            )
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("select * from `cupid_db.default.t_test`");
            final ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    assertNotNull(rs.getObject(i));
                }
            }
        }
    }

    @Test
    public void testQueryPrint() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000",
                "cupid_db",
                "cupid-db"
            )
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery(
                "select started_at,st_x(start_point) from `cupid_db.default.t_test`"
            );
            final ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(rs.getObject(i) + ",");
                }
                System.out.println();
            }
        }
    }

    @Test
    public void testShowCreateTable() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000",
                "cupid_db",
                "cupid-db"
            )
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("show create table `cupid_db.default.t_test`");
            final ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(rs.getObject(i) + ",");
                }
                System.out.println();
            }
        }
    }

    @Test
    public void testBatchInsert() throws SQLException {
        final Properties info = new Properties();
        info.put("user", "cupid_db");
        info.put("password", "cupid-db");
        info.put("db", "default");
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000",
                info
            )
        ) {
            final Statement stmt = conn.createStatement();

            for (int i = 0; i < 10; i++) {
                stmt.addBatch(
                    "Insert into t_test (idx, ride_id, start_point) values (171, '05608CC867EBDF63', st_makePoint(2.1, 2))"
                );
            }
            final int[] res = stmt.executeBatch();
            assertEquals(10, res.length);
        }
    }

    @Test
    public void testUseDb() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:cupid-db:url=http://127.0.0.1:8000;db=default",
                "cupid_db",
                "cupid-db"
            )
        ) {
            final Statement stmt = conn.createStatement();

            stmt.execute("use default");

            final ResultSet rs = stmt.executeQuery("select count(1) from t_test");
            rs.next();
            assertTrue(rs.getInt(1) >= 0);
        }
    }
}

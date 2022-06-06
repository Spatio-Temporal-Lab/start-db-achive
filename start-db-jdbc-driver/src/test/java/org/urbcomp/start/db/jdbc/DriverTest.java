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

package org.urbcomp.start.db.jdbc;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

@Ignore
public class DriverTest {

    @Test
    public void testDriver() throws SQLException {
        try (
                Connection conn = DriverManager.getConnection("jdbc:start-db:url=http://127.0.0.1:8000", "start_db", "start-db")
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("select count(1) from citibike_tripdata");
            rs.next();
            assertTrue(rs.getInt(1) >= 0);
        }
    }
}

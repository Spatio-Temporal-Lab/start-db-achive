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

package org.urbcomp.start.db.server;

import org.junit.Ignore;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

@Ignore
public class MainTest {

    @Test
    public void testJDBC() throws SQLException {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:avatica:remote:url=http://127.0.0.1:8000"
                )
        ) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("select count(1) from test_table01");
            rs.next();
            assertTrue(rs.getInt(1) >= 2);
        }
    }

    @Test
    public void testCalcite() throws SQLException, UnsupportedEncodingException {
        final Properties p = new Properties();
        final URL url = this.getClass().getResource("/model.json");
        p.put("model", URLDecoder.decode(url.toString(), "UTF-8").replace("file:", ""));
        try (Connection conn = DriverManager.getConnection("jdbc:calcite:", p)) {
            final Statement stmt = conn.createStatement();

            final ResultSet rs = stmt.executeQuery("select count(1) from test_table01");
            rs.next();
            assertTrue(rs.getInt(1) >= 2);
        }
    }
}

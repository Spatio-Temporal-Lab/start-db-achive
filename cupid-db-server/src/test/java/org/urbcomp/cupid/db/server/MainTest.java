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
package org.urbcomp.cupid.db.server;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;

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
}

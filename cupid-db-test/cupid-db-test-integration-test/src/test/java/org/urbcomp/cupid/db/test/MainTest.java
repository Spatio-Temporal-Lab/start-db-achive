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
package org.urbcomp.cupid.db.test;

import org.junit.Test;
import org.junit.Ignore;

import java.sql.*;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.urbcomp.cupid.db.test.GetData.getResultArray;
import static org.urbcomp.cupid.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.cupid.db.test.RunSingleSQLCase.runSingleCase;
import static org.urbcomp.cupid.db.test.RunSingleSQLCase.getConnect;

public class MainTest {
    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    @Ignore
    public void testDrop() throws Exception {
        try (
            Connection connection = getConnect();
            Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("create database if not exists testDrop");
            statement.executeUpdate("drop database testDrop");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Test
    @Ignore
    public void testUpdate() {
        try (Connection conn = getConnect(); Statement stmt = conn.createStatement()) {
            String sql = "create table int_table (int1 Integer)";
            int rowCount = stmt.executeUpdate(sql);
            log.info("影响的行数为:" + rowCount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Ignore
    public void testQuery() throws Exception {
        try (
            Connection conn = getConnect();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select * from t_test order by idx;")
        ) {
            List<String> resultArray = getResultArray(result);
            for (String s : resultArray) {
                log.info(s);
            }
        }
    }

    @Test
    @Ignore
    public void singleSQLCaseTest() throws Exception {
        // 执行单个xml测试用例文件
        String xmlResource = Objects.requireNonNull(
            RunSingleSQLCase.class.getClassLoader().getResource("cases/udf/math.xml")
        ).getPath();
        runSingleCase(xmlResource);
    }

    @Test
    @Ignore
    public void allSQLCaseTest() throws Exception {
        // 执行所有测试用例文件
        List<String> sqlCaseXMLs = getSqlCaseXMLs();
        for (String sqlCaseXML : sqlCaseXMLs) {
            runSingleCase(sqlCaseXML);
        }
    }
}

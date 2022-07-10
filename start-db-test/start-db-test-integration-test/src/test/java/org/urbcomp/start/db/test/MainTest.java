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

package org.urbcomp.start.db.test;

import org.junit.Test;
import org.junit.Ignore;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.urbcomp.start.db.test.GetData.getResultArray;
import static org.urbcomp.start.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.start.db.test.RunSingleSQLCase.runSingleCase;
import static org.urbcomp.start.db.test.AutoWriteExpect.writeExpect;
public class MainTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "root",
                "start-db"
            );
        } catch (Exception e) {
            System.out.println("创建Connection异常:" + e.getMessage());
        }
        return conn;
    }

    @Test
    @Ignore
    public void testAutoWriteExpect() throws Exception {
        String xmlPath = Objects.requireNonNull(
                MainTest.class.getClassLoader().getResource("cases/ddl/database.xml")
        ).getPath();
        writeExpect(xmlPath);

    }

    @Test
    @Ignore
    public void testUpdate(){
        try {
            Connection conn = getConn();
            Statement stmt = conn.createStatement();
            String sql = "create table int_table (int1 Integer)";
            int rowCount = stmt.executeUpdate(sql);
            System.out.println(rowCount);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @Ignore
    public void testQuery() throws Exception{
        Connection conn = getConn();
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("select * from t_test order by idx;");
        ArrayList<String> resultArray = getResultArray(result);
        for (String s : resultArray) {
            System.out.println(s);
        }
        result.close();
        stat.close();
        conn.close();
    }

    @Test
    @Ignore
    public void testPath() throws IOException {
        String xmlPath = Objects.requireNonNull(
            MainTest.class.getClassLoader().getResource("cases/ddl/database.xml")
        ).getPath();
        String parentPath = new File(xmlPath).getParentFile().getAbsolutePath();
        String path = parentPath + File.separator + "autoExpect";
        File folder = new File(path);
        if (!folder.exists() && !folder.isDirectory()) {
            boolean mkdir = folder.mkdirs();
            System.out.println("创建文件夹autoExpect:" + mkdir);
        }
        File file = new File(path + File.separator + "abc.xml");
        if (!file.exists() && !file.isFile()) {
            boolean newFile = file.createNewFile();
            System.out.println("创建文件:" + newFile);
        }

    }

    @Test
    @Ignore
    public void singleSQLCaseTest() throws Exception {
        // 执行单个xml测试用例文件
        String xmlResource = Objects.requireNonNull(
            RunSingleSQLCase.class.getClassLoader().getResource("cases/ddl/database.xml")
        ).getPath();
        log.info("xmlResource:" + xmlResource);
        runSingleCase(xmlResource);
    }

    @Test
    @Ignore
    public void allSQLCaseTest() throws Exception {
        // 执行所有测试用例文件
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();
        for (String sqlCaseXML : sqlCaseXMLs) {
            log.info("执行文件:" + sqlCaseXML);
            runSingleCase(sqlCaseXML);
        }
    }



}

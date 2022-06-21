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

import static org.urbcomp.start.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.start.db.test.RunSingleSQLCase.runSingleCase;

public class MainTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static Connection getConn() throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "start_db",
                "start-db"
            );
        } catch (Exception e) {
            System.out.println("出现异常:" + e.getMessage());
        }
        return conn;
    }

    @Test
    public void testShowTables() throws Exception {
        try {
            Connection conn = getConn();
            Statement stmt = conn.createStatement();
            String sql = "show tables;";
            int rowCount = stmt.executeUpdate(sql);
            System.out.println(rowCount);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateTable() throws Exception {
        try {
            Connection conn = getConn();
            Statement stmt = conn.createStatement();
            String sql = "create table all_Type ("
                + "int1 int, "
                + "int2 integer, "
                + "long_ long,"
                + "float_ float,"
                + "double_ double,"
                + "string_ string,"
                + "boolean1 bool,"
                + "boolean2 boolean,"
                + "binary_ binary,"
                + "datetime_ datetime,"
                + "timestamp_ timestamp,"
                + "geometry_ geometry,"
                + "point_ point,"
                + "linestring_ linestring,"
                + "polygon_ polygon,"
                + "MultiPoint_ multipoint,"
                + "MultiLineString_ MultiLineString,"
                + "MultiPolygon_ MultiPolygon,"
                + "GeometryCollection_ GeometryCollection"
                + ")";
            int rowCount = stmt.executeUpdate(sql);
            System.out.println(rowCount);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPath() throws IOException {
        String xmlPath = Objects.requireNonNull(
            RunSingleSQLCase.class.getClassLoader().getResource("cases/ddl/database.xml")
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
        String xmlResource = Objects.requireNonNull(
            RunSingleSQLCase.class.getClassLoader().getResource("cases/ddl/database.xml")
        ).getPath();
        log.info("xmlResource:" + xmlResource);
        runSingleCase(xmlResource);
    }

    @Test
    @Ignore
    public void allSQLCaseTest() throws Exception {
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();
        // 遍历
        for (String sqlCaseXML : sqlCaseXMLs) {
            log.info("执行文件:" + sqlCaseXML);
            runSingleCase(sqlCaseXML);
        }
    }

    @Test
    @Ignore
    public void singleUpdateSql() throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "start_db",
                "start-db"
            )
        ) {
            Statement stmt = conn.createStatement();
            String sql = "create table all_Type ("
                + "int1 int, "
                + "int2 integer, "
                + "long_ long,"
                + "float_ float,"
                + "double_ double,"
                + "string_ string,"
                + "boolean1 bool,"
                + "boolean2 boolean,"
                + "binary_ binary,"
                + "datetime_ datetime,"
                + "timestamp_ timestamp,"
                + "geometry_ geometry,"
                + "point_ point,"
                + "linestring_ linestring,"
                + "polygon_ polygon,"
                + "MultiPoint_ multipoint,"
                + "MultiLineString_ MultiLineString,"
                + "MultiPolygon_ MultiPolygon,"
                + "GeometryCollection_ GeometryCollection,"
                + "traj trajectory,"
                + "road1 roadSegment,"
                + "road2 roadNetwork"
                + ")";
            int rowCount = stmt.executeUpdate(sql);
            System.out.println(rowCount);
            stmt.close();
        }
    }

    @Test
    @Ignore
    public void singleQuerySql() throws SQLException {
        Connection connect;
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "start_db",
                "start-db"
            )
        ) {
            Statement stmt = conn.createStatement();
            // final ResultSet rs = stmt.executeQuery("select st_aswkt(st_makepoint(10,20))");
            ResultSet rs = stmt.executeQuery("select * from t_test order by idx;");

            int columnCount = rs.getMetaData().getColumnCount();
            System.out.println("col:" + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getMetaData().getColumnTypeName(i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getObject(i) + "\t");
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
        }
    }

    @Test
    @Ignore
    public void singleQuerySql2() throws SQLException {
        Connection connect;
        try (
            Connection conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "start_db",
                "start-db"
            )
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");
            ArrayList<String> result = GetData.getResultArray(rs);
            for (String row : result) {
                System.out.println(row);
            }
            rs.close();
            stmt.close();
        }
    }

}

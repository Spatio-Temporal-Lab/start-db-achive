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

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.urbcomp.start.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.start.db.test.RunSingleSQLCase.runSingleCase;


import java.nio.file.Paths;
import java.util.Properties;

public class MainTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws SQLException {
        Connection connect;
        Path path = Paths.get("E:\\GitHub\\start-db\\start-db-server\\src\\main\\resources\\model.json");
        System.out.println(path);
        String url = path.toAbsolutePath().toString();
        System.out.println(url);
        Properties config = new Properties();
        config.put("model", url);
        config.put("caseSensitive", "false");
        connect = DriverManager.getConnection("jdbc:calcite:fun=spatial", config);

        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1+1");

        Object object = resultSet.getObject(1);
        System.out.println(object);

        connect.close();
    }

    @Test
    public void singleSQLCaseTest() throws Exception {

        String xmlResource = Objects.requireNonNull(
            RunSingleSQLCase.class.getClassLoader().getResource("cases/dml/dml.xml")
        ).getPath();
        log.info("xmlResource:" + xmlResource);
        runSingleCase(xmlResource);

    }

    @Test
    public void allSQLCaseTest() throws Exception {
        // 获取所有sqlCase的xml文件路径
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();
        // 遍历
        for (String sqlCaseXML : sqlCaseXMLs) {
            log.info("执行文件:" + sqlCaseXML);
            runSingleCase(sqlCaseXML);
        }
    }


}

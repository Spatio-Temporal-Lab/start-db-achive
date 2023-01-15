/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.urbcomp.start.db.test.CompareResult.compareArrayData;
import static org.urbcomp.start.db.test.GetData.*;

public class RunSingleSQLCase {
    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean ERROR_STOP = true;
    static String DBNAME;
    static Date START_TIME;
    private final static Logger log = LoggerFactory.getLogger(RunSingleSQLCase.class);

    public static Connection getConnect() throws Exception {
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                "jdbc:start-db:url=http://127.0.0.1:8000",
                "root",
                "start-db"
            );
        } catch (Exception e) {
            throw new Exception("start-db 创建connect失败");
        }
        return conn;
    }

    /**
     * 执行指定xml文件中的sql用例并对返回值进行校验
     *
     * @param xmlPath xml文件路径
     * */
    public static void runSingleCase(String xmlPath) throws Exception {
        START_TIME = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMdd_HHmmss");
        try (Connection connect = getConnect()) {
            // 创建测试数据库并use
            DBNAME = String.format("td_%s", ft.format(START_TIME));
            try (Statement statement = connect.createStatement();) {
                statement.executeUpdate("create database is not exists " + DBNAME);
                statement.executeUpdate("use " + DBNAME);
            }
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();

            // 获取根标签下的所有case标签列表
            List<Element> caseElements = rootElement.elements();
            for (Element caseElement : caseElements) {
                // 获取case标签下的所有子标签列表
                List<Element> elements = caseElement.elements();
                // 第一个标签一定是sql
                if (elements.get(0).getName().equals("sql")) {
                    log.info("case的子标签内容有误, 跳过执行");
                    continue;
                }
                // 遍历单个case标签内的子标签列表
                String initSql = "";
                String sqlType = "";
                ArrayList<String> actualArray = new ArrayList<>();
                for (int i = 0; i < elements.size(); i++) {
                    try (Statement stmt = connect.createStatement()) {
                        // 每次执行sql都需要重新创建 Statement

                        Element element = elements.get(i);
                        String elementName = element.getName();

                        if (elementName.equals("sql")) {
                            sqlType = element.attributeValue("type");
                            initSql = element.getText();
                            // 检查是否需要拼接参数
                            if (!initSql.contains("?")) {
                                log.info("执行sql:" + initSql);
                                // 执行sql, 获取返回值
                                // 执行sql的替换
                                initSql = dataTransform(initSql);
                                actualArray = executeSql(stmt, initSql, sqlType);
                                // 比较预期结果和预期异常信息都在assertion标签中执行
                                // 如果下一个标签不是assertion标签, 需要直接判断返回结果
                                // 条件: 当前sql标签的类型必须为update, 且正确执行无异常
                                boolean isAssertion = false;
                                // 如果有下一个标签, 且标签为assertion, 则值为true
                                if (i + 1 < elements.size()) {
                                    isAssertion = elements.get(i + 1).getName().equals("assertion");
                                }
                                if (sqlType.equals("update")
                                    && !isAssertion
                                    && actualArray.size() == 0) {
                                    throw new Exception("sql执行有误" + initSql);
                                } else if (sqlType.equals("query") && !isAssertion) {
                                    throw new Exception("query标签无预期数据");
                                } else {
                                    log.info("执行完成");
                                }
                            }
                        } else if (elementName.equals("assertion")) {
                            String params = element.getText();
                            String expected = element.attributeValue("expected");

                            // 1. 有参数的话就重新拼接sql, 执行, 获取返回值
                            if (params != null) {
                                // 将参数和sql进行拼接
                                String sqlWithParam = getSqlWithParam(initSql, params);
                                log.info("执行sql:" + sqlWithParam);
                                // 2. 根据type来执行sql, 拿到实际结果
                                sqlWithParam = dataTransform(sqlWithParam);
                                actualArray = executeSql(stmt, sqlType, sqlWithParam);
                            }

                            // 2. 获取预期结果或者预期异常
                            ArrayList<String> expectArray = new ArrayList<>();
                            // 如果不是以 error开头说明有预期结果, 否则为预期异常
                            if (!expected.startsWith("error:")) {
                                expectArray = getExpectDataArray(expected, xmlPath);
                            } else {
                                expectArray.add(expected);
                            }

                            // 3. 有预期结果或者预期异常时, 与实际返回值进行比较
                            if (expectArray.size() != 0) {
                                compareArrayData(actualArray, expectArray);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (ERROR_STOP) {
                throw new Exception(e.getMessage());
            }
        }
        log.info("用例执行结束");
    }

    /**
     * 根据sql的type类型执行sql, 并返回结果
     *
     * @param sql 可执行的sql
     * @param sqlType sql的类型
     * @return sql执行后得到的返回值
     * */
    public static ArrayList<String> executeSql(Statement stmt, String sqlType, String sql) {
        ArrayList<String> actualValue = new ArrayList<>();
        try {
            switch (sqlType) {
                case "update":
                    stmt.executeUpdate(sql);
                    break;
                case "query":
                    try (ResultSet result = stmt.executeQuery(sql)) {
                        actualValue = GetData.getResultArray(result);
                    }
                    break;
                case "ignore":
                    log.info("忽略执行:" + sql);
                    break;
                default:
                    log.info("sql标签的type类型有误");
            }
        } catch (Exception e) {
            // 捕获异常信息
            actualValue.add(e.getMessage());
        }
        return actualValue;
    }
}

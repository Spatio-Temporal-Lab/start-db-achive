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

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.urbcomp.cupid.db.test.CompareResult.*;
import static org.urbcomp.cupid.db.test.GetData.*;

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
                "jdbc:cupid-db:url=http://127.0.0.1:8000",
                "root",
                "cupid-db"
            );
        } catch (Exception e) {
            throw new Exception("cupid-db 创建connect失败");
        }
        return conn;
    }

    /**
     * 执行指定xml文件中的sql用例并对返回值进行校验
     *
     * @param xmlPath xml文件路径
     */
    public static void runSingleCase(String xmlPath) throws Exception {
        try (Connection connect = getConnect()) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(xmlPath);

            // 获取xml文件名
            Element xmlElement = (Element) document.selectSingleNode("//resultXml");
            String xmlName = xmlElement.getText();

            // 获取所有case标签
            List<Node> caseElements = document.selectNodes("//case");
            for (int i = 0; i < caseElements.size(); i++) {
                Element caseElement = (Element) caseElements.get(i);

                // 第一个标签一定是sql
                if (!caseElement.node(1).getName().equals("sql")) {
                    log.info("case的子标签内容有误, 跳过执行");
                    continue;
                }
                
                // 获取case标签下的sql标签和arguments标签列表
                List<Element> sqlElements = caseElement.elements("sql");
                List<Element> argumentsElements = caseElement.elements("arguments");
                List<String> actualArray;

                // 遍历单个case标签内的sql标签列表
                for (Element sqlElement : sqlElements) {
                    String initSql = sqlElement.getText();
                    String sqlType = sqlElement.attributeValue("type");

                    // sql不需要拼接参数时
                    if (!initSql.contains("?")) {
                        if (sqlType.equals("query") && sqlElement.attributeValue("resultID") != null) {
                            String resultID = sqlElement.attributeValue("resultID");
                            log.info("开始执行sql:" + initSql + " resultID: " + resultID);
                        } else {
                            log.info("开始执行sql:" + initSql);
                        }
                        // 替换sql中的文本内容然后执行sql, 获取返回值
                        initSql = dataTransform(initSql);
                        // 每次执行sql都需要重新创建 Statement
                        try (Statement stmt = connect.createStatement()) {
                            actualArray = executeSql(stmt, initSql, sqlType);
                        }
                        System.out.println("实际返回值： " + actualArray);
                        log.info("sql执行完成");
                    }
                    // sql需要拼接参数时
                    else {
                        for(Element argumentsElement : argumentsElements) {
                            String params = argumentsElement.getText();
                            String resultID = argumentsElement.attributeValue("resultID");
                            String error = argumentsElement.attributeValue("error");
                            List<String> expectedArray = new ArrayList<>();

                            // 将sql和参数进行拼接
                            String sqlWithParam = getSqlWithParam(initSql, params);
                            if (resultID == null && error == null || resultID != null && error != null) {
                                throw new Exception("参数标签格式不对");
                            }

                            // 有预期结果获取并加入预期数据中,然后与实际数据进行比较
                            if (resultID != null) {
                                log.info("开始执行sql:" + sqlWithParam + " resultID: " + resultID);
                                sqlWithParam = dataTransform(sqlWithParam);
                                try (Statement stmt = connect.createStatement()) {
                                    actualArray = executeSql(stmt, sqlWithParam, sqlType);
                                }
                                System.out.println("实际返回值： " + actualArray);
                                expectedArray = getExpectedDataArray(xmlName, xmlPath, resultID);
                                System.out.println("预期返回值： " + expectedArray);
                                compareResult(actualArray, expectedArray);
                            }

                            // 有预期异常加入预期数据中，然后与实际数据进行比较
                            else {
                                if (!error.contains("Exception")) {
                                    throw new Exception("预期异常内容不对");
                                }
                                else {
                                    log.info("开始执行sql:" + sqlWithParam);
                                    sqlWithParam = dataTransform(sqlWithParam);
                                    try (Statement stmt = connect.createStatement()) {
                                        actualArray = executeSql(stmt, sqlWithParam, sqlType);
                                    }
                                    System.out.println("实际返回值： " + actualArray);
                                    expectedArray.add(error);
                                    System.out.println("预期异常： " + expectedArray);
                                    compareException(actualArray, expectedArray);
                                }
                            }
                            log.info("sql执行完成");
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
     * @param sql     可执行的sql
     * @param sqlType sql的类型
     * @return sql执行后得到的返回值
     */
    public static List<String> executeSql(Statement stmt, String sql, String sqlType) {
        List<String> actualValue = new ArrayList<>();
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
                    log.info(sql + ":sql标签的type类型有误");
            }
        } catch (Exception e) {
            // 捕获异常信息
            actualValue.add(e.toString());
        }
        return actualValue;
    }
}

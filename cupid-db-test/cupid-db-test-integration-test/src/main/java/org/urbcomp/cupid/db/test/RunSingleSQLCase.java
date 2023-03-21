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
import static org.urbcomp.cupid.db.test.AutoWriteActual.*;

public class RunSingleSQLCase {
    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean ERROR_STOP = true;
    // 用一个静态变量来控制是否自动将实际返回值写入xml文件中
    static boolean WRITE_ACTUAL = true;
    // 分别用一个静态变量来控制是否比较执行结果或异常
    static boolean COMPARE_RESULT = true;
    static boolean COMPARE_EXCEPTION = true;
    // 用一个静态变量来控制是否输出过程信息
    static boolean OUTPUT_MESSAGE = false;
    static String XML_PATH;
    static String XML_NAME;
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
     * @param xmlPath 要执行的xml文件路径
     */
    public static void runSingleCase(String xmlPath) throws Exception {
        XML_PATH = xmlPath;
        log.info("xmlPath:" + XML_PATH);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(XML_PATH);
        log.info("开始执行测试用例");

        // 获取储存sql执行结果的xml文件名
        Element xmlElement = (Element) document.selectSingleNode("//resultXml");
        XML_NAME = xmlElement.getText();

        // 获取所有case标签
        List<Node> caseElements = document.selectNodes("//case");
        for (Node element : caseElements) {
            Element caseElement = (Element) element;
            // 第一个标签一定是sql
            if (!caseElement.node(1).getName().equals("sql")) {
                log.info("case的子标签内容有误, 跳过执行");
                continue;
            }

            // 获取case标签下的sql标签和arguments标签列表
            List<Element> sqlElements = caseElement.elements("sql");
            List<Element> argumentsElements = caseElement.elements("arguments");

            // 遍历单个case标签内的sql标签列表
            for (Element sqlElement : sqlElements) {
                String initSql = sqlElement.getText();
                String sqlType = sqlElement.attributeValue("type");

                // sql不需要拼接参数时
                if (!initSql.contains("?")) {
                    analyseSql(sqlElement, initSql, sqlType);
                } else {
                    // sql需要拼接参数时
                    for (Element argumentsElement : argumentsElements) {
                        // 将sql和参数进行拼接
                        String params = argumentsElement.getText();
                        String sqlWithParam = getSqlWithParam(initSql, params);
                        analyseSql(argumentsElement, sqlWithParam, sqlType);
                    }
                }
            }
        }
        if (WRITE_ACTUAL) {
            writeActualXml(XML_PATH, XML_NAME);
        }
        log.info("测试用例执行结束");
    }

    /**
     * 解析当前xml中的结点决定要如何执行sql
     *
     * @param element 当前结点
     * @param sql     要执行的sql
     * @param sqlType sql的类型
     */
    public static void analyseSql(Element element, String sql, String sqlType) throws Exception {
        try (Connection connect = getConnect()) {
            List<String> actualArray;
            String resultID = element.attributeValue("resultID");
            String exception = element.attributeValue("exception");
            if (resultID != null && exception != null) {
                throw new Exception("参数标签格式不对");
            }

            // 有预期结果获取并加入预期数据中,然后与实际数据进行比较
            if (resultID != null) {
                if (OUTPUT_MESSAGE) {
                    log.info("开始执行sql: " + sql + " resultID: " + resultID);
                }
                sql = dataTransform(sql);
                // 执行sql并选择是否将实际返回值写入文档
                try (Statement stmt = connect.createStatement()) {
                    actualArray = executeSql(stmt, sql, sqlType);
                    if (WRITE_ACTUAL) {
                        writeActualDocument(actualArray, resultID);
                    }
                }
                if (OUTPUT_MESSAGE) {
                    log.info("实际返回值：" + actualArray);
                }
                // 选择是否进行结果比较，是的话获取预期结果然后与实际结果进行比较
                if (COMPARE_RESULT) {
                    List<String> expectedArray;
                    expectedArray = getExpectedDataArray(XML_PATH, XML_NAME, resultID);
                    if (OUTPUT_MESSAGE) {
                        log.info("预期返回值：" + expectedArray);
                    }
                    compareResult(actualArray, expectedArray);
                }
                if (OUTPUT_MESSAGE) {
                    log.info("sql执行完成");
                }
            } else if (exception != null) {
                // 有预期异常加入预期数据中，然后与实际数据进行比较
                if (!exception.contains("Exception")) {
                    throw new Exception("预期异常内容不对");
                } else {
                    if (OUTPUT_MESSAGE) {
                        log.info("开始执行sql: " + sql);
                    }
                    sql = dataTransform(sql);
                    try (Statement stmt = connect.createStatement()) {
                        actualArray = executeSql(stmt, sql, sqlType);
                    }
                    if (OUTPUT_MESSAGE) {
                        log.info("实际返回值：" + actualArray);
                    }
                    // 选择是否进行异常比较，是的话获取预期异常与实际异常进行比较
                    if (COMPARE_EXCEPTION) {
                        List<String> expectedArray = new ArrayList<>();
                        expectedArray.add(exception);
                        if (OUTPUT_MESSAGE) {
                            log.info("预期异常：" + expectedArray);
                        }
                        compareException(actualArray, expectedArray);
                    }
                    if (OUTPUT_MESSAGE) {
                        log.info("sql执行完成");
                    }
                }
            } else {
                // 没有预期结果和异常
                if (OUTPUT_MESSAGE) {
                    log.info("开始执行sql: " + sql);
                }
                sql = dataTransform(sql);
                try (Statement stmt = connect.createStatement()) {
                    executeSql(stmt, sql, sqlType);
                }
                if (OUTPUT_MESSAGE) {
                    log.info("sql执行完成");
                }
            }
        } catch (Exception e) {
            if (ERROR_STOP) {
                throw new Exception(e.getMessage());
            }
        }
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

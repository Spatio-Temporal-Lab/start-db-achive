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
            Element rootElement = document.getRootElement();

            // 获取根标签下的所有标签列表
            List<Element> elementlist = rootElement.elements();

            // 获取xml文件名
            Element xmlElemnt = elementlist.get(0);
            String xmlName = xmlElemnt.getText();

            for (int j = 1; j < elementlist.size(); j++) {
                // 获取case标签下的所有子标签列表
                Element caseElement = elementlist.get(j);
                List<Element> elements = caseElement.elements();

                // 第一个标签一定是sql
                if (!elements.get(0).getName().equals("sql")) {
                    log.info("case的子标签内容有误, 跳过执行");
                    continue;
                }
                String initSql = "";
                String sqlType = "";
                List<String> actualArray = new ArrayList<>();

                // 遍历单个case标签内的子标签列表
                for (int i = 0; i < elements.size(); i++) {
                    // 每次执行sql都需要重新创建 Statement
                    try (Statement stmt = connect.createStatement()) {
                        Element element = elements.get(i);
                        String elementName = element.getName();
                        List<String> expectedArray = new ArrayList<>();

                        // 如果当前是sql标签
                        if (elementName.equals("sql")) {
                            initSql = element.getText();
                            sqlType = element.attributeValue("type");

                            // 不需要拼接参数时
                            if (!initSql.contains("?")) {
                                if (sqlType.equals("query")
                                    && elements.get(i + 1).attributeValue("resultID") != null) {
                                    String resultID = elements.get(i + 1)
                                        .attributeValue("resultID");
                                    log.info("开始执行sql:" + initSql + " resultID: " + resultID);
                                } else {
                                    log.info("开始执行sql:" + initSql);
                                }
                                // 替换sql中的文本内容然后执行sql, 获取返回值
                                initSql = dataTransform(initSql);
                                actualArray = executeSql(stmt, initSql, sqlType);
                                System.out.println("实际返回值： " + actualArray);
                                if (i + 1 >= elements.size()
                                    || elements.get(i + 1).getName().equals("sql")) {
                                    log.info("sql执行完成");
                                }
                            }
                        }
                        // 如果当前是arguments标签
                        else if (elementName.equals("arguments")) {
                            String params = element.getText();
                            String resultID = element.attributeValue("resultID");
                            String error = element.attributeValue("error");
                            if (resultID == null && error == null
                                || resultID != null && error != null) {
                                throw new Exception("参数标签格式不对");
                            }

                            // 有参数的话就重新拼接sql然后执行, 获取返回值
                            if (!params.equals("")) {
                                // 将参数和sql进行拼接
                                String sqlWithParam = getSqlWithParam(initSql, params);
                                log.info("开始执行sql:" + sqlWithParam + " resultID: " + resultID);
                                // 根据type来执行sql, 拿到实际结果
                                sqlWithParam = dataTransform(sqlWithParam);
                                actualArray = executeSql(stmt, sqlWithParam, sqlType);
                                System.out.println("实际返回值： " + actualArray);
                            }

                            // 有预期结果获取并加入预期数据中,然后与实际数据进行比较
                            if (resultID != null) {
                                expectedArray = getexpectedDataArray(xmlName, xmlPath, resultID);
                                System.out.println("预期返回值： " + expectedArray);
                                compareResult(actualArray, expectedArray);
                            }

                            // 如果有预期异常加入预期数据中，然后与实际数据进行比较
                            else {
                                if (!error.contains("Exception")) {
                                    throw new Exception("预期异常内容不对");
                                } else {
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

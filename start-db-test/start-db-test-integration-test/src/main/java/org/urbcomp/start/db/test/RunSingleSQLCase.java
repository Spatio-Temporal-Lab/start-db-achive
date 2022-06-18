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

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.urbcomp.start.db.test.CompareResult.compareData;
import static org.urbcomp.start.db.test.GetSQLAndExpectData.getExpectData;
import static org.urbcomp.start.db.test.GetSQLAndExpectData.getSqlWithParam;

public class RunSingleSQLCase {
    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean ERROR_STOP = true;
    private final static Logger log = LoggerFactory.getLogger(RunSingleSQLCase.class);

    /**
     * 执行指定xml文件中的sql用例并对返回值进行校验
     *
     * @param xmlPath xml文件路径
     * */
    public static void runSingleCase(String xmlPath) throws Exception {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();

            // 获取根标签下的所有case标签列表
            List<Element> caseElements = rootElement.elements();
            for (Element caseElement : caseElements) {
                // 获取case标签下的所有子标签列表
                List<Element> elements = caseElement.elements();
                // 第一个标签一定是sql, 如果不是, 抛异常
                if (elements.get(0).getName().equals("sql")) {
                    throw new Exception("case标签的内容有误");
//                        log.info  然后continue
                }
                // 遍历单个case标签内的子标签列表
                for (int i = 0; i < elements.size(); i++){
                    Element element = elements.get(i);
                    String elementName = element.getName();
                    String initSql = "";
                    String sqlType = "";
                    String actualValue = "";

                    // 如果标签为sql标签
                    if (elementName.equals("sql")){
                        sqlType = element.attributeValue("type");
                        initSql = element.getText();
                        // 检查是否需要拼接参数
                        if (!initSql.contains("?")){
                            // 执行sql
                            actualValue = executeSql(initSql, sqlType);
                        }
                        // 如果标签为assertion标签

                    }else if (elementName.equals("assertion")) {
                        String params = element.getText();
                        String paramId = element.attributeValue("paramId");
                        String expected = element.attributeValue("expected");

                        // 1. 有参数的话就重新拼接sql, 执行, 获取返回值
                        if (params != null) {
                            // 解析参数 将参数和sql进行拼接, 得到拼接后的sql
                            String sqlWithParam = getSqlWithParam(initSql, params);

                            // 2. 根据type来执行sql, 预期值重新赋值
                            actualValue = executeSql(sqlType, sqlWithParam);
                        }

                        // 2. 获取预期结果或者预期异常
                        String expectValue = "";
                        if (paramId != null && expected != null) {
                            // 获取预期结果
                            getExpectData(expected, xmlPath, paramId);
                            expectValue = "";
                        } else if (paramId == null && expected != null){
                            // 获取预期异常
                            expectValue = expected.replace("error:", "").trim();
                        }

                        // 3. 有预期结果或者预期异常时, 与实际返回值进行比较
                        if (!expectValue.equals("")){
                            compareData(actualValue, expectValue);
                        }
                    }

                }

            }
        } catch (Exception e) {
            if (ERROR_STOP) {
                throw new Exception(e.getMessage());
            }
        }
    }

    private static String executeSql(String sqlType, String sql) {
        String actualValue = "";
        try{
            switch (sqlType){
                case "update":
                    // 执行sql
                    break;
                case "query":
                    // 执行sql 并拿到实际返回结果
                    actualValue = "returnData";
                    break;
                case "ignore":
                    // log.info 跳过执行
                default:
                    throw new Exception("sql标签的type类型有误");
            }
        }catch (Exception e) {
            // 捕获异常信息
            actualValue = e.getMessage();

        }
        return actualValue;
    }
}

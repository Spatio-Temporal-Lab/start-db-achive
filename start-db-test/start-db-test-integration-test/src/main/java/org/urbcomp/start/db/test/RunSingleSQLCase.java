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
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

import static org.urbcomp.start.db.test.CompareActualAndExpect.compareData;
import static org.urbcomp.start.db.test.GetSQLAndExpectData.getSqlWithParam;

public class RunSingleSQLCase {
    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean ERROR_STOP = true;

    /**
     * 执行指定xml文件中的sql用例并对返回值进行校验
     *
     * @param xmlPath xml文件路径
     * */
    public static void runSingleCase(String xmlPath) throws Exception {
        try {
            SAXReader saxReader = new SAXReader();
            // String xmlResource = Objects.requireNonNull(
            // RunSingleSQLCase.class.getClassLoader().getResource("cases/dml/dml.xml")
            // ).getPath();
            // System.out.println(xmlResource);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();

            // 获取根标签下的所有子元素列表
            List<Element> caseElements = rootElement.elements();
            for (Element caseElement : caseElements) {
                // 获取case标签的type类型 sql子标签的文本
                String type = caseElement.attributeValue("type");
                String sqlText = caseElement.elementText("sql");
                List<Node> assertionList = caseElement.selectNodes("assertion");
                // 当assertion标签数量不为空的时候, 再执行下面的代码
                if (assertionList.size() != 0) {
                    for (Node node : assertionList) {
                        Element assertionElement = (Element) node;
                        // 获取assertion标签的属性值: id parameters 和 expected
                        String paramId = assertionElement.attributeValue("id");
                        String parameters = assertionElement.attributeValue("parameters");
                        String expectData = assertionElement.attributeValue("expected");
                        // 获取拼接参数后的sql
                        String sql;
                        if (parameters == null || parameters.equals("")) {
                            sql = sqlText;
                        } else {
                            sql = getSqlWithParam(sqlText, parameters);
                        }
                        System.out.println("执行sql:" + sql);

                        // 获取预期值或预期异常
                        String expectValue = "";
                        if (expectData != null && !expectData.equals("")) {
                            // expectValue = getExpectData(expectData, xmlPath, paramId);
                        }

                        // 初始化一个空的实际返回值actualValue
                        String actualValue;
                        try {
                            // todo 执行拼接后的sql, 拿到实际返回值actualValue 或者 捕获预期异常

                            actualValue = "returnData";
                        } catch (Exception e) {
                            actualValue = "errorMessage";
                        }
                        // 如果预期结果不为空,就对实际结果进行验证
                        if (!expectValue.equals("")) {
                            System.out.print("比较预期值:");
                            try {
                                compareData(actualValue, expectValue);
                            } catch (Exception e) {
                                // 通过静态变量来控制异常是否抛出
                                if (ERROR_STOP) {
                                    throw new Exception("出现异常信息");
                                }
                            }
                        } else {
                            System.out.println("执行通过");
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

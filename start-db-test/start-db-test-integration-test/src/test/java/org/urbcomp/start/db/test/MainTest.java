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
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.urbcomp.start.db.test.CompareActualAndExpect.compareData;
import static org.urbcomp.start.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.start.db.test.GetSQLAndExpectData.getExpectData;
import static org.urbcomp.start.db.test.GetSQLAndExpectData.getSqlWithParam;

public class MainTest {

    // 用一个静态变量来控制出现报错后是否继续执行, 是否抛出异常
    static boolean errorStop = true;

    /**
     * 1. 首先拿到所有的 sql用例 case文件
     * 2. 遍历每一个文件中的  case 标签
     * 3. 遍历参数, 将参数与sql拼接, 然后执行拼接后的sql
     * 4. 获取参数对应的预期值
     * 5. 实际结果与预期值进行比较
     *
     * */

    @Test
    public void allSQLCaseTest() {
        // todo 执行全部xml文件
        // 1. 获取所有的 sqlCase的xml文件路径
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();
        // 遍历所有xml文件
        for (String sqlCaseXML : sqlCaseXMLs) {
            // 具体实现逻辑见下面的 Test
        }

    }

    @Test
    public void singleSQLCaseTest() throws Exception {
        // todo 执行指定的xml文件
        SAXReader saxReader = new SAXReader();
        String xmlResource = Objects.requireNonNull(
            MainTest.class.getClassLoader().getResource("cases/dml/dmlcase.xml")
        ).getPath();
        System.out.println(xmlResource);
        try {
            Document document = saxReader.read(xmlResource);
            Element rootElement = document.getRootElement();

            // 获取跟标签下的所有子元素列表
            List<Element> caseElements = rootElement.elements();
            for (Element caseElement : caseElements) {
                // 获取case标签下 sql子标签的文本, 以及assertion标签的属性值: parameters 和 expected-data-file
                Element sqlElement = (Element) caseElement.selectNodes("sql").get(0);
                String sqlText = sqlElement.toString();
                List<Node> assertionList = caseElement.selectNodes("assertion");

                for (Node node : assertionList) {
                    Element assertionElement = (Element) node;
                    String parameters = assertionElement.attributeValue("parameters");
                    String expectData = assertionElement.attributeValue("expected-data-file");

                    // expectData不为空的情况下去执行, 如果parameters为空的话, 就跳过sql和参数的拼接
                    String ConcatSql = sqlText;
                    String expectValue = "";
                    if (!Objects.equals(parameters, "")) {
                        ConcatSql = getSqlWithParam(sqlText, parameters);
                    }
                    if (!Objects.equals(expectData, "")) {
                        expectValue = getExpectData(expectData);
                    }
                    // 初始化一个空的实际返回值actualValue
                    String actualValue = "";
                    try {
                        // todo 执行拼接后的sql, 拿到实际返回值actualValue
                        if (!expectValue.equals("")) {
                            actualValue = ConcatSql;
                        } else {
                            // todo 只执行sql, 不获取返回值
                        }
                    } catch (Exception e) {
                        actualValue = "errorMessage";
                    }
                    // 如果预期结果不为空,就对实际结果进行验证
                    if (!expectValue.equals("")) {
                        try {
                            compareData(actualValue, expectValue);
                        } catch (Exception e) {
                            // 通过静态变量来控制异常是否抛出
                            if (errorStop) {
                                throw new Exception("出现异常信息");
                            }
                        }
                    }

                }

            }

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}

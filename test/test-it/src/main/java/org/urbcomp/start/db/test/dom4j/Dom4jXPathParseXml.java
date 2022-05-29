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

package org.urbcomp.start.db.test.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;


public class Dom4jXPathParseXml {
/**
 * 个人练习
 *
 * */
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(
                Dom4jXPathParseXml.class.getClassLoader().getResource("cases/dql/testcase.xml")
            );

            System.out.println("1. 使用绝对路径方式查找元素");
            Element element = (Element) document.selectSingleNode("/testcase/case/sql");
            String sql = element.getText();
            System.out.println(sql);

            System.out.println("2. 使用相对路径的方式查找元素");
            Element result = (Element) element.selectSingleNode("../result");
            System.out.println(result.getText());

            System.out.println("3. 使用全文搜索的方式");
            List<Node> nodes = document.selectNodes("//sql");
            for (Node node : nodes) {
                Element sqlElement = (Element) node;
                System.out.println(sqlElement.getText());
            }

            System.out.println("4. 谓语(条件筛选)方式");
            Element idElement = (Element) document.selectSingleNode("//case[@id='1']");
            List<Element> idelements = idElement.elements();
            System.out.println(idelements.size());
            for (Element ele : idelements) {
                System.out.println("名称：" + ele.getName());
                System.out.println("文本：" + ele.getTextTrim());
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}

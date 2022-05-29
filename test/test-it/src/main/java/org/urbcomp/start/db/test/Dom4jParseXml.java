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
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

public class Dom4jParseXml {
/**
 * 个人练习
 *
 * */
    public static void main(String[] args) {
        // 创建解析器对象
        SAXReader saxReader = new SAXReader();

        try {
            // 读取 xml 文件
            URL xmlResource = Dom4jParseXml.class.getClassLoader()
                .getResource("cases/dql/testcase.xml");
            // 创建文档对象
            Document document = saxReader.read(xmlResource);
            // 获取根节点标签
            Element rootElement = document.getRootElement();
            System.out.println("1.根节点的名字是" + rootElement.getName());

            System.out.println("2.获取根标签的子标签列表");
            List<Element> usersSubElementList = rootElement.elements();
            for (Element usersSubElement : usersSubElementList) {
                System.out.println("子标签的名字是" + usersSubElement.getName());
                System.out.println("子标签的id属性值是" + usersSubElement.attributeValue("id"));
                System.out.println("子标签的属性值是" + usersSubElement.attributeValue(""));

                // 获取子标签中的子标签列表
                List<Element> userSubElementList = usersSubElement.elements();
                for (Element userSubElement : userSubElementList) {
                    System.out.println("子标签的名字是" + userSubElement.getName());
                    System.out.println("子标签的文本是" + userSubElement.getText());

                }

            }

            // 获取根标签的第一个子标签
            Element firstElement = rootElement.element("case");
            // 获取第一个子标签的子标签xxx的文本
            String xxx = firstElement.elementText("sql");
            System.out.println(xxx);

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}

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
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import static org.urbcomp.cupid.db.test.GetData.getSqlWithParam;
import static org.urbcomp.cupid.db.test.GetData.dataTransform;
import static org.urbcomp.cupid.db.test.RunSingleSQLCase.getConnect;
import static org.urbcomp.cupid.db.test.RunSingleSQLCase.executeSql;

public class AutoWriteExpect {
    private final static Logger log = LoggerFactory.getLogger(AutoWriteExpect.class);

    /**
     * 自动执行测试用例, 并将返回值写入到target文件夹的文件中
     *
     * @param xmlPath 用例的路径
     *
     * */
    public static void writeExpect(String xmlPath) throws Exception {
        // 1. 执行sql文件, 得到异常信息 或 预期结果
        // 2. 将返回值写入到文件同目录下的文件夹中, 文件名用assertion标签中的
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(xmlPath);
        Element rootElement = document.getRootElement();
        // 获取根标签下的所有case标签列表
        List<Element> caseElements = rootElement.elements();
        try (Connection connect = getConnect(); Statement stmt = connect.createStatement()) {
            for (Element caseElement : caseElements) {
                // 获取case标签下的所有子标签列表
                List<Element> elements = caseElement.elements();

                String initSql = "";
                String sqlType = "";
                ArrayList<String> actualArray;
                for (int i = 0; i < elements.size(); i++) {
                    // 每次执行sql都需要重新创建 Statement
                    Element element = elements.get(i);
                    String elementName = element.getName();

                    if (elementName.equals("sql")) {
                        sqlType = element.attributeValue("type");
                        initSql = element.getText();
                    } else if (elementName.equals("assertion")) {
                        // 将执行结果存到预期文件中, 不包含预期异常
                        String params = element.getText();
                        String expectFileName = element.attributeValue("expected");
                        // 有参数的话就重新拼接sql, 根据type来执行sql, 获取返回值
                        String sql;
                        if (params != null) {
                            // 将参数和sql进行拼接
                            sql = getSqlWithParam(initSql, params);
                        } else {
                            sql = initSql;
                        }
                        log.info("执行sql:" + sql);
                        sql = dataTransform(sql);
                        actualArray = executeSql(stmt, sqlType, sql);

                        // 预期值为文件名的时候再将结果保存为文件
                        if (expectFileName != null && !expectFileName.startsWith("error")) {
                            String expectFilePath = xmlPath + File.separator + expectFileName;
                            try (FileWriter out = new FileWriter(expectFilePath)) {
                                createDocument(actualArray).write(out);

                                // 转成字符串
                                OutputFormat format = OutputFormat.createPrettyPrint();
                                format.setEncoding("UTF-8");
                                XMLWriter writer = new XMLWriter(System.out, format);
                                writer.write(createDocument(actualArray));
                            } catch (IOException e) {
                                log.info(e.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 将执行结果写入到文档
     * @param actualArray 预期结果的字符串数组
     * @return 预期结果对应的文档
     * */
    private static Document createDocument(ArrayList<String> actualArray) {
        Document writeDoc = DocumentHelper.createDocument();
        // 编辑文档内容
        // 创建元素的根节点
        Element dataset = writeDoc.addElement("dateset");
        // 添加表头元素和属性值, 返回的数据中, 第一行时表头名, 第二行是对应的属性
        Element metadata = dataset.addElement("metadata");
        // 获取表头个数, 然后循环读取写入到metadata元素中
        String[] headerList = actualArray.get(0).split("\t");
        String[] headerTypeList = actualArray.get(1).split("\t");
        for (int j = 0; j < headerList.length; j++) {
            metadata.addElement("column")
                .addAttribute("name", headerList[j])
                .addAttribute("type", headerTypeList[j]);
        }
        // 添加行元素, 返回的字符串数组, 从第三行都是单行的数据
        for (int k = 2; k < actualArray.size(); k++) {
            dataset.addElement("row").addText(actualArray.get(k));
        }
        return writeDoc;
    }

}

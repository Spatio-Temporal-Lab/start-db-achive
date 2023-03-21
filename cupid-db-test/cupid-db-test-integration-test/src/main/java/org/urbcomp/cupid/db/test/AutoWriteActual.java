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

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;

public class AutoWriteActual {
    private final static Logger log = LoggerFactory.getLogger(AutoWriteActual.class);
    static Document document = DocumentHelper.createDocument();

    /**
     * 将实际返回值写入文档中
     *
     * @param actualArray 实际返回值
     * @param resultID 返回结果的id
     */
    public static void writeActualDocument(List<String> actualArray, String resultID) {
        // 编辑文档内容
        // 创建元素的根节点
        if (!document.hasContent()) {
            document.addElement("actualResult");
        }
        Element actualResult = document.getRootElement();

        // 添加返回结果
        Element result = actualResult.addElement("result");
        result.addAttribute("id", resultID);

        // 添加字段, 返回的数据中, 第一行是字段名, 第二行是字段属性
        String columnName = actualArray.get(0).trim();
        String columnType = actualArray.get(1).trim();
        result.addElement("column");
        Element column = result.element("column");
        column.addAttribute("name", columnName);
        column.addAttribute("type", columnType);

        // 添加元组, 返回的数据中, 从第三行起都是元组
        for (int k = 2; k < actualArray.size(); k++) {
            column.addElement("row").addText(actualArray.get(k));
        }
    }

    /**
     * 将实际返回值写入xml文件
     *
     * @param xmlName 储存sql执行结果的xml文件名
     */
    public static void writeActualXml(String xmlPath, String xmlName) {
        // 获取xml文件路径
        File parentFile = new File(xmlPath).getParentFile();
        String filePath = parentFile.getPath() + "/actual/" + xmlName;

        // 创建文件夹
        File directory = new File(parentFile.getPath() + "/actual");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // 将document转化为xml文件
        try (FileWriter out = new FileWriter(filePath)) {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            format.setIndentSize(4);
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(document);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}

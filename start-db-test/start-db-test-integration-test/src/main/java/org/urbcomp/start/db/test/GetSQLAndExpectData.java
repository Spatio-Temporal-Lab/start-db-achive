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

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSQLAndExpectData {

    private final static Logger log = LoggerFactory.getLogger(GetSQLAndExpectData.class);

    /**
     * 返回拼接参数后的sql
     *
     * @param sqlText sql文本
     * @param parameters 参数字符串
     * @return 返回拼接后的sql
     * */
    public static String getSqlWithParam(String sqlText, String parameters) throws Exception {
        // 解析参数信息 先判断内容是否是有效的, 不能为null或空字符串
        // 参数使用[]包括, 解析的时候先去掉两遍的[]中括号, 然后使用 ][ 分隔
        String[] params = {};
        StringBuilder sql = new StringBuilder();
        if (!Objects.equals(parameters, "") && parameters != null) {
            parameters = StringUtils.strip(parameters, "[]");
            // 如果参数出现换行, 就会出现空格, 需要替换下, 保证下面能正常分隔参数
            if (parameters.contains("] [")) {
                parameters = parameters.replace("] [", "][");
            }
            params = parameters.split("]\\[");

            // 参数的数量正确的情况下再拼接sql
            int paramCount = appearNumber(sqlText, '?');
            if (paramCount != 0 && paramCount == params.length) {
                sql.setLength(0);
                // 将参数拼接到sql中, 先将sql以 ? 切分, 然后在加上参数拼接为新的sql字符串
                String[] sqlSplitList = sqlText.split("\\?");
                for (int i = 0; i < params.length; i++) {
                    sql.append(sqlSplitList[i]).append(params[i]);
                }
                sql.append(sqlSplitList[paramCount]);
            } else {
                log.info("sql中的占位符数量为 " + paramCount + ",\n实际参数数量为 " + params.length);
                throw new Exception("参数不匹配, 请检查测试用例");
            }
        } else {
            sql.append(sqlText);
        }

        return sql.toString();
    }

    /**
     *返回的预期结果或者预期异常信息
     *
     * @param expectData 预期字符串
     * @param filePath sql用例的文件路径
     * @param paramId 参数id值
     * @return 预期内容或预期异常
     * */
    public static String getExpectData(String expectData, String filePath, String paramId)
        throws Exception {
        // 将返回的预期结果或者预期异常信息返回
        if (expectData.startsWith("error")) {
            expectData = expectData.replace("error:", "");
            return expectData;
        } else {
            // 获取预期文件的路径
            File parentFile = new File(filePath).getParentFile();
            String expectedPath = parentFile.getPath()
                + File.separator
                + "expected"
                + File.separator
                + expectData;
            // 获取根标签
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(expectedPath);
            Element rootElement = document.getRootElement();
            // 获取表头信息 metadata标签
            List<Element> metaElements = rootElement.elements("metadata");
            for (Element metaElement : metaElements) {
                String filedName = metaElement.attributeValue("name");
                String filedType = metaElement.attributeValue("type");
            }
            // 获取指定id的返回数据信息 row标签
            String paramStr = String.format("//case[@id=%s]\"", paramId);
            List<Node> idNodes = rootElement.selectNodes(paramStr);
            for (Node idNode : idNodes) {
                Element idElement = (Element) idNode;
                String rowText = idElement.getText();
            }
            // todo 需要知道实际返回的数据格式是什么样子的，再拼接预期数据, 方便后续的结果比较
            return "Concatenated-SQL";
        }
    }

    /**
     * 获取指定字符串出现的次数
     *
     * @param srcText 源字符串
     * @param findText 要查找的字符串
     * @return 返回字符串出现的次数
     * */
    private static int appearNumber(String srcText, char findText) {
        int count = 0;
        for (int i = 0; i < srcText.length(); i++) {
            if (srcText.charAt(i) == findText) {
                count += 1;
            }
        }
        return count;
    }
}

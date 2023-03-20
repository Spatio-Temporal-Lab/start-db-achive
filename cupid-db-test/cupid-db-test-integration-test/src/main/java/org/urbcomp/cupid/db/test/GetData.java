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

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.urbcomp.cupid.db.test.RunSingleSQLCase.DBNAME;
import static org.urbcomp.cupid.db.test.RunSingleSQLCase.START_TIME;

public class GetData {

    private final static Logger log = LoggerFactory.getLogger(GetData.class);

    /**
     * 返回拼接参数后的sql
     *
     * @param initSql sql文本
     * @param parameters 参数字符串
     * @return 返回拼接后的sql
     * */
    public static String getSqlWithParam(String initSql, String parameters) throws Exception {
        // 解析参数信息 先判断内容是否是有效的, 不能为null或空字符串
        // 参数使用[]包括, 解析的时候先去掉两遍的[]中括号, 然后使用 ][ 分隔
        String[] params;
        StringBuilder sql = new StringBuilder();

        parameters = StringUtils.strip(parameters, "[]");
        // 如果参数出现换行, 就会出现空格, 需要替换下, 保证下面能正常分隔参数
        if (parameters.contains("] [")) {
            parameters = parameters.replace("] [", "][");
        }
        params = parameters.split("]\\[");

        // 参数的数量正确的情况下再拼接sql
        int paramCount = appearNumber(initSql, '?');
        if (paramCount != 0 && paramCount == params.length) {
            // 保证拼接前的sql是个空字符串
            sql.setLength(0);
            // 将参数拼接到sql中, 先将sql以 ? 切分, 然后在加上参数拼接为新的sql字符串
            String[] sqlSplitList = initSql.split("\\?");
            for (int i = 0; i < params.length; i++) {
                sql.append(sqlSplitList[i]).append(params[i]);
            }
            sql.append(sqlSplitList[paramCount]);
        } else {
            log.info("sql中的占位符数量为 " + paramCount + ",\n实际参数数量为 " + params.length);
            throw new Exception("参数不匹配, 请检查测试用例");
        }
        return sql.toString();
    }

    /**
     *以字符串数组的格式返回预期数据
     *
     * @param xmlPath 执行的xml文件路径
     * @param xmlName 储存sql执行结果的xml文件名
     * @param resultID 执行结果的ID
     * @return 预期内容
     * */
    public static List<String> getExpectedDataArray(String xmlPath, String xmlName, String resultID)
        throws Exception {
        // 获取储存sql执行结果的xml文件路径
        File parentFile = new File(xmlPath).getParentFile();
        String filePath = parentFile.getPath() + "/expected/" + xmlName;
        StringBuilder expectedValue = new StringBuilder();
        List<String> expectedArray = new ArrayList<>();

        // 获取根标签
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(filePath);
        Element rootElement = document.getRootElement();

        // 根据resultID获取当前执行sql的预期结果标签
        Element resultElement = (Element) rootElement.selectSingleNode(
            "//result[@id = " + resultID + "]"
        );
        List<Element> columnElements = resultElement.elements();
        for (Element columnElement : columnElements) {
            String filedName = columnElement.attributeValue("name");
            String filedType = columnElement.attributeValue("type");
            expectedValue.append(filedName).append("\t");
            expectedArray.add(expectedValue.toString());
            expectedValue.setLength(0);
            expectedValue.append(filedType).append("\t");
            expectedArray.add(expectedValue.toString());
            expectedValue.setLength(0);
            // 获取row标签的内容
            List<Element> rowElements = columnElement.elements("row");
            for (Element rowElement : rowElements) {
                String rowText = rowElement.getText();
                expectedArray.add(rowText + "\t");
            }
        }
        return expectedArray;
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

    /**
     * 以字符串数组的形式返回执行结果
     *
     * @param result 执行sql返回的result
     * @return 字符串数组
     * */
    public static List<String> getResultArray(ResultSet result) throws SQLException {
        // 获取返回数据的列数
        int columnCount = result.getMetaData().getColumnCount();
        // 将表头信息和表头的类型拼接为字符串
        StringBuilder resultStr = new StringBuilder();
        List<String> resultArray = new ArrayList<>();
        // 拼接表头
        for (int i = 1; i <= columnCount; i++) {
            resultStr.append(result.getMetaData().getColumnName(i)).append("\t");
        }
        resultArray.add(resultStr.toString());
        resultStr.setLength(0);
        // 拼接表头的属性
        for (int i = 1; i <= columnCount; i++) {
            String colType = result.getMetaData().getColumnTypeName(i);
            resultStr.append(typeConvert(colType)).append("\t");
        }
        resultArray.add(resultStr.toString());
        resultStr.setLength(0);
        // 拼接返回的数据
        while (result.next()) {
            for (int i = 1; i <= columnCount; i++) {
                resultStr.append(result.getObject(i)).append("\t");
            }
            resultArray.add(resultStr.toString());
            resultStr.setLength(0);
        }
        return resultArray;
    }

    /**
     * 对返回的数据类型进行转换, 便于后续结果比较
     *
     * @param colType 实际返回的数据类型
     * @return 转换后的数据类型
     * */
    private static String typeConvert(String colType) {
        String type;
        switch (colType.toLowerCase()) {
            case "varchar":
                type = "string";
                break;
            case "integer":
                type = "int";
                break;
            case "bool":
                type = "boolean";
                break;
            default:
                type = colType.toLowerCase();
        }
        return type;
    }

    /**
     * 替换文本内容
     *
     * @param sql 需要替换的sql
     * @return 替换后的sql
     * */
    public static String dataTransform(String sql) {
        if (sql.contains("{dbname}")) {
            sql = sql.replace("{dbname}", DBNAME);
        }
        if (sql.contains("{timestamp}")) {
            sql = sql.replace(
                "{timestamp}",
                new SimpleDateFormat("yyMMdd_HHmmss").format(START_TIME)
            );
        }
        if (sql.contains("{dataTime}")) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            sql = sql.replace("{current_date}", date.format(formatter));
        }
        if (sql.contains("{current_time}")) {
            LocalTime now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            sql = sql.replace("{current_time}", now.format(formatter));
        }
        if (sql.contains("{current_timestamp}")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
            sql = sql.replace("{current_timestamp}", formatter.format(new Date()));
        }
        return sql;
    }

}

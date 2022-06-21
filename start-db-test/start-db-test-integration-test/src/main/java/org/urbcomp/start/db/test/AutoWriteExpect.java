package org.urbcomp.start.db.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

import static org.urbcomp.start.db.test.GetData.*;
import static org.urbcomp.start.db.test.RunSingleSQLCase.*;


public class AutoWriteExpect {
    private final static Logger log = LoggerFactory.getLogger(AutoWriteExpect.class);

    /**
     * 自动执行测试用例, 并将返回值写入到target文件夹的文件中
     * 和RunSingleSQLTest的区别就是,Run是用得到的实际结果与预期比较
     * 而Write是将按照得到实际结果生成对应的预期结果
     *
     * @param xmlPath 用例的路径
     *
     * */
    public void writeExpect(String xmlPath) throws Exception {
        // 1. 执行sql文件, 得到异常信息 或 预期结果
        // 2. 将返回值写入到文件同目录下的文件夹中, 文件名用assertion标签中的
        Connection connect = getConnect();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(xmlPath);
        Element rootElement = document.getRootElement();
        // 获取根标签下的所有case标签列表
        List<Element> caseElements = rootElement.elements();
        for (Element caseElement : caseElements) {
            // 获取case标签下的所有子标签列表
            List<Element> elements = caseElement.elements();

            String initSql = "";
            String sqlType = "";
            ArrayList<String> actualArray = new ArrayList<>();
            for (int i = 0; i < elements.size(); i++) {
                // 每次执行sql都需要重新创建 Statement
                STMT = connect.createStatement();

                Element element = elements.get(i);
                String elementName = element.getName();

                if (elementName.equals("sql")) {
                    sqlType = element.attributeValue("type");
                    initSql = element.getText();
                } else if (elementName.equals("assertion")) {
                    String params = element.getText();
                    // 1. 有参数的话就重新拼接sql, 执行, 获取返回值
                    if (params != null) {
                        // 将参数和sql进行拼接
                        String sqlWithParam = getSqlWithParam(initSql, params);
                        log.info("执行sql:" + sqlWithParam);
                        // 2. 根据type来执行sql
                        sqlWithParam = dataTransform(sqlWithParam);
                        actualArray = executeSql(sqlType, sqlWithParam);
                        // todo 将返回数据写入到预期文件

                    }
                }
                STMT.close();
            }

        }
        connect.close();
    }

    private static void addExpectXML(String xmlPath, ArrayList<String> actualArray, Element element) {
        try {
            String paramId = element.attributeValue("paramId");
            String expected = element.attributeValue("expected");
            // 在指定文件夹中, 创建xml文件存放返回数据
            String parentPath = new File(xmlPath).getParentFile().getAbsolutePath();

            // 创建文件方法

            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(xmlPath);
            Element root = document.addElement("root");
        } catch (Exception e) {
            log.info("出现异常:" + e.getMessage());
        }
    }

}

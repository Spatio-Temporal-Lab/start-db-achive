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

import org.junit.Test;

import java.util.ArrayList;

import static org.urbcomp.start.db.test.GetCasePathByXML.getSqlCaseXMLs;
import static org.urbcomp.start.db.test.RunSingleSQLCase.runSingleCase;

public class MainTest {

    @Test
    public void singleSQLCaseTest() throws Exception {
        String xmlPath =
            "E:/GitHub/start-db/start-db-test/start-db-test-integration-test/target/classes/cases/dml/dml.xml";
        runSingleCase(xmlPath);

    }

    @Test
    public void allSQLCaseTest() throws Exception {
        // 获取所有sqlCase的xml文件路径
        ArrayList<String> sqlCaseXMLs = getSqlCaseXMLs();
        // 遍历
        for (String sqlCaseXML : sqlCaseXMLs) {
            runSingleCase(sqlCaseXML);
        }

    }

}

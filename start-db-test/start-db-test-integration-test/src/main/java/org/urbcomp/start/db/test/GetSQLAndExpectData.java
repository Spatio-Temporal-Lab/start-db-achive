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

public class GetSQLAndExpectData {

    public static String getSqlWithParam(String sqlText, String parameters) {
        // todo 将参数与sql进行拼接

        return "Concatenated-SQL";
    }

    public static String getExpectData(String expectData) {
        // todo 将返回的预期结果或者预期异常信息返回
        expectData = "";
        if (expectData.startsWith("error")) {

        } else {

        }
        return "Concatenated-SQL";

    }
}

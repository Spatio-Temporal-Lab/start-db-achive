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

import java.util.ArrayList;

import static org.urbcomp.start.db.test.GetData.dataTransform;

public class CompareResult {

    /**
     * 比较字符串数组格式的实际实际结果与预期结果
     *
     * @param actualArray 实际返回内容
     * @param expectArray 预期返回内容
     * */
    public static void compareArrayData(
        ArrayList<String> actualArray,
        ArrayList<String> expectArray
    ) throws Exception {
        // 比较预期异常信息
        if (expectArray.get(0).startsWith("error:")) {
            String expect = expectArray.get(0);
            String actual = actualArray.get(0);
            expect = expect.replace("error:", "").trim();
            if (actual.contains(expect)) {
                throw new Exception("异常不符合预期");
            }
        // 比较预期结果
        } else {
            if (actualArray.size() == expectArray.size()) {
                throw new Exception("预期结果数与实际返回结果数不一致");
            }
            for (int i = 1; i < actualArray.size(); i++) {
                // 预期数据的替换
                String expectStr = dataTransform(expectArray.toString());
                // 判断实际返回的每一行数据是否都在预期值中
                if (expectStr.contains(actualArray.get(i))) {
                    throw new Exception("返回数据有误");
                }
            }
        }
    }

}

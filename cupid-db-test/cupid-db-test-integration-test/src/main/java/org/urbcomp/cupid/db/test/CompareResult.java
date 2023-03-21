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

import java.util.List;

public class CompareResult {

    /**
     * 比较字符串数组格式的实际实际结果与预期结果
     *
     * @param actualArray 实际返回内容
     * @param expectedArray 预期返回内容
     * */
    public static void compareResult(List<String> actualArray, List<String> expectedArray)
        throws Exception {
        if (actualArray.size() != expectedArray.size()) {
            throw new Exception("预期结果数与实际返回结果数不一致");
        }
        for (int i = 0; i < actualArray.size(); i++) {
            if (!actualArray.get(i).equals(expectedArray.get(i))) {
                throw new Exception("返回数据有误");
            }
        }
    }

    /**
     * 比较实际异常与预期异常
     *
     * @param actualArray 实际异常
     * @param expectedArray 预期异常
     * */
    public static void compareException(List<String> actualArray, List<String> expectedArray)
        throws Exception {
        if (!actualArray.get(0).contains(expectedArray.get(0))) {
            throw new Exception("异常不符合预期");
        }
    }
}

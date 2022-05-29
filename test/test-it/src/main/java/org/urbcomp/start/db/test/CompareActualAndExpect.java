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

public class CompareActualAndExpect {

    public static void compareData(String actualValue, String expectValue) throws Exception {
        // todo 比较实际返回值或者实际抛出的异常是否与预期一致, 不一致就抛出异常
        if (true) {

            System.out.println("正确返回结果");
        } else {
            throw new Exception("返回结果有误");
        }
    }

}

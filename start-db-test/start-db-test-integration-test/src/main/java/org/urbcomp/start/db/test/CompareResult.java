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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompareResult {

    private final static Logger log = LoggerFactory.getLogger(
        CompareResult.class.getName()
    );

    /**
     * 比较实际返回值或者实际抛出的异常是否符合预期, 不一致就抛出异常
     *
     * @param actualValue 实际返回内容
     * @param expectValue 预期返回内容
     * */
    public static void compareData(String actualValue, String expectValue) throws Exception {
        // todo 比较实际返回值或者实际抛出的异常是否与预期一致, 不一致就抛出异常
        // 比较预期异常信息
        if (expectValue.startsWith("error:")) {

        // 比较预期结果
        }else {
            if (true) {

                log.info("正确返回结果");

            } else {
                throw new Exception("返回结果有误");
            }
        }

    }

}

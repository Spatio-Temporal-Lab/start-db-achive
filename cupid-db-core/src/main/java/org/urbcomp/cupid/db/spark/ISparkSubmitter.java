/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.spark;

import org.urbcomp.cupid.db.spark.livy.LivySubmitter;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import java.util.concurrent.TimeoutException;

/**
 * @author jimo
 **/
public interface ISparkSubmitter {

    static ISparkSubmitter getInstance() {
        return new LivySubmitter();
    }

    /**
     * 提交到spark
     *
     * @return sqlId
     */
    String submit(SparkSqlParam param);

    /**
     * 同步等待执行完成
     *
     * @param id sql id
     */
    void waitToFinish(String id) throws TimeoutException;
}

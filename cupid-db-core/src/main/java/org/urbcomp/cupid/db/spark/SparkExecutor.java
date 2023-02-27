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

import org.urbcomp.cupid.db.infra.MetadataResult;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import java.util.concurrent.TimeoutException;

/**
 * @author jimo
 **/
public class SparkExecutor {

    /**
     * 提交到spark并返回结果
     * 如果是异步，那么只返回一个提交成功
     */
    public <T> MetadataResult<T> execute(SparkSqlParam param) {
        final ISparkSubmitter submitter = ISparkSubmitter.getInstance();
        final String sqlId = submitter.submit(param);
        if (param.isAsync()) {
            // TODO 记录执行任务到缓存队列
            return MetadataResult.buildDDLResult(0);
        }
        // wait result
        try {
            submitter.waitToFinish(sqlId);
        } catch (TimeoutException e) {
            throw new RuntimeException("sync wait timeout", e);
        }
        return ISparkDataRead.getReader(param.getExportType()).read(sqlId);
    }
}

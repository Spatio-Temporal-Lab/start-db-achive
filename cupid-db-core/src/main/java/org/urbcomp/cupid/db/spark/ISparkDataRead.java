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
import org.urbcomp.cupid.db.model.data.DataExportType;
import org.urbcomp.cupid.db.spark.reader.SparkDataReadDummy;
import org.urbcomp.cupid.db.spark.reader.SparkDataReadHdfs;

/**
 * 根据不同存储方式读取spark返回的数据
 *
 * @author jimo
 **/
public interface ISparkDataRead {

    static ISparkDataRead getReader(DataExportType type) {
        switch (type) {
            case PRINT:
                return new SparkDataReadDummy();
            case HDFS:
                return new SparkDataReadHdfs();
            case CACHE:
            default:
                throw new IllegalArgumentException("Not Support Type Yet:" + type);
        }
    }

    <T> MetadataResult<T> read(String sqlId);
}

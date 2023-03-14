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

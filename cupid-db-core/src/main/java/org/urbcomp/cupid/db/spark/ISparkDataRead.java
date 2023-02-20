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

/**
 * 根据不同存储方式读取spark返回的数据
 *
 * @author jimo
 **/
public interface ISparkDataRead {

    static ISparkDataRead getReader(DataExportType type) {
        return null; // TODO
    }

    <T> MetadataResult<T> read(String sqlId);
}

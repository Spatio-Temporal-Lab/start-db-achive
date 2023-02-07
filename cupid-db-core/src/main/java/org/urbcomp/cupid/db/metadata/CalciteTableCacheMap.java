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

package org.urbcomp.cupid.db.metadata;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.calcite.schema.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.urbcomp.cupid.db.geomesa.GeomesaTable;
import org.urbcomp.cupid.db.util.MetadataUtil;
import org.urbcomp.cupid.db.util.UserDbTable;

import java.util.concurrent.TimeUnit;

/**
 * supply dynamic table metadata for calcite
 *
 * @author jimo
 **/
public class CalciteTableCacheMap {

    private static final Logger logger = LoggerFactory.getLogger(CalciteTableCacheMap.class);

    private static final Cache<UserDbTable, Table> tableCache = Caffeine.newBuilder()
        .initialCapacity(16)
        .maximumSize(256)
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build();

    public static Table getTable(String key) {
        // split key , key must be user.db.table
        final UserDbTable udt = MetadataUtil.splitUserDbTable(key);
        return tableCache.get(
            udt,
            userDbTable -> new GeomesaTable(
                userDbTable.getUsername(),
                userDbTable.getDbName(),
                userDbTable.getTableName()
            )
        );
    }

    public static void dropTableCache(String key) {
        tableCache.invalidate(MetadataUtil.splitUserDbTable(key));
    }
}

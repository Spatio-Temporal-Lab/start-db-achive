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

package org.urbcomp.start.db.metadata;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.calcite.schema.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.urbcomp.start.db.geomesa.GeomesaTable;
import org.urbcomp.start.db.util.MetadataUtil;
import org.urbcomp.start.db.util.UserDbTable;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * supply dynamic table metadata for calcite
 *
 * @author jimo
 **/
public class MetadataCacheTableMap extends AbstractMap<String, Table> {

    private static final Logger logger = LoggerFactory.getLogger(MetadataCacheTableMap.class);

    private static final Cache<UserDbTable, Table> tableCache = Caffeine.newBuilder()
            .initialCapacity(16)
            .maximumSize(256)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build();

    private static final Set<Entry<String, Table>> tableNameCache = new HashSet<>(32);

    static {
        refreshTableNames();
    }

    private static void refreshTableNames() {
        // query from metadata
        final List<UserDbTable> allUserDbTable = MetadataAccessUtil.getUserDbTables();
        for (UserDbTable udt : allUserDbTable) {
            tableNameCache.add(
                    new NullTableEntry(
                            MetadataUtil.combineUserDbTableKey(
                                    udt.getUsername(),
                                    udt.getDbName(),
                                    udt.getTableName()
                            )
                    )
            );
        }
        logger.info("Load Table Name Cache Size: {}", tableNameCache.size());
    }

    private static class NullTableEntry implements Entry<String, Table> {

        private final String tableName;

        NullTableEntry(String tableName) {
            this.tableName = tableName;
        }

        @Override
        public String getKey() {
            return tableName;
        }

        @Override
        public Table getValue() {
            // we don't need table value
            return null;
        }

        @Override
        public Table setValue(Table value) {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NullTableEntry that = (NullTableEntry) o;
            return Objects.equals(tableName, that.tableName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tableName);
        }
    }

    public static void dropTableCache(String key) {
        tableNameCache.remove(new NullTableEntry(key));
    }

    public static void addTableCache(String key) {
        tableNameCache.add(new NullTableEntry(key));
    }

    public static void reloadCache() {
        refreshTableNames();
    }

    /**
     * calcite store all table metadata in memory,
     * we load all table names to memory temporarily,
     * and will change the calcite source code to support load metadata on demand TODO
     */
    @Nonnull
    @Override
    public Set<Entry<String, Table>> entrySet() {
        return tableNameCache;
    }

    /**
     * will be called many times in a query, add a cache
     */
    @Override
    public Table get(Object key) {
        return getTable(key.toString());
    }

    public static Table getTable(String key) {
        // split key , key must be user.db.table
        final UserDbTable udt = MetadataUtil.splitUserDbTable(key);
        return tableCache.get(udt, userDbTable -> new GeomesaTable(
                userDbTable.getUsername(),
                userDbTable.getDbName(),
                userDbTable.getTableName()
        ));
    }
}

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

import org.apache.calcite.schema.Table;
import org.urbcomp.start.db.geomesa.GeomesaTable;

import javax.annotation.Nonnull;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * supply dynamic table metadata for calcite
 *
 * @author jimo
 **/
public class MetadataCacheTableMap extends AbstractMap<String, Table> {

    private static final Set<Entry<String, Table>> tableNameCache = refreshTableNames();

    private static Set<Entry<String, Table>> refreshTableNames() {
        Set<Entry<String, Table>> tableNames = new HashSet<>(32);
        // TODO query from metadata
        tableNames.add(new NullTableEntry("citibike_tripdata"));
        return tableNames;
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
        // TODO removeTableCache(key);
    }

    public static void addTableCache(String key) {
        tableNameCache.add(new NullTableEntry(key));
        // TODO addTableCache(key);
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
        // TODO split key , key maybe [[user.]db.]table
        return new GeomesaTable("", "citibike_tripdata", "citibike_tripdata");
    }
}

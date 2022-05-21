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

package org.apache.calcite.sql.type;

import org.apache.calcite.avatica.util.ArrayImpl;
import org.apache.calcite.runtime.Geometries;

import com.google.common.collect.ImmutableMap;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * JavaToSqlTypeConversionRules defines mappings from common Java types to corresponding SQL types.
 */
public class JavaToSqlTypeConversionRules {
    // ~ Static fields/initializers ---------------------------------------------

    private static final JavaToSqlTypeConversionRules INSTANCE = new JavaToSqlTypeConversionRules();

    // ~ Instance fields --------------------------------------------------------

    private final Map<Class<?>, SqlTypeName> rules = ImmutableMap.<Class<?>, SqlTypeName>builder()
                    .put(Integer.class, SqlTypeName.INTEGER).put(int.class, SqlTypeName.INTEGER)
                    .put(Long.class, SqlTypeName.BIGINT).put(long.class, SqlTypeName.BIGINT)
                    .put(Short.class, SqlTypeName.SMALLINT).put(short.class, SqlTypeName.SMALLINT)
                    .put(byte.class, SqlTypeName.TINYINT).put(Byte.class, SqlTypeName.TINYINT)

                    .put(Float.class, SqlTypeName.REAL).put(float.class, SqlTypeName.REAL)
                    .put(Double.class, SqlTypeName.DOUBLE).put(double.class, SqlTypeName.DOUBLE)

                    .put(boolean.class, SqlTypeName.BOOLEAN).put(Boolean.class, SqlTypeName.BOOLEAN)
                    .put(byte[].class, SqlTypeName.VARBINARY).put(String.class, SqlTypeName.VARCHAR)
                    .put(char[].class, SqlTypeName.VARCHAR).put(Character.class, SqlTypeName.CHAR)
                    .put(char.class, SqlTypeName.CHAR)

                    .put(java.util.Date.class, SqlTypeName.TIMESTAMP)
                    .put(Date.class, SqlTypeName.DATE).put(Timestamp.class, SqlTypeName.TIMESTAMP)
                    .put(Time.class, SqlTypeName.TIME).put(BigDecimal.class, SqlTypeName.DECIMAL)

                    .put(Geometries.Geom.class, SqlTypeName.GEOMETRY)

                    .put(ResultSet.class, SqlTypeName.CURSOR)
                    .put(ColumnList.class, SqlTypeName.COLUMN_LIST)
                    .put(ArrayImpl.class, SqlTypeName.ARRAY).put(List.class, SqlTypeName.ARRAY)
                    .put(Map.class, SqlTypeName.MAP).put(Void.class, SqlTypeName.NULL).build();

    // ~ Methods ----------------------------------------------------------------

    /**
     * Returns the {@link org.apache.calcite.util.Glossary#SINGLETON_PATTERN singleton} instance.
     */
    public static JavaToSqlTypeConversionRules instance() {
        return INSTANCE;
    }

    /**
     * Returns a corresponding {@link SqlTypeName} for a given Java class.
     *
     * @param javaClass the Java class to lookup
     * @return a corresponding SqlTypeName if found, otherwise null is returned
     */
    public SqlTypeName lookup(Class javaClass) {
        return rules.get(javaClass);
    }

    /**
     * Make this public when needed. To represent COLUMN_LIST SQL value, we need a type
     * distinguishable from {@link List} in user-defined types.
     */
    private interface ColumnList extends List {
    }
}

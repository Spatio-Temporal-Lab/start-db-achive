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
package org.apache.calcite.schema.impl;

import org.apache.calcite.linq4j.tree.Expression;
import org.apache.calcite.rel.type.RelProtoDataType;
import org.apache.calcite.schema.Function;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.schema.SchemaVersion;
import org.apache.calcite.schema.Schemas;
import org.apache.calcite.schema.Table;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Abstract implementation of {@link Schema}.
 *
 * <p>Behavior is as follows:</p>
 * <ul>
 *   <li>The schema has no tables unless you override
 *       {@link #getTableMap()}.</li>
 *   <li>The schema has no functions unless you override
 *       {@link #getFunctionMultimap()}.</li>
 *   <li>The schema has no sub-schemas unless you override
 *       {@link #getSubSchemaMap()}.</li>
 *   <li>The schema is mutable unless you override
 *       {@link #isMutable()}.</li>
 *   <li>The name and parent schema are as specified in the constructor
 *       arguments.</li>
 * </ul>
 */
public class AbstractSchema implements Schema {
    public AbstractSchema() {}

    public boolean isMutable() {
        return true;
    }

    public Schema snapshot(SchemaVersion version) {
        return this;
    }

    public Expression getExpression(SchemaPlus parentSchema, String name) {
        return Schemas.subSchemaExpression(parentSchema, name, getClass());
    }

    /**
     * Returns a map of tables in this schema by name.
     *
     * <p>The implementations of {@link #getTableNames()}
     * and {@link #getTable(String)} depend on this map.
     * The default implementation of this method returns the empty map.
     * Override this method to change their behavior.</p>
     *
     * @return Map of tables in this schema by name
     */
    protected Map<String, Table> getTableMap() {
        return ImmutableMap.of();
    }

    public final Set<String> getTableNames() {
        return getTableMap().keySet();
    }

    public Table getTable(String name) {
        return getTableMap().get(name);
    }

    /**
     * Returns a map of types in this schema by name.
     *
     * <p>The implementations of {@link #getTypeNames()}
     * and {@link #getType(String)} depend on this map.
     * The default implementation of this method returns the empty map.
     * Override this method to change their behavior.</p>
     *
     * @return Map of types in this schema by name
     */
    protected Map<String, RelProtoDataType> getTypeMap() {
        return ImmutableMap.of();
    }

    public RelProtoDataType getType(String name) {
        return getTypeMap().get(name);
    }

    public Set<String> getTypeNames() {
        return getTypeMap().keySet();
    }

    /**
     * Returns a multi-map of functions in this schema by name.
     * It is a multi-map because functions are overloaded; there may be more than
     * one function in a schema with a given name (as long as they have different
     * parameter lists).
     *
     * <p>The implementations of {@link #getFunctionNames()}
     * and {@link Schema#getFunctions(String)} depend on this map.
     * The default implementation of this method returns the empty multi-map.
     * Override this method to change their behavior.</p>
     *
     * @return Multi-map of functions in this schema by name
     */
    protected Multimap<String, Function> getFunctionMultimap() {
        return ImmutableMultimap.of();
    }

    public final Collection<Function> getFunctions(String name) {
        return getFunctionMultimap().get(name); // never null
    }

    public final Set<String> getFunctionNames() {
        return getFunctionMultimap().keySet();
    }

    /**
     * Returns a map of sub-schemas in this schema by name.
     *
     * <p>The implementations of {@link #getSubSchemaNames()}
     * and {@link #getSubSchema(String)} depend on this map.
     * The default implementation of this method returns the empty map.
     * Override this method to change their behavior.</p>
     *
     * @return Map of sub-schemas in this schema by name
     */
    protected Map<String, Schema> getSubSchemaMap() {
        return ImmutableMap.of();
    }

    public final Set<String> getSubSchemaNames() {
        return getSubSchemaMap().keySet();
    }

    public final Schema getSubSchema(String name) {
        return getSubSchemaMap().get(name);
    }

    /**
     * Schema factory that creates an
     * {@link org.apache.calcite.schema.impl.AbstractSchema}.
     */
    public static class Factory implements SchemaFactory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {}

        public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
            return new AbstractSchema();
        }
    }
}

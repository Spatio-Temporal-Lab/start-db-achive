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
package org.urbcomp.cupid.db.core.geomesa.model;

import org.apache.calcite.linq4j.tree.ConstantExpression;
import org.apache.calcite.linq4j.tree.Primitive;
import org.apache.calcite.plan.RelOptTable;
import org.opengis.filter.Filter;

import java.lang.reflect.Type;

/**
 * This class is different from the native implementation of geotools, because the native
 * implementation of GeoTools does not java basic data types, so it cannot be recognized in the
 * expression parsing of linq4j.
 * 
 * @see ConstantExpression#ConstantExpression(Type, Object)
 * @see Primitive
 *
 *      Therefore, we need to re encapsulate the query object of geotools. When we need this
 *      information, we need to present it in the form of basic data types.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class GeomesaQuery {

    /**
     * GeoTools Filter
     */
    private Filter filter = Filter.INCLUDE;

    /**
     * user name
     */
    private String userName;

    /**
     * db name
     */
    private String dbName;

    /**
     * table name
     */
    private String tableName;

    /**
     * RelNode Option of Table
     */
    private RelOptTable relOptTable;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public RelOptTable getRelOptTable() {
        return relOptTable;
    }

    public void setRelOptTable(RelOptTable relOptTable) {
        this.relOptTable = relOptTable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

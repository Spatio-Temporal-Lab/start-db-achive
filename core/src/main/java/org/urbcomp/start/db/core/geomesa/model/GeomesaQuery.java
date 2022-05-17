package org.urbcomp.start.db.core.geomesa.model;

import org.apache.calcite.linq4j.tree.ConstantExpression;
import org.apache.calcite.linq4j.tree.Primitive;
import org.apache.calcite.plan.RelOptTable;
import org.opengis.filter.Filter;

import java.lang.reflect.Type;

/**
 * This class is different from the native implementation of geotools, because the
 * native implementation of GeoTools does not java basic data types, so it cannot
 * be recognized in the expression parsing of linq4j.
 * @see ConstantExpression#ConstantExpression(Type, Object)
 * @see Primitive
 *
 * Therefore, we need to re encapsulate the query object of geotools. When we need
 * this information, we need to present it in the form of basic data types.
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
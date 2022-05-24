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

package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.SqlSessionUtil;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.DatabaseMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

import java.util.List;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of tables are realized.
 * 
 * @author Wang Bohong
 * @Date 2022-05-21
 */
public class TableAccessor implements IAccessor<Table> {

    /**
     * select all tables
     * 
     * @return list of table instance
     */
    @Override
    public List<Table> selectAll(boolean commit) {
        return getMapper(commit).selectAll();
    }

    /**
     * overloading method
     * 
     * @return list of table instance
     */
    public List<Table> selectAll() {
        return selectAll(true);
    }

    /**
     * select one table in table
     * 
     * @param id id
     * @return table instance
     */
    @Override
    public Table selectById(long id, boolean commit) {
        return getMapper(commit).selectById(id);
    }

    /**
     * overloading method
     * 
     * @param id id
     * @return table instance
     */
    public Table selectById(long id) {
        return selectById(id, true);
    }

    /**
     * select one table by name
     * 
     * @param name name
     * @return table instance
     */
    @Override
    public Table selectByName(String name, boolean commit) {
        return getMapper(commit).selectByName(name);
    }

    /**
     * overloading method
     * 
     * @param name dbName
     * @return table instance
     */
    public Table selectByName(String name) {
        return selectByName(name, true);
    }

    /**
     * select all ids in table
     * 
     * @param commit auto_commit
     * @return list of ids
     */
    @Override
    public List<Long> selectAllId(boolean commit) {
        return getMapper(commit).selectAllId();
    }

    /**
     * overloading method
     * 
     * @return list of ids
     */
    public List<Long> selectAllId() {
        return selectAllId(true);
    }

    /**
     * select all names in table
     * 
     * @param commit auto_commit
     * @return list of names
     */
    @Override
    public List<String> selectAllName(boolean commit) {
        return getMapper(commit).selectAllName();
    }

    /**
     * overloading method
     * 
     * @return list of names
     */
    public List<String> selectAllName() {
        return selectAllName(true);
    }

    /**
     * insert one table into table
     * 
     * @param table user instance
     * @return number of affected rows
     */
    @Override
    public long insert(Table table, boolean commit) {
        if (!isValid(table)) return -1;
        return getMapper(commit).insert(table);
    }

    public long insert(Table table) {
        return insert(table, true);
    }

    /**
     * update one table in table
     * 
     * @param table table instance
     * @return number of affected rows
     */
    @Override
    public long update(Table table, boolean commit) {
        return getMapper(commit).update(table);
    }

    public long update(Table table) {
        return update(table, true);
    }

    /**
     * delete one table in table by id
     * 
     * @param id id
     * @return number of affected rows
     */
    @Override
    public long deleteById(long id, boolean commit) {
        return getMapper(commit).deleteById(id);
    }

    /**
     * overloeading method
     * 
     * @param id id
     * @return number of affected rows
     */
    public long deleteById(long id) {
        return deleteById(id, true);
    }

    /**
     * commit operations
     */
    @Override
    public void commit() {
        SqlSessionUtil.getSession(false).commit();
    }

    /**
     * rollback operations
     */
    @Override
    public void rollback() {
        SqlSessionUtil.getSession(false).rollback();
    }

    /**
     * get mapper instance of table
     * 
     * @param commit auto-commit
     * @return IMapper
     *         <Table>
     */
    @Override
    public IMapper<Table> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(TableMapper.class);
    }

    @Override
    public void close() {
        SqlSessionUtil.getSession(false).close();
    }

    /**
     * constraint about insert
     * 
     * @param table table to be inserted
     * @return isValid
     */
    private boolean isValid(Table table) {
        boolean valid = false;
        long dbId = table.getDbId();
        String name = table.getName();
        DatabaseMapper databaseMapper = SqlSessionUtil.getSession(true)
            .getMapper(DatabaseMapper.class);
        // Judge whether dbId exists.
        List<Long> dbIds = databaseMapper.selectAllId();
        for (Long curDbId : dbIds) {
            if (dbId == curDbId) {
                valid = true;
                break;
            }
        }
        // Judge whether there are tables with the same name in a database
        List<String> tableNames = getMapper(true).selectAllName();
        for (String tableName : tableNames) {
            if (tableName.equals(name)) {
                // names
                if (getMapper(true).selectByName(tableName).getId() == dbId) return false;
            }
        }
        return valid;
    }
}

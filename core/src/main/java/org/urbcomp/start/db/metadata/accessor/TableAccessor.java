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
import org.urbcomp.start.db.metadata.SqlSessionUtilManual;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.DatabaseMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

import java.util.List;

/**
 * Accessor for Table
 * 
 * @author : Wang Bohong
 * @Date: 2022-05-21
 */
public class TableAccessor implements IAccessor<Table> {

    /**
     * select all tables
     * 
     * @return list of table instance
     */
    @Override
    public List<Table> selectAll(boolean commit) {
        if (commit) {
            return getMapper().selectAll();
        } else {
            return getMapperManual().selectAll();
        }
    }

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
        if (commit) {
            return getMapper().selectById(id);
        } else {
            return getMapperManual().selectById(id);
        }
    }

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
        if (commit) {
            return getMapper().selectByName(name);
        } else {
            return getMapperManual().selectByName(name);
        }
    }

    public Table selectByName(String name) {
        return selectByName(name, true);
    }

    /**
     * insert one table into table
     * 
     * @param table user instance
     * @return number of affected rows
     */
    @Override
    public long insert(Table table, boolean commit) {
        if (!isValid(table))
            return -1;
        if (commit) {
            return getMapper().insert(table);
        } else {
            return getMapperManual().insert(table);
        }
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
        if (commit) {
            return getMapper().update(table);
        } else {
            return getMapperManual().update(table);
        }
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
        if (commit) {
            return getMapper().deleteById(id);
        } else {
            return getMapperManual().deleteById(id);
        }
    }

    public long deleteById(long id) {
        return deleteById(id, true);
    }

    /**
     * commit operations
     */
    @Override
    public void commit() {
        SqlSessionUtilManual.getSession().commit();
    }

    /**
     * rollback operations
     */
    @Override
    public void rollback() {
        SqlSessionUtilManual.getSession().rollback();
    }


    /**
     * get mapper instance of table
     * 
     * @return IMapper
     *         <Table>
     */
    @Override
    public IMapper<Table> getMapper() {
        return SqlSessionUtil.getSession().getMapper(TableMapper.class);
    }

    /**
     * get mapper instance of table (manual commit)
     * 
     * @return IMapper
     *         <Table>
     */
    @Override
    public IMapper<Table> getMapperManual() {
        return SqlSessionUtilManual.getSession().getMapper(TableMapper.class);
    }

    @Override
    public void close() throws Exception {
        SqlSessionUtilManual.getSession().close();
    }

    /**
     * constraint about insert
     * 
     * @param table
     * @return isValid
     */
    private boolean isValid(Table table) {
        boolean valid = false;
        long dbId = table.getDbId();
        String name = table.getName();
        DatabaseMapper databaseMapper = SqlSessionUtil.getSession().getMapper(DatabaseMapper.class);
        List<Database> databases = databaseMapper.selectAll();
        for (Database database : databases) {
            if (dbId == database.getId()) {
                valid = true;
                break;
            }
        }
        List<Table> tables = getMapper().selectAll();
        for (Table table1 : tables) {
            if (table1.getName().equals(name) && table1.getDbId() == table.getDbId()) {
                return false;
            }
        }
        return valid;
    }
}

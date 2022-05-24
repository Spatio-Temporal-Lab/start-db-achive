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
import org.urbcomp.start.db.metadata.mapper.DatabaseMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

import java.util.List;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of databases are realized.
 * 
 * @author WangBohong
 * @date 2022-05-21
 */
public class DatabaseAccessor implements IAccessor<Database> {

    /**
     * select all databases
     * 
     * @return list of database instance
     */
    @Override
    public List<Database> selectAll(boolean commit) {
        return getMapper(commit).selectAll();
    }

    /**
     * overloading method
     * 
     * @return list of database instance
     */
    public List<Database> selectAll() {
        return selectAll(true);
    }

    /**
     * select one database in table
     * 
     * @param id id
     * @return database instance
     */
    @Override
    public Database selectById(long id, boolean commit) {
        return getMapper(commit).selectById(id);
    }

    /**
     * overloading method
     * 
     * @param id id
     * @return one database instance
     */
    public Database selectById(long id) {
        return selectById(id, true);
    }

    /**
     * select one database by name
     * 
     * @param name db name
     * @return one database instance
     */
    @Override
    public Database selectByName(String name, boolean commit) {
        return getMapper(commit).selectByName(name);
    }

    /**
     * overloading method
     * 
     * @param name db name
     * @return one database instance
     */
    public Database selectByName(String name) {
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
     * if db's name exists or userId does not exist, return -1.
     * 
     * @param database database instance
     * @param commit auto_commit
     * @return number of affected rows
     */
    @Override
    public long insert(Database database, boolean commit) {
        if (!isValid(database)) {
            return -1;
        }
        return getMapper(commit).insert(database);
    }

    /**
     * overloading method
     * 
     * @param database database instance
     * @return number of affected rows
     */
    public long insert(Database database) {
        return insert(database, true);
    }

    /**
     * update one database in table
     * 
     * @param database user instance
     * @return number of affected rows
     */
    @Override
    public long update(Database database, boolean commit) {
        return getMapper(commit).update(database);
    }

    public long update(Database database) {
        return update(database, true);
    }

    /**
     * delete one database in table by id
     * 
     * @param id id
     * @return number of affected rows
     */
    @Override
    public long deleteById(long id, boolean commit) {
        return getMapper(commit).deleteById(id);
    }

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
     * get mapper instance of database
     * 
     * @param commit auto-commit
     * @return IMapper<Database>
     */
    @Override
    public IMapper<Database> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(DatabaseMapper.class);
    }

    /**
     * close session
     */
    @Override
    public void close() {
        SqlSessionUtil.getSession(false).close();
    }

    /**
     * constraint about insert
     * 
     * @param db database
     * @return isValid
     */
    private boolean isValid(Database db) {
        boolean valid = false;
        long userId = db.getUserId();
        String name = db.getName();
        UserMapper userMapper = SqlSessionUtil.getSession(true).getMapper(UserMapper.class);
        // make sure that userId exists.
        List<Long> userIds = userMapper.selectAllId();
        for (Long id : userIds) {
            if (userId == id) {
                valid = true;
                break;
            }
        }
        // make sure dbName does not exist.
        List<Database> names = getMapper(true).selectAll();
        for (Database curDb : names) {
            if (curDb.getName().equals(name) && curDb.getUserId() == userId) {
                return false;
            }
        }
        return valid;
    }

}

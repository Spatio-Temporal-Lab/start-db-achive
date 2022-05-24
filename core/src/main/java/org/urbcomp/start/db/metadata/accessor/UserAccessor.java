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
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

import java.util.List;

/**
 * @Description This class is the implementation class of IAccessor.The basic functions of metadata
 *              interaction of users are realized.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class UserAccessor implements IAccessor<User> {

    /**
     * select all users in table
     *
     * @param commit auto-commit select all users
     * @return list of user instance
     */
    @Override
    public List<User> selectAll(boolean commit) {
        return getMapper(commit).selectAll();
    }

    /**
     * overloading method
     * 
     * @return list of user instance
     */
    public List<User> selectAll() {
        return selectAll(true);
    }

    /**
     * select one user in table
     * 
     * @param id id
     * @param commit auto-commit
     * @return user instance
     */
    @Override
    public User selectById(long id, boolean commit) {
        return getMapper(commit).selectById(id);
    }

    /**
     * select one user by name
     * 
     * @param name name
     * @return user instance
     */
    public User selectByName(String name) {
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
     * select one user by name
     * 
     * @param name name
     * @param commit auto-commit
     * @return user instance
     */
    @Override
    public User selectByName(String name, boolean commit) {
        return getMapper(commit).selectByName(name);
    }


    /**
     * insert one user into table
     * 
     * @param user user instance
     * @param commit auto-commit
     * @return number of affected rows
     */
    @Override
    public long insert(User user, boolean commit) {
        return getMapper(commit).insert(user);
    }

    /**
     * insert one user into table
     *
     * @param user user instance
     * @return number of affected rows
     */
    public long insert(User user) {
        return insert(user, true);
    }

    /**
     * update one user in table
     * 
     * @param user user instance
     * @return number of affected rows
     */
    public long update(User user) {
        return insert(user, true);
    }

    /**
     * update one user in table
     * 
     * @param user user instance
     * @param commit auto-commit
     * @return number of affected rows
     */
    @Override
    public long update(User user, boolean commit) {
        return getMapper(commit).update(user);
    }

    /**
     * delete one user in table by id
     * 
     * @param id id
     * @return number of affected rows
     */
    public long deleteById(long id) {
        return getMapper(true).deleteById(id);
    }

    /**
     * delete one user in table by id
     * 
     * @param id id
     * @param commit auto-commit
     * @return number of affected rows
     */
    @Override
    public long deleteById(long id, boolean commit) {
        return getMapper(commit).deleteById(id);
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
     * close session
     */
    @Override
    public void close() {
        SqlSessionUtil.getSession(false).close();
    }

    /**
     * get mapper instance of user
     * 
     * @param commit auto-commit
     * @return IMapper<User>
     */
    @Override
    public IMapper<User> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(UserMapper.class);
    }

}

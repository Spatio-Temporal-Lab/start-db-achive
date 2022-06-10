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
import org.urbcomp.start.db.metadata.entity.AbstractEntity;
import org.urbcomp.start.db.metadata.mapper.IMapper;

/**
 * This interface is used to encapsulate some accessor information.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public interface IAccessor<T extends AbstractEntity, M extends IMapper<T>> extends AutoCloseable {

    /**
     * select one entity from table by id
     *
     * @param id     id
     * @param commit auto_commit
     * @return entity instance
     */
    default T selectById(long id, boolean commit) {
        return getMapper(commit).selectById(id);
    }

    /**
     * select one entity from table by name
     *
     * @param name  name
     * @param commit    auto_commit
     * @return entity instance
     */
    default T selectByName(String name, boolean commit) {
        return getMapper(commit).selectByName(name);
    }

    /**
     * select one entity from table by name
     *
     * @param fid    foreign id
     * @param name   name
     * @param commit auto_commit
     * @return entity instance
     */
    default T selectByFidAndName(long fid, String name, boolean commit) {
        return getMapper(commit).selectByFidAndName(fid, name);
    }

    /**
     * insert one entity instance into table
     *
     * @param entity entity instance
     * @param commit auto_commit
     * @return number of affected rows
     */
    default long insert(T entity, boolean commit) {
        if (isNotValid(entity)) {
            return -1;
        }
        return getMapper(commit).insert(entity);
    }

    /**
     * update one entity instance in table
     *
     * @param entity entity instance
     * @param commit auto_commit
     * @return number of affected rows
     */
    default long update(T entity, boolean commit) {
        if (isNotValid(entity)) {
            return -1;
        }
        return getMapper(commit).update(entity);
    }

    /**
     * delete one entity instance in table
     *
     * @param id     id
     * @param commit auto_commit
     * @return number of affected rows
     */
    default long deleteById(long id, boolean commit) {
        return getMapper(commit).deleteById(id);
    }

    /**
     * commit operation
     */
    default void commit() {
        SqlSessionUtil.getSession(false).commit();
    }

    /**
     * rollback pre operation
     */
    default void rollback() {
        SqlSessionUtil.getSession(false).rollback();
    }

    /**
     * Close session
     */
    @Override
    default void close() {
        SqlSessionUtil.getSession(false).close();
    }

    /**
     * get mapper instance
     *
     * @param commit auto-commit
     * @return IMapper<T>
     */
    M getMapper(boolean commit);

    /**
     * Check the entity is valid
     *
     * @param entity entity instance
     * @return the check result
     */
    boolean isNotValid(T entity);
}

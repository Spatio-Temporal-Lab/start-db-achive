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
package org.urbcomp.cupid.db.metadata.accessor;

import org.urbcomp.cupid.db.metadata.entity.AbstractEntity;
import org.urbcomp.cupid.db.metadata.mapper.IMapper;

import java.util.List;

/**
 * This interface is used to encapsulate some accessor information.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public interface IAccessor<T extends AbstractEntity, M extends IMapper<T>> extends AutoCloseable {

    default List<T> selectAllByFid(long fid) {
        return getMapper().selectAllByFid(fid);
    }

    /**
     * select one entity from table by id
     *
     * @param id id
     * @return entity instance
     */
    default T selectById(long id) {
        return getMapper().selectById(id);
    }

    /**
     * select one entity from table by name
     *
     * @param fid  foreign id
     * @param name name
     * @return entity instance
     */
    default T selectByFidAndName(long fid, String name) {
        return getMapper().selectByFidAndName(fid, name);
    }

    /**
     * insert one entity instance into table
     *
     * @param entity entity instance
     * @return number of affected rows
     */
    default long insert(T entity) {
        if (isNotValid(entity)) {
            return -1;
        }
        return getMapper().insert(entity);
    }

    /**
     * update one entity instance in table
     *
     * @param entity entity instance
     * @return number of affected rows
     */
    default long update(T entity) {
        if (isNotValid(entity)) {
            return -1;
        }
        return getMapper().update(entity);
    }

    /**
     * delete one entity instance in table
     *
     * @param id id
     * @return number of affected rows
     */
    default long deleteById(long id) {
        return getMapper().deleteById(id);
    }

    /**
     * delete one entity instance in table
     *
     * @param fid fid
     * @return number of affected rows
     */
    default long deleteByFid(long fid) {
        return getMapper().deleteByFid(fid);
    }

    /**
     * Close session
     */
    @Override
    default void close() {}

    /**
     * get mapper instance
     *
     * @return IMapper<T>
     */
    M getMapper();

    /**
     * Check the entity is valid
     *
     * @param entity entity instance
     * @return the check result
     */
    boolean isNotValid(T entity);

    /**
     * physical delete if the deleteTime has passed expiredTimeLenS
     *
     * @param expiredTimeLenS the time len before current time
     * @return number of record deleted
     */
    default int clean(int expiredTimeLenS) {
        return getMapper().clean(expiredTimeLenS);
    }
}

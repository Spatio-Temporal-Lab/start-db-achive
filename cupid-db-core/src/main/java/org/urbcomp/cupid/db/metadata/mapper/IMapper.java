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
package org.urbcomp.cupid.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.cupid.db.metadata.entity.AbstractEntity;

import java.util.List;

/**
 * This interface is used to encapsulate some basic mapping information.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public interface IMapper<T extends AbstractEntity> {

    /**
     * select all entities in table
     *
     * @param fid fid
     * @return list of entity instance
     */
    List<T> selectAllByFid(@Param("fid") long fid);

    /**
     * select one entity in table based on id
     *
     * @param id id
     * @return entity instance
     */
    T selectById(@Param("id") long id);

    /**
     * select one entity in table based on name
     *
     * @param fid  foreign id
     * @param name name
     * @return entity instance
     */
    T selectByFidAndName(@Param("fid") long fid, @Param("name") String name);

    /**
     * insert one entity into table
     *
     * @param entity entity
     * @return number of affected rows
     */
    long insert(T entity);

    /**
     * update one entity in a table
     *
     * @param entity entity
     * @return number of affected rows
     */
    long update(T entity);

    /**
     * delete on entity in a table by id
     *
     * @param id id
     * @return number of affected rows
     */
    long deleteById(@Param("id") long id);

    /**
     * delete on entity in a table by fid
     *
     * @param fid fid
     * @return number of affected rows
     */
    long deleteByFid(@Param("fid") long fid);

    /**
     * physical delete if the deleteTime has passed expiredTimeLen
     *
     * @param expiredTimeLenS the time len before current time
     * @return number of record deleted
     */
    int clean(@Param("expiredTimeLenS") int expiredTimeLenS);
}

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
import org.urbcomp.cupid.db.metadata.entity.Index;

/**
 * This interface is used to encapsulate some index mapping information
 *
 * @author Wang Bohong
 * @Date 2022-07-28
 */
public interface IndexMapper extends IMapper<Index> {

    /**
     * insert an index instance into sys_index table
     *
     * @param index index instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("index") Index index);

    /**
     * update an index instance into sys_index table
     *
     * @param index index instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("index") Index index);

    /**
     * delete an index instance from sys_index table
     *
     * @param fid table id
     * @return number of affected rows
     */
    @Override
    long deleteByFid(@Param("fid") long fid);
}

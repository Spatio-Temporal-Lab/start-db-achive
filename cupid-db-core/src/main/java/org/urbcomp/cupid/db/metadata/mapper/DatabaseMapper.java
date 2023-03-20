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
import org.urbcomp.cupid.db.metadata.entity.Database;

/**
 * This interface is used to encapsulate some database mapping information.
 * 
 * @author Wang Bohong
 * @Date 2022-05-20 17:00:05
 */
public interface DatabaseMapper extends IMapper<Database> {

    /**
     * insert one database instance into sys_db table
     * 
     * @param database database instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("database") Database database);

    /**
     * insert one database instance into sys_db table
     * 
     * @param database database instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("database") Database database);
}

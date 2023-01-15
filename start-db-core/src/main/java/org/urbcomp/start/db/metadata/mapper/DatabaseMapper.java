/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Database;

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

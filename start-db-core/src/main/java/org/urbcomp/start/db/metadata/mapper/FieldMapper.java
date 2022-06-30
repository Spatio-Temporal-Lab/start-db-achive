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

package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Field;

/**
 * This interface is used to encapsulate some table mapping information.
 * 
 * @author Wang Bohong, Xiang He
 * @Date 2022-05-20 17:32:15
 */
public interface FieldMapper extends IMapper<Field> {

    /**
     * insert one field instance into sys_field table
     * 
     * @param field field instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("field") Field field);

    /**
     * insert one field instance into sys_field table
     * 
     * @param field field instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("field") Field field);

    @Override
    long deleteByFid(@Param("fid") long fid);

}

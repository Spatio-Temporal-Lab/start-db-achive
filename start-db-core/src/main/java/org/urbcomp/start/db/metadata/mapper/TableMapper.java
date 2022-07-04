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
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.util.UserDbTable;

import java.util.List;

/**
 * This interface is used to encapsulate some table mapping information.
 *
 * @author Wang Bohong
 * @Date 2022-05-20 17:00:05
 */
public interface TableMapper extends IMapper<Table> {

    /**
     * insert a table instance into sys_table table
     *
     * @param table table instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("table") Table table);

    /**
     * update a table instance into sys_table table
     *
     * @param table table instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("table") Table table);

    /**
     * get all user db table
     */
    List<UserDbTable> getAllUserDbTable();

    @Override
    long deleteByFid(@Param("fid") long fid);
}

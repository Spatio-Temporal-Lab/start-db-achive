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

package org.urbcomp.cupid.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.cupid.db.metadata.entity.User;

/**
 * This interface is used to encapsulate some user mapping information.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public interface UserMapper extends IMapper<User> {
    /**
     * insert one user instance into user table
     * 
     * @param user user instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("user") User user);

    /**
     * update one user instance in user table
     * 
     * @param user user instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("user") User user);
}

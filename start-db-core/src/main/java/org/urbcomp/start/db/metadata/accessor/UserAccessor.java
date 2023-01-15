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

package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.MetadataAccessUtil;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of users are realized.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class UserAccessor implements IAccessor<User, UserMapper> {

    @Override
    public UserMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(UserMapper.class);
    }

    @Override
    public boolean isNotValid(User entity) {
        // here fid is not used.
        return getMapper().selectByFidAndName(0, entity.getName()) != null;
    }
}

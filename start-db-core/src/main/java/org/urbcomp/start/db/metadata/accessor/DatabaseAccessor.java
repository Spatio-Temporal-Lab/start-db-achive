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
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.mapper.DatabaseMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of databases are realized.
 *
 * @author WangBohong
 * @date 2022-05-21
 */
public class DatabaseAccessor implements IAccessor<Database> {

    @Override
    public IMapper<Database> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(DatabaseMapper.class);
    }

    public boolean isNotValid(Database db) {
        // make sure dbName does not exist.
        return getMapper(true).selectByFidAndName(db.getUserId(), db.getName()) != null;
    }
}

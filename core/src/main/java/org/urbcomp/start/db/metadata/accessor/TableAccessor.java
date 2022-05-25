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
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of tables are realized.
 *
 * @author Wang Bohong
 * @Date 2022-05-21
 */
public class TableAccessor implements IAccessor<Table> {

    @Override
    public IMapper<Table> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(TableMapper.class);
    }

    @Override
    public boolean isNotValid(Table entity) {
        return getMapper(true).selectByFidAndName(entity.getDbId(), entity.getName()) != null;
    }
}

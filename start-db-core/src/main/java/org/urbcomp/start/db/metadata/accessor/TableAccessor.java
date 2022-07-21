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

import org.urbcomp.start.db.metadata.MetadataAccessUtil;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.TableMapper;
import org.urbcomp.start.db.util.UserDbTable;

import java.util.List;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of tables are realized.
 *
 * @author Wang Bohong
 * @date 2022-05-21
 */
public class TableAccessor implements IAccessor<Table, TableMapper> {

    @Override
    public TableMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(TableMapper.class);
    }

    @Override
    public boolean isNotValid(Table entity) {
        return getMapper().selectByFidAndName(entity.getDbId(), entity.getName()) != null;
    }

    public List<UserDbTable> getAllUserDbTable() {
        return getMapper().getAllUserDbTable();
    }
}

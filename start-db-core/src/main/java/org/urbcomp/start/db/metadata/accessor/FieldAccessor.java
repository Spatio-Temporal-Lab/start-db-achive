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
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.mapper.FieldMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of fields are realized.
 *
 * @author Wang Bohong
 * @Date 2022-05-20
 */
public class FieldAccessor implements IAccessor<Field, FieldMapper> {

    @Override
    public FieldMapper getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(FieldMapper.class);
    }

    @Override
    public boolean isNotValid(Field entity) {
        return getMapper(true).selectByFidAndName(entity.getTableId(), entity.getName()) != null;
    }
}

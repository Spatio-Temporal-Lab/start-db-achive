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
import org.urbcomp.start.db.metadata.entity.Index;
import org.urbcomp.start.db.metadata.mapper.IndexMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of indexes are realized.
 *
 * @author Wang Bohong
 * @date 2022-07-28
 */
public class IndexAccessor implements IAccessor<Index, IndexMapper> {

    @Override
    public IndexMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(IndexMapper.class);
    }

    @Override
    public boolean isNotValid(Index entity) {
        return getMapper().selectByFidAndName(entity.getTableId(), entity.getName()) != null;
    }
}

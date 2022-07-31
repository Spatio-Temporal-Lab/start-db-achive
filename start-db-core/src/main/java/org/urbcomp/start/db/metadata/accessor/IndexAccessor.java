package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.MetadataAccessUtil;
import org.urbcomp.start.db.metadata.entity.Index;
import org.urbcomp.start.db.metadata.mapper.IndexMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

/**
 * This class is the implementation class of IAccessor.The basic functions of metadata interaction
 * of indexes are realized.
 *
 * @author Wang Bohong
 * @date 2022-07-28
 */
public class IndexAccessor implements IAccessor<Index, IndexMapper>{

    @Override
    public IndexMapper getMapper() {
        return MetadataAccessUtil.getSqlSession().getMapper(IndexMapper.class);
    }

    @Override
    public boolean isNotValid(Index entity) {
        return getMapper().selectByFidAndName(entity.getTableId(), entity.getName()) != null;
    }
}

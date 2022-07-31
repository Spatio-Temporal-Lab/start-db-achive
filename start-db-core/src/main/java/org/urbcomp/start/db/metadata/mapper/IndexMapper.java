package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Index;

/**
 * This interface is used to encapsulate some index mapping information
 *
 * @author Wang Bohong
 * @Date 2022-07-28
 */
public interface IndexMapper extends IMapper<Index>{

    /**
     * insert an index instance into sys_index table
     *
     * @param index index instance
     * @return number of affected rows
     */
    @Override
    long insert(@Param("index")Index index);

    /**
     * update an index instance into sys_index table
     *
     * @param index index instance
     * @return number of affected rows
     */
    @Override
    long update(@Param("index")Index index);

    /**
     * delete an index instance from sys_index table
     *
     * @param fid table id
     * @return number of affected rows
     */
    @Override
    long deleteByFid(@Param("fid") long fid);
}

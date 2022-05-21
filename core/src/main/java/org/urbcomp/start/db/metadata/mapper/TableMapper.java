package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Table;

/**
 * This interface is used to encapsulate some table mapping information.
 * @author   Wang Bohong
 * @Date    2022-05-20 17:00:05
 */
public interface TableMapper extends IMapper<Table>{

    /**
     * insert a table instance into sys_table table
     * @param table
     * @return number of affected rows
     */
    @Override
    long insert(@Param("table") Table table);

    /**
     * update a table instance into sys_table table
     * @param table
     * @return number of affected rows
     */
    @Override
    long update(@Param("table") Table table);
}

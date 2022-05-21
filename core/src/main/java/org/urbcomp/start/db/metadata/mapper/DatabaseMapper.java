package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Database;

/**
 * This interface is used to encapsulate some database mapping information.
 * @author   Wang Bohong
 * @Date    2022-05-20 17:00:05
 */
public interface DatabaseMapper extends IMapper<Database>{

    /**
     * insert one database instance into sys_db table
     * @param database
     * @return number of affected rows
     */
    @Override
    long insert(@Param("database") Database database);

    /**
     * insert one database instance into sys_db table
     * @param database
     * @return number of affected rows
     */
    @Override
    long update(@Param("database") Database database);
}
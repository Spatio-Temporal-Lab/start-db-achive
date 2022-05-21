package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.Field;

/**
 * This interface is used to encapsulate some table mapping information.
 * @author   Wang Bohong
 * @Date    2022-05-20 17:32:15
 */
public interface FieldMapper extends IMapper<Field> {

    /**
     * insert one field instance into sys_field table
     * @param field
     * @return number of affected rows
     */
    @Override
    long insert(@Param("field") Field field);

    /**
     * insert one field instance into sys_field table
     * @param field
     * @return number of affected rows
     */
    @Override
    long update(@Param("field") Field field);

}

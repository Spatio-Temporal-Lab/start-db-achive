package org.urbcomp.start.db.metadata.mapper;

import org.apache.ibatis.annotations.Param;
import org.urbcomp.start.db.metadata.entity.User;

/**
 * This interface is used to encapsulate some user mapping information.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public interface UserMapper extends IMapper<User> {
    /**
     * insert one user instance into user table
     * @param user  user instance
     * @return  number of affected rows
     */
    @Override
    long insert(@Param("user") User user);

    /**
     * update one user instance in user table
     * @param user  user instance
     * @return  number of affected rows
     */
    @Override
    long update(@Param("user") User user);
}

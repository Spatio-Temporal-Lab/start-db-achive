package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.SqlSessionUtil;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

import java.util.List;

/**
 * Accessor for User
 *
 * @author zaiyuan
 * @date 2022-03-27 15:17:07
 */
public class UserAccessor implements IAccessor<User> {
    /**
     * select all users
     * @return  list of user instance
     */
    @Override
    public List<User> selectAll() {
        return getMapper().selectAll();
    }

    /**
     * select one user in table
     * @param id    id
     * @return  user instance
     */
    @Override
    public User selectById(long id) {
        return getMapper().selectById(id);
    }

    /**
     * select one user by name
     * @param name  name
     * @return  user instance
     */
    @Override
    public User selectByName(String name) {
        return getMapper().selectByName(name);
    }

    /**
     * insert one user into table
     * @param user  user instance
     * @return  number of affected rows
     */
    @Override
    public long insert(User user) {
        return getMapper().insert(user);
    }

    /**
     * update one user in table
     * @param user  user instance
     * @return  number of affected rows
     */
    @Override
    public long update(User user) {
        return getMapper().update(user);
    }

    /**
     * delete one user in table by id
     * @param id    id
     * @return  number of affected rows
     */
    @Override
    public long deleteById(long id) {
        return getMapper().deleteById(id);
    }

    /**
     * commit operations
     */
    @Override
    public void commit() {
        SqlSessionUtil.getSession().commit();
    }

    /**
     * rollback operations
     */
    @Override
    public void rollback() {
        SqlSessionUtil.getSession().rollback();
    }

    /**
     * close session
     */
    @Override
    public void close() {
        SqlSessionUtil.getSession().close();
    }

    /**
     * get mapper instance of user
     * @return  IMapper<User>
     */
    @Override
    public IMapper<User> getMapper() {
        return SqlSessionUtil.getSession().getMapper(UserMapper.class);
    }
}

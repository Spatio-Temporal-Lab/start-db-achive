package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.SqlSessionUtil;
import org.urbcomp.start.db.metadata.SqlSessionUtilManual;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

import java.util.List;

/**
 * Accessor for User
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class UserAccessor implements IAccessor<User> {

    /**
     * select all users
     * @return  list of user instance
     */
    public List<User> selectAll() {
        return getMapper().selectAll();
    }

    /**
     * @param commit    auto-commit
     * select all users
     * @return  list of user instance
     */
    @Override
    public List<User> selectAll(boolean commit) {
        if(commit) {
            return getMapper().selectAll();
        } else {
            return getMapperManual().selectAll();
        }
    }

    /**
     * select one user in table
     * @param id    id
     * @return  user instance
     */
    public User selectById(long id) {
        return getMapper().selectById(id);
    }

    /**
     * select one user in table
     * @param id    id
     * @param commit    auto-commit
     * @return  user instance
     */
    @Override
    public User selectById(long id, boolean commit) {
        if (commit) {
            return getMapper().selectById(id);
        } else {
            return getMapperManual().selectById(id);
        }
    }

    /**
     * select one user by name
     * @param name  name
     * @return  user instance
     */
    public User selectByName(String name) {
        return getMapper().selectByName(name);
    }

    /**
     * select one user by name
     * @param name  name
     * @param commit    auto-commit
     * @return  user instance
     */
    @Override
    public User selectByName(String name, boolean commit) {
        if (commit) {
            return getMapper().selectByName(name);
        } else {
            return getMapperManual().selectByName(name);
        }
    }

    /**
     * insert one user into table
     * @param user  user instance
     * @return  number of affected rows
     */
    public long insert(User user) {
        return getMapper().insert(user);
    }

    /**
     * insert one user into table
     * @param user  user instance
     * @param commit    auto-commit
     * @return  number of affected rows
     */
    @Override
    public long insert(User user, boolean commit) {
        if (commit) {
            return getMapper().insert(user);
        } else {
            return getMapperManual().insert(user);
        }
    }

    /**
     * update one user in table
     * @param user  user instance
     * @return  number of affected rows
     */
    public long update(User user) {
        return getMapper().update(user);
    }

    /**
     * update one user in table
     * @param user  user instance
     * @param commit    auto-commit
     * @return  number of affected rows
     */
    @Override
    public long update(User user, boolean commit) {
        if (commit) {
            return getMapper().update(user);
        } else {
            return getMapperManual().update(user);
        }
    }

    /**
     * delete one user in table by id
     * @param id    id
     * @return  number of affected rows
     */
    public long deleteById(long id) {
        return getMapper().deleteById(id);
    }

    /**
     * delete one user in table by id
     * @param id    id
     * @param commit    auto-commit
     * @return  number of affected rows
     */
    @Override
    public long deleteById(long id, boolean commit) {
        if (commit) {
            return getMapper().deleteById(id);
        } else {
            return getMapperManual().deleteById(id);
        }
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

    /**
     * get mapper instance of user (manual commit)
     * @return  IMapper<User>
     */
    @Override
    public IMapper<User> getMapperManual() {
        return SqlSessionUtilManual.getSession().getMapper(UserMapper.class);
    }

}

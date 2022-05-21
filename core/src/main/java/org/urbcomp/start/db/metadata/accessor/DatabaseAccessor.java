package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.SqlSessionUtil;
import org.urbcomp.start.db.metadata.SqlSessionUtilManual;
import org.urbcomp.start.db.metadata.entity.Database;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.metadata.mapper.DatabaseMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.UserMapper;

import java.util.List;

/**
 * Accessor for Database
 * @authour: wangbohong
 * @Date: 2022-05-21
 */
public class DatabaseAccessor implements IAccessor<Database> {

    /**
     * select all databases
     * @return  list of database instance
     */
    @Override
    public List<Database> selectAll(boolean commit) {
        if (commit) {
            return getMapper().selectAll();
        } else {
            return getMapperManual().selectAll();
        }
    }

    public List<Database> selectAll() {
        return selectAll(true);
    }


    /**
     * select one database in table
     * @param id    id
     * @return  database instance
     */
    @Override
    public Database selectById(long id, boolean commit) {
        if (commit) {
            return getMapper().selectById(id);
        } else {
            return getMapperManual().selectById(id);
        }
    }

    public Database selectById(long id) {
        return selectById(id, true);
    }

    /**
     * select one datavase by name
     * @param name  name
     * @return  database instance
     */
    @Override
    public Database selectByName(String name, boolean commit) {
        if (commit) {
            return getMapper().selectByName(name);
        } else {
            return getMapperManual().selectByName(name);
        }
    }

    public Database selectByName(String name) {
        return selectByName(name, true);
    }

    /**
     * if db's name exists or userId does not exist, return -1.
     * @param database    database instance
     * @param commit    auto_commit
     * @return
     */
    @Override
    public long insert(Database database, boolean commit) {
        if (!isValid(database)) return -1;
        if (commit) {
            return getMapper().insert(database);
        } else {
            return getMapperManual().insert(database);
        }
    }

    public long insert(Database database) {
        return insert(database, true);
    }

    /**
     * update one database in table
     * @param database  user instance
     * @return  number of affected rows
     */
    @Override
    public long update(Database database, boolean commit) {
        if (commit) {
            return getMapper().update(database);
        } else {
            return getMapperManual().update(database);
        }
    }

    public long update(Database database) { return update(database, true); }

    /**
     * delete one database in table by id
     * @param id    id
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

    public long deleteById(long id) {
        return deleteById(id, true);
    }

    /**
     * commit operations
     */
    @Override
    public void commit() {
        SqlSessionUtilManual.getSession().commit();
    }

    /**
     * rollback operations
     */
    @Override
    public void rollback() {
        SqlSessionUtilManual.getSession().rollback();
    }

    /**
     * get mapper instance of database
     * @return  IMapper<Database>
     */
    @Override
    public IMapper<Database> getMapper() {
        return SqlSessionUtil.getSession().getMapper(DatabaseMapper.class);
    }

    /**
     * get mapper instance of database (manual commit)
     * @return  IMapper<Database>
     */
    @Override
    public IMapper<Database> getMapperManual() {
        return SqlSessionUtilManual.getSession().getMapper(DatabaseMapper.class);
    }

    /**
     * close session
     */
    @Override
    public void close() throws Exception {
        SqlSessionUtilManual.getSession().close();
    }
    /**
     * constraint about insert
     * @param db database
     * @return isValid
     */
    private boolean isValid(Database db) {
        boolean valid = false;
        long userId = db.getUserId();
        String name = db.getName();
        UserMapper userMapper = SqlSessionUtil.getSession().getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            if (userId == user.getId()) {
                valid = true;
                break;
            }
        }
        List<Database> databases = getMapper().selectAll();
        for (Database database : databases) {
            if (database.getName().equals(name)) {
                return false;
            }
        }
        return valid;
    }


}
package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.entity.AbstractEntity;
import org.urbcomp.start.db.metadata.mapper.IMapper;

import java.util.List;

/**
 * This interface is used to encapsulate some accessor information.
 *
 * @author zaiyuan
 * @date 2022-03-27 15:17:07
 */
public interface IAccessor<T extends AbstractEntity> extends AutoCloseable {
    /**
     * select all entity in table
     * @return  list of entity instance
     */
    List<T> selectAll();

    /**
     * select one entity from table by id
     * @param id    id
     * @return  entity instance
     */
    T selectById(long id);

    /**
     * select one entity from table by name
     * @param name  name
     * @return  entity instance
     */
    T selectByName(String name);

    /**
     * insert one entity instance into table
     * @param entity    entity instance
     * @return  number of affected rows
     */
    long insert(T entity);

    /**
     * update one entity instance in table
     * @param entity    entity instance
     * @return  number of affected rows
     */
    long update(T entity);

    /**
     * delete one entity instance in table
     * @param id    id
     * @return  number of affected rows
     */
    long deleteById(long id);

    /**
     * commit operation
     */
    void commit();

    /**
     * rollback pre operation
     */
    void rollback();

    /**
     * get mapper instance
     * @return  IMapper<T>
     */
    IMapper<T> getMapper();
}

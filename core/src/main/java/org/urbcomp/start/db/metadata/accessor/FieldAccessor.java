/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.metadata.accessor;

import org.urbcomp.start.db.metadata.SqlSessionUtil;
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.FieldMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

import java.util.List;

/**
 * This class is the implementation class of IAccessor.The basic function of metadata interaction of
 * fields is realized.
 * 
 * @author Wang Bohong
 * @Date: 2022-05-20
 */
public class FieldAccessor implements IAccessor<Field> {

    /**
     * select all fields
     * 
     * @param commit auto-commit
     * @return list of fields instance
     */
    @Override
    public List<Field> selectAll(boolean commit) {
        return getMapper(commit).selectAll();
    }

    /**
     *
     * @return
     */
    public List<Field> selectAll() {
        return selectAll(true);
    }

    /**
     * select one field in table
     *
     * @param commit auto-commit
     * @param id id
     * @return field instance
     */
    @Override
    public Field selectById(long id, boolean commit) {
        return getMapper(commit).selectById(id);
    }

    /**
     * overloading method
     * 
     * @param id
     * @return field instance
     */
    public Field selectById(long id) {
        return selectById(id, true);
    }

    /**
     * select one field by name
     * 
     * @param commit auto-commit
     * @param name name
     * @return field instance
     */
    @Override
    public Field selectByName(String name, boolean commit) {
        return getMapper(commit).selectByName(name);
    }

    /**
     * overloading method
     * 
     * @param name
     * @return field instance
     */
    public Field selectByName(String name) {
        return selectByName(name, true);
    }

    /**
     * select all ids in table
     * 
     * @param commit auto_commit
     * @return list of ids
     */
    @Override
    public List<Long> selectAllId(boolean commit) {
        return getMapper(commit).selectAllId();
    }

    /**
     * overloading method
     * 
     * @return list of ids
     */
    public List<Long> selectAllId() {
        return selectAllId(true);
    }

    /**
     * select all names in table
     * 
     * @param commit auto_commit
     * @return list of names
     */
    @Override
    public List<String> selectAllName(boolean commit) {
        return getMapper(commit).selectAllName();
    }

    /**
     * overloading method
     * 
     * @return list of names
     */
    public List<String> selectAllName() {
        return selectAllName(true);
    }

    /**
     * insert one field into table
     * 
     * @param field user instance
     * @return number of affected rows
     */
    @Override
    public long insert(Field field, boolean commit) {
        if (!isValid(field))
            return -1;
        return getMapper(commit).insert(field);
    }

    public long insert(Field field) {
        return insert(field, true);
    }

    /**
     * update one field in table
     * 
     * @param field user instance
     * @param commit auto-commit
     * @return number of affected rows
     */
    @Override
    public long update(Field field, boolean commit) {
        return getMapper(true).update(field);
    }

    /**
     * overloading method
     * 
     * @param field a field instance
     * @return field instance
     */
    public long update(Field field) {
        return update(field, true);
    }

    /**
     * delete one field in table by id
     * 
     * @param id id
     * @param commit auto-commit
     * @return number of affected rows
     */
    @Override
    public long deleteById(long id, boolean commit) {
        return getMapper(commit).deleteById(id);
    }

    /**
     * overloading method
     * 
     * @param id a field instance
     * @return number of affected rows
     */
    public long deleteById(long id) {
        return deleteById(id, true);
    }

    /**
     * commit operations
     */
    @Override
    public void commit() {
        SqlSessionUtil.getSession(false).commit();
    }

    /**
     * rollback operations
     */
    @Override
    public void rollback() {
        SqlSessionUtil.getSession(false).rollback();
    }

    /**
     * get mapper instance of field
     * 
     * @return IMapper<Field>
     */
    @Override
    public IMapper<Field> getMapper(boolean commit) {
        return SqlSessionUtil.getSession(commit).getMapper(FieldMapper.class);
    }


    /**
     * close operation
     */
    @Override
    public void close() throws Exception {
        SqlSessionUtil.getSession(false).close();
    }

    /**
     * constraint check
     * 
     * @param field
     * @return whether the instance to be inserted is valid
     */
    private boolean isValid(Field field) {
        boolean valid = false;
        long tableId = field.getTableId();
        String name = field.getName();
        TableMapper tableMapper = SqlSessionUtil.getSession(true).getMapper(TableMapper.class);
        List<Long> tableIds = tableMapper.selectAllId();
        // judge whether id exists
        for (Long id : tableIds) {
            if (tableId == id) {
                valid = true;
                break;
            }
        }
        // Judge whether there are fields with the same name in a table
        List<String> fieldNames = getMapper(true).selectAllName();
        for (String fieldName : fieldNames) {
            if (fieldName.equals(name)) {
                // names
                if (getMapper(true).selectByName(fieldName).getId() == tableId)
                    return false;
            }
        }
        return valid;
    }
}

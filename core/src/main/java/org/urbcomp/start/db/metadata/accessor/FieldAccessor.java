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
import org.urbcomp.start.db.metadata.SqlSessionUtilManual;
import org.urbcomp.start.db.metadata.entity.Field;
import org.urbcomp.start.db.metadata.entity.Table;
import org.urbcomp.start.db.metadata.mapper.FieldMapper;
import org.urbcomp.start.db.metadata.mapper.IMapper;
import org.urbcomp.start.db.metadata.mapper.TableMapper;

import java.util.List;

/**
 * Accessor for Field
 * 
 * @author Wang Bohong
 * @Date: 2022-05-20
 */
public class FieldAccessor implements IAccessor<Field> {

    /**
     * select all fields
     * 
     * @return list of fields instance
     */
    @Override
    public List<Field> selectAll(boolean commit) {
        if (commit) {
            return getMapper().selectAll();
        } else {
            return getMapperManual().selectAll();
        }
    }

    public List<Field> selectAll() {
        return selectAll(true);
    }

    /**
     * select one field in table
     * 
     * @param id id
     * @return field instance
     */
    @Override
    public Field selectById(long id, boolean commit) {
        if (commit) {
            return getMapper().selectById(id);
        } else {
            return getMapperManual().selectById(id);
        }
    }

    public Field selectById(long id) {
        return selectById(id, true);
    }

    /**
     * select one field by name
     * 
     * @param name name
     * @return field instance
     */
    @Override
    public Field selectByName(String name, boolean commit) {
        if (commit) {
            return getMapper().selectByName(name);
        } else {
            return getMapperManual().selectByName(name);
        }
    }

    public Field selectByName(String name) {
        return selectByName(name, true);
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
        if (commit) {
            return getMapper().insert(field);
        } else {
            return getMapperManual().insert(field);
        }
    }

    public long insert(Field field) {
        return insert(field, true);
    }

    /**
     * update one field in table
     * 
     * @param field user instance
     * @return number of affected rows
     */
    @Override
    public long update(Field field, boolean commit) {
        if (commit) {
            return getMapper().update(field);
        } else {
            return getMapperManual().update(field);
        }
    }

    public long update(Field field) {
        return update(field, true);
    }

    /**
     * delete one field in table by id
     * 
     * @param id id
     * @return number of affected rows
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
     * get mapper instance of field
     * 
     * @return IMapper<Field>
     */
    @Override
    public IMapper<Field> getMapper() {
        return SqlSessionUtil.getSession().getMapper(FieldMapper.class);
    }

    /**
     * get mapper instance of field (manual commit)
     * 
     * @return IMapper<Field>
     */
    @Override
    public IMapper<Field> getMapperManual() {
        return SqlSessionUtilManual.getSession().getMapper(FieldMapper.class);
    }

    @Override
    public void close() throws Exception {
        SqlSessionUtilManual.getSession().close();
    }

    /**
     * constraint check
     * 
     * @param field
     * @return
     */
    private boolean isValid(Field field) {
        boolean valid = false;
        long tableId = field.getTableId();
        String name = field.getName();
        TableMapper tableMapper = SqlSessionUtil.getSession().getMapper(TableMapper.class);
        List<Table> tables = tableMapper.selectAll();
        for (Table table : tables) {
            if (tableId == table.getId()) {
                valid = true;
                break;
            }
        }
        List<Field> fields = getMapper().selectAll();
        for (Field field1 : fields) {
            if (field1.getName().equals(name) && field1.getTableId() == field.getTableId()) {
                return false;
            }
        }
        return valid;
    }
}

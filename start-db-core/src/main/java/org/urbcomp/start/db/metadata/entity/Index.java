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

package org.urbcomp.start.db.metadata.entity;

/**
 * This class is used to encapsulate the basic information of index
 *
 * @author Wang Bohong
 * @date 2022-07-28 11:40:19
 */
public class Index extends AbstractEntity {

    /**
     * tableId of the index
     */
    private long tableId;

    /**
     * index type
     */
    private String indexType;

    /**
     * field_id list
     */
    private String fieldsIdList;

    /**
     * index properties
     */
    private String indexProperties;

    public Index(long tableId, String indexType, String fieldsIdList, String indexProperties) {
        this.tableId = tableId;
        this.indexType = indexType;
        this.fieldsIdList = fieldsIdList;
        this.indexProperties = indexProperties;
    }

    public Index(
        long id,
        String name,
        long tableId,
        String indexType,
        String fieldsIdList,
        String indexProperties
    ) {
        super(id, name);
        this.tableId = tableId;
        this.indexType = indexType;
        this.fieldsIdList = fieldsIdList;
        this.indexProperties = indexProperties;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getFieldsIdList() {
        return fieldsIdList;
    }

    public void setFieldsIdList(String fieldsIdList) {
        this.fieldsIdList = fieldsIdList;
    }

    public String getIndexProperties() {
        return indexProperties;
    }

    public void setIndexProperties(String indexProperties) {
        this.indexProperties = indexProperties;
    }
}

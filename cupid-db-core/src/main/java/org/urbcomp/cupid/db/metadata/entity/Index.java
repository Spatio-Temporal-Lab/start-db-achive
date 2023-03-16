/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.metadata.entity;

import java.sql.Timestamp;

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

    public Index(
        long tableId,
        String indexType,
        String indexName,
        String fieldsIdList,
        String indexProperties
    ) {
        this.tableId = tableId;
        this.indexType = indexType;
        this.name = indexName;
        this.fieldsIdList = fieldsIdList;
        this.indexProperties = indexProperties;
    }

    public Index(
        long id,
        long tableId,
        String indexType,
        String indexName,
        String fieldsIdList,
        String indexProperties,
        Timestamp createdDate,
        Timestamp modifiedDate,
        long deleteTime
    ) {
        super(id, indexName);
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

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
 * @Description This class is used to encapsulate the basic information of table
 *
 * @author Wang Bohong
 * @date 2022-05-20 16:25:09
 */
public class Table extends AbstractEntity {

    /**
     * Database id of the table
     */
    private long dbId;

    /**
     * StorageEngine
     */
    private String storageEngine;

    public Table(long id, long dbId, String name, String storageEngine) {
        super(id, name);
        this.dbId = dbId;
        this.storageEngine = storageEngine;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public String getStorageEngine() {
        return storageEngine;
    }

    public void setStorageEngine(String storageEngine) {
        this.storageEngine = storageEngine;
    }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", name='" + name + '\'' + ", dbId=" + dbId
                        + ", storageEngine='" + storageEngine + '\'' + '}';
    }
}

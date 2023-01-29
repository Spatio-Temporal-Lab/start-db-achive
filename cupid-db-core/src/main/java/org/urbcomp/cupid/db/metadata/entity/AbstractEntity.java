/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.metadata.entity;

/**
 * Abstract class for entities: user, db, table. etc
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public abstract class AbstractEntity {

    /**
     * id
     */
    protected long id;

    /**
     * name
     */
    protected String name;

    public AbstractEntity() {}

    public AbstractEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IEntity{" + "id=" + id + ", userName='" + name + '\'' + '}';
    }
}

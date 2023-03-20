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

/**
 * This class is used to encapsulate the basic information of field
 *
 * @author Wang Bohong
 * @date 2022-05-20 16:40:19
 */
public class Field extends AbstractEntity {

    /**
     * tableId of the Field
     */
    private long tableId;

    /**
     * type
     */
    private String type;

    /**
     * 1: primary key; 0: else
     */
    private int isPrimary;

    public Field(long id, long tableId, String name, String type, int isPrimary) {
        super(id, name);
        this.tableId = tableId;
        this.type = type;
        this.isPrimary = isPrimary;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(int isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Override
    public String toString() {
        return "Field{"
            + "id="
            + id
            + ", name='"
            + name
            + '\''
            + ", tableId="
            + tableId
            + ", type='"
            + type
            + '\''
            + ", isPrimary="
            + isPrimary
            + '}';
    }

}

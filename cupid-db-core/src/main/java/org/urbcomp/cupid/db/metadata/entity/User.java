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
 * This class is used to encapsulate the basic information of users
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class User extends AbstractEntity {

    /**
     * password
     */
    private String password;

    public User(long id, String userName, String password) {
        super(id, userName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{"
            + "id="
            + id
            + ", name='"
            + name
            + '\''
            + ", password='"
            + password
            + '\''
            + '}';
    }
}

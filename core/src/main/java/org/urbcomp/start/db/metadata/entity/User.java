/*
 * Copyright 2022 ST-Lab

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

package org.urbcomp.start.db.metadata.entity;

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
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\''
                        + '}';
    }
}

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

package org.urbcomp.start.db.metadata;

import org.urbcomp.start.db.metadata.accessor.UserAccessor;

/**
 * This is a class that manages accessor instances through factory mode.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class AccessorFactory {

    /**
     * get UserAccessor
     * 
     * @return UserAccessor
     */
    public static UserAccessor getUserAccessor() {
        return new UserAccessor();
    }
}

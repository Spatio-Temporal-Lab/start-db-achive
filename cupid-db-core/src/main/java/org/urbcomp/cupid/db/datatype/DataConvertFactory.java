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

package org.urbcomp.cupid.db.datatype;

/**
 * @author jimo
 **/
public class DataConvertFactory {

    /**
     * 将 val转换为 type类型的数据
     */
    public static Object convert(String val, DataTypeField type) {
        switch (type.getType()) {
            case "integer":
            case "int":
                return Integer.parseInt(val);
            case "string":
            default:
                return val;
        }
    }
}

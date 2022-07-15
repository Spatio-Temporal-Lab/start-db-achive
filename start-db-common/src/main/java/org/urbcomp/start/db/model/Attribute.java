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

package org.urbcomp.start.db.model;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class Attribute {
    private final Class type;
    private final Object value;

    public Attribute(Class type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Attribute(String s) throws ClassNotFoundException {
        String[] split = s.split(" ");
        type = Class.forName(split[0]);
        value = JSONObject.parseObject(split[1], type);
    }

    public Class getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return type.toString().split(" ")[1] + " " + value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return type.equals(attribute.type) && value.equals(attribute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}

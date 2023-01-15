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

package org.urbcomp.start.db.util;

import org.locationtech.jts.geom.*;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.trajectory.Trajectory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DataTypeUtils {
    private static final Map<String, String> strToName = new HashMap<>(32);
    private static final Map<String, Class<?>> nameToClass = new HashMap<>(32);

    static {
        nameToClass.put("Point", Point.class);
        nameToClass.put("LineString", LineString.class);
        nameToClass.put("Polygon", Polygon.class);
        nameToClass.put("MultiPoint", MultiPoint.class);
        nameToClass.put("MultiLineString", MultiLineString.class);
        nameToClass.put("MultiPolygon", MultiPolygon.class);
        nameToClass.put("Geometry", Geometry.class);
        nameToClass.put("GeometryCollection", GeometryCollection.class);
        nameToClass.put("RoadSegment", RoadSegment.class);
        nameToClass.put("RoadNetwork", String.class);   // TODO
        nameToClass.put("Trajectory", Trajectory.class);
        nameToClass.put("Integer", Integer.class);
        nameToClass.put("Long", Long.class);
        nameToClass.put("Float", Float.class);
        nameToClass.put("Double", Double.class);
        nameToClass.put("String", String.class);
        nameToClass.put("Boolean", Boolean.class);
        nameToClass.put("Binary", byte[].class);
        nameToClass.put("Timestamp", Timestamp.class);
        nameToClass.put("Datetime", LocalDateTime.class);

        nameToClass.keySet().forEach(t -> strToName.put(t.toLowerCase(), t));
        strToName.put("int", "Integer");
        strToName.put("bool", "Boolean");
    }

    public static Class<?> getClass(String name) {
        String norm = normalizeType(name);
        return nameToClass.get(norm);
    }

    public static boolean isGeometry(String name) {
        String norm = normalizeType(name);
        Class<?> c = nameToClass.get(norm);
        return Geometry.class.isAssignableFrom(c);
    }

    private static String normalizeType(String raw) {
        String normalized = strToName.get(raw.toLowerCase());
        if (normalized == null) {
            throw new IllegalArgumentException("Invalid type " + raw);
        }
        return normalized;
    }

}

/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.start.db.type;

import org.locationtech.jts.geom.Geometry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TypeHelper {

    private static final String[] SUPPORT_TYPES = new String[] {
        Geometry.TYPENAME_POINT,
        Geometry.TYPENAME_LINESTRING,
        Geometry.TYPENAME_POLYGON,
        Geometry.TYPENAME_MULTIPOINT,
        Geometry.TYPENAME_MULTILINESTRING,
        Geometry.TYPENAME_MULTIPOLYGON,
        "Geometry",
        "RoadSegment",
        "Trajectory",
        "Integer",
        "Long",
        "Float",
        "Double",
        "String",
        "Boolean",
        "Binary",
        "Timestamp",
        "Datetime" };
    private static final Map<String, String> typeMapping = new HashMap<>(SUPPORT_TYPES.length);

    static {
        Arrays.asList(SUPPORT_TYPES).forEach(t -> typeMapping.put(t.toLowerCase(), t));
    }

    public static String normalizeType(String raw) {
        String normalized = typeMapping.get(raw.toLowerCase());
        if (normalized == null) {
            throw new IllegalArgumentException("Invalid type " + raw);
        }
        return normalized;
    }
}

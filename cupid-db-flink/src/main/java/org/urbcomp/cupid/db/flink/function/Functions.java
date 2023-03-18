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

package org.urbcomp.cupid.db.flink.function;

import org.apache.flink.table.annotation.DataTypeHint;
import org.apache.flink.table.functions.ScalarFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class Functions {
    public static class ST_Point extends ScalarFunction {
        @DataTypeHint(value = "RAW", bridgedTo = Geometry.class)
        public Geometry eval(@DataTypeHint("Double") Double x, @DataTypeHint("Double") Double y) {
            Coordinate coordinates = new Coordinate(x, y);
            GeometryFactory geometryFactory = new GeometryFactory();
            return geometryFactory.createPoint(coordinates);
        }
    }
}

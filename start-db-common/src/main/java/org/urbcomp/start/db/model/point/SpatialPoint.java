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

package org.urbcomp.start.db.model.point;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;

public class SpatialPoint extends Point {
    public SpatialPoint(double lng, double lat) {
        super(
            new CoordinateArraySequence(new Coordinate[] { new Coordinate(lng, lat) }),
            new GeometryFactory(new PrecisionModel(), 4326)
        );
    }

    public SpatialPoint(Coordinate coordinate) {
        this(coordinate.x, coordinate.y);
    }

    public double getLng() {
        return this.getX();
    }

    public double getLat() {
        return this.getY();
    }
}

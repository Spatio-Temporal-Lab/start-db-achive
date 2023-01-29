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

package org.urbcomp.cupid.db.model.point;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.urbcomp.cupid.db.util.GeometryFactoryUtils;

public class SpatialPoint extends Point {
    public SpatialPoint(double lng, double lat) {
        super(
            new CoordinateArraySequence(new Coordinate[] { new Coordinate(lng, lat) }),
            GeometryFactoryUtils.defaultGeometryFactory()
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equalsExact(((SpatialPoint) o));
    }
}

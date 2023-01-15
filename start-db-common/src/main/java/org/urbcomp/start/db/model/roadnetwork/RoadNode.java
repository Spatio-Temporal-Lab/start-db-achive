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

package org.urbcomp.start.db.model.roadnetwork;

import org.locationtech.jts.geom.Coordinate;
import org.urbcomp.start.db.model.point.SpatialPoint;

public class RoadNode extends SpatialPoint {
    private final int nodeId;

    public RoadNode(int nodeId, double lng, double lat) {
        super(lng, lat);
        this.nodeId = nodeId;
    }

    public RoadNode(int nodeId, Coordinate coordinate) {
        super(coordinate);
        this.nodeId = nodeId;
    }

    public int getNodeId() {
        return this.nodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadNode rn = (RoadNode) o;
        return nodeId == rn.nodeId;
    }

    @Override
    public int hashCode() {
        return nodeId;
    }
}

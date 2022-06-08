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

package org.urbcomp.start.db.algorithm.shortestpath;

import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadsegment.RoadNetwork;

public abstract class AbstractOneToOneShortestPath implements IShortestPath {
    private RoadNetwork roadNetwork;
    private SpatialPoint startPoint;
    private SpatialPoint endPoint;
    /**
     * note that the start and end points may be mot exactly on the road segments,
     * the searchDistance defines the scope to find the start or end road segments.
     */
    private double searchDistance;

    public AbstractOneToOneShortestPath(
        RoadNetwork roadNetwork,
        SpatialPoint startPoint,
        SpatialPoint endPoint
    ) {
        this.roadNetwork = roadNetwork;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}

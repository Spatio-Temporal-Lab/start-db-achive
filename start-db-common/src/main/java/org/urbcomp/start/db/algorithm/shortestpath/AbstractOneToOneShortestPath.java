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

import org.urbcomp.start.db.model.point.CandidatePoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadsegment.RoadNetwork;
import org.urbcomp.start.db.model.roadsegment.RoadNode;
import org.urbcomp.start.db.model.roadsegment.RoadSegment;

public abstract class AbstractOneToOneShortestPath {
    private RoadNetwork roadNetwork;
    /**
     * note that the start and end points may be mot exactly on the road segments,
     * the searchDistance defines the scope to find the start or end road segments.
     * unit: meter
     */
    private double searchDistance = 300;

    public AbstractOneToOneShortestPath(RoadNetwork roadNetwork, double searchDistance) {
        this.roadNetwork = roadNetwork;
        this.searchDistance = searchDistance;
    }

    public AbstractOneToOneShortestPath(RoadNetwork roadNetwork) {
        this.roadNetwork = roadNetwork;
    }

    protected abstract ShortestPathResult findShortestPath(RoadNode startNode, RoadNode endNode);

    public ShortestPathResult findShortestPath(SpatialPoint startPoint, SpatialPoint endPoint) {

    }
}

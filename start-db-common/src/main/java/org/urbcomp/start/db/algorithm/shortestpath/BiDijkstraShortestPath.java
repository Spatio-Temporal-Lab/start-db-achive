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

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.BidirectionalDijkstraShortestPath;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadsegment.Path;
import org.urbcomp.start.db.model.roadsegment.RoadNetwork;
import org.urbcomp.start.db.model.roadsegment.RoadNode;
import org.urbcomp.start.db.model.roadsegment.RoadSegment;

import java.util.ArrayList;
import java.util.List;

public class BiDijkstraShortestPath extends AbstractShortestPath {
    public BiDijkstraShortestPath(RoadNetwork roadNetwork, double searchDistance) {
        super(roadNetwork, searchDistance);
    }

    public BiDijkstraShortestPath(RoadNetwork roadNetwork) {
        super(roadNetwork);
    }

    @Override
    protected Path findShortestPath(RoadNode startNode, RoadNode endNode) {
        BidirectionalDijkstraShortestPath<RoadNode, RoadSegment> algo =
            new BidirectionalDijkstraShortestPath<>(roadNetwork.getDirectedRoadGraph());
        GraphPath<RoadNode, RoadSegment> shortestPath = algo.getPath(startNode, endNode);
        if (shortestPath == null) {
            return new Path(Double.MAX_VALUE, new ArrayList<>(), new ArrayList<>());
        } else {
            List<SpatialPoint> points = new ArrayList<>();
            double length = 0;
            List<Integer> roadSegmentIds = new ArrayList<>();
            for (RoadSegment rs : shortestPath.getEdgeList()) {
                length += rs.getLengthInMeter();
                points.addAll(rs.getPoints());
                roadSegmentIds.add(rs.getRoadSegmentId());
            }
            return new Path(length, points, roadSegmentIds);
        }
    }
}

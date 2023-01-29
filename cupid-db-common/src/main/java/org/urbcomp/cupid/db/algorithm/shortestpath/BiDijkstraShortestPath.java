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

package org.urbcomp.cupid.db.algorithm.shortestpath;

import org.jgrapht.alg.shortestpath.BidirectionalDijkstraShortestPath;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;

public class BiDijkstraShortestPath extends AbstractShortestPath {
    public BiDijkstraShortestPath(RoadNetwork roadNetwork, double searchDistance) {
        super(
            roadNetwork,
            searchDistance,
            new BidirectionalDijkstraShortestPath<>(roadNetwork.getDirectedRoadGraph())
        );
    }

    public BiDijkstraShortestPath(RoadNetwork roadNetwork) {
        super(
            roadNetwork,
            new BidirectionalDijkstraShortestPath<>(roadNetwork.getDirectedRoadGraph())
        );
    }
}

/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.algorithm.shortestpath;

import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.util.GeoFunctions;

public class AStarShortestPath extends AbstractShortestPath {
    public AStarShortestPath(RoadNetwork roadNetwork, double searchDistance) {
        super(
            roadNetwork,
            searchDistance,
            new org.jgrapht.alg.shortestpath.AStarShortestPath<>(
                roadNetwork.getDirectedRoadGraph(),
                GeoFunctions::getDistanceInM
            )
        );
    }

    public AStarShortestPath(RoadNetwork roadNetwork) {
        super(
            roadNetwork,
            new org.jgrapht.alg.shortestpath.AStarShortestPath<>(
                roadNetwork.getDirectedRoadGraph(),
                GeoFunctions::getDistanceInM
            )
        );
    }
}

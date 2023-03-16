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
package org.urbcomp.cupid.db.algorithm.reachable;

import org.urbcomp.cupid.db.algorithm.shortestpath.AbstractShortestPath;
import org.urbcomp.cupid.db.algorithm.shortestpath.BiDijkstraShortestPath;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.*;

public class ReachableArea {

    private SpatialPoint startPt;
    private double disInMeter;
    private List<Integer> roadType;
    private final AbstractShortestPath pathAlgo;
    private final RoadNetwork roadNetwork;

    public ReachableArea(
        RoadNetwork roadNetwork,
        SpatialPoint startPt,
        double timeBudgetInS,
        String travelMode
    ) {
        this.startPt = startPt;
        this.roadNetwork = roadNetwork;
        this.pathAlgo = new BiDijkstraShortestPath(roadNetwork);
        if (travelMode == "Drive") {
            this.roadType = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
            this.disInMeter = timeBudgetInS / 3600 * 30000;
        } else if (travelMode == "Walk") {
            this.roadType = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
            this.disInMeter = timeBudgetInS / 3600 * 5000;
        } else if (travelMode == "Ride") {
            this.roadType = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
            this.disInMeter = timeBudgetInS / 3600 * 10000;
        } else {
            throw new IllegalArgumentException("Travel mode should be drive, walk, or ride");
        }
    }

    public ArrayList<SpatialPoint> calReachableArea() {
        Stack<RoadNode> nodeStack = new Stack<>();
        ArrayList<RoadNode> visitedNode = new ArrayList<>();
        ArrayList<SpatialPoint> researchable = new ArrayList<>();
        RoadGraph graph = roadNetwork.getDirectedRoadGraph();
        SpatialPoint startPoint = new SpatialPoint(startPt.getCoordinate());

        CandidatePoint startCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            startPoint,
            roadNetwork,
            500
        );
        RoadNode startNode = roadNetwork.getRoadSegmentById(startCandidatePoint.getRoadSegmentId())
            .getStartNode();
        nodeStack.push(startNode);
        SpatialPoint startNodePoint = new SpatialPoint(startNode.getLng(), startNode.getLat());

        this.disInMeter = this.disInMeter - GeoFunctions.getDistanceInM(
            startCandidatePoint,
            startNodePoint
        );

        while (!nodeStack.isEmpty()) {
            RoadNode node = nodeStack.pop();
            visitedNode.add(node);
            Set<RoadSegment> edges = graph.edgesOf(node); // return the edge from the node
            for (RoadSegment e : edges) {
                if (roadType.contains(e.getLevel().value())) // check road level
                {
                    if (e.getStartNode().equals(node)
                        && (e.getDirection() == RoadSegmentDirection.DUAL
                            || e.getDirection() == RoadSegmentDirection.FORWARD)) {

                        if (!visitedNode.contains(e.getEndNode())
                            && pathAlgo.findShortestPath(startNode, e.getEndNode())
                                .getLengthInMeter() < disInMeter) {
                            nodeStack.push(e.getEndNode());
                            researchable.add(e.getEndNode());
                        }
                    } else if (e.getEndNode().equals(node)
                        && (e.getDirection() == RoadSegmentDirection.DUAL
                            || e.getDirection() == RoadSegmentDirection.BACKWARD)) {
                                if (!visitedNode.contains(e.getStartNode())
                                    && pathAlgo.findShortestPath(startNode, e.getStartNode())
                                        .getLengthInMeter() < disInMeter) {
                                    nodeStack.push(e.getStartNode());
                                    researchable.add(e.getStartNode());

                                }
                            }
                }
            }
        }
        return researchable;
    }
}

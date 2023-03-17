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

import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.*;

public class ReachableArea {

    private final SpatialPoint startPoint;
    private final double timeBudgetInS;
    private final List<Integer> roadType;
    private final RoadNetwork roadNetwork;
    private final String travelMode;
    private double speed;

    public ReachableArea(
        RoadNetwork roadNetwork,
        SpatialPoint startPoint,
        double timeBudgetInS,
        String travelMode
    ) {
        this.startPoint = startPoint;
        this.roadNetwork = roadNetwork;
        this.timeBudgetInS = timeBudgetInS;
        this.travelMode = travelMode;
        switch (travelMode) {
            case "Drive":
                this.roadType = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
                this.speed = 50.0 / 3.6;
                break;
            case "Walk":
                this.roadType = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
                this.speed = 5.0 / 3.6;
                break;
            case "Ride":
                this.roadType = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
                this.speed = 10.0 / 3.6;
                break;
            default:
                throw new IllegalArgumentException("Travel mode should be drive, walk, or ride");
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ArrayList<SpatialPoint> calReachableArea() {

        Queue<RoadNode> nodeQueue = new LinkedList<>();
        HashMap<RoadNode, Double> costMap = new HashMap<>();
        ArrayList<SpatialPoint> researchable = new ArrayList<>();
        ArrayList<SpatialPoint> visitedNode = new ArrayList<>();
        RoadGraph graph = this.roadNetwork.getDirectedRoadGraph();

        CandidatePoint startCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            startPoint,
            roadNetwork,
            100
        );
        if(startCandidatePoint != null)
        {
            RoadNode startNode = roadNetwork.getRoadSegmentById(startCandidatePoint.getRoadSegmentId())
                    .getStartNode();
            nodeQueue.offer(startNode);
            visitedNode.add(startNode);
            costMap.put(
                    startNode,
                    GeoFunctions.getDistanceInM(this.startPoint, startNode) / this.speed
            );

            while (!nodeQueue.isEmpty()) {
                RoadNode curNode = nodeQueue.poll();
                Set<RoadSegment> edges = graph.edgesOf(curNode); // return the edge from the node
                for (RoadSegment e : edges) {
                    RoadNode candidateNode;
                    if (this.roadType.contains(e.getLevel().value())) {
                        if (e.getStartNode().equals(curNode)
                                && (e.getDirection() == RoadSegmentDirection.DUAL
                                || e.getDirection() == RoadSegmentDirection.FORWARD)) {
                            candidateNode = e.getEndNode();
                        } else if (e.getEndNode().equals(curNode)
                                && (e.getDirection() == RoadSegmentDirection.DUAL
                                || e.getDirection() == RoadSegmentDirection.BACKWARD)) {
                            candidateNode = e.getStartNode();
                        } else {
                            continue;
                        }

                        if (visitedNode.contains(candidateNode)) {
                            continue;
                        }
                        double curCost = costMap.get(curNode);

                        if (this.travelMode.equals("Drive")) {
                            setSpeed(e.getSpeedLimit() / 3.6);
                        }
                        double candidateCost = curCost + e.getLengthInMeter() / this.speed;

                        if (candidateCost <= this.timeBudgetInS) {
                            nodeQueue.offer(candidateNode);
                            visitedNode.add(candidateNode);
                            researchable.add(candidateNode);
                            costMap.put(candidateNode, candidateCost);
                        } else {
                            List<SpatialPoint> pts = e.getPoints();
                            for (int i = 0; i < pts.size(); i++) {
                                double dis = GeoFunctions.getDistanceInM(curNode, pts.get(i));
                                if (curCost + dis / this.speed > this.timeBudgetInS) {
                                    if (i > 0) {
                                        researchable.add(pts.get(i - 1));
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return researchable;
    }
}

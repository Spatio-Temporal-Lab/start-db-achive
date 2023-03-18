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
    private final List<RoadSegmentLevel> roadType;
    private final RoadNetwork roadNetwork;
    private final TravelMode travelMode;
    protected static double rideSpeedInMeterPerSec = 10.0 / 3.6;
    protected static double walkSpeedInMeterPerSec = 5.0 / 3.6;

    public ReachableArea(
        RoadNetwork roadNetwork,
        SpatialPoint startPoint,
        double timeBudgetInS,
        String travelMode
    ) {
        this.startPoint = startPoint;
        this.roadNetwork = roadNetwork;
        this.timeBudgetInS = timeBudgetInS;
        switch (travelMode) {
            case "Drive":
                this.travelMode = TravelMode.DRIVE;
                this.roadType = Arrays.asList(
                    RoadSegmentLevel.ELEVATED_ROAD,
                    RoadSegmentLevel.HIGH_WAY_ROAD,
                    RoadSegmentLevel.NATIONAL_ROAD,
                    RoadSegmentLevel.PROVINCIAL_ROAD,
                    RoadSegmentLevel.COUNTRY_ROAD,
                    RoadSegmentLevel.MAIN_ROAD,
                    RoadSegmentLevel.URBAN_ROAD,
                    RoadSegmentLevel.DOWNTOWN_ROAD,
                    RoadSegmentLevel.RESIDENTIAL_ROAD
                );
                break;
            case "Walk":
                this.travelMode = TravelMode.WALK;
                this.roadType = Arrays.asList(
                    RoadSegmentLevel.NATIONAL_ROAD,
                    RoadSegmentLevel.PROVINCIAL_ROAD,
                    RoadSegmentLevel.COUNTRY_ROAD,
                    RoadSegmentLevel.MAIN_ROAD,
                    RoadSegmentLevel.URBAN_ROAD,
                    RoadSegmentLevel.DOWNTOWN_ROAD,
                    RoadSegmentLevel.RESIDENTIAL_ROAD,
                    RoadSegmentLevel.SIDEWALK_ROAD
                );
                break;
            case "Ride":
                this.travelMode = TravelMode.RIDE;
                this.roadType = Arrays.asList(
                    RoadSegmentLevel.NATIONAL_ROAD,
                    RoadSegmentLevel.PROVINCIAL_ROAD,
                    RoadSegmentLevel.COUNTRY_ROAD,
                    RoadSegmentLevel.MAIN_ROAD,
                    RoadSegmentLevel.URBAN_ROAD,
                    RoadSegmentLevel.DOWNTOWN_ROAD,
                    RoadSegmentLevel.RESIDENTIAL_ROAD,
                    RoadSegmentLevel.SIDEWALK_ROAD
                );
                break;
            default:
                throw new IllegalArgumentException("Travel mode should be drive, walk, or ride");
        }
    }

    public double getSpeed(TravelMode mode, RoadSegment roadSegment) {
        switch (mode) {
            case WALK:
                return walkSpeedInMeterPerSec;
            case RIDE:
                return rideSpeedInMeterPerSec;
            case DRIVE:
                return roadSegment.getSpeedLimit() / 3.6;
            default:
                throw new IllegalArgumentException("Travel mode should be drive, walk, or ride");
        }
    }

    public RoadNode getCandidateNode(TravelMode mode, RoadSegment e, ReachableNode curNode) {
        if (mode.equals(TravelMode.DRIVE)) {
            if (e.getStartNode().equals(curNode.getNode())
                && (e.getDirection() == RoadSegmentDirection.DUAL
                    || e.getDirection() == RoadSegmentDirection.FORWARD)) {
                return e.getEndNode();
            } else if (e.getEndNode().equals(curNode.getNode())
                && (e.getDirection() == RoadSegmentDirection.DUAL
                    || e.getDirection() == RoadSegmentDirection.BACKWARD)) {
                        return e.getStartNode();
                    } else {
                        return null;
                    }
        } else {
            if (e.getStartNode().equals(curNode.getNode())) {
                return e.getEndNode();
            } else {
                return e.getStartNode();
            }
        }
    }

    public ArrayList<SpatialPoint> calReachableArea() {

        ArrayList<SpatialPoint> researchable = new ArrayList<>();
        HashSet<SpatialPoint> visitedNode = new HashSet<>();
        RoadGraph graph = this.roadNetwork.getDirectedRoadGraph();
        Queue<ReachableNode> nodeQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getCost() == o2.getCost()) {
                return 0;
            } else {
                return o1.getCost() <= o2.getCost() ? -1 : 1;
            }
        });

        CandidatePoint startCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            startPoint,
            roadNetwork,
            100
        );
        if (startCandidatePoint != null) {
            RoadSegment startSegment = roadNetwork.getRoadSegmentById(
                startCandidatePoint.getRoadSegmentId()
            );
            RoadNode startNode = startSegment.getStartNode();
            visitedNode.add(startNode);
            nodeQueue.offer(
                new ReachableNode(
                    startNode,
                    GeoFunctions.getDistanceInM(this.startPoint, startNode) / getSpeed(
                        this.travelMode,
                        startSegment
                    )
                )
            );
            while (!nodeQueue.isEmpty()) {
                ReachableNode curNode = nodeQueue.poll();
                assert curNode != null;
                Set<RoadSegment> edges = graph.edgesOf(curNode.getNode()); // return the edge from
                                                                           // the node
                for (RoadSegment e : edges) {
                    if (this.roadType.contains(e.getLevel())) {
                        RoadNode candidateNode = getCandidateNode(this.travelMode, e, curNode);
                        if (candidateNode == null || visitedNode.contains(candidateNode)) {
                            continue;
                        }
                        double curCost = curNode.getCost();
                        double candidateCost = curCost + e.getLengthInMeter() / getSpeed(
                            this.travelMode,
                            e
                        );
                        if (candidateCost <= this.timeBudgetInS) {
                            visitedNode.add(candidateNode);
                            researchable.add(candidateNode);
                            nodeQueue.offer(new ReachableNode(candidateNode, candidateCost));
                        } else {
                            List<SpatialPoint> pts = e.getPoints();
                            for (int i = 0; i < pts.size(); i++) {
                                double dis = GeoFunctions.getDistanceInM(
                                    curNode.getNode(),
                                    pts.get(i)
                                );
                                if (curCost + dis / getSpeed(
                                    this.travelMode,
                                    e
                                ) > this.timeBudgetInS) {
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

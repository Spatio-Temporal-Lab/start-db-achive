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

import org.locationtech.jts.geom.Polygon;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.*;

public abstract class AbstractReachableArea {
    protected final SpatialPoint startPoint;
    protected final double timeBudgetInS;
    protected final RoadNetwork roadNetwork;
    private final TravelMode travelMode;
    private final List<RoadSegmentLevel> roadType;

    protected final static double rideSpeedInMeterPerSec = 10.0 / 3.6;
    protected final static double walkSpeedInMeterPerSec = 5.0 / 3.6;

    public AbstractReachableArea(
        RoadNetwork roadNetwork,
        SpatialPoint startPt,
        double timeBudgetInS,
        String travelMode
    ) {
        this.startPoint = startPt;
        this.roadNetwork = roadNetwork;
        this.timeBudgetInS = timeBudgetInS;
        this.travelMode = TravelMode.fromString(travelMode);
        this.roadType = getRoadType(this.travelMode);
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
        if (mode == TravelMode.DRIVE) {
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

    public abstract Polygon getHull();

    private List<RoadSegmentLevel> getRoadType(TravelMode travelMode) {
        switch (travelMode) {
            case DRIVE:
                return Arrays.asList(
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
            case WALK:
            case RIDE:
                return Arrays.asList(
                    RoadSegmentLevel.NATIONAL_ROAD,
                    RoadSegmentLevel.PROVINCIAL_ROAD,
                    RoadSegmentLevel.COUNTRY_ROAD,
                    RoadSegmentLevel.MAIN_ROAD,
                    RoadSegmentLevel.URBAN_ROAD,
                    RoadSegmentLevel.DOWNTOWN_ROAD,
                    RoadSegmentLevel.RESIDENTIAL_ROAD,
                    RoadSegmentLevel.SIDEWALK_ROAD
                );
            default:
                throw new IllegalArgumentException("Unsupported travel mode");
        }
    }

    protected ArrayList<SpatialPoint> calReachableArea() {
        ArrayList<SpatialPoint> reachablePoints = new ArrayList<>();
        HashSet<SpatialPoint> visitedNodes = new HashSet<>();
        RoadGraph graph = this.roadNetwork.getDirectedRoadGraph();
        Queue<ReachableNode> nodeQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getCost() == o2.getCost()) {
                return 0;
            } else {
                return o1.getCost() < o2.getCost() ? -1 : 1;
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
            visitedNodes.add(startNode);
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
                        if (candidateNode == null || visitedNodes.contains(candidateNode)) {
                            continue;
                        }
                        double curCost = curNode.getCost();
                        double candidateCost = curCost + e.getLengthInMeter() / getSpeed(
                            this.travelMode,
                            e
                        );
                        if (candidateCost <= this.timeBudgetInS) {
                            visitedNodes.add(candidateNode);
                            List<SpatialPoint> pts = e.getPoints();
                            for (int i = 1; i < pts.size(); i++) {
                                reachablePoints.add(pts.get(i));
                            }
                            nodeQueue.offer(new ReachableNode(candidateNode, candidateCost));
                        } else {
                            List<SpatialPoint> pts = e.getPoints();
                            double dis = 0;
                            for (int i = 1; i < pts.size(); i++) {
                                dis += GeoFunctions.getDistanceInM(pts.get(i - 1), pts.get(i));
                                if (curCost + dis / getSpeed(
                                    this.travelMode,
                                    e
                                ) <= this.timeBudgetInS) {
                                    reachablePoints.add(pts.get(i));
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return reachablePoints;
    }
}

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

import com.github.davidmoten.guavamini.Lists;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ManyToManyShortestPathsAlgorithm;
import org.urbcomp.cupid.db.exception.AlgorithmExecuteException;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.*;

public class AbstractManyToManyShortestPath {
    private final ManyToManyShortestPathsAlgorithm<RoadNode, RoadSegment> algo;
    private final RoadNetwork roadNetwork;

    public AbstractManyToManyShortestPath(
        RoadNetwork roadNetwork,
        ManyToManyShortestPathsAlgorithm<RoadNode, RoadSegment> algo
    ) {
        this.roadNetwork = roadNetwork;
        this.algo = algo;
    }

    public Map<RoadNode, Map<RoadNode, Path>> findShortestPath(
        Set<CandidatePoint> startPoints,
        Set<CandidatePoint> endPoints
    ) throws AlgorithmExecuteException {

        Set<RoadNode> startNodes = new HashSet<>();
        Set<RoadNode> endNodes = new HashSet<>();
        Iterator iterStart = startPoints.iterator();
        Iterator iterEnd = endPoints.iterator();

        while (iterStart.hasNext()) {
            CandidatePoint startPt = (CandidatePoint) iterStart.next();
            RoadSegment startRoadSegment = roadNetwork.getRoadSegmentById(
                startPt.getRoadSegmentId()
            );
            startNodes.add(startRoadSegment.getEndNode());
        }
        while (iterEnd.hasNext()) {
            CandidatePoint endPt = (CandidatePoint) iterEnd.next();
            RoadSegment endRoadSegment = roadNetwork.getRoadSegmentById(endPt.getRoadSegmentId());
            endNodes.add(endRoadSegment.getStartNode());
        }
        return findManyToManyShortestPath(startNodes, endNodes);
    }

    public Map<RoadNode, Map<RoadNode, Path>> findManyToManyShortestPath(
        Set<RoadNode> startNodes,
        Set<RoadNode> endNodes
    ) {
        ManyToManyShortestPathsAlgorithm.ManyToManyShortestPaths<RoadNode, RoadSegment> paths = algo
            .getManyToManyPaths(startNodes, endNodes);

        Iterator iterStart = startNodes.iterator();

        Map<RoadNode, Map<RoadNode, Path>> Paths = new HashMap();
        while (iterStart.hasNext()) {
            RoadNode startNode = (RoadNode) iterStart.next();
            Map<RoadNode, Path> tmpMap = new HashMap();
            Iterator iterEnd = endNodes.iterator();
            while (iterEnd.hasNext()) {
                RoadNode endNode = (RoadNode) iterEnd.next();
                GraphPath<RoadNode, RoadSegment> shortestPath = paths.getPath(startNode, endNode);
                if (shortestPath.getLength() == 0) {
                    shortestPath.getLength();
                    tmpMap.put(
                        endNode,
                        new Path(Double.MAX_VALUE, new ArrayList<>(), new ArrayList<>())
                    );
                } else {
                    List<SpatialPoint> points = new ArrayList<>();
                    double length = 0;
                    List<Integer> roadSegmentIds = new ArrayList<>();
                    for (RoadSegment rs : shortestPath.getEdgeList()) {
                        length += rs.getLengthInMeter();
                        points.addAll(rs.getPoints());
                        roadSegmentIds.add(rs.getRoadSegmentId());
                    }
                    tmpMap.put(endNode, new Path(length, points, roadSegmentIds));

                }
            }
            Paths.put(startNode, tmpMap);
        }
        return Paths;

    }

    public Path getCompletePath(
        CandidatePoint startCandidatePoint,
        CandidatePoint endCandidatePoint,
        Path path
    ) {
        RoadSegment startRoadSegment = roadNetwork.getRoadSegmentById(
            startCandidatePoint.getRoadSegmentId()
        );
        RoadSegment endRoadSegment = roadNetwork.getRoadSegmentById(
            endCandidatePoint.getRoadSegmentId()
        );

        // 两个点在同一条双向路段上，并且方向相反
        if (startRoadSegment.getRoadSegmentId() == -endRoadSegment.getRoadSegmentId()) {
            endCandidatePoint = reverseCandidatePoint(
                endCandidatePoint,
                endRoadSegment,
                startRoadSegment
            );
            endRoadSegment = startRoadSegment;
        }
        // 两个点在同一条路段上, 并且出发点在前
        if (startRoadSegment.getRoadSegmentId() == endRoadSegment.getRoadSegmentId()
            && startCandidatePoint.getOffsetInMeter() <= endCandidatePoint.getOffsetInMeter()) {
            return getPathInSameRoadSegmentInOrder(
                startCandidatePoint,
                endCandidatePoint,
                startRoadSegment
            );
        }
        // 两个点在同一条双向路段上，并且出发点在后
        if (startRoadSegment.getRoadSegmentId() == endRoadSegment.getRoadSegmentId()
            && startCandidatePoint.getOffsetInMeter() > endCandidatePoint.getOffsetInMeter()
            && startRoadSegment.getDirection() == RoadSegmentDirection.DUAL) {
            return getPathInSameRoadSegmentReverse(
                startCandidatePoint,
                endCandidatePoint,
                startRoadSegment
            );
        } else {
            Path result = getSubPathFromStartPoint(startCandidatePoint, startRoadSegment);
            result.addPath(path);
            result.addPath(getSubPathToEndPoint(endCandidatePoint, endRoadSegment));
            return result;

        }

    }

    private Path getSubPathFromStartPoint(
        CandidatePoint startCandidatePoint,
        RoadSegment startRoadSegment
    ) {
        List<SpatialPoint> points = new ArrayList<>();
        points.add(startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex() + 1; i < startRoadSegment.getPoints()
            .size(); i++) {
            points.add(startRoadSegment.getPoints().get(i));
        }
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Lists.newArrayList(startRoadSegment.getRoadSegmentId())
        );
    }

    private Path getSubPathToEndPoint(
        CandidatePoint endCandidatePoint,
        RoadSegment endRoadSegment
    ) {
        List<SpatialPoint> points = new ArrayList<>();
        for (int i = 0; i < endCandidatePoint.getMatchedIndex(); i++) {
            points.add(endRoadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Lists.newArrayList(endRoadSegment.getRoadSegmentId())
        );
    }

    private Path getPathInSameRoadSegmentInOrder(
        CandidatePoint startCandidatePoint,
        CandidatePoint endCandidatePoint,
        RoadSegment roadSegment
    ) {
        List<SpatialPoint> points = new ArrayList<>();
        points.add(startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex() + 1; i <= endCandidatePoint
            .getMatchedIndex(); i++) {
            points.add(roadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Collections.singletonList(roadSegment.getRoadSegmentId())
        );
    }

    private Path getPathInSameRoadSegmentReverse(
        CandidatePoint startCandidatePoint,
        CandidatePoint endCandidatePoint,
        RoadSegment roadSegment
    ) {
        List<SpatialPoint> points = new ArrayList<>();
        points.add(startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex(); i > endCandidatePoint
            .getMatchedIndex(); i--) {
            points.add(roadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Collections.singletonList(roadSegment.getRoadSegmentId())
        );
    }

    private CandidatePoint reverseCandidatePoint(
        CandidatePoint candidatePoint,
        RoadSegment rsOld,
        RoadSegment rsNew
    ) {
        return new CandidatePoint(
            candidatePoint,
            rsNew,
            rsOld.getPoints().size() - 2 - candidatePoint.getMatchedIndex(),
            candidatePoint.getErrorDistanceInMeter()
        );
    }

}

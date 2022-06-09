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

import com.github.davidmoten.guavamini.Lists;
import org.urbcomp.start.db.exception.AlgorithmExecuteException;
import org.urbcomp.start.db.model.point.CandidatePoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadsegment.*;
import org.urbcomp.start.db.util.GeoFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractOneToOneShortestPath {
    private final RoadNetwork roadNetwork;
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

    protected abstract Path findShortestPath(RoadNode startNode, RoadNode endNode);

    /**
     * 获得最短路径的Id列表，以及点列表
     * @param startPoint 起始点
     * @param endPoint 终止点
     * @return path
     * @throws AlgorithmExecuteException 当找不到最近的路网，则抛出异常
     */
    public Path findShortestPath(SpatialPoint startPoint, SpatialPoint endPoint)
        throws AlgorithmExecuteException {
        if (startPoint.equals(endPoint)) {
            return new Path(0, Arrays.asList(startPoint, endPoint), new ArrayList<>());
        }
        CandidatePoint startCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            startPoint,
            roadNetwork,
            searchDistance
        );
        CandidatePoint endCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            endPoint,
            roadNetwork,
            searchDistance
        );
        if (startCandidatePoint == null || endCandidatePoint == null) {
            throw new AlgorithmExecuteException(
                "No candidate road segment found, please increase the search distance or check your query points"
            );
        }
        RoadSegment startRoadSegment = roadNetwork.getRoadSegmentById(
            startCandidatePoint.getRoadSegmentId()
        );
        RoadSegment endRoadSegment = roadNetwork.getRoadSegmentById(
            endCandidatePoint.getRoadSegmentId()
        );

        // 两个点在同一条双向路段上
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
                startPoint,
                startCandidatePoint,
                endPoint,
                endCandidatePoint,
                startRoadSegment
            );
        }
        // 两个点在同一条双向路段上，并且出发点在后
        if (startRoadSegment.getRoadSegmentId() == endRoadSegment.getRoadSegmentId()
            && startCandidatePoint.getOffsetInMeter() > endCandidatePoint.getOffsetInMeter()
            && startRoadSegment.getDirection() == RoadSegmentDirection.DUAL) {
            return getPathInSameRoadSegmentReverse(
                startPoint,
                startCandidatePoint,
                endPoint,
                endCandidatePoint,
                startRoadSegment
            );
        }

        // 处理在不同路段的情况
        List<Path> results = new ArrayList<>();

    }

    private Path getPathInSameRoadSegmentInOrder(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        SpatialPoint endPoint,
        CandidatePoint endCandidatePoint,
        RoadSegment roadSegment
    ) {
        List<SpatialPoint> points = Lists.newArrayList(startPoint, startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex(); i <= endCandidatePoint
            .getMatchedIndex(); i++) {
            points.add(roadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        points.add(endPoint);
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Collections.singletonList(roadSegment.getRoadSegmentId())
        );
    }

    private Path getPathInSameRoadSegmentReverse(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        SpatialPoint endPoint,
        CandidatePoint endCandidatePoint,
        RoadSegment roadSegment
    ) {
        List<SpatialPoint> points = Lists.newArrayList(startPoint, startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex(); i >= endCandidatePoint
            .getMatchedIndex(); i--) {
            points.add(roadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        points.add(endPoint);
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

    private Path startPointToEndNode(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        RoadSegment startRoadSegment
    ) {
        List<SpatialPoint> points = Lists.newArrayList(startPoint, startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex(); i < startRoadSegment.getPoints()
            .size(); i++) {
            points.add(startRoadSegment.getPoints().get(i));
        }
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Lists.newArrayList(startRoadSegment.getRoadSegmentId())
        );
    }

    private Path endNodeToEndPoint(
        SpatialPoint endPoint,
        CandidatePoint endCandidatePoint,
        RoadSegment endRoadSegment
    ) {
        List<SpatialPoint> points = new ArrayList<>();
        for (int i = 0; i < endCandidatePoint.getMatchedIndex(); i++) {
            points.add(endRoadSegment.getPoints().get(i));
        }
        points.add(endCandidatePoint);
        points.add(endPoint);
        return new Path(
            GeoFunctions.getDistanceInM(points),
            points,
            Lists.newArrayList(endRoadSegment.getRoadSegmentId())
        );
    }
}

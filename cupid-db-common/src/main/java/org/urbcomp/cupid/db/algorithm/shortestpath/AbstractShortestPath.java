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

import com.github.davidmoten.guavamini.Lists;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.urbcomp.cupid.db.exception.AlgorithmExecuteException;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.*;

public abstract class AbstractShortestPath {
    private final ShortestPathAlgorithm<RoadNode, RoadSegment> algo;
    private final RoadNetwork roadNetwork;
    /**
     * note that the start and end points may be mot exactly on the road segments,
     * the searchDistance defines the scope to find the start or end road segments.
     * unit: meter
     */
    private double searchDistance = 300;

    public AbstractShortestPath(
        RoadNetwork roadNetwork,
        double searchDistance,
        ShortestPathAlgorithm<RoadNode, RoadSegment> algo
    ) {
        this.roadNetwork = roadNetwork;
        this.searchDistance = searchDistance;
        this.algo = algo;
    }

    public AbstractShortestPath(
        RoadNetwork roadNetwork,
        ShortestPathAlgorithm<RoadNode, RoadSegment> algo
    ) {
        this.roadNetwork = roadNetwork;
        this.algo = algo;
    }

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
        List<Path> paths = new ArrayList<>();
        paths.add(
            getPathByEndNodeToStartNode(
                startPoint,
                startCandidatePoint,
                startRoadSegment,
                endPoint,
                endCandidatePoint,
                endRoadSegment
            )
        );
        if (startRoadSegment.getDirection() == RoadSegmentDirection.DUAL) {
            RoadSegment reverseStartRoadSegment = roadNetwork.getRoadSegmentById(
                -startRoadSegment.getRoadSegmentId()
            );
            CandidatePoint reverseStartCandidatePoint = reverseCandidatePoint(
                startCandidatePoint,
                startRoadSegment,
                reverseStartRoadSegment
            );
            paths.add(
                getPathByEndNodeToStartNode(
                    startPoint,
                    reverseStartCandidatePoint,
                    reverseStartRoadSegment,
                    endPoint,
                    endCandidatePoint,
                    endRoadSegment
                )
            );
            if (endRoadSegment.getDirection() == RoadSegmentDirection.DUAL) {
                RoadSegment reverseEndRoadSegment = roadNetwork.getRoadSegmentById(
                    -endRoadSegment.getRoadSegmentId()
                );
                CandidatePoint reverseEndCandidatePoint = reverseCandidatePoint(
                    endCandidatePoint,
                    endRoadSegment,
                    reverseEndRoadSegment
                );
                paths.add(
                    getPathByEndNodeToStartNode(
                        startPoint,
                        reverseStartCandidatePoint,
                        reverseStartRoadSegment,
                        endPoint,
                        reverseEndCandidatePoint,
                        reverseEndRoadSegment
                    )
                );
            }
        }
        if (endRoadSegment.getDirection() == RoadSegmentDirection.DUAL) {
            RoadSegment reverseEndRoadSegment = roadNetwork.getRoadSegmentById(
                -endRoadSegment.getRoadSegmentId()
            );
            CandidatePoint reverseEndCandidatePoint = reverseCandidatePoint(
                endCandidatePoint,
                endRoadSegment,
                reverseEndRoadSegment
            );
            paths.add(
                getPathByEndNodeToStartNode(
                    startPoint,
                    startCandidatePoint,
                    startRoadSegment,
                    endPoint,
                    reverseEndCandidatePoint,
                    reverseEndRoadSegment
                )
            );
        }
        Path path = Collections.min(paths, Comparator.comparingDouble(Path::getLengthInMeter));
        if (path.getLengthInMeter() != Double.MAX_VALUE) {
            return path;
        } else {
            return new Path(Double.MAX_VALUE, new ArrayList<>(), new ArrayList<>());
        }
    }

    public Path findShortestPath(RoadNode startNode, RoadNode endNode) {
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

    private Path getPathByEndNodeToStartNode(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        RoadSegment startRoadSegment,
        SpatialPoint endPoint,
        CandidatePoint endCandidatePoint,
        RoadSegment endRoadSegment
    ) {
        Path result = getSubPathFromStartPoint(startPoint, startCandidatePoint, startRoadSegment);
        result.addPath(
            findShortestPath(startRoadSegment.getEndNode(), endRoadSegment.getStartNode())
        );
        result.addPath(getSubPathToEndPoint(endPoint, endCandidatePoint, endRoadSegment));
        return result;
    }

    private Path getPathInSameRoadSegmentInOrder(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        SpatialPoint endPoint,
        CandidatePoint endCandidatePoint,
        RoadSegment roadSegment
    ) {
        List<SpatialPoint> points = Lists.newArrayList(startPoint, startCandidatePoint);
        for (int i = startCandidatePoint.getMatchedIndex() + 1; i <= endCandidatePoint
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
        for (int i = startCandidatePoint.getMatchedIndex(); i > endCandidatePoint
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

    /**
     * 获得从起始点的子路径
     * @param startPoint 起始点
     * @param startCandidatePoint 起始点对应的候选点
     * @param startRoadSegment 起始点对应的路段
     * @return 起始点到对应路段终端的子路径
     */
    private Path getSubPathFromStartPoint(
        SpatialPoint startPoint,
        CandidatePoint startCandidatePoint,
        RoadSegment startRoadSegment
    ) {
        List<SpatialPoint> points = Lists.newArrayList(startPoint, startCandidatePoint);
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

    /**
     * 获得到目标点的子路径
     * @param endPoint 目标点
     * @param endCandidatePoint 目标点对应的候选点
     * @param endRoadSegment    目标点对应的路段
     * @return 对应路段始端到终止点的子路径
     */
    private Path getSubPathToEndPoint(
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

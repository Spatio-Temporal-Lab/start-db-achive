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

package org.urbcomp.start.db.model.point;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.locationtech.jts.geom.Envelope;
import org.urbcomp.start.db.model.roadsegment.RoadNetwork;
import org.urbcomp.start.db.model.roadsegment.RoadSegment;
import org.urbcomp.start.db.util.GeoFunctions;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandidatePoint extends SpatialPoint {
    /**
     * matched road segment id
     */
    private final int roadSegmentId;
    /**
     * the distance from the start point of the matched road segment, meter
     */
    private final double offsetInMeter;

    /**
     * the matched position index in the road segment geo
     */
    private final int matchedIndex;

    /**
     * the distance between the matched point and the gps point
     */
    private final double errorDistanceInMeter;

    public int getRoadSegmentId() {
        return roadSegmentId;
    }

    public double getOffsetInMeter() {
        return offsetInMeter;
    }

    public int getMatchedIndex() {
        return matchedIndex;
    }

    public double getErrorDistanceInMeter() {
        return errorDistanceInMeter;
    }

    public CandidatePoint(
        SpatialPoint matchedPoint,
        RoadSegment roadSegment,
        int matchedIndex,
        double errorDistanceInMeter
    ) {
        super(matchedPoint.getLng(), matchedPoint.getLat());
        this.roadSegmentId = roadSegment.getRoadSegmentId();
        this.matchedIndex = matchedIndex;
        this.errorDistanceInMeter = errorDistanceInMeter;
        this.offsetInMeter = calOffsetInMeter(roadSegment, matchedIndex);
    }

    private double calOffsetInMeter(RoadSegment roadSegment, int matchedIndex) {
        double offset = GeoFunctions.getDistanceInM(
            new SpatialPoint(roadSegment.getPoints().get(matchedIndex).getCoordinate()),
            this
        );
        List<SpatialPoint> points = roadSegment.getPoints();
        for (int i = 0; i < points.size(); i++) {
            offset += GeoFunctions.getDistanceInM(points.get(i), points.get(i + 1));
        }
        return offset;
    }

    /**
     * 找到离原始点最近的candidate point
     *
     * @param pt          原始点
     * @param roadNetwork 路网索引
     * @param dist        搜索距离
     * @return candidate point
     */
    public static CandidatePoint getNearestCandidatePoint(SpatialPoint pt, RoadNetwork roadNetwork, double dist) {
        List<CandidatePoint> candidates = getCandidatePoint(pt, roadNetwork, dist);
        if (candidates.size() != 0) {
            return Collections.min(candidates, Comparator.comparingDouble(CandidatePoint::getErrorDistanceInMeter));
        } else {
            return null;
        }
    }

    /**
     * 给定一个点 和一个搜索距离 返回range query的roadSegment
     *
     * @param pt          点
     * @param roadNetwork 路网索引
     * @param dist        搜索的距离
     * @return 这个点在搜索范围内，所有可能对应的 candidate points
     */
    public static List<CandidatePoint> getCandidatePoint(SpatialPoint pt, RoadNetwork roadNetwork, double dist) {
        Envelope mbr = GeoFunctions.getExtendedBBox(pt, dist);
        Rectangle rec = Geometries.rectangleGeographic(mbr.getMinX(), mbr.getMinY(), mbr.getMaxX(), mbr.getMaxY());
        Iterable<RoadSegment> roadSegmentIterable = roadNetwork.getRoadRTree().search(rec).map(Entry::value).toBlocking().toIterable();
        List<CandidatePoint> result = new ArrayList<>();
        roadSegmentIterable.forEach(roadSegment1 -> {
            CandidatePoint candiPt = calCandidatePoint(pt, roadSegment1);
            if (candiPt.errorDistanceInMeter <= dist) {
                result.add(candiPt);
            }
        });
        return !result.isEmpty() ? result : new ArrayList<>();
    }

    /**
     * 给一个点，路网，加上对应的roadSegment，找出candidate point
     *
     * @param rawPoint 原始点
     * @param rs       路段
     * @return 对应在该路段上的candidate point
     */
    public static CandidatePoint calCandidatePoint(SpatialPoint rawPoint, RoadSegment rs) {
        List<SpatialPoint> coords = rs.getCoords();
        Tuple2<ProjectionPoint, Integer> tuple = GeoFunction.calProjection(rawPoint, coords, 0, coords.size() - 1);
        ProjectionPoint projectionPoint = tuple._1;
        int matchIndex = tuple._2;
        return new CandidatePoint(projectionPoint, rs, matchIndex, projectionPoint.getErrorDistance());
    }
}

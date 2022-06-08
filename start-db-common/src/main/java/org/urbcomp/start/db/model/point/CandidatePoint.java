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

import org.urbcomp.start.db.model.roadsegment.RoadSegment;
import org.urbcomp.start.db.util.GeoFunctions;

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
}

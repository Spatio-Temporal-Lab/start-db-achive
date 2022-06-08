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

import org.locationtech.jts.geom.Coordinate;
import org.urbcomp.start.db.model.roadsegment.RoadSegment;
import org.urbcomp.start.db.util.GeoFunctions;

public class CandidatePoint extends SpatialPoint {
    /**
     * matched road segment id
     */
    private final int roadSegmentId;
    /**
     * the distance from the start point of the matched road segment, meter
     */
    private final double offsetInM;

    /**
     * the matched position index in the road segment geo
     */
    private final int matchedIndex;

    /**
     * the distance between the matched point and the gps point
     */
    private final double errorDistanceM;

    public int getRoadSegmentId() {
        return roadSegmentId;
    }

    public double getOffsetInM() {
        return offsetInM;
    }

    public int getMatchedIndex() {
        return matchedIndex;
    }

    public double getErrorDistanceM() {
        return errorDistanceM;
    }

    public CandidatePoint(
        SpatialPoint matchedPoint,
        RoadSegment roadSegment,
        int matchedIndex,
        double errorDistanceM
    ) {
        super(matchedPoint.getLng(), matchedPoint.getLat());
        this.roadSegmentId = roadSegment.getRoadSegmentId();
        this.matchedIndex = matchedIndex;
        this.errorDistanceM = errorDistanceM;
        this.offsetInM = calOffsetInM(roadSegment, matchedIndex);
    }

    private double calOffsetInM(RoadSegment roadSegment, int matchedIndex) {
        double offset = GeoFunctions.getDistanceInM(
            new SpatialPoint(roadSegment.getGeom().getCoordinateN(matchedIndex)),
            this
        );
        Coordinate[] coordinates = roadSegment.getGeom().getCoordinates();
        for (int i = 0; i < coordinates.length; i++) {
            offset += GeoFunctions.getDistanceInM(
                new SpatialPoint(coordinates[i]),
                new SpatialPoint(coordinates[i + 1])
            );
        }
        return offset;
    }
}

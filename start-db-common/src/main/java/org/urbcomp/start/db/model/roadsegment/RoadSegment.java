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

package org.urbcomp.start.db.model.roadsegment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.LngLatAlt;
import org.locationtech.jts.geom.LineString;

import java.util.Arrays;
import java.util.Objects;

public class RoadSegment {
    // road segment id
    private int roadSegmentId;
    // the road geometry
    private LineString geom;
    // the road direction
    private RoadSegmentDirection direction;
    // the speed limitation, km/h
    private double speedLimit;
    // road level
    private RoadSegmentLevel level;
    // the start node id
    private int startId;
    // the end node id
    private int endId;
    // the length of the road, m
    private double length;

    public int getRoadSegmentId() {
        return roadSegmentId;
    }

    public RoadSegment setRoadSegmentId(int roadSegmentId) {
        this.roadSegmentId = roadSegmentId;
        return this;
    }

    public LineString getGeom() {
        return geom;
    }

    public RoadSegment setGeom(LineString geom) {
        this.geom = geom;
        return this;
    }

    public RoadSegmentDirection getDirection() {
        return direction;
    }

    public RoadSegment setDirection(RoadSegmentDirection direction) {
        this.direction = direction;
        return this;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public RoadSegment setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
        return this;
    }

    public RoadSegmentLevel getLevel() {
        return level;
    }

    public RoadSegment setLevel(RoadSegmentLevel level) {
        this.level = level;
        return this;
    }

    public int getStartId() {
        return startId;
    }

    public RoadSegment setStartId(int startId) {
        this.startId = startId;
        return this;
    }

    public int getEndId() {
        return endId;
    }

    public RoadSegment setEndId(int endId) {
        this.endId = endId;
        return this;
    }

    public double getLength() {
        return length;
    }

    public RoadSegment setLength(double length) {
        this.length = length;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadSegment rs = (RoadSegment) o;
        return Objects.equals(this.roadSegmentId, rs.roadSegmentId)
            && Objects.equals(this.direction, rs.direction)
            && Objects.equals(this.speedLimit, rs.speedLimit)
            && Objects.equals(this.level, rs.level)
            && Objects.equals(this.startId, rs.startId)
            && Objects.equals(this.endId, rs.endId)
            && Objects.equals(this.length, rs.length);
    }

    public Feature toFeature() {
        Feature f = new Feature();
        f.setProperty("rsId", roadSegmentId);
        f.setProperty("direction", direction.value());
        f.setProperty("speedLimit", speedLimit);
        f.setProperty("level", level.value());
        f.setProperty("startId", startId);
        f.setProperty("endId", endId);
        f.setProperty("length", length);
        LngLatAlt[] lngLats = Arrays.stream(geom.getCoordinates())
            .map(o -> new LngLatAlt(o.x, o.y))
            .toArray(LngLatAlt[]::new);
        f.setGeometry(new org.geojson.LineString(lngLats));
        return f;
    }

    public static RoadSegment fromFeature(Feature f) {
        return new RoadSegment().setRoadSegmentId(f.getProperty("rsId"))
            .setDirection(RoadSegmentDirection.valueOf((Integer) f.getProperty("direction")))
            .setSpeedLimit(f.getProperty("speedLimit"))
            .setLevel(RoadSegmentLevel.valueOf((Integer) f.getProperty("level")))
            .setStartId(f.getProperty("startId"))
            .setEndId(f.getProperty("endId"))
            .setLength(f.getProperty("length"));
    }

    /**
     * Convert this RoadSegment to GeoJSON String
     * @return GeoJSON String
     */
    public String toGeoJSON() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(toFeature());
    }

    public static RoadSegment fromGeoJSON(String geoJsonStr) throws JsonProcessingException {
        Feature f = new ObjectMapper().readValue(geoJsonStr, Feature.class);
        return fromFeature(f);
    }
}

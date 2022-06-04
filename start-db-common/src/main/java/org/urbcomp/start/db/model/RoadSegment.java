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

package org.urbcomp.start.db.model;

import org.locationtech.jts.geom.LineString;

public class RoadSegment {
    // road segment id
    private String rsId;
    // the road geometry
    private LineString geom;
    // the road direction
    private RoadSegmentDirection direction;
    // the speed limitation, km/h
    private double speedLimit;
    // road level
    private RoadSegmentLevel level;
    // the start node id
    private String startId;
    // the end node id
    private String endId;
    // the length of the road, m
    private double length;

    public String getRsId() {
        return rsId;
    }

    public RoadSegment setRsId(String rsId) {
        this.rsId = rsId;
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

    public String getStartId() {
        return startId;
    }

    public RoadSegment setStartId(String startId) {
        this.startId = startId;
        return this;
    }

    public String getEndId() {
        return endId;
    }

    public RoadSegment setEndId(String endId) {
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

}

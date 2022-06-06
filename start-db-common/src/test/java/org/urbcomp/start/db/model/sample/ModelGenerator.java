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

package org.urbcomp.start.db.model.sample;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.urbcomp.start.db.model.*;

import java.sql.Timestamp;

public class ModelGenerator {
    public static Trajectory generateTrajectory() {
        GeometryFactory gf = new GeometryFactory();
        Point p1 = gf.createPoint(new Coordinate(111.37939453125, 54.00776876193478));
        Point p2 = gf.createPoint(new Coordinate(116.3671875, 53.05442186546102));
        return new Trajectory("tid", "oid").addGPSPoint(
            new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:00"), p1)
        ).addGPSPoint(new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:05"), p2));
    }

    public static RoadSegment generateRoadSegment() {
        GeometryFactory gf = new GeometryFactory();
        LineString ls = gf.createLineString(
            new Coordinate[] {
                new Coordinate(111.37939453125, 54.00776876193478),
                new Coordinate(116.3671875, 53.05442186546102) }
        );
        return new RoadSegment().setRsId("rsId")
            .setGeom(ls)
            .setDirection(RoadSegmentDirection.DUAL)
            .setSpeedLimit(30.0)
            .setLevel(RoadSegmentLevel.URBAN_ROAD)
            .setStartId("startId")
            .setEndId("endId")
            .setLength(120);
    }

    public static RoadNetwork generateRoadNetwork() {
        GeometryFactory gf = new GeometryFactory();
        LineString ls1 = gf.createLineString(
            new Coordinate[] {
                new Coordinate(111.37939453125, 54.00776876193478),
                new Coordinate(116.3671875, 53.05442186546102) }
        );
        RoadSegment rs1 = new RoadSegment().setRsId("rsId1")
            .setGeom(ls1)
            .setDirection(RoadSegmentDirection.DUAL)
            .setSpeedLimit(30.0)
            .setLevel(RoadSegmentLevel.URBAN_ROAD)
            .setStartId("startId1")
            .setEndId("endId1")
            .setLength(120);
        LineString ls2 = gf.createLineString(
            new Coordinate[] {
                new Coordinate(116.3671875, 53.05442186546102),
                new Coordinate(115.37939453125, 52.00776876193478) }
        );
        RoadSegment rs2 = new RoadSegment().setRsId("rsId2")
            .setGeom(ls2)
            .setDirection(RoadSegmentDirection.FORWARD)
            .setSpeedLimit(120)
            .setLevel(RoadSegmentLevel.HIGH_WAY_ROAD)
            .setStartId("endId1")
            .setEndId("endId2")
            .setLength(300);
        RoadNetwork rn = new RoadNetwork();
        rn.addRoadSegment(rs1).addRoadSegment(rs2);
        return rn;
    }
}

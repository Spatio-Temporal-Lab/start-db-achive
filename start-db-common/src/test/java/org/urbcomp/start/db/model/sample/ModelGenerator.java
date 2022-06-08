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

import org.urbcomp.start.db.model.Trajectory;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadsegment.RoadNetwork;
import org.urbcomp.start.db.model.roadsegment.RoadSegment;
import org.urbcomp.start.db.model.roadsegment.RoadSegmentDirection;
import org.urbcomp.start.db.model.roadsegment.RoadSegmentLevel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ModelGenerator {
    public static Trajectory generateTrajectory() {
        return new Trajectory("tid", "oid").addGPSPoint(
            new GPSPoint(
                Timestamp.valueOf("2022-06-04 18:52:00"),
                111.37939453125,
                54.00776876193478
            )
        )
            .addGPSPoint(
                new GPSPoint(
                    Timestamp.valueOf("2022-06-04 18:52:05"),
                    116.3671875,
                    53.05442186546102
                )
            );
    }

    public static RoadSegment generateRoadSegment() {
        List<SpatialPoint> points = new ArrayList<>();
        points.add(new SpatialPoint(111.37939453125, 54.00776876193478));
        points.add(new SpatialPoint(116.3671875, 53.05442186546102));
        return new RoadSegment(1, 1, 2, points).setDirection(RoadSegmentDirection.DUAL)
            .setSpeedLimit(30.0)
            .setLevel(RoadSegmentLevel.URBAN_ROAD)
            .setLengthInMeter(120);
    }

    public static RoadNetwork generateRoadNetwork() {
        RoadSegment rs1 = generateRoadSegment();
        RoadSegment rs2 = generateRoadSegment();
        rs2.setLevel(RoadSegmentLevel.HIGH_WAY_ROAD);
        RoadNetwork rn = new RoadNetwork();
        rn.addRoadSegment(rs1).addRoadSegment(rs2);
        return rn;
    }
}

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

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class TrajectoryTest {
    private Trajectory trajectory;

    @Before
    public void setUp() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        Point p1 = gf.createPoint(new Coordinate(111.37939453125, 54.00776876193478));
        Point p2 = gf.createPoint(new Coordinate(116.3671875, 53.05442186546102));
        trajectory = new Trajectory("tid", "oid").addGPSPoint(
            new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:00"), p1)
        ).addGPSPoint(new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:05"), p2));
    }

    @Test
    public void toGeoJSON() throws JsonProcessingException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

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
import org.locationtech.jts.geom.LineString;

import static org.junit.Assert.assertEquals;

public class RoadSegmentTest {
    private RoadSegment rs;

    @Before
    public void setUp() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        LineString ls = gf.createLineString(
            new Coordinate[] {
                new Coordinate(111.37939453125, 54.00776876193478),
                new Coordinate(116.3671875, 53.05442186546102) }
        );
        rs = new RoadSegment().setRsId("rsId")
            .setGeom(ls)
            .setDirection(RoadSegmentDirection.DUAL)
            .setSpeedLimit(30.0)
            .setLevel(RoadSegmentLevel.URBAN_ROAD)
            .setStartId("startId")
            .setEndId("endId")
            .setLength(120);
    }

    @Test
    public void toGeoJSON() throws JsonProcessingException {
        String jsonStr = rs.toGeoJSON();
        RoadSegment rs1 = RoadSegment.fromGeoJSON(jsonStr);
        assertEquals(rs, rs1);
    }
}

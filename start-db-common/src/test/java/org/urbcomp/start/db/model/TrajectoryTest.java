package org.urbcomp.start.db.model;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.junit.Test;
import org.junit.Before;

import java.sql.Timestamp;

public class TrajectoryTest {
    private Trajectory trajectory;

    @Before
    public void setUp() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        Point p1 = gf.createPoint(new Coordinate(111.37939453125,54.00776876193478));
        Point p2 = gf.createPoint(new Coordinate(116.3671875,53.05442186546102));
        trajectory = new Trajectory("tid", "oid")
                        .addGPSPoint(new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:00"), p1))
                        .addGPSPoint(new GPSPoint(Timestamp.valueOf("2022-06-04 18:52:05"), p2));
    }

    @Test
    public void toGeoJSON() {
        System.out.println(trajectory.toGeoJSON());
    }
}

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

import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.urbcomp.start.db.model.sample.ModelGenerator;
import org.urbcomp.start.db.model.trajectory.Trajectory;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TrajectoryTest {
    private final Trajectory trajectory = ModelGenerator.generateTrajectory();

    @Test
    public void toGeoJsonWithExtraAttribute() throws IOException {
        String[] namesArray = new String[] { "int", "str", "double", "point" };
        String[] typeArray = new String[] { "Integer", "String", "Double", "Point" };
        Trajectory trajectory1 = ModelGenerator.generateTrajectory(
            Arrays.asList(namesArray),
            Arrays.asList(typeArray)
        );
        String geoJson = trajectory1.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(1, traj.getAttribute("int"));
        assertEquals("2", traj.getAttribute("str"));
        assertEquals(3.0, traj.getAttribute("double"));
        GeometryFactory factory = new GeometryFactory();
        assertEquals(factory.createPoint(new Coordinate(1, 2)), trajectory1.getAttribute("point"));
        assertEquals(trajectory1, traj);
    }

    @Test
    public void toGeoJSON() throws IOException, ClassNotFoundException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

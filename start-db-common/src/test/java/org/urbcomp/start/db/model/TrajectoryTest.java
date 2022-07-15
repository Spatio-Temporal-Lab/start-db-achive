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
import org.junit.Test;
import org.urbcomp.start.db.model.sample.ModelGenerator;
import org.urbcomp.start.db.model.trajectory.Trajectory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class TestObj {
    private Integer i;
    private Double d;
    private String s;

    public TestObj(Integer i, Double d, String s) {
        this.i = i;
        this.d = d;
        this.s = s;
    }

    public Integer getI() {
        return i;
    }

    public Double getD() {
        return d;
    }

    public String getS() {
        return s;
    }
}

public class TrajectoryTest {
    private final Trajectory trajectory = ModelGenerator.generateTrajectory();

    @Test
    public void toGeoJsonWithExtraAttribute() throws ClassNotFoundException,
        JsonProcessingException {
        String[] namesStr = new String[] { "int", "str", "double", "testObj" };
        Class[] typeStr = new Class[] { Integer.class, String.class, Double.class, TestObj.class };
        Trajectory trajectory1 = ModelGenerator.generateTrajectory(
            Arrays.asList(namesStr),
            Arrays.asList(typeStr)
        );
        String geoJson = trajectory1.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(1, traj.getAttribute("int"));
        assertEquals("2", traj.getAttribute("str"));
        assertEquals(3.0, traj.getAttribute("double"));
        TestObj testObj = (TestObj) traj.getAttribute("testObj");
        assertEquals("3", testObj.getS());
        assertEquals(trajectory1, traj);
    }

    @Test
    public void toGeoJSON() throws JsonProcessingException, ClassNotFoundException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

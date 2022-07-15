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
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

class TestObj {
    Integer a;

    TestObj(Integer a) {
        this.a = a;
    }

    public Integer getA() {
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObj testObj = (TestObj) o;
        return Objects.equals(a, testObj.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}

public class TrajectoryTest {
    private final Trajectory trajectory = ModelGenerator.generateTrajectory();

    @Test
    public void toGeoJsonWithExtraAttribute() throws ClassNotFoundException,
        JsonProcessingException {
        String[] namesArray = new String[] { "int", "str", "double", "list", "testObj" };
        Class[] typeArray = new Class[] {
            Integer.class,
            String.class,
            Double.class,
            List.class,
            TestObj.class };
        Trajectory trajectory1 = ModelGenerator.generateTrajectory(
            Arrays.asList(namesArray),
            Arrays.asList(typeArray)
        );
        String geoJson = trajectory1.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(1, traj.getAttribute("int"));
        assertEquals("2", traj.getAttribute("str"));
        assertEquals(3.0, traj.getAttribute("double"));
        assertEquals(Arrays.asList(1, 2, 3), traj.getAttribute("list"));
        TestObj testObj = (TestObj) traj.getAttribute("testObj");
        assertEquals(1, (int) testObj.getA());
        assertEquals(trajectory1, traj);
    }

    @Test
    public void toGeoJSON() throws JsonProcessingException, ClassNotFoundException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

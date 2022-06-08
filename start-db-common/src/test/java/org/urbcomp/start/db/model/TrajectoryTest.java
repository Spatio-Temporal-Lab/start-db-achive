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

import static org.junit.Assert.assertEquals;

public class TrajectoryTest {
    private final Trajectory trajectory = ModelGenerator.generateTrajectory();

    @Test
    public void toGeoJSON() throws JsonProcessingException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

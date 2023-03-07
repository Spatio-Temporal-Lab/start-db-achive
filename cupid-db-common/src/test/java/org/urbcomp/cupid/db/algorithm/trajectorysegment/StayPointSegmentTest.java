/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.algorithm.trajectorysegment;

import org.junit.Before;
import org.junit.Test;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StayPointSegmentTest {

    private static Trajectory trajectory;

    @Before
    public void setup() {
        trajectory = ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt");

    }

    @Test
    public void stayPointSegmentTest() {
        StayPointSegment trajectorySegment = new StayPointSegment(10, 10);
        List<Trajectory> subTrajectory = trajectorySegment.segment(trajectory);
        int totalSize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(subTrajectory.size(), 3);
        // 8 gps points belong to stay points
        assertEquals(trajectory.getGPSPointList().size() - 8, totalSize);

    }
}

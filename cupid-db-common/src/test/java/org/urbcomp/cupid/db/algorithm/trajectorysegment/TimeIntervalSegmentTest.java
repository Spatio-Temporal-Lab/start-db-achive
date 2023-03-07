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

public class TimeIntervalSegmentTest {

    private static TimeIntervalSegment trajectorySegment;
    private static Trajectory trajectory;

    @Before
    public void setup() {
        trajectory = ModelGenerator.generateTrajectory();
    }

    @Test
    public void timeIntervalSegmentTest() {
        trajectorySegment = new TimeIntervalSegment(2);
        List<Trajectory> subTrajectory = trajectorySegment.segment(trajectory);
        assertEquals(subTrajectory.size(), 117);

        int totalsize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(trajectory.getGPSPointList().size(), totalsize);

        trajectorySegment = new TimeIntervalSegment(10);
        subTrajectory = trajectorySegment.segment(trajectory);
        assertEquals(subTrajectory.size(), 2);
        totalsize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(trajectory.getGPSPointList().size(), totalsize);

        trajectorySegment = new TimeIntervalSegment(11);
        subTrajectory = trajectorySegment.segment(trajectory);
        assertEquals(subTrajectory.size(), 1);
        totalsize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(trajectory.getGPSPointList().size(), totalsize);

    }
}

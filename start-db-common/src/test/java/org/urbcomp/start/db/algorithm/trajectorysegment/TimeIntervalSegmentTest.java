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

package org.urbcomp.start.db.algorithm.trajectorysegment;

import org.junit.Before;
import org.junit.Test;
import org.urbcomp.start.db.model.sample.ModelGenerator;
import org.urbcomp.start.db.model.trajectory.Trajectory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimeIntervalSegmentTest {

    private static TimeIntervalSegment trajectortsegment;
    private static Trajectory trajectory;

    @Before
    public void setup(){
        trajectory = ModelGenerator.generateTrajectory();
        trajectortsegment = new TimeIntervalSegment(120);
    }

    @Test
    public void TimeIntervalSegmenttest() {
        List<Trajectory> subtrajectory = trajectortsegment.segment(trajectory);
        assertEquals(subtrajectory.size(), 3);
        int totalsize = 0;
        for (Trajectory traj : subtrajectory) {
            int a = traj.getGPSPointList().size();
            totalsize += a;
        }
        assertEquals(trajectory.getGPSPointList().size(), totalsize);
    }
}

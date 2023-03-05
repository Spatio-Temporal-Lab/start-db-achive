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

package org.urbcomp.cupid.db.algorithm.staypointdetect;

import org.junit.Before;
import org.junit.Test;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StayPointDetectTest {

    private static StayPointDetect stayPointDetect;
    private static Trajectory trajectory;
    private static double d;
    private static double t;

    @Before
    public void setup() {
        trajectory = ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt");
        stayPointDetect = new StayPointDetect();
        d = 10;
        t = 10;
    }

    @Test
    public void StayPointDetectiontest() {
        List<StayPointDetectResult> SPs = stayPointDetect.detect(trajectory, d, t);
        assertEquals(SPs.size(), 2);
    }

}

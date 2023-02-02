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

package org.urbcomp.cupid.db.algorithm.staypointdetection;

import org.junit.Before;
import org.junit.Test;
import org.urbcomp.cupid.db.model.point.GPSPoint;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.List;

public class StayPointDetectionTest {

    private static StayPointDetection stayPointDetection;
    private static Trajectory trajectory;
    private static Double d;
    private static Double t;

    @Before
    public void setup() {
        trajectory = ModelGenerator.generateTrajectory();
        stayPointDetection = new StayPointDetection();
        d = 50D;
        t = 400D;
    }

    @Test
    public void StayPointDetectiontest() {
        List<StayGPSPointList> SPs = stayPointDetection.detection(trajectory, d, t);
        List<GPSPoint> list = SPs.get(0).getMultiPoint();
        System.out.println(list.size());
        list.forEach(gpsPoint -> System.out.println(gpsPoint.getTime().getTime()));
    }

}

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

import org.urbcomp.cupid.db.model.point.GPSPoint;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.ArrayList;
import java.util.List;

public class TimeIntervalSegment implements AbstractTrajectorySegment {
    private final double maxTimeIntervalInSec;

    public TimeIntervalSegment(double maxTimeIntervalInSec) {
        this.maxTimeIntervalInSec = maxTimeIntervalInSec;
    }

    /**
     * 获得最短路径的Id列表，以及点列表
     * @param trajectory 长轨迹
     * @return List<Trajectory> 轨迹段
     */
    @Override

    public List<Trajectory> segment(Trajectory trajectory) {
        List<Trajectory> subTrajectory = new ArrayList<>();
        List<GPSPoint> segment = new ArrayList<>();
        List<GPSPoint> gpsPointList = trajectory.getGPSPointList();
        GPSPoint lastPoint;
        GPSPoint curPoint;
        int flag = 0;
        if (gpsPointList.size() != 0) {
            segment.add(gpsPointList.get(0));
            lastPoint = gpsPointList.get(0);
            for (int i = 1; i < gpsPointList.size(); i++) {
                curPoint = gpsPointList.get(i);
                double duration = (curPoint.getTime().getTime() - lastPoint.getTime().getTime())
                    / 1000.0;
                if (duration < maxTimeIntervalInSec) {
                    segment.add(curPoint);
                } else {
                    if (segment.size() > 0) {
                        Trajectory newTrajectory = new Trajectory(
                            trajectory.getTid() + "_timeInterval_" + flag,
                            trajectory.getOid(),
                            segment
                        );
                        subTrajectory.add(newTrajectory);
                        flag++;
                    }
                    segment = new ArrayList<>();
                    segment.add(curPoint);
                }
                lastPoint = curPoint;
            }
            if (segment.size() > 0) {
                Trajectory newTrajectory = new Trajectory(
                    trajectory.getTid() + "_timeInterval_" + flag,
                    trajectory.getOid(),
                    segment
                );
                subTrajectory.add(newTrajectory);
            }

        }

        return subTrajectory;
    }

}

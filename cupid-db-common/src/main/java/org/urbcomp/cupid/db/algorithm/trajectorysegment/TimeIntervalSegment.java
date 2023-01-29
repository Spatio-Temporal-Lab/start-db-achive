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
        List<GPSPoint> gpslist = trajectory.getGPSPointList();
        int startindex = 0;
        List<Trajectory> subTrajectory = new ArrayList<>();

        // 遍历直到时间差超过阈值（秒为单位）
        int flag = 1;
        for (int index = 1; index < gpslist.size(); index++) {
            double timeInterval = (gpslist.get(index).getTime().getTime() - gpslist.get(startindex)
                .getTime()
                .getTime()) / 1000.0;
            if (timeInterval > maxTimeIntervalInSec) {
                subTrajectory.add(
                    new Trajectory(
                        trajectory.getTid() + "_" + flag,
                        trajectory.getOid(),
                        gpslist.subList(startindex, index)
                    )
                );
                flag += 1;
                startindex = index;
            }
        }
        // 添加最后一段轨迹
        if (startindex < gpslist.size()) {
            subTrajectory.add(
                new Trajectory(
                    trajectory.getTid() + "_" + flag,
                    trajectory.getOid(),
                    gpslist.subList(startindex, gpslist.size())
                )
            );
        }
        return subTrajectory;
    }
}

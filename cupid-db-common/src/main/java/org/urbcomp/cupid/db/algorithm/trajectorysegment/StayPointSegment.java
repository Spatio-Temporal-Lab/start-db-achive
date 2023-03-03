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
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.ArrayList;
import java.util.List;

public class StayPointSegment implements AbstractTrajectorySegment {
    private double maxStayTimeInSecond;
    private double maxDistInMeter;

    public StayPointSegment(double maxStayTimeInSecond, double maxDistInMeter) {
        this.maxStayTimeInSecond = maxStayTimeInSecond;
        this.maxDistInMeter = maxDistInMeter;
    }

    @Override
    public List<Trajectory> segment(Trajectory trajectory) {
        List<GPSPoint> pts = trajectory.getGPSPointList();
        List<Trajectory> result = new ArrayList<>();
        int stayPointNum = 0;
        int currentIndex = 0;
        int nextIndex = 0;
        int trajIndex = 0;
        while (currentIndex < pts.size() - 1) {
            GPSPoint currentPoint = pts.get(nextIndex);
            nextIndex = currentIndex + 1;
            while (nextIndex < pts.size()) {
                GPSPoint nextPoint = pts.get(nextIndex);
                double distance = GeoFunctions.getDistanceInM(currentPoint, nextPoint);
                if (distance > maxDistInMeter) {
                    break;
                }
                nextIndex++;
            }
            int startIndex = currentIndex;
            int endIndex = nextIndex - 1;
            double dwellTime = (pts.get(endIndex).getTime().getTime() - pts.get(startIndex)
                .getTime()
                .getTime()) / 1000;
            if (dwellTime > maxStayTimeInSecond) {
                stayPointNum++;
                if (trajIndex < startIndex - 1) {

                    Trajectory subTrajectory = new Trajectory(
                        trajectory.getTid() + result.size(),
                        trajectory.getOid(),
                        new ArrayList<>(pts.subList(trajIndex, startIndex))
                    );
                    if (subTrajectory.getGPSPointList().size() > 1) {
                        result.add(subTrajectory);
                    }
                }
                trajIndex = endIndex + 1;
                currentIndex = nextIndex;
            } else {
                currentIndex++;
            }
        }
        if (stayPointNum == 0) {
            if (trajectory.getGPSPointList().size() > 1) {
                result.add(trajectory);
            }
        } else if (trajIndex < pts.size() - 2) {
            Trajectory subTrajectory = new Trajectory(
                trajectory.getTid() + result.size(),
                trajectory.getOid(),
                new ArrayList<>(pts.subList(trajIndex, pts.size()))
            );
            if (subTrajectory.getGPSPointList().size() > 1) {
                result.add(subTrajectory);
            }
        }
        return result;
    }
}

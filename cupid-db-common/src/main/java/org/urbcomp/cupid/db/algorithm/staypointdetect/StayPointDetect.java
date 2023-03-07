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

import org.urbcomp.cupid.db.model.point.GPSPoint;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.ArrayList;
import java.util.List;

public class StayPointDetect implements IStayPointDetect {

    /**
     *驻留点检测
     *@param trajectory, d, t 长轨迹 空间阈值 时间阈值
     *@return List<StayGPSPointList> 驻留点表 List[startTime:Timestamp, endTime:Timestamp, gpsList:MultiPoint]
     * startTime:该驻留点起始时间 endTime:该驻留点终止时间 gpsList:驻留点包含的gps列表
    **/
    @Override
    public List<StayPointDetectResult> detect(Trajectory trajectory, double d, double t) {
        List<StayPointDetectResult> stayPoints = new ArrayList<>();
        List<GPSPoint> list = trajectory.getGPSPointList();
        int trLen = list.size();
        int start = 0, end = 0;
        boolean newSpFlag = true;
        int i = 0;
        while (i < trLen - 1) {
            int j = i + 1;
            // find the first point that does not satisfy the conditions
            while (j < trLen && GeoFunctions.getDistanceInM(list.get(i), list.get(j)) <= d) {
                j++;
            }
            if (j > i + 1
                && ((list.get(j - 1).getTime().getTime() - list.get(i).getTime().getTime()))
                    / 1000.0 >= t) {
                if (newSpFlag) {
                    start = i;
                    newSpFlag = false;
                }
                end = j - 1;
            }
            i++;
            // form a new stay point
            if (!newSpFlag && i > end) {
                StayPointDetectResult res = new StayPointDetectResult();
                res.setStarTime(list.get(start).getTime());
                res.setEndTime(list.get(end).getTime());

                List<GPSPoint> temp = new ArrayList<>();
                for (int k = start; k <= end; k++) {
                    temp.add(list.get(k));
                }
                res.setMultiPoint(temp);

                stayPoints.add(res);
                newSpFlag = true;
            }
        }
        return stayPoints;
    }

}

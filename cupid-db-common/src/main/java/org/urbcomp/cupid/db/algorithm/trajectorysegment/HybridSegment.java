/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.algorithm.trajectorysegment;

import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.ArrayList;
import java.util.List;

public class HybridSegment implements AbstractTrajectorySegment {
    private final StayPointSegment stayPointSegment;
    private final TimeIntervalSegment timeIntervalSegment;

    public HybridSegment(
        double maxStayTimeInSecond,
        double maxDistInMeter,
        double maxTimeIntervalInSecond
    ) {
        this.stayPointSegment = new StayPointSegment(maxStayTimeInSecond, maxDistInMeter);
        this.timeIntervalSegment = new TimeIntervalSegment(maxTimeIntervalInSecond);

    }

    @Override
    public List<Trajectory> segment(Trajectory trajectory) {
        List<Trajectory> stayPointSegmentResult = stayPointSegment.segment(trajectory);
        List<Trajectory> result = new ArrayList<>();
        for (Trajectory stayPointTrajectory : stayPointSegmentResult) {
            List<Trajectory> timeIntervalSegmentResult = timeIntervalSegment.segment(
                stayPointTrajectory
            );
            result.addAll(timeIntervalSegmentResult);
        }
        return result;

    }
}

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
package org.urbcomp.cupid.db.algorithm.staypointdetect;

import org.urbcomp.cupid.db.model.point.GPSPoint;

import java.sql.Timestamp;
import java.util.List;

public class StayPointDetectResult {
    private Timestamp starTime;
    private Timestamp endTime;
    private List<GPSPoint> multiPoint;

    public StayPointDetectResult() {}

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public List<GPSPoint> getMultiPoint() {
        return multiPoint;
    }

    public void setMultiPoint(List<GPSPoint> multiPoint) {
        this.multiPoint = multiPoint;
    }
}

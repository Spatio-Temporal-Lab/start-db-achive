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

import java.sql.Timestamp;
import java.util.List;

public class StayGPSPointList {
    private Timestamp starTime;
    private Timestamp endTime;
    private List<GPSPoint> multiPoint;

    public StayGPSPointList() {}

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

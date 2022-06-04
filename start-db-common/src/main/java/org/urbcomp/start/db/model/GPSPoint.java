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

package org.urbcomp.start.db.model;

import org.locationtech.jts.geom.Point;

import java.sql.Timestamp;

/**
 * GPS Point class
 */
public class GPSPoint {
    /**
     * the timestamp of the GPS Point
     */
    private final Timestamp time;
    /**
     * the location of the GPS Point
     */
    private final Point point;

    /**
     * Constructor of GPS Point
     * @param time timestamp
     * @param point location
     */
    public GPSPoint(Timestamp time, Point point) {
        this.time = time;
        this.point = point;
    }

    /**
     * get the timestamp of the GPS point
     * @return timestamp
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * get tht location of the GPS Point
     * @return location
     */
    public Point getPoint() {
        return point;
    }

}

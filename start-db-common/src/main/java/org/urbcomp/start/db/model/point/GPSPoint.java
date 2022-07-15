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

package org.urbcomp.start.db.model.point;

import org.urbcomp.start.db.model.Attribute;
import org.urbcomp.start.db.util.MapUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * GPS Point class
 */
public class GPSPoint extends SpatialPoint {
    /**
     * the timestamp of the GPS Point
     */
    private final Timestamp time;

    private Map<String, Attribute> attributes = new HashMap<>();

    public GPSPoint(Timestamp time, double lng, double lat) {
        super(lng, lat);
        this.time = time;
    }

    public GPSPoint(Timestamp time, double lng, double lat, Map<String, Attribute> attributes) {
        super(lng, lat);
        this.time = time;
        this.attributes = attributes;
    }

    /**
     * get the timestamp of the GPS point
     * @return timestamp
     */
    public Timestamp getTime() {
        return time;
    }

    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(this.time, ((GPSPoint) o).time)
            && MapUtil.additionalAttributesEquals(attributes, ((GPSPoint) o).attributes)
            && super.equalsExact(((GPSPoint) o));
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (time == null ? 0 : time.hashCode());
    }
}

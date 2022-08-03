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

package org.urbcomp.start.db.algorithm.dbscan;

import org.urbcomp.start.db.model.Attribute;
import org.urbcomp.start.db.model.point.GPSPoint;

import java.sql.Timestamp;
import java.util.Map;

public class ClusterPoint extends GPSPoint {

    /**
     * 继承GPSPoint数据类型，添加自定义属性
     */
    private boolean isVisited;
    private int cluster;
    private boolean isNoised;

    public ClusterPoint(Timestamp time, double lng, double lat) {
        super(time, lng, lat);
    }

    public ClusterPoint(Timestamp time, double lng, double lat, Map<String, Attribute> attributes) {
        super(time, lng, lat, attributes);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public boolean isNoised() {
        return isNoised;
    }

    public void setNoised(boolean noised) {
        isNoised = noised;
    }
}

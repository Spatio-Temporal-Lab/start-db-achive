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

package org.urbcomp.start.db.model.trajectory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.urbcomp.start.db.model.point.MapMatchedPoint;
import org.urbcomp.start.db.util.FeatureCollectionWithProperties;

import java.io.Serializable;
import java.util.List;

public class MapMatchedTrajectory implements Serializable {
    private final String tid;
    /**
     * 对象ID
     */
    private final String oid;
    /**
     * 地图匹配后的点
     */
    private final List<MapMatchedPoint> mmPtList;

    /**
     * 构造函数
     *
     * @param oid 对象id
     * @param mmPtList 匹配点list
     */
    public MapMatchedTrajectory(String tid, String oid, List<MapMatchedPoint> mmPtList) {
        this.tid = tid;
        this.oid = oid;
        this.mmPtList = mmPtList;
    }

    public String getOid() {
        return oid;
    }

    public List<MapMatchedPoint> getMmPtList() {
        return mmPtList;
    }

    public String getTid() {
        return tid;
    }

    public String toGeoJSON() throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new FeatureCollectionWithProperties();
        fcp.setProperty("oid", oid);
        fcp.setProperty("tid", tid);
        for (MapMatchedPoint p : mmPtList) {
            Feature f = new Feature();
            f.setGeometry(
                new org.geojson.Point(p.getCandidatePoint().getX(), p.getCandidatePoint().getY())
            );
            f.setProperty("time", p.getRawPoint().getTime().toString());
            f.setProperty("roadSegmentId", p.getCandidatePoint().getRoadSegmentId());
            f.setProperty("errorDistanceInMeter", p.getCandidatePoint().getErrorDistanceInMeter());
            f.setProperty("matchedIndex", p.getCandidatePoint().getMatchedIndex());
            f.setProperty("offsetInMeter", p.getCandidatePoint().getOffsetInMeter());
            fcp.add(f);
        }
        return new ObjectMapper().writeValueAsString(fcp);
    }
}

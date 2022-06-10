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

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.urbcomp.start.db.model.point.MapMatchedPoint;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class MapMatchedTrajectory implements Serializable {
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
    public MapMatchedTrajectory(String oid, List<MapMatchedPoint> mmPtList) {
        this.oid = oid;
        this.mmPtList = mmPtList;
    }

    public String getOid() {
        return oid;
    }

    public List<MapMatchedPoint> getMmPtList() {
        return mmPtList;
    }

    /**
     * 生成匹配点LineString
     *
     * @return LineString
     */
    public LineString getCandidateLineString() {
        if (mmPtList != null) {
            return new LineString(
                new CoordinateArraySequence(
                    this.mmPtList.stream()
                        .filter(i -> i.getCandidatePoint() != null)
                        .map(
                            mmPoint -> new Coordinate(
                                mmPoint.getCandidatePoint().getLng(),
                                mmPoint.getCandidatePoint().getLat()
                            )
                        )
                        .collect(Collectors.toList())
                        .toArray(new Coordinate[] {})
                ),
                new GeometryFactory(new PrecisionModel(), 4326)
            );
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return getCandidateLineString().toString();
    }
}

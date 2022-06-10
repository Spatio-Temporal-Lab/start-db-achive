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

import java.sql.Timestamp;

public class MapMatchedPoint {
    /**
     * 原始点
     */
    private final GPSPoint rawPoint;
    /**
     * 候选点
     */
    private final CandidatePoint candidatePoint;

    /**
     * 构造函数
     *
     * @param rawPoint       原始点
     * @param candidatePoint 匹配点
     */
    public MapMatchedPoint(GPSPoint rawPoint, CandidatePoint candidatePoint) {
        this.rawPoint = rawPoint;
        this.candidatePoint = candidatePoint;
    }

    public GPSPoint getRawPoint() {
        return rawPoint;
    }

    /**
     * @return ZonedDateTime
     */
    public Timestamp getTime() {
        return this.rawPoint.getTime();
    }

    public CandidatePoint getCandidatePoint() {
        return candidatePoint;
    }

    @Override
    public int hashCode() {
        String code = String.format(
            "%d%d",
            this.getCandidatePoint().hashCode(),
            this.getTime().hashCode()
        );
        char[] charArr = code.toCharArray();
        int hashcode = 0;
        for (char c : charArr) {
            hashcode = hashcode * 131 + c;
        }
        return hashcode;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MapMatchedPoint
            && ((MapMatchedPoint) o).getCandidatePoint().equals(getCandidatePoint())
            && ((MapMatchedPoint) o).getTime().equals(getTime());
    }
}

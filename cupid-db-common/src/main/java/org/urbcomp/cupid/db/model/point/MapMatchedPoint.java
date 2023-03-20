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
package org.urbcomp.cupid.db.model.point;

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

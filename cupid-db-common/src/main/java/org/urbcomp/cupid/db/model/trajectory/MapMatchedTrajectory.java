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
package org.urbcomp.cupid.db.model.trajectory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.urbcomp.cupid.db.model.point.MapMatchedPoint;
import org.urbcomp.cupid.db.util.FeatureCollectionWithProperties;

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
            if (p.getCandidatePoint() != null) {
                Feature f = new Feature();
                f.setGeometry(
                    new org.geojson.Point(
                        p.getCandidatePoint().getX(),
                        p.getCandidatePoint().getY()
                    )
                );
                f.setProperty("time", p.getRawPoint().getTime().toString());
                f.setProperty("roadSegmentId", p.getCandidatePoint().getRoadSegmentId());
                f.setProperty(
                    "errorDistanceInMeter",
                    p.getCandidatePoint().getErrorDistanceInMeter()
                );
                f.setProperty("matchedIndex", p.getCandidatePoint().getMatchedIndex());
                f.setProperty("offsetInMeter", p.getCandidatePoint().getOffsetInMeter());
                fcp.add(f);
            }
        }
        return new ObjectMapper().writeValueAsString(fcp);
    }
}

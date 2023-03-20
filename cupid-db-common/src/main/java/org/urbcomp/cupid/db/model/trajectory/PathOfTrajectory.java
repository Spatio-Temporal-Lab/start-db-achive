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
import org.locationtech.jts.geom.Point;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.util.FeatureCollectionWithProperties;

import java.util.ArrayList;
import java.util.List;

public class PathOfTrajectory {
    private final String tid;
    private final String oid;
    private final List<SpatialPoint> points;
    private final List<Integer> roadSegmentIds;

    public PathOfTrajectory(
        String tid,
        String oid,
        List<SpatialPoint> points,
        List<Integer> roadSegmentIds
    ) {
        this.tid = tid;
        this.oid = oid;
        this.points = points;
        this.roadSegmentIds = roadSegmentIds;
    }

    public PathOfTrajectory(String tid, String oid) {
        this(tid, oid, new ArrayList<>(), new ArrayList<>());
    }

    public String getTid() {
        return tid;
    }

    public String getOid() {
        return oid;
    }

    public List<SpatialPoint> getPoints() {
        return points;
    }

    public List<Integer> getRoadSegmentIds() {
        return roadSegmentIds;
    }

    public void addPointIfNotEqual(SpatialPoint point) {
        if (this.points.isEmpty() || !this.points.get(this.points.size() - 1).equals(point))
            this.points.add(point);
    }

    public void addRoadSegmentIdIfNotEqual(int roadSegmentId) {
        if (this.roadSegmentIds.isEmpty()
            || !this.roadSegmentIds.get(this.roadSegmentIds.size() - 1).equals(roadSegmentId))
            this.roadSegmentIds.add(roadSegmentId);
    }

    public String toGeoJSON() throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new FeatureCollectionWithProperties();
        fcp.setProperty("oid", oid);
        fcp.setProperty("tid", tid);
        fcp.setProperty("roadSegmentIds", roadSegmentIds);
        for (Point p : points) {
            Feature f = new Feature();
            f.setGeometry(new org.geojson.Point(p.getX(), p.getY()));
            fcp.add(f);
        }
        return new ObjectMapper().writeValueAsString(fcp);
    }
}

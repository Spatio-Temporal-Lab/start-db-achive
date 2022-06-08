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

package org.urbcomp.start.db.model.roadsegment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;

import java.util.ArrayList;
import java.util.List;

public class RoadNetwork {
    private List<RoadSegment> roadSegments;

    public RoadNetwork(List<RoadSegment> roadSegments) {
        this.roadSegments = roadSegments;
    }

    public RoadNetwork() {
        this(new ArrayList<>());
    }

    public RoadNetwork addRoadSegment(RoadSegment roadSegment) {
        this.roadSegments.add(roadSegment);
        return this;
    }

    public List<RoadSegment> getRoadSegments() {
        return roadSegments;
    }

    public RoadNetwork setRoadSegments(List<RoadSegment> roadSegments) {
        this.roadSegments = roadSegments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadNetwork rn = (RoadNetwork) o;
        if (this.roadSegments.size() != rn.roadSegments.size()) {
            return false;
        }
        for (int i = 0; i < this.roadSegments.size(); i++) {
            if (!this.roadSegments.get(i).equals(rn.roadSegments.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String toGeoJSON() throws JsonProcessingException {
        FeatureCollection fc = new FeatureCollection();
        roadSegments.forEach(rs -> fc.add(rs.toFeature()));
        return new ObjectMapper().writeValueAsString(fc);
    }

    public static RoadNetwork fromGeoJSON(String geoJsonStr) throws JsonProcessingException {
        FeatureCollection fc = new ObjectMapper().readValue(geoJsonStr, FeatureCollection.class);
        RoadNetwork rn = new RoadNetwork();
        fc.getFeatures().forEach(f -> rn.addRoadSegment(RoadSegment.fromFeature(f)));
        return rn;
    }
}

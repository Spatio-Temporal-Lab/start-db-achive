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
package org.urbcomp.cupid.db.model.roadnetwork;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.geojson.FeatureCollection;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.serializer.RoadNetworkDeserializer;
import org.urbcomp.cupid.db.serializer.RoadNetworkSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonSerialize(using = RoadNetworkSerializer.class)
@JsonDeserialize(using = RoadNetworkDeserializer.class)
public class RoadNetwork {
    private final HashMap<Integer, RoadSegment> idToExpandedRoadSegment = new HashMap<>();
    private final List<RoadSegment> roadSegments;

    private final Object directedRoadGraphLock = new Object();
    private volatile RoadGraph directedRoadGraph;

    private final Object undirectedRoadGraphLock = new Object();
    private volatile RoadGraph undirectedRoadGraph;

    private final Object roadRTreeLock = new Object();
    private volatile RTree<RoadSegment, Rectangle> roadRTree;

    public RoadNetwork(List<RoadSegment> roadSegments) {
        this.roadSegments = roadSegments.stream()
            .map(RoadSegment::flipBackwardRoadSegment)
            .collect(Collectors.toList());
        this.roadSegments.forEach(o -> {
            idToExpandedRoadSegment.put(o.getRoadSegmentId(), o);
            Optional<RoadSegment> rsOp = o.createReverseRoadSegmentIfDual();
            if (rsOp.isPresent()) {
                RoadSegment rs = rsOp.get();
                idToExpandedRoadSegment.put(rs.getRoadSegmentId(), rs);
            }
        });
    }

    public RoadGraph getDirectedRoadGraph() {
        if (directedRoadGraph == null) {
            synchronized (directedRoadGraphLock) {
                if (directedRoadGraph == null) {
                    directedRoadGraph = new RoadGraph(true);
                    idToExpandedRoadSegment.values().forEach(o -> directedRoadGraph.addEdge(o));
                }
            }
        }
        return directedRoadGraph;
    }

    public RoadGraph getUndirectedRoadGraph() {
        if (undirectedRoadGraph == null) {
            synchronized (undirectedRoadGraphLock) {
                if (undirectedRoadGraph == null) {
                    undirectedRoadGraph = new RoadGraph(false);
                    idToExpandedRoadSegment.values().forEach(o -> undirectedRoadGraph.addEdge(o));
                }
            }
        }
        return undirectedRoadGraph;
    }

    public RTree<RoadSegment, Rectangle> getRoadRTree() {
        if (roadRTree == null) {
            synchronized (roadRTreeLock) {
                if (roadRTree == null) {
                    roadRTree = RTree.create();
                    for (RoadSegment rs : idToExpandedRoadSegment.values()) {
                        List<SpatialPoint> points = rs.getPoints();
                        double minLng = Double.MAX_VALUE;
                        double minLat = Double.MAX_VALUE;
                        double maxLng = Double.MIN_VALUE;
                        double maxLat = Double.MIN_VALUE;
                        for (SpatialPoint point : points) {
                            minLng = Math.min(minLng, point.getLng());
                            minLat = Math.min(minLat, point.getLat());
                            maxLng = Math.max(maxLng, point.getLng());
                            maxLat = Math.max(maxLat, point.getLat());
                        }
                        roadRTree = roadRTree.add(
                            rs,
                            Geometries.rectangleGeographic(minLng, minLat, maxLng, maxLat)
                        );
                    }
                }
            }
        }
        return roadRTree;
    }

    public RoadSegment getRoadSegmentById(int roadSegmentId) {
        return idToExpandedRoadSegment.get(roadSegmentId);
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
        List<RoadSegment> roadSegmentList = fc.getFeatures()
            .stream()
            .map(RoadSegment::fromFeature)
            .collect(Collectors.toList());
        return new RoadNetwork(roadSegmentList);
    }

    public List<RoadSegment> getRoadSegments() {
        return roadSegments;
    }

    @Override
    public String toString() {
        try {
            return this.toGeoJSON();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

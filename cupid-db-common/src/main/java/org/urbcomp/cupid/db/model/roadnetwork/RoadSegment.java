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
import org.geojson.Feature;
import org.geojson.LngLatAlt;
import org.locationtech.jts.geom.Envelope;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.util.GeoFunctions;
import org.urbcomp.cupid.db.serializer.RoadSegmentSerializer;
import org.urbcomp.cupid.db.serializer.RoadSegmentDeserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonSerialize(using = RoadSegmentSerializer.class)
@JsonDeserialize(using = RoadSegmentDeserializer.class)
public class RoadSegment {
    // road segment id
    private final int roadSegmentId;
    // the road geometry
    private final List<SpatialPoint> points;
    // the start node id
    private final RoadNode startNode;
    // the end node id
    private final RoadNode endNode;
    // the road direction
    private RoadSegmentDirection direction;
    // the speed limitation, km/h
    private double speedLimit;
    // road level
    private RoadSegmentLevel level;
    // the length of the road, m
    private double lengthInMeter;

    public RoadSegment(int roadSegmentId, int startId, int endId, List<SpatialPoint> points) {
        this.roadSegmentId = roadSegmentId;
        this.startNode = new RoadNode(startId, points.get(0).getCoordinate());
        this.endNode = new RoadNode(endId, points.get(points.size() - 1).getCoordinate());
        this.points = points;
    }

    public int getRoadSegmentId() {
        return roadSegmentId;
    }

    public RoadNode getStartNode() {
        return startNode;
    }

    public RoadNode getEndNode() {
        return endNode;
    }

    public List<SpatialPoint> getPoints() {
        return points;
    }

    public RoadSegmentDirection getDirection() {
        return direction;
    }

    public RoadSegment setDirection(RoadSegmentDirection direction) {
        this.direction = direction;
        return this;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public RoadSegment setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
        return this;
    }

    public RoadSegmentLevel getLevel() {
        return level;
    }

    public RoadSegment setLevel(RoadSegmentLevel level) {
        this.level = level;
        return this;
    }

    public double getLengthInMeter() {
        return lengthInMeter;
    }

    public RoadSegment setLengthInMeter(double lengthInMeter) {
        this.lengthInMeter = lengthInMeter;
        return this;
    }

    public Envelope getBBox() {
        return GeoFunctions.getBBox(points);
    }

    @Override
    public int hashCode() {
        return roadSegmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadSegment rs = (RoadSegment) o;
        return Objects.equals(this.roadSegmentId, rs.roadSegmentId)
            && Objects.equals(this.startNode, rs.startNode)
            && Objects.equals(this.endNode, rs.endNode)
            && Objects.equals(this.points, rs.points)
            && Objects.equals(this.direction, rs.direction)
            && Objects.equals(this.speedLimit, rs.speedLimit)
            && Objects.equals(this.level, rs.level)
            && Objects.equals(this.lengthInMeter, rs.lengthInMeter);
    }

    public Feature toFeature() {
        Feature f = new Feature();
        f.setProperty("rsId", roadSegmentId);
        f.setProperty("direction", direction.value());
        f.setProperty("speedLimit", speedLimit);
        f.setProperty("level", level.value());
        f.setProperty("startId", startNode.getNodeId());
        f.setProperty("endId", endNode.getNodeId());
        f.setProperty("lengthInMeter", lengthInMeter);
        LngLatAlt[] lngLats = points.stream()
            .map(o -> new LngLatAlt(o.getLng(), o.getLat()))
            .toArray(LngLatAlt[]::new);
        f.setGeometry(new org.geojson.LineString(lngLats));
        return f;
    }

    public static RoadSegment fromFeature(Feature f) {
        org.geojson.LineString lineString = (org.geojson.LineString) f.getGeometry();
        List<SpatialPoint> points = lineString.getCoordinates()
            .stream()
            .map(o -> new SpatialPoint(o.getLongitude(), o.getLatitude()))
            .collect(Collectors.toList());
        return new RoadSegment(
            f.getProperty("rsId"),
            f.getProperty("startId"),
            f.getProperty("endId"),
            points
        ).setDirection(RoadSegmentDirection.valueOf((Integer) f.getProperty("direction")))
            .setSpeedLimit(f.getProperty("speedLimit"))
            .setLevel(RoadSegmentLevel.valueOf((Integer) f.getProperty("level")))
            .setLengthInMeter(f.getProperty("lengthInMeter"));
    }

    /**
     * Convert this RoadSegment to GeoJSON String
     *
     * @return GeoJSON String
     */
    public String toGeoJSON() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(toFeature());
    }

    public static RoadSegment fromGeoJSON(String geoJsonStr) throws JsonProcessingException {
        Feature f = new ObjectMapper().readValue(geoJsonStr, Feature.class);
        return fromFeature(f);
    }

    /**
     * if this road segment if dual, create a road segment with its id as an opposite number, otherwise, return empty.
     */
    public Optional<RoadSegment> createReverseRoadSegmentIfDual() {
        if (direction == RoadSegmentDirection.DUAL) {
            int reverseRoadId = roadSegmentId == 0 ? Integer.MIN_VALUE : -roadSegmentId;
            return Optional.of(safeReverse(reverseRoadId, RoadSegmentDirection.DUAL));
        } else {
            return Optional.empty();
        }
    }

    /**
     * if the road segment is backward, return its reversed version with the same id, otherwise, return itself
     */
    public RoadSegment flipBackwardRoadSegment() {
        return direction == RoadSegmentDirection.BACKWARD
            ? safeReverse(roadSegmentId, RoadSegmentDirection.FORWARD)
            : this;
    }

    private RoadSegment safeReverse(int reverseRoadSegmentId, RoadSegmentDirection dir) {
        List<SpatialPoint> pointsReverse = new ArrayList<>(points.size());
        for (int i = points.size() - 1; i >= 0; --i) {
            pointsReverse.add(new SpatialPoint(points.get(i).getCoordinate()));
        }
        return new RoadSegment(
            reverseRoadSegmentId,
            endNode.getNodeId(),
            startNode.getNodeId(),
            pointsReverse
        ).setDirection(dir)
            .setSpeedLimit(speedLimit)
            .setLevel(level)
            .setLengthInMeter(lengthInMeter);
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

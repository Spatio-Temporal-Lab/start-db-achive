/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.cupid.db.function;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.locationtech.jts.geom.*;
import org.urbcomp.cupid.db.algorithm.reachable.ReachableAreaConcaveHull;
import org.urbcomp.cupid.db.algorithm.reachable.ReachableAreaConvexHull;
import org.urbcomp.cupid.db.algorithm.shortestpath.BiDijkstraShortestPath;
import org.urbcomp.cupid.db.exception.AlgorithmExecuteException;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.util.GeometryFactoryUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Road Segment/Network Function
 *
 * @author XiangHe
 */
public class RoadFunction {

    @CupidDBFunction("st_rn_shortestPath")
    public String st_rn_shortestPath(RoadNetwork roadNetwork, Point startPoint, Point endPoint)
        throws AlgorithmExecuteException, JsonProcessingException {
        BiDijkstraShortestPath biDijkstraShortestPath = new BiDijkstraShortestPath(roadNetwork);
        return biDijkstraShortestPath.findShortestPath(
            new SpatialPoint(startPoint.getCoordinate()),
            new SpatialPoint(endPoint.getCoordinate())
        ).toGeoJSON();
    }

    @CupidDBFunction("st_rn_makeRoadNetwork")
    public RoadNetwork st_rn_makeRoadNetwork(List<RoadSegment> rsList)
        throws JsonProcessingException {
        return new RoadNetwork(rsList);
    }

    @CupidDBFunction("st_rn_fromGeoJson")
    public RoadNetwork st_rn_fromGeoJson(String geoJson) throws JsonProcessingException {
        return RoadNetwork.fromGeoJSON(geoJson);
    }

    @CupidDBFunction("st_rs_fromGeoJSON")
    public RoadSegment st_rs_fromGeoJSON(String geoJson) throws JsonProcessingException {
        return RoadSegment.fromGeoJSON(geoJson);
    }

    @CupidDBFunction("st_rs_asGeoJSON")
    public String st_rs_asGeoJSON(RoadSegment rs) throws JsonProcessingException {
        return rs.toGeoJSON();
    }

    @CupidDBFunction("st_rs_rsid")
    public String st_rs_rsid(RoadSegment rs) {
        return String.valueOf(rs.getRoadSegmentId());
    }

    @CupidDBFunction("st_rs_geom")
    public LineString st_rs_geom(RoadSegment rs) {
        GeometryFactory geometryFactory = GeometryFactoryUtils.defaultGeometryFactory();
        return geometryFactory.createLineString(
            rs.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
        );
    }

    @CupidDBFunction("st_rs_direction")
    public String st_rs_direction(RoadSegment rs) {
        return rs.getDirection().toString();
    }

    @CupidDBFunction("st_rs_speedLimitInKMPerHour")
    public Double st_rs_speedLimitInKMPerHour(RoadSegment rs) {
        return rs.getSpeedLimit();
    }

    @CupidDBFunction("st_rs_level")
    public Integer st_rs_level(RoadSegment rs) {
        return rs.getLevel().value();
    }

    @CupidDBFunction("st_rs_startId")
    public String st_rs_startId(RoadSegment rs) {
        return String.valueOf(rs.getStartNode().getNodeId());
    }

    @CupidDBFunction("st_rs_endId")
    public String st_rs_endId(RoadSegment rs) {
        return String.valueOf(rs.getEndNode().getNodeId());
    }

    @CupidDBFunction("st_rs_lengthInKM")
    public Double st_rs_lengthInKM(RoadSegment rs) {
        return rs.getLengthInMeter() / 1000;
    }

    @CupidDBFunction("st_rn_reachableConvexHull")
    public Polygon st_rn_reachableConvexHull(
        RoadNetwork roadNetwork,
        Point startPt,
        BigDecimal timeInSec,
        String travelMode
    ) {
        SpatialPoint startSpatialPoint = new SpatialPoint(startPt.getCoordinate());
        ReachableAreaConvexHull reachable = new ReachableAreaConvexHull(
            roadNetwork,
            startSpatialPoint,
            timeInSec.doubleValue(),
            travelMode
        );
        return reachable.getHull();
    }

    @CupidDBFunction("st_rn_reachableConcaveHull")
    public Polygon st_rn_reachableConcaveHull(
        RoadNetwork roadNetwork,
        Point startPt,
        BigDecimal timeInSec,
        String travelMode

    ) {
        SpatialPoint startSpatialPoint = new SpatialPoint(startPt.getCoordinate());
        ReachableAreaConcaveHull reachable = new ReachableAreaConcaveHull(
            roadNetwork,
            startSpatialPoint,
            timeInSec.doubleValue(),
            travelMode
        );
        return reachable.getHull();
    }

}

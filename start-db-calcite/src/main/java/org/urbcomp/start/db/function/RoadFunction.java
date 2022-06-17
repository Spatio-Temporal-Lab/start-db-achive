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

package org.urbcomp.start.db.function;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.urbcomp.start.db.algorithm.shortestpath.BiDijkstraShortestPath;
import org.urbcomp.start.db.exception.AlgorithmExecuteException;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.Path;
import org.urbcomp.start.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;

import java.util.List;

/**
 * Road Segment/Network Function
 *
 * @author XiangHe
 */
public class RoadFunction {

    @StartDBFunction("st_rn_shortestPath")
    public Path st_rn_shortestPath(RoadNetwork roadNetwork, Point startPoint, Point endPoint)
        throws AlgorithmExecuteException {
        BiDijkstraShortestPath biDijkstraShortestPath = new BiDijkstraShortestPath(roadNetwork);
        return biDijkstraShortestPath.findShortestPath(
            new SpatialPoint(startPoint.getCoordinate()),
            new SpatialPoint(endPoint.getCoordinate())
        );
    }

    @StartDBFunction("st_makeRoadNetwork")
    public RoadNetwork st_makeRoadNetwork(List<RoadSegment> rsList) throws JsonProcessingException {
        return new RoadNetwork(rsList);
    }

    @StartDBFunction("st_makeRoadSegment")
    public RoadSegment st_makeRoadSegment(String geoJson) throws JsonProcessingException {
        return RoadSegment.fromGeoJSON(geoJson);
    }

    @StartDBFunction("st_rs_rsid")
    public String st_rs_rsid(RoadSegment rs) {
        return String.valueOf(rs.getRoadSegmentId());
    }

    @StartDBFunction("st_rs_geom")
    public LineString st_rs_geom(RoadSegment rs) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createLineString(
            rs.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
        );
    }

    @StartDBFunction("st_rs_direction")
    public String st_rs_direction(RoadSegment rs) {
        return rs.getDirection().toString();
    }

    @StartDBFunction("st_rs_speedLimitInKMPerHour")
    public Double st_rs_speedLimitInKMPerHour(RoadSegment rs) {
        return rs.getSpeedLimit();
    }

    @StartDBFunction("st_rs_level")
    public Integer st_rs_level(RoadSegment rs) {
        return rs.getLevel().value();
    }

    @StartDBFunction("st_rs_startId")
    public String st_rs_startId(RoadSegment rs) {
        return String.valueOf(rs.getStartNode().getNodeId());
    }

    @StartDBFunction("st_rs_endId")
    public String st_rs_endId(RoadSegment rs) {
        return String.valueOf(rs.getEndNode().getNodeId());
    }

    @StartDBFunction("st_rs_lengthInKM")
    public Double st_rs_lengthInKM(RoadSegment rs) {
        return rs.getLengthInMeter() / 1000;
    }

}

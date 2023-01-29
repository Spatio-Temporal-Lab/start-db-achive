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

import org.locationtech.jts.geom.*;
import org.urbcomp.cupid.db.function.coordtransform.*;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

public class CoordTransformFunction {
    @CupidDBFunction("st_BD09ToWGS84")
    public Point st_BD09ToWGS84(Point point) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public LineString st_BD09ToWGS84(LineString lineString) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public Polygon st_BD09ToWGS84(Polygon polygon) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public MultiPoint st_BD09ToWGS84(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public MultiLineString st_BD09ToWGS84(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public MultiPolygon st_BD09ToWGS84(MultiPolygon mPolygon) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.multiPolygonTransform(mPolygon);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public Geometry st_BD09ToWGS84(Geometry geometry) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public GeometryCollection st_BD09ToWGS84(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public Trajectory st_BD09ToWGS84(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public RoadSegment st_BD09ToWGS84(RoadSegment rs) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.roadSegmentTransform(rs);
    }

    @CupidDBFunction("st_BD09ToWGS84")
    public RoadNetwork st_BD09ToWGS84(RoadNetwork rn) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.roadNetworkTransform(rn);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public Point st_WGS84ToBD09(Point point) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public LineString st_WGS84ToBD09(LineString lineString) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public Polygon st_WGS84ToBD09(Polygon polygon) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public MultiPoint st_WGS84ToBD09(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public MultiLineString st_WGS84ToBD09(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public MultiPolygon st_WGS84ToBD09(MultiPolygon multiPolygon) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.multiPolygonTransform(multiPolygon);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public Geometry st_WGS84ToBD09(Geometry geometry) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public GeometryCollection st_WGS84ToBD09(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public Trajectory st_WGS84ToBD09(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public RoadSegment st_WGS84ToBD09(RoadSegment roadSegment) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.roadSegmentTransform(roadSegment);
    }

    @CupidDBFunction("st_WGS84ToBD09")
    public RoadNetwork st_WGS84ToBD09(RoadNetwork roadNetwork) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.roadNetworkTransform(roadNetwork);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public Point st_GCJ02ToBD09(Point point) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public LineString st_GCJ02ToBD09(LineString lineString) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public Polygon st_GCJ02ToBD09(Polygon polygon) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public MultiPoint st_GCJ02ToBD09(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public MultiLineString st_GCJ02ToBD09(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public MultiPolygon st_GCJ02ToBD09(MultiPolygon multiPolygon) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.multiPolygonTransform(multiPolygon);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public Geometry st_GCJ02ToBD09(Geometry geometry) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public GeometryCollection st_GCJ02ToBD09(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public Trajectory st_GCJ02ToBD09(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public RoadSegment st_GCJ02ToBD09(RoadSegment roadSegment) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.roadSegmentTransform(roadSegment);
    }

    @CupidDBFunction("st_GCJ02ToBD09")
    public RoadNetwork st_GCJ02ToBD09(RoadNetwork roadNetwork) {
        AbstractCoordTransformer transformer = new GCJ02ToBD09Transformer();
        return transformer.roadNetworkTransform(roadNetwork);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public Point st_BD09ToGCJ02(Point point) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public LineString st_BD09ToGCJ02(LineString lineString) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public Polygon st_BD09ToGCJ02(Polygon polygon) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public MultiPoint st_BD09ToGCJ02(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public MultiLineString st_BD09ToGCJ02(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public MultiPolygon st_BD09ToGCJ02(MultiPolygon multiPolygon) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.multiPolygonTransform(multiPolygon);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public Geometry st_BD09ToGCJ02(Geometry geometry) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public GeometryCollection st_BD09ToGCJ02(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public Trajectory st_BD09ToGCJ02(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public RoadSegment st_BD09ToGCJ02(RoadSegment roadSegment) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.roadSegmentTransform(roadSegment);
    }

    @CupidDBFunction("st_BD09ToGCJ02")
    public RoadNetwork st_BD09ToGCJ02(RoadNetwork roadNetwork) {
        AbstractCoordTransformer transformer = new BD09ToGCJ02Transformer();
        return transformer.roadNetworkTransform(roadNetwork);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public Point st_WGS84ToGCJ02(Point point) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public LineString st_WGS84ToGCJ02(LineString lineString) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public Polygon st_WGS84ToGCJ02(Polygon polygon) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public MultiPoint st_WGS84ToGCJ02(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public MultiLineString st_WGS84ToGCJ02(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public MultiPolygon st_WGS84ToGCJ02(MultiPolygon multiPolygon) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.multiPolygonTransform(multiPolygon);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public Geometry st_WGS84ToGCJ02(Geometry geometry) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public GeometryCollection st_WGS84ToGCJ02(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public Trajectory st_WGS84ToGCJ02(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public RoadSegment st_WGS84ToGCJ02(RoadSegment roadSegment) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.roadSegmentTransform(roadSegment);
    }

    @CupidDBFunction("st_WGS84ToGCJ02")
    public RoadNetwork st_WGS84ToGCJ02(RoadNetwork roadNetwork) {
        AbstractCoordTransformer transformer = new WGS84ToGCJ02Transformer();
        return transformer.roadNetworkTransform(roadNetwork);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public Point st_GCJ02ToWGS84(Point point) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.pointTransform(point);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public LineString st_GCJ02ToWGS84(LineString lineString) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public Polygon st_GCJ02ToWGS84(Polygon polygon) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.polygonTransform(polygon);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public MultiPoint st_GCJ02ToWGS84(MultiPoint multiPoint) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.multiPointTransform(multiPoint);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public MultiLineString st_GCJ02ToWGS84(MultiLineString multiLineString) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.multiLineStringTransform(multiLineString);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public MultiPolygon st_GCJ02ToWGS84(MultiPolygon multiPolygon) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.multiPolygonTransform(multiPolygon);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public Geometry st_GCJ02ToWGS84(Geometry geometry) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.geometryTransform(geometry);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public GeometryCollection st_GCJ02ToWGS84(GeometryCollection geometryCollection) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.geometryCollectionTransform(geometryCollection);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public Trajectory st_GCJ02ToWGS84(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public RoadSegment st_GCJ02ToWGS84(RoadSegment roadSegment) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.roadSegmentTransform(roadSegment);
    }

    @CupidDBFunction("st_GCJ02ToWGS84")
    public RoadNetwork st_GCJ02ToWGS84(RoadNetwork roadNetwork) {
        AbstractCoordTransformer transformer = new GCJ02ToWGS84Transformer();
        return transformer.roadNetworkTransform(roadNetwork);
    }

}

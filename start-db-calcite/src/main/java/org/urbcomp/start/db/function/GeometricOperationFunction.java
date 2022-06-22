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

import org.geotools.referencing.GeodeticCalculator;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.util.AffineTransformation;
import org.locationtech.jts.operation.distance.DistanceOp;
import org.locationtech.jts.util.GeometricShapeFactory;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.distance.DistanceCalculator;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Circle;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.jts.JtsPoint;
import org.urbcomp.start.db.util.GeoFunctions;
import org.urbcomp.start.db.util.GeometryFactoryUtils;

public class GeometricOperationFunction {
    @StartDBFunction("st_translate")
    public Geometry st_translate(Geometry geom, double deltaX, double deltaY) {
        AffineTransformation at = new AffineTransformation();
        at.setToTranslation(deltaX, deltaY);
        return at.transform(geom);
    }

    @StartDBFunction("st_x")
    public Double st_x(Geometry geom) {
        if (geom instanceof Point) {
            return ((Point) geom).getX();
        } else {
            return null;
        }
    }

    @StartDBFunction("st_y")
    public Double st_y(Geometry geom) {
        if (geom instanceof Point) {
            return ((Point) geom).getY();
        } else {
            return null;
        }
    }

    @StartDBFunction("st_BBox")
    public Geometry st_BBox(Geometry geom) {
        return geom.getEnvelope();
    }

    @StartDBFunction("st_numPoints")
    public int st_numPoints(Geometry geom) {
        return geom.getNumPoints();
    }

    @StartDBFunction("st_pointN")
    public Point st_pointN(Geometry geom, int n) {
        if (geom instanceof LineString) {
            if (n > 0 && n <= geom.getNumPoints()) {
                return ((LineString) geom).getPointN(n - 1);
            } else if (n < 0 && n + geom.getNumPoints() >= 0) {
                return ((LineString) geom).getPointN(n + geom.getNumPoints());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @StartDBFunction("st_area")
    public double st_area(Geometry geom) {
        return geom.getArea();
    }

    @StartDBFunction("st_centroid")
    public Point st_centroid(Geometry geom) {
        return geom.getCentroid();
    }

    @StartDBFunction("st_closestPoint")
    public Point st_closestPoint(Geometry geom1, Geometry geom2) {
        DistanceOp op = new DistanceOp(geom1, geom2);
        GeometryFactory geomFactory = GeometryFactoryUtils.defaultGeometryFactory();
        return geomFactory.createPoint(op.nearestPoints()[0]);
    }

    @StartDBFunction("st_distance")
    public double st_distance(Geometry geom1, Geometry geom2) {
        DistanceOp op = new DistanceOp(geom1, geom2);
        return op.distance();
    }

    @StartDBFunction("st_distanceSphere")
    public double st_distanceSphere(Geometry geom1, Geometry geom2) {
        Coordinate c1 = geom1.getCoordinate();
        Coordinate c2 = geom2.getCoordinate();
        DistanceCalculator ca = ThreadLocal.withInitial(JtsSpatialContext.GEO::getDistCalc).get();
        org.locationtech.spatial4j.shape.Point startPoint = JtsSpatialContext.GEO.getShapeFactory()
            .pointXY(c1.x, c1.y);
        return DistanceUtils.DEG_TO_KM * ca.distance(startPoint, c2.x, c2.y) * 1000;
    }

    @StartDBFunction("st_distanceSpheroid")
    public double st_distanceSpheroid(Geometry geom1, Geometry geom2) {
        Coordinate c1 = geom1.getCoordinate();
        Coordinate c2 = geom2.getCoordinate();
        GeodeticCalculator gc = ThreadLocal.withInitial(GeodeticCalculator::new).get();
        gc.setStartingGeographicPoint(c1.x, c1.y);
        gc.setDestinationGeographicPoint(c2.x, c2.y);
        return gc.getOrthodromicDistance();
    }

    @StartDBFunction("st_intersection")
    public Geometry st_intersection(Geometry geom1, Geometry geom2) {
        return geom1.intersection(geom2);
    }

    @StartDBFunction("st_length")
    public double st_length(Geometry geom) {
        return geom.getLength();
    }

    @StartDBFunction("st_lengthSphere")
    public double st_lengthSphere(LineString geom) {
        double sum = 0.0;
        DistanceCalculator ca = ThreadLocal.withInitial(JtsSpatialContext.GEO::getDistCalc).get();
        Coordinate[] cs = geom.getCoordinates();
        for (int i = 1; i < cs.length; i++) {
            org.locationtech.spatial4j.shape.Point startPoint = JtsSpatialContext.GEO
                .getShapeFactory()
                .pointXY(cs[i - 1].x, cs[i - 1].y);
            sum += ca.distance(startPoint, cs[i].x, cs[i].y);
        }
        return sum * DistanceUtils.DEG_TO_KM * 1000;
    }

    @StartDBFunction("st_lengthSpheroid")
    public double st_lengthSpheroid(LineString geom) {
        double sum = 0.0;

        GeodeticCalculator gc = ThreadLocal.withInitial(GeodeticCalculator::new).get();
        Coordinate[] cs = geom.getCoordinates();
        for (int i = 1; i < cs.length; i++) {
            gc.setStartingGeographicPoint(cs[i - 1].x, cs[i - 1].y);
            gc.setDestinationGeographicPoint(cs[i].x, cs[i].y);
            sum += gc.getOrthodromicDistance();
        }
        return sum;
    }

    @StartDBFunction("st_difference")
    public Geometry st_difference(Geometry geom1, Geometry geom2) {
        return geom1.difference(geom2);
    }

    @StartDBFunction("st_isValid")
    public boolean st_isValid(Geometry geom) {
        return geom.isValid();
    }

    @StartDBFunction("st_bufferPoint")
    public Geometry st_bufferPoint(Point point, double distanceInM) {
        double degrees = GeoFunctions.getDegreeFromM(distanceInM);
        JtsPoint jstPoint = new JtsPoint(point, JtsSpatialContext.GEO);
        Circle circle = jstPoint.getBuffered(degrees, JtsSpatialContext.GEO);
        GeometricShapeFactory gsf = ThreadLocal.withInitial(
            () -> new GeometricShapeFactory(GeometryFactoryUtils.defaultGeometryFactory())
        ).get();
        gsf.setSize(circle.getBoundingBox().getWidth());
        gsf.setNumPoints(4 * 25);
        gsf.setCentre(new Coordinate(circle.getCenter().getX(), circle.getCenter().getY()));
        Geometry geomTemp = gsf.createCircle();
        Geometry geomCopy = GeometryFactoryUtils.defaultGeometryFactory().createGeometry(geomTemp);
        if (geomCopy.getEnvelopeInternal().getMinX() < -180
            || geomCopy.getEnvelopeInternal().getMaxX() > 180) {
            geomCopy.apply(new CoordinateSequenceFilter() {
                @Override
                public void filter(CoordinateSequence seq, int i) {
                    seq.setOrdinate(
                        i,
                        CoordinateSequence.X,
                        seq.getX(i) + degreesToTranslate(seq.getX(i))
                    );
                }

                @Override
                public boolean isDone() {
                    return false;
                }

                @Override
                public boolean isGeometryChanged() {
                    return true;
                }
            });
        }
        Shape datelineSafeShape = JtsSpatialContext.GEO.getShapeFactory()
            .makeShapeFromGeometry(geomCopy);
        return JtsSpatialContext.GEO.getShapeFactory().getGeometryFrom(datelineSafeShape);
    }

    @StartDBFunction("st_convexHull")
    public Geometry st_convexHull(Geometry geom) {
        return geom.convexHull();
    }

    // 经度有可能会跨
    private double degreesToTranslate(double x) {
        return (int) (Math.floor((x + 180) / 360.0) * -360);
    }
}

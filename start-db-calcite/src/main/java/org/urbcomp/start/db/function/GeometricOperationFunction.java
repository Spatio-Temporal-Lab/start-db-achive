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
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.util.AffineTransformation;
import org.locationtech.jts.operation.distance.DistanceOp;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.distance.DistanceCalculator;
import org.locationtech.spatial4j.distance.DistanceUtils;

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
        GeometryFactory geomFactory = new GeometryFactory();
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
        DistanceCalculator ca = JtsSpatialContext.GEO.getDistCalc();
        org.locationtech.spatial4j.shape.Point startPoint = JtsSpatialContext.GEO.getShapeFactory()
            .pointXY(c1.x, c1.y);
        return DistanceUtils.DEG_TO_KM * ca.distance(startPoint, c2.x, c2.y) * 1000;
    }

    @StartDBFunction("st_distanceSpheroid")
    public double st_distanceSpheroid(Geometry geom1, Geometry geom2) {
        Coordinate c1 = geom1.getCoordinate();
        Coordinate c2 = geom2.getCoordinate();
        GeodeticCalculator gc = new GeodeticCalculator(DefaultGeographicCRS.WGS84);
        gc.setStartingGeographicPoint(c1.x, c1.y);
        gc.setDestinationGeographicPoint(c2.x, c2.y);
        return gc.getOrthodromicDistance();
    }
}

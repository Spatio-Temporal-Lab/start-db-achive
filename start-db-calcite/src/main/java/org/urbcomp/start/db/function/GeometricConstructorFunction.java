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

import org.locationtech.jts.geom.*;
import org.urbcomp.start.db.util.GeoFunctions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruiyuan li
 * @date 2022-05-28 23:12:07
 */
public class GeometricConstructorFunction {
    @StartDBFunction("st_makePoint")
    public Point st_makePoint(BigDecimal x, BigDecimal y) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPoint(new Coordinate(x.doubleValue(), y.doubleValue()));
    }

    @StartDBFunction("st_makeLineString")
    public LineString st_makeLineString(List<Point> points) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createLineString(
            points.stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
        );
    }

    @StartDBFunction("st_makePolygon")
    public Polygon st_makePolygon(LineString shell) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPolygon(
            geometryFactory.createLinearRing(shell.getCoordinateSequence())
        );
    }

    @StartDBFunction("st_makePolygon")
    public Polygon st_makePolygon(LineString shell, List<LineString> holes) {
        GeometryFactory geometryFactory = new GeometryFactory();
        return geometryFactory.createPolygon(
            geometryFactory.createLinearRing(shell.getCoordinateSequence()),
            holes.stream()
                .map(o -> geometryFactory.createLinearRing(o.getCoordinateSequence()))
                .toArray(LinearRing[]::new)
        );
    }

    @StartDBFunction("st_makeBBox")
    public Polygon st_makeBBox(
        BigDecimal lowerX,
        BigDecimal lowerY,
        BigDecimal upperX,
        BigDecimal upperY
    ) {
        List<Point> points = new ArrayList<>(5);
        points.add(st_makePoint(lowerX, lowerY));
        points.add(st_makePoint(lowerX, upperY));
        points.add(st_makePoint(upperX, upperY));
        points.add(st_makePoint(upperX, lowerY));
        points.add(st_makePoint(lowerX, lowerY));
        return st_makePolygon(st_makeLineString(points));
    }

    @StartDBFunction("st_makeBBox")
    public Polygon st_makeBBox(Point point1, Point point2) {
        return st_makeBBox(
            BigDecimal.valueOf(point1.getX()),
            BigDecimal.valueOf(point1.getY()),
            BigDecimal.valueOf(point2.getX()),
            BigDecimal.valueOf(point2.getY())
        );
    }

    @StartDBFunction("st_makeCircle")
    public Polygon st_makeCircle(Point center, double radiusInM) {
        return (Polygon) center.buffer(GeoFunctions.getDegreeFromM(radiusInM));
    }
}

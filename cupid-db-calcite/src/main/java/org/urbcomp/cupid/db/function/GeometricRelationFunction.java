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
import org.locationtech.jts.geom.prep.*;

import java.util.Optional;

public class GeometricRelationFunction {

    private Optional<PreparedGeometry> prepareGeometry(Geometry geom) {
        switch (geom.getGeometryType()) {
            case Geometry.TYPENAME_POINT:
            case Geometry.TYPENAME_MULTIPOINT:
                return Optional.of(new PreparedPoint((Puntal) geom));
            case Geometry.TYPENAME_LINESTRING:
                return Optional.of(new PreparedLineString((Lineal) geom));
            case Geometry.TYPENAME_POLYGON:
                return Optional.of(new PreparedPolygon((Polygonal) geom));
            default:
                return Optional.empty();
        }
    }

    @CupidDBFunction("st_equals")
    public boolean st_equals(Geometry geom1, Geometry geom2) {
        return geom1.equals(geom2);
    }

    /**
     * Geometry A contains Geometry B if no points of B lie in the exterior of A,
     * and at least one point of the interior of B lies in the interior of A.
     * The difference between contain and cover, e.g., when a line is
     * on the edge of a polygon, contain return false but cover return true
     */
    @CupidDBFunction("st_contains")
    public boolean st_contains(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.contains(geom2))
            .orElseGet(() -> geom1.contains(geom2));
    }

    /**
     * Returns true if no point in Geometry geom2 is outside Geometry geom1.
     */
    @CupidDBFunction("st_covers")
    public boolean st_covers(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.covers(geom2))
            .orElseGet(() -> geom1.covers(geom2));
    }

    /**
     * Returns true if the supplied geometries have some, but not all, interior points in common,
     * and the dimension of the intersection is less than that of at least one of them
     */
    @CupidDBFunction("st_crosses")
    public boolean st_crosses(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.crosses(geom2))
            .orElseGet(() -> geom1.crosses(geom2));
    }

    /**
     * Returns true if the geometries do not “spatially intersect”; i.e.,
     * they do not share any space together. Equivalent to NOT st_intersects(geom1, geom2).
     */
    @CupidDBFunction("st_disjoint")
    public boolean st_disjoint(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.disjoint(geom2))
            .orElseGet(() -> geom1.disjoint(geom2));
    }

    /**
     * Equivalent to NOT st_disjoint(geom1, geom2).
     */
    @CupidDBFunction("st_intersects")
    public boolean st_intersects(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.intersects(geom2))
            .orElseGet(() -> geom1.intersects(geom2));
    }

    /**
     * Geometry A contains Geometry B if they have at least one point in common,
     * but their interiors do not intersect.
     */
    @CupidDBFunction("st_touches")
    public boolean st_touches(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.touches(geom2))
            .orElseGet(() -> geom1.touches(geom2));

    }

    /**
     * Geometry A within Geometry B if Geometry B contains Geometry A
     */
    @CupidDBFunction("st_within")
    public boolean st_within(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.within(geom2))
            .orElseGet(() -> geom1.within(geom2));
    }

    /**
     * Returns true if the geometries have some but not all points in common,
     * are of the same dimension, and the intersection of the interiors of the
     * two geometries has the same dimension as the geometries themselves.
     */
    @CupidDBFunction("st_overlaps")
    public boolean st_overlaps(Geometry geom1, Geometry geom2) {
        Optional<PreparedGeometry> preparedGeom1 = prepareGeometry(geom1);
        return preparedGeom1.map(preparedGeometry -> preparedGeometry.overlaps(geom2))
            .orElseGet(() -> geom1.overlaps(geom2));
    }

    /**
     * Returns the spatial relationship of two geometric objects,
     * a matrix of the DE-9IM model to String
     */
    @CupidDBFunction("st_relate")
    public String st_relate(Geometry geom1, Geometry geom2) {
        return geom1.relate(geom2).toString();
    }
}

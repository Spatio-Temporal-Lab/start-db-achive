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
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.io.*;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.jts.JtsShapeFactory;

import java.io.IOException;
import java.text.ParseException;

public class GeometricRelationTypeConversionFunction {
    @StartDBFunction("st_castToPoint")
    public Point st_castToPoint(Geometry geom) {
        if (geom instanceof Point) {
            return (Point) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_castToLineString")
    public LineString st_castToLineString(Geometry geom) {
        if (geom instanceof LineString) {
            return (LineString) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_castToPolygon")
    public Polygon st_castToPolygon(Geometry geom) {
        if (geom instanceof Polygon) {
            return (Polygon) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_castToMPoint")
    public MultiPoint st_castToMPoint(Geometry geom) {
        if (geom instanceof MultiPoint) {
            return (MultiPoint) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_castToMLineString")
    public MultiLineString st_castToMLineString(Geometry geom) {
        if (geom instanceof MultiLineString) {
            return (MultiLineString) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_castToMPolygon")
    public MultiPolygon st_castToMPolygon(Geometry geom) {
        if (geom instanceof MultiPolygon) {
            return (MultiPolygon) geom;
        } else {
            return null;
        }
    }

    @StartDBFunction("st_pointFromWKT")
    public Point st_pointFromWKT(String wktString) {
        JtsSpatialContext jtsSpatialContext = JtsSpatialContext.GEO;
        JtsShapeFactory jtsShapeFactory = jtsSpatialContext.getShapeFactory();
        WKTReader wktReader = (WKTReader) jtsSpatialContext.getFormats().getWktReader();
        try {
            Shape shape = wktReader.read(wktString);
            Geometry geometry = jtsShapeFactory.getGeometryFrom(shape);
            return st_castToPoint(geometry);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @StartDBFunction("st_geomFromWKT")
    public Geometry st_geomFromWKT(String wktString) {
        JtsSpatialContext jtsSpatialContext = JtsSpatialContext.GEO;
        JtsShapeFactory jtsShapeFactory = jtsSpatialContext.getShapeFactory();
        WKTReader wktReader = (WKTReader) jtsSpatialContext.getFormats().getWktReader();
        try {
            Shape shape = wktReader.read(wktString);
            return jtsShapeFactory.getGeometryFrom(shape);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

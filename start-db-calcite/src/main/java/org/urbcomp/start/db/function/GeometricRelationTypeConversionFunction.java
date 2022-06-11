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

import org.locationtech.geomesa.spark.jts.util.GeoHashUtils;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.*;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import java.io.IOException;
import java.io.StringWriter;

public class GeometricRelationTypeConversionFunction {
    @StartDBFunction("st_pointFromGeoJSON")
    public Point st_pointFromGeoJSON(String geoJson) throws ParseException {
        return st_castToPoint(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_lineStringFromGeoJSON")
    public LineString st_lineStringFromGeoJSON(String geoJson) throws ParseException {
        return st_castToLineString(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_polygonFromGeoJSON")
    public Polygon st_polygonFromGeoJSON(String geoJson) throws ParseException {
        return st_castToPolygon(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_mPointFromGeoJSON")
    public MultiPoint st_mPointFromGeoJSON(String geoJson) throws ParseException {
        return st_castToMPoint(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_mLineStringFromGeoJSON")
    public MultiLineString st_mLineStringFromGeoJSON(String geoJson) throws ParseException {
        return st_castToMLineString(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_mPolygonFromGeoJSON")
    public MultiPolygon st_mPolygonFromGeoJSON(String geoJson) throws ParseException {
        return st_castToMPolygon(st_geomFromGeoJSON(geoJson));
    }

    @StartDBFunction("st_geomFromGeoJSON")
    public Geometry st_geomFromGeoJSON(String geoJson) throws ParseException {
        GeoJsonReader geoJsonReader = new GeoJsonReader();
        return geoJsonReader.read(geoJson);
    }

    @StartDBFunction("st_asGeoJSON")
    public String st_asGeoJSON(Geometry geom) {
        GeoJsonWriter geoJsonWriter = new GeoJsonWriter();
        return geoJsonWriter.write(geom);
    }

    @StartDBFunction("st_pointFromWKT")
    public Point st_pointFromWKT(String wktString) throws ParseException {
        return st_castToPoint(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_lineStringFromWKT")
    public LineString st_lineStringFromWKT(String wktString) throws ParseException {
        return st_castToLineString(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_polygonFromWKT")
    public Polygon st_polygonFromWKT(String wktString) throws ParseException {
        return st_castToPolygon(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_mPointFromWKT")
    public MultiPoint st_mPointFromWKT(String wktString) throws ParseException {
        return st_castToMPoint(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_mLineStringFromWKT")
    public MultiLineString st_mLineStringFromWKT(String wktString) throws ParseException {
        return st_castToMLineString(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_mPolygonFromWKT")
    public MultiPolygon st_mPolygonFromWKT(String wktString) throws ParseException {
        return st_castToMPolygon(st_geomFromWKT(wktString));
    }

    @StartDBFunction("st_geomFromWKT")
    public Geometry st_geomFromWKT(String wktString) throws ParseException {
        WKTReader wktReader = new WKTReader();
        return wktReader.read(wktString);
    }

    @StartDBFunction("st_asWKT")
    public String st_asWKT(Geometry geom) throws IOException {
        WKTWriter wktWriter = new WKTWriter();
        StringWriter writer = new StringWriter();
        wktWriter.write(geom, writer);
        return writer.toString();
    }

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

    @StartDBFunction("st_castToGeometry")
    public Geometry st_castToGeometry(Geometry geom) {
        return geom;
    }

    @StartDBFunction("st_pointFromWKB")
    public Point st_pointFromWKB(byte[] wkb) throws ParseException {
        return st_castToPoint(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_lineStringFromWKB")
    public LineString st_lineStringFromWKB(byte[] wkb) throws ParseException {
        return st_castToLineString(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_polygonFromWKB")
    public Polygon st_polygonFromWKB(byte[] wkb) throws ParseException {
        return st_castToPolygon(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_mPointFromWKB")
    public MultiPoint st_mPointFromWKB(byte[] wkb) throws ParseException {
        return st_castToMPoint(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_mLineStringFromWKB")
    public MultiLineString st_mLineStringFromWKB(byte[] wkb) throws ParseException {
        return st_castToMLineString(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_mPolygonFromWKB")
    public MultiPolygon st_mPolygonFromWKB(byte[] wkb) throws ParseException {
        return st_castToMPolygon(st_geomFromWKB(wkb));
    }

    @StartDBFunction("st_geomFromWKB")
    public Geometry st_geomFromWKB(byte[] wkb) throws ParseException {
        WKBReader wkbReader = new WKBReader();
        return wkbReader.read(wkb);
    }

    @StartDBFunction("st_asWKB")
    public byte[] st_asWKB(Geometry geom) throws IOException {
        WKBWriter wkbWriter = new WKBWriter();
        return wkbWriter.write(geom);
    }

    @StartDBFunction("st_pointFromGeoHash")
    public Point st_pointFromGeoHash(String geoHashStr, int precision) {
        return GeoHashUtils.decode(geoHashStr, precision).getInteriorPoint();
    }

    @StartDBFunction("st_geomFromGeoHash")
    public Geometry st_geomFromGeoHash(String geoHashStr, int precision) {
        return GeoHashUtils.decode(geoHashStr, precision);
    }

    @StartDBFunction("st_asGeoHash")
    public String st_asGeoHash(Geometry geom, int precision) {
        return GeoHashUtils.encode(geom, precision);
    }
}

/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db

import org.junit.Assert.assertEquals

class GeometricRelationTypeConversionFunctionTest extends AbstractCalciteFunctionTest {
  test("st_pointFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_pointFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_lineStringFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_lineStringFromGeoJSON(st_asGeoJSON(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))), " +
        "st_lineStringFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_polygonFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_polygonFromGeoJSON(st_asGeoJSON(st_polygonFromWKT('POLYGON((10 11,12 12,13 14,15 16,10 11))')))," +
        " st_polygonFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("POLYGON ((10 11, 12 12, 13 14, 15 16, 10 11))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPointFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPointFromGeoJSON(st_asGeoJSON(st_mPointFromWKT('MULTIPOINT(3.5 5.6, 4.8 10.5)')))," +
        " st_mPointFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((3.5 5.6), (4.8 10.5))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mLineStringFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mLineStringFromGeoJSON(st_asGeoJSON(" +
        "st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))')))," +
        "st_mLineStringFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPolygonFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPolygonFromGeoJSON(st_asGeoJSON(" +
        "st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))'))), " +
        "st_mPolygonFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_geomFromGeoJSON(String)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_geomFromGeoJSON(st_asGeoJSON(st_makePoint(1, 2)))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_asGeoJSON(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_asGeoJSON(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals(
      "{\"type\":\"Point\",\"coordinates\":[1,2],\"crs\":{\"type\":\"name\",\"properties\":{\"name\":\"EPSG:0\"}}}",
      resultSet.getObject(1)
    )
  }

  test("st_pointFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_pointFromWKT('POINT(2 3)'), st_pointFromWKT('LINESTRING(0 0,1 1,1 2)')"
    )
    resultSet.next()
    assertEquals("POINT (2 3)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_lineStringFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'), st_lineStringFromWKT('POINT(2 3)')"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_polygonFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_polygonFromWKT('POLYGON((10 11,12 12,13 14,15 16,10 11))'), st_polygonFromWKT('POINT(2 3)')"
    )
    resultSet.next()
    assertEquals("POLYGON ((10 11, 12 12, 13 14, 15 16, 10 11))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPointFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPointFromWKT('MULTIPOINT(3.5 5.6, 4.8 10.5)'), st_mPointFromWKT('POINT(2 3)')"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((3.5 5.6), (4.8 10.5))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mLineStringFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'), " +
        "st_mLineStringFromWKT('POINT(2 3)')"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPolygonFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPolygonFromWKT(" +
        "'MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))')" +
        ", st_mPolygonFromWKT('POINT(2 3)')"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_geomFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_geomFromWKT('GEOMETRYCOLLECTION(POINT(4 6),LINESTRING(4 6,7 10))')"
    )
    resultSet.next()
    assertEquals(
      "GEOMETRYCOLLECTION (POINT (4 6), LINESTRING (4 6, 7 10))",
      resultSet.getObject(1).toString
    )
  }

  test("st_asWKT(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_asWKT(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_castToPoint(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToPoint(st_makePoint(1, 2)), st_castToPoint(st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToLineString(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToLineString(st_geomFromWKT('LINESTRING(0 0,1 1,1 2)'))," +
        " st_castToLineString(st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToPolygon(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToPolygon(st_geomFromWKT('POLYGON((10 11,12 12,13 14,15 16,10 11))'))" +
        ", st_castToPolygon(st_makePoint(1, 2))"
    )
    resultSet.next()
    assertEquals("POLYGON ((10 11, 12 12, 13 14, 15 16, 10 11))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToMPoint(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToMPoint(st_geomFromWKT('MULTIPOINT(3.5 5.6, 4.8 10.5)'))" +
        ", st_castToMPoint(st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((3.5 5.6), (4.8 10.5))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToMLineString(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToMLineString(st_geomFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))" +
        ", st_castToMLineString(st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToMPolygon(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToMPolygon(st_geomFromWKT" +
        "('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))')), " +
        "st_castToMPolygon(st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_castToGeometry(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_castToGeometry(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
  }
}

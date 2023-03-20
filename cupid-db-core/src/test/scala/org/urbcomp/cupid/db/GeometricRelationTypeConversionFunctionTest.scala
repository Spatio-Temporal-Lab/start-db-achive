/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db

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
      "{\"type\":\"Point\",\"coordinates\":[1,2],\"crs\":{\"type\":\"name\",\"properties\":{\"name\":\"EPSG:4326\"}}}",
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

  test("st_pointFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_pointFromWKB(st_asWKB(st_makePoint(1, 2)))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_lineStringFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_lineStringFromWKB(st_asWKB(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))), " +
        "st_lineStringFromWKB(st_asWKB(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_polygonFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_polygonFromWKB(st_asWKB(st_polygonFromWKT('POLYGON((10 11,12 12,13 14,15 16,10 11))')))," +
        " st_polygonFromWKB(st_asWKB(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("POLYGON ((10 11, 12 12, 13 14, 15 16, 10 11))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPointFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPointFromWKB(st_asWKB(st_mPointFromWKT('MULTIPOINT(3.5 5.6, 4.8 10.5)')))," +
        " st_mPointFromWKB(st_asWKB(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((3.5 5.6), (4.8 10.5))", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mLineStringFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mLineStringFromWKB(st_asWKB(" +
        "st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))')))," +
        "st_mLineStringFromWKB(st_asWKB(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_mPolygonFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_mPolygonFromWKB(st_asWKB(" +
        "st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))'))), " +
        "st_mPolygonFromWKB(st_asWKB(st_makePoint(1, 2)))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_geomFromWKB(WKB)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_geomFromWKB(st_asWKB(st_makePoint(1, 2)))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_asWKB(geom)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_geomFromWKB(st_asWKB(st_makePoint(1, 2)))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_pointFromGeoHash(str, precision)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_pointFromGeoHash('s10', 12)")
    resultSet.next()
    assertEquals("POINT (2.8125 7.03125)", resultSet.getObject(1).toString)
  }

  test("st_geomFromGeoHash(str, precision)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_geomFromGeoHash('s10', 12)")
    resultSet.next()
    assertEquals(
      "POLYGON ((0 5.625, 0 8.4375, 5.625 8.4375, 5.625 5.625, 0 5.625))",
      resultSet.getObject(1).toString
    )
  }

  test("st_asGeoHash(geom, precision)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_asGeoHash(st_geomFromWKT('MULTIPOINT(3.5 5.6, 4.8 10.5)'), 12)"
    )
    resultSet.next()
    assertEquals("s10", resultSet.getObject(1).toString)
  }
}

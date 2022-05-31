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
import org.urbcomp.start.db.util.GeoFunctions

class GeometricOperationFunctionTest extends CalciteGeomesaFunctionTest {
  test("st_translate(geom, deltaX, deltaY)") {
    val statement = connect.createStatement
    var resultSet = statement.executeQuery(
      "select st_translate(st_makePoint(1, 2), 1, 1), st_translate(st_makeBBox(1, 2, 3, 4), 1, 1)"
    )
    resultSet.next()
    assertEquals("POINT (2 3)", resultSet.getObject(1).toString)
    assertEquals("POLYGON ((2 3, 2 5, 4 5, 4 3, 2 3))", resultSet.getObject(2).toString)
  }

  test("st_x(point)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_x(st_makePoint(1, 2)), st_x(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals("1.0", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_y(point)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_y(st_makePoint(1, 2)), st_y(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals("2.0", resultSet.getObject(1).toString)
    assertEquals(null, resultSet.getObject(2))
  }

  test("st_BBox(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BBox(st_makePoint(1, 2)), st_BBox(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
    assertEquals("POLYGON ((1 2, 1 4, 3 4, 3 2, 1 2))", resultSet.getObject(2).toString)
  }

  test("st_numPoints(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_numPoints(st_makePoint(1, 2)), st_numPoints(st_makeBBox(1, 2, 3, 4))"
      )
    resultSet.next()
    assertEquals("1", resultSet.getObject(1).toString)
    assertEquals("5", resultSet.getObject(2).toString)
  }

  test("st_pointN(geom, n)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_pointN(st_makePoint(1, 2), 1), st_pointN(st_makeBBox(1, 2, 3, 4), 1)"
      )
    resultSet.next()
    assertEquals(null, resultSet.getObject(1))
    assertEquals(null, resultSet.getObject(2))
    // todo 测试LineString的结果
  }

  test("st_area(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_area(st_makePoint(1, 2)), st_area(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals(0.0, resultSet.getObject(1))
    assertEquals(4.0, resultSet.getObject(2))
  }

  test("st_centroid(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_centroid(st_makePoint(1, 2)), st_centroid(st_makeBBox(1, 2, 3, 4))"
      )
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
    assertEquals("POINT (2 3)", resultSet.getObject(2).toString)
  }

  test("st_closestPoint(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_closestPoint(st_makePoint(1, 2), st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_distance(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_distance(st_makePoint(1, 2), st_makeBBox(1, 2, 3, 4)), " +
          "st_distance(st_makePoint(0, 0), st_makeBBox(1, 2, 3, 4))"
      )
    resultSet.next()
    assertEquals(0.0, resultSet.getObject(1))
    assertEquals(Math.sqrt(5), resultSet.getObject(2))
  }

  test("st_distanceSphere(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_distanceSphere(st_makePoint(116.307683,39.978879), st_makePoint(116.337579,39.984186))"
      )
    resultSet.next()
    System.out.print(GeoFunctions.getDistanceInM(116.307683, 39.978879, 116.337579, 39.984186))
    assertEquals(2614.7025275922806, resultSet.getObject(1))
  }
}

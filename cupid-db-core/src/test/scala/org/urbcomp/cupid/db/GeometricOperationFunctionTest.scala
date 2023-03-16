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

import org.junit.Assert.{assertEquals, assertTrue}

class GeometricOperationFunctionTest extends AbstractCalciteFunctionTest {
  test("st_translate(geom, deltaX, deltaY)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
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
    assertEquals(2614.7025275922806, resultSet.getObject(1))
  }

  test("st_distanceSpheroid(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_distanceSpheroid(st_makePoint(116.307683,39.978879), st_makePoint(116.337579,39.984186))"
      )
    resultSet.next()
    assertEquals(2620.727593714579, resultSet.getObject(1))
  }

  test("st_intersection(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_intersection(st_makePoint(116.307683,39.978879), st_makePoint(116.337579,39.984186)), " +
          "st_intersection(st_makeBBox(1, 2, 3, 4), st_makePoint(2, 3)), " +
          "st_intersection(st_makeBBox(1, 2, 3, 4), st_makeBBOX(2, 3, 4, 5))"
      )
    resultSet.next()
    assertEquals("POINT EMPTY", resultSet.getObject(1))
    assertEquals("POINT (2 3)", resultSet.getObject(2))
    assertEquals("POLYGON ((2 4, 3 4, 3 3, 2 3, 2 4))", resultSet.getObject(3))
  }

  test("st_length(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_length(st_makePoint(116.307683,39.978879)), st_length(st_makeBBox(1, 2, 3, 4))"
      )
    resultSet.next()
    assertEquals(0.0, resultSet.getObject(1))
    assertEquals(8.0, resultSet.getObject(2))
  }

  test("st_lengthSphere(lineString)") {
    // todo 测试linestring的结果
  }

  test("st_lengthSpheroid(lineString)") {
    // todo 测试linestring的结果
  }

  test("st_difference(geom1, geom2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_difference(st_makeBBox(1, 2, 3, 4), st_makeBBox(2, 3, 4, 5))"
      )
    resultSet.next()
    assertEquals("POLYGON ((1 2, 1 4, 2 4, 2 3, 3 3, 3 2, 1 2))", resultSet.getObject(1))
  }

  test("st_isValid(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_isValid(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    // todo 一个不符合的测试
  }

  test("st_bufferPoint(point, distanceInM)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_bufferPoint(st_makePoint(116.307683,39.978879), 2000)")
    assertTrue(resultSet.next())
  }

  test("st_convexHull(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_convexHull(st_makePoint(116.307683,39.978879))")
    resultSet.next()
    assertEquals("POINT (116.307683 39.978879)", resultSet.getObject(1))
    // todo LineString等完成之后，再测
  }
}

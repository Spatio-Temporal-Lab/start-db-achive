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

import org.junit.Assert.{assertEquals, assertNotNull, assertTrue}

/**
 * Geometry relation Function test
 *
 * @author XiangHe
 */

// TODO test the relation between linestring and polygon
class GeometryRelationFunctionTest extends CalciteGeomesaFunctionTest {
  test("st_equals") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_equals(st_makePoint(1, 2), st_makePoint(2, 3)), " +
        "st_equals(st_makePoint(1, 2), st_makeBBox(1, 2, 3, 4))," +
        "st_equals(st_makeBBox(1, 2, 3, 4), st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
  }

  test("st_contains") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_contains(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_contains(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_contains(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))," +
        "st_contains(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_crosses") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_crosses(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_crosses(st_makeBBox(1, 1, 3, 2), st_makeBBox(2, 1, 4, 2))," +
        "st_crosses(st_makeBBox(1, 1, 3, 2), "
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
  }

  test("st_disjoint") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_disjoint(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_disjoint(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_disjoint(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_disjoint(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_intersects") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_intersects(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_intersects(st_makeBBox(1, 1, 2, 2), st_makeBBox(0, 0, 2, 2))," +
        "st_intersects(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_intersects(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(true, resultSet.getObject(4))
  }

  test("st_touches") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_touches(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_touches(st_makeBBox(1, 1, 2, 2), st_makeBBox(2, 1, 3, 2))," +
        "st_touches(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_touches(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(true, resultSet.getObject(4))
  }
}

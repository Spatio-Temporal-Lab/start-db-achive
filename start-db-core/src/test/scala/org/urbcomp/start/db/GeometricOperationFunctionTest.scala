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
    val resultSet = statement.executeQuery("select st_x(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("1.0", resultSet.getObject(1).toString)
  }

  test("st_y(point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_y(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("2.0", resultSet.getObject(1).toString)
  }

  test("st_BBox(geom)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BBox(st_makePoint(1, 2)), st_BBox(st_makeBBox(1, 2, 3, 4))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
    assertEquals("POLYGON ((1 2, 1 4, 3 4, 3 2, 1 2))", resultSet.getObject(2).toString)
  }
}

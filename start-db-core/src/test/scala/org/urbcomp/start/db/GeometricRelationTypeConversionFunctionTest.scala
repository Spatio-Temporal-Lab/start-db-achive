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
    //todo
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

  test("st_geomFromWKT(WKT)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_geomFromWKT('POINT(2 3)')")
    resultSet.next()
    assertEquals("POINT (2 3)", resultSet.getObject(1).toString)
  }
}

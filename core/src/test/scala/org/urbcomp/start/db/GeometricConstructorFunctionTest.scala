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

class GeometricConstructorFunctionTest extends CalciteGeomesaFunctionTest {
  test("st_makePoint") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makePoint(1, 2)")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }
}
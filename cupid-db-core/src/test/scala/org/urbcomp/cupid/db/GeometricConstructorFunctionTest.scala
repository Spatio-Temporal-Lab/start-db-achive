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

import org.junit.Assert.{assertEquals, assertNotNull}

class GeometricConstructorFunctionTest extends AbstractCalciteFunctionTest {
  test("st_makePoint(x, y)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makePoint(1.1, 2)")
    resultSet.next()
    assertEquals("POINT (1.1 2)", resultSet.getObject(1).toString)
  }

  test("st_makeLineString(points)") {
    // todo need build a table
  }

  test("st_makePolygon(shell)") {
    // todo need build a table
  }

  test("st_makePolygon(shell, holes)") {
    // todo need build a table
  }

  test("st_makeBBox(lowerX, lowerY, upperX, upperY)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makeBBox(1.2, 2, 3, 4)")
    resultSet.next()
    assertEquals("POLYGON ((1.2 2, 1.2 4, 3 4, 3 2, 1.2 2))", resultSet.getObject(1).toString)
  }

  test("st_makeBBox(point1, point2)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_makeBBox(st_makePoint(1, 2), st_makePoint(3, 4))")
    resultSet.next()
    assertEquals("POLYGON ((1 2, 1 4, 3 4, 3 2, 1 2))", resultSet.getObject(1).toString)
  }

  test("st_makeCircle(center, radiusInM)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makeCircle(st_makePoint(1, 2), 10)")
    resultSet.next()
    assertNotNull(resultSet.getObject(1))
  }
}

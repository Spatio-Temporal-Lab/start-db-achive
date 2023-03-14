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

class DataTypeConversionFunctionTest extends AbstractCalciteFunctionTest {

  test("castToInteger") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToInteger('1234')")
    resultSet.next()
    assertEquals(1234, resultSet.getObject(1))
  }

  test("castToLong") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToLong('12344')")
    resultSet.next()
    assertEquals(12344L, resultSet.getObject(1))
  }

  test("castToFloat") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToFloat('123.1')")
    resultSet.next()
    assertEquals(123.1f, resultSet.getObject(1))
  }

  test("castToDouble") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToDouble('123444555.3')")
    resultSet.next()
    assertEquals(123444555.3d, resultSet.getObject(1))
  }

  test("castToBoolean") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToBoolean('true')")
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
  }

  test("castToString") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select castToString('1234')")
    resultSet.next()
    assertEquals("1234", resultSet.getObject(1))
  }

  test("parseInteger") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select parseInteger('1234')")
    resultSet.next()
    assertEquals(1234, resultSet.getObject(1))
  }

  test("parseLong") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select parseLong('1234')")
    resultSet.next()
    assertEquals(1234L, resultSet.getObject(1))
  }

  test("parseDouble") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select parseDouble('1234')")
    resultSet.next()
    assertEquals(1234d, resultSet.getObject(1))
  }

}

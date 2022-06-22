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

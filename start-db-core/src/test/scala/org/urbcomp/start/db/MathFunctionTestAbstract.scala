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

class MathFunctionTestAbstract extends AbstractCalciteFunctionTest {

  /**
    * test for log
    */
  test("log") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select log(3,9)")
    resultSet.next()
    assertEquals(2.0, resultSet.getObject(1))
  }

  /**
    * test for pi
    */
  test("pi") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select pi")
    resultSet.next()
    assertEquals(3.14159265358979323846, resultSet.getObject(1))
  }

  /**
    * test for log1p
    */
  test("log1p") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select log1p(1)")
    resultSet.next()
    assertEquals(0.6931471805599453, resultSet.getObject(1))
  }

  /**
    * test for log2
    */
  test("log2") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select log2(8)")
    resultSet.next()
    assertEquals(3.0, resultSet.getObject(1))
  }

  /**
    * test for pow
    */
  test("pow") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select pow('0.5',3)")
    resultSet.next()
    assertEquals(0.125, resultSet.getObject(1))
  }

  /**
    * test for toRadians
    */
  test("toRadians") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select toRadians('90')")
    resultSet.next()
    assertEquals(1.5707963267948966, resultSet.getObject(1))
  }

  /**
    * test for toDegrees
    */
  test("toDegrees") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select toDegrees('1')")
    resultSet.next()
    assertEquals(57.29577951308232, resultSet.getObject(1))
  }

}

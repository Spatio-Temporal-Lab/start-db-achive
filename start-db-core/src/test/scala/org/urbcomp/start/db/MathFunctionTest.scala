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

class MathFunctionTest extends CalciteGeomesaFunctionTest {

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
    * test for ln
    */
  test("ln") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select ln(2)")
    resultSet.next()
    assertEquals(0.6931471805599453, resultSet.getObject(1))
  }

  /**
    * test for log10
    */
  test("log10") {
    val statement = connect.createStatement()
    var resultSet = statement.executeQuery("select log10(1000)")
    resultSet.next()
    assertEquals(3.0, resultSet.getObject(1))
  }

  /**
    * test for abs(int)
    */
  test("abs(int)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select abs(-19)")
    resultSet.next()
    assertEquals(19, resultSet.getObject(1))
  }

  /**
    * test for abs(long)
    */
  test("abs(long)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select abs(-1653829186356786)")
    resultSet.next()
    assertEquals(1653829186356786L, resultSet.getObject(1))
  }

  /**
    * test for abs(float)
    */
  test("abs(float)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select abs('-2.23')")
    resultSet.next()
    assertEquals("2.23", resultSet.getObject(1).toString)
  }

  /**
    * test for ceil
    */
  test("ceil") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select ceil('2.23')")
    resultSet.next()
    assertEquals("3", resultSet.getObject(1).toString)
  }

  /**
    * test for floor
    */
  test("floor") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select floor('2.23')")
    resultSet.next()
    assertEquals("2", resultSet.getObject(1).toString)
  }

  /**
   * test for round
   */
  test("round") {
    val statement = connect.createStatement()
    var resultSet = statement.executeQuery("select round('4.527',2)")
    resultSet.next()
    assertEquals("4.53", resultSet.getObject(1).toString)

    resultSet = statement.executeQuery("select round('456.527',-1)")
    resultSet.next()
    assertEquals("460", resultSet.getObject(1).toString)
  }

  /**
    * test for signum
    */
  test("signum") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select signum('2.23')")
    resultSet.next()
    assertEquals(1.0, resultSet.getObject(1))
  }

  /**
    * test for mod
    */
  test("mod") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select mod(10,3)")
    resultSet.next()
    assertEquals(1, resultSet.getObject(1))
  }

  /**
    * test for sin
    */
  test("sin") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select sin(90)")
    resultSet.next()
    assertEquals(0.8939966636005579, resultSet.getObject(1))
  }

  /**
    * test for cos
    */
  test("cos") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select cos(90)")
    resultSet.next()
    assertEquals(-0.4480736161291702, resultSet.getObject(1))
  }

  /**
    * test for tan
    */
  test("tan") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select tan('0.9')")
    resultSet.next()
    assertEquals(1.2601582175503392, resultSet.getObject(1))
  }

  /**
    * test for asin
    */
  test("asin") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select asin('0.9')")
    resultSet.next()
    assertEquals(1.1197695149986342, resultSet.getObject(1))
  }

  /**
    * test for acos
    */
  test("acos") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select acos('0.9')")
    resultSet.next()
    assertEquals(0.45102681179626236, resultSet.getObject(1))
  }

}

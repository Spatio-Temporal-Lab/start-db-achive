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

import java.sql.Timestamp

/**
  * Time UDF functions test
  *
  * @author Wang Bohong
  * @Date 2022-05-29
  */
class TimeFunctionTest extends CalciteGeomesaFunctionTest {

  /**
    * test for toTimestamp(two parameter)
    */
  test("toTimestamp(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select toTimestamp('20210520 11:21:01', 'yyyyMMdd HH:mm:ss')")
    resultSet.next()
    assertEquals(new Timestamp(1621480861000L), resultSet.getObject(1))
  }

  /**
    * test for toTimestamp(one parameter)
    */
  test("toTimestamp(str)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select toTimestamp('2021-05-20 11:21:01.234')")
    resultSet.next()
    assertEquals(new Timestamp(1621480861234L), resultSet.getObject(1))
  }

  /**
    * test for currentTimestamp
    */
  test("currentTimestamp") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select currentTimestamp()")
    resultSet.next()
    // The result is different every time
    // assertEquals("xxx", resultSet.getObject(1))
  }

  /**
    * test for timestampToLong
    */
  test("timestampToLong(str)") {
    val statement = connect.createStatement()
    var resultSet = statement.executeQuery("select timestampToLong('2022-05-29 20:59:46.345')")
    resultSet.next()
    assertEquals(1653829186345L, resultSet.getObject(1))

    resultSet = statement.executeQuery("select timestampToLong('2022-05-29 20:59:46')")
    resultSet.next()
    assertEquals(1653829186000L, resultSet.getObject(1))
  }

  /**
    * test for timestampToLong
    */
  test("timestampToLong(timestamp)") {
    val statement = connect.createStatement()
    var resultSet = statement.executeQuery("select timestampToLong(longToTimestamp(1653829186345))")
    resultSet.next()
    assertEquals(1653829186345L, resultSet.getObject(1))
  }

  /**
    * test for longToTimestamp
    */
  test("longToTimestamp(long)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select longToTimestamp('1653829186356')")
    resultSet.next()
    assertEquals(new Timestamp(1653829186356L), resultSet.getObject(1))
  }

  /**
    * test for timestampFormat
    */
  test("timestampFormat(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select timestampFormat('2022-05-29 20:59:46', 'yyyyMMdd')")
    resultSet.next()
    assertEquals("20220529", resultSet.getObject(1))
  }

}

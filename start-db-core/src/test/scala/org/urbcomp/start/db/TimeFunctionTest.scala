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

import org.junit.Assert.{assertEquals, assertTrue}

import java.sql.Timestamp
import java.time.LocalDateTime

/**
  * Time UDF functions test
  *
  * @author Wang Bohong
  */
class TimeFunctionTest extends CalciteGeomesaFunctionTest {
  val DEFAULT_TIME_STR = "2021-05-20 11:21:01.234"
  val DEFAULT_TIMESTAMP: Timestamp = Timestamp.valueOf(DEFAULT_TIME_STR)
  val DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"

  /**
    * test for toTimestamp(two parameter)
    */
  test("toTimestamp(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select toTimestamp('" + DEFAULT_TIME_STR + "', '" + DEFAULT_FORMAT + "')"
      )
    resultSet.next()
    assertEquals(DEFAULT_TIMESTAMP, resultSet.getObject(1))
  }

  /**
    * test for toTimestamp(one parameter)
    */
  test("toTimestamp(str)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select toTimestamp('" + DEFAULT_TIME_STR + "')")
    resultSet.next()
    assertEquals(DEFAULT_TIMESTAMP, resultSet.getObject(1))
  }

  /**
    * test for currentTimestamp
    */
  test("currentTimestamp") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select currentTimestamp()")
    assertTrue(resultSet.next())
  }

  /**
    * test for timestampToLong
    */
  test("timestampToLong(str)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select timestampToLong('" + DEFAULT_TIME_STR + "')")
    resultSet.next()
    assertEquals(DEFAULT_TIMESTAMP.getTime, resultSet.getObject(1))
  }

  /**
    * test for timestampToLong
    */
  test("timestampToLong(timestamp)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery(
      "select timestampToLong(longToTimestamp(" + DEFAULT_TIMESTAMP.getTime + "))"
    )
    resultSet.next()
    assertEquals(DEFAULT_TIMESTAMP.getTime, resultSet.getObject(1))
  }

  /**
    * test for longToTimestamp
    */
  test("longToTimestamp(long)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select longToTimestamp('" + DEFAULT_TIMESTAMP.getTime + "')")
    resultSet.next()
    assertEquals(DEFAULT_TIMESTAMP, resultSet.getObject(1))
  }

  /**
    * test for timestampFormat
    */
  test("timestampFormat(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select timestampFormat('" + DEFAULT_TIME_STR + "', 'yyyy-MM-dd')")
    resultSet.next()
    assertEquals(DEFAULT_TIME_STR.substring(0, "yyyy-MM-dd".length), resultSet.getObject(1))
  }

  /**
    * DatetimeFunctionDemo Tests
    */
  /**
    * test for toDatetime (two parameters)
    */
  test("toDatetime(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select toDatetime('20220529 11:35:01', 'yyyyMMdd HH:mm:ss')")
    resultSet.next()
    assertEquals("2022-05-29T11:35:01", resultSet.getObject(1).toString)
  }

  /**
    * test for toDatetime (one parameter)
    */
  test("toDatetime(str)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select toDatetime('2022-05-29 11:35:01')")
    resultSet.next()
    assertEquals("2022-05-29T11:35:01", resultSet.getObject(1).toString)
  }

  /**
    * test for toTimestamp(with timezone)
    */
  test("toTimestamp(str, format, ?)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select toTimestamp('20220529 11:35:01', 'yyyyMMdd HH:mm:ss', '?')")
    resultSet.next
    assertEquals("2022-05-29T11:35:01Z[UTC]", resultSet.getObject(1).toString)
  }

  /**
    * test for datetimeToTimestamp
    */
  test("datetimeToTimestamp(str)") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select datetimeToTimestamp('2022-05-29 11:35:01')")
    resultSet.next()
    assertEquals("2022-05-29T11:35:01Z[UTC]", resultSet.getObject(1).toString)
  }
}

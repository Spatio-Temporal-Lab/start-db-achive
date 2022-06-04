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

/**
  * Time UDF functions test
  *
  * @author Wang Bohong
  */
class TimeFunctionTestAbstract extends AbstractCalciteFunctionTest {
  val DEFAULT_TIME_STR = "2021-05-20 11:21:01.234"
  val DEFAULT_TIMESTAMP: Timestamp = Timestamp.valueOf(DEFAULT_TIME_STR)
  val DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"
  val DEFAULT_DT_STR = "2021-05-20T11:21:01.234"

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
    * test for toDatetime
    */
  test("toDatetime(str, format)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select toDatetime('" + DEFAULT_TIME_STR + "', '" + DEFAULT_FORMAT + "')"
      )
    resultSet.next()
    assertEquals(DEFAULT_DT_STR, resultSet.getObject(1).toString)
  }

  /**
    * test for toDatetime
    */
  test("toDatetime(str)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select toDatetime('" + DEFAULT_TIME_STR + "')")
    resultSet.next()
    assertEquals(DEFAULT_DT_STR, resultSet.getObject(1).toString)
  }

  /**
    * test for datetimeToTimestamp
    */
  test("datetimeToTimestamp") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select datetimeToTimestamp('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(DEFAULT_TIME_STR, resultSet.getObject(1).toString)
  }

  /**
    * test for timestampToDatetime
    */
  test("timestampToDatetime") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select timestampToDatetime('" + DEFAULT_TIME_STR + "')")
    resultSet.next()
    assertEquals(DEFAULT_DT_STR, resultSet.getObject(1).toString)
  }

  /**
    * test for currentDatetime
    */
  test("currentDatetime") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select currentDatetime()")
    assertTrue(resultSet.next())
  }

  /**
    * test for datetimeFormat
    */
  test("datetimeFormat") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select datetimeFormat('" + DEFAULT_DT_STR + "', '" + DEFAULT_FORMAT + "')"
      )
    resultSet.next()
    assertEquals(DEFAULT_TIME_STR, resultSet.getObject(1))
  }

  /**
    * test for hour
    */
  test("hour") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select hour('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(11, resultSet.getObject(1))
  }

  /**
    * test for minute
    */
  test("minute") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select minute('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(21, resultSet.getObject(1))
  }

  /**
    * test for second
    */
  test("second") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select second('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(1, resultSet.getObject(1))
  }

  /**
    * test for week
    */
  test("week") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select week('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(20, resultSet.getObject(1))
  }

  /**
    * test for month
    */
  test("month") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select month('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(5, resultSet.getObject(1))
  }

  /**
    * test for year
    */
  test("year") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select year('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(2021, resultSet.getObject(1))
  }

  /**
    * test for dayOfMonth
    */
  test("dayOfMonth") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select dayOfMonth('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(20, resultSet.getObject(1))
  }

  /**
    * test for dayOfWeek
    */
  test("dayOfWeek") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select dayOfWeek('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(4, resultSet.getObject(1))
  }

  /**
    * test for dayOfYear
    */
  test("dayOfYear") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select dayOfYear('" + DEFAULT_DT_STR + "')")
    resultSet.next()
    assertEquals(140, resultSet.getObject(1))
  }
}

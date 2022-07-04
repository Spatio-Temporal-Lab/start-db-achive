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

class QueryTest extends AbstractCalciteFunctionTest {

  test("test query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select count(1) from t_test")
    assertTrue(rs.next())
  }

  test("test query col") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select * from t_test")
    val md = rs.getMetaData
    val cnt = md.getColumnCount
    while (rs.next()) {
      for (i <- 1 until cnt) {
        if (!md.getColumnClassName(i).equals(classOf[Timestamp].getCanonicalName)) {
          rs.getObject(i)
        }
      }
    }
  }

  test("test select one column") {
    val stmt = connect.createStatement()
    stmt.execute("create table if not exists t_int(i int)")
    stmt.execute("insert into t_int values (123)")

    val rs = stmt.executeQuery("select * from t_int")
    rs.next()
    assertEquals(123, rs.getInt(1))
  }

  test("select timestamp") {
    val stmt = connect.createStatement()
    stmt.execute("create table if not exists t_timestamp  (timestamp11 timestamp);")
    stmt.execute("insert into t_timestamp values (toTimestamp(\"2022-06-29 10:00:00.000\"));")
    val rs = stmt.executeQuery("select * from t_timestamp;")
    rs.next()
    val value = rs.getObject(1)
    assertEquals(false, value == null)
  }
}

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

package org.urbcomp.start.db.query

import org.junit.Assert.{assertEquals, assertTrue}
import org.urbcomp.start.db.AbstractCalciteCRUDTest

import java.sql.Timestamp

class QueryTest extends AbstractCalciteCRUDTest {

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    statement.executeUpdate("insert into t_crud_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))")
  }

  test("test query") {
    val rs = statement.executeQuery("select count(1) from t_crud_test")
    assertTrue(rs.next())
  }

  test("test query col") {
    val rs = statement.executeQuery("select * from t_crud_test")
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
    statement.execute("create table if not exists t_int(i int)")
    statement.execute("insert into t_int values (123)")

    val rs = statement.executeQuery("select * from t_int")
    rs.next()
    assertEquals(123, rs.getInt(1))
    statement.execute("drop table if exists t_int")
  }

  test("select timestamp") {
    statement.execute("create table if not exists t_timestamp  (timestamp11 timestamp);")
    statement.execute("insert into t_timestamp values (toTimestamp(\"2022-06-29 10:00:00.000\"));")
    val rs = statement.executeQuery("select * from t_timestamp;")
    rs.next()
    val value = rs.getObject(1)
    assertEquals(false, value == null)
    statement.execute("drop table if exists t_timestamp")
  }

  test("bool equal test") {
    statement.execute("create table t_bool (bool7 bool);")
    statement.execute("insert into t_bool values (true);")

    val rs = statement.executeQuery("select * from t_bool where bool7 = true;")
    while (rs.next()) {
      assertEquals(true, rs.getObject(1))
    }
    statement.execute("drop table if exists t_bool")
  }

  test("chinese string insert test") {
    statement.execute("""
                       |create table t_string10 (string6 string)
                       |""".stripMargin)

    statement.execute("""
                       |insert into t_string10 values ('字符串')
                       |""".stripMargin)

    val rs = statement.executeQuery("select * from t_string10")
    while (rs.next()) {
      assertEquals("字符串", rs.getObject(1))
    }
    statement.execute("drop table if exists t_string10")
  }

  test("geometry equal test") {
    val statement = connect.createStatement()
    statement.execute("create table t_point (point13 point)")
    statement.execute("""
                   |insert into t_point values (st_PointFromWkt("Point(10 20)"))
                   |""".stripMargin)

    val rs =
      statement.executeQuery("""
                          |select * from t_point where point13 = st_PointFromWkt("Point(10 20)")
                          |""".stripMargin)
    var count = 0
    while (rs.next()) {
      count += 1
    }
    assertEquals(1, count)
  }
  statement.execute("drop table if exists t_point")
}

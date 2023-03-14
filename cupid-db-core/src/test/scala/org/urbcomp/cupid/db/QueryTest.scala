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

  test("bool equal test") {
    val stmt = connect.createStatement()
    stmt.execute("create table t_bool (bool7 bool);")
    stmt.execute("insert into t_bool values (true);")

    val rs = stmt.executeQuery("select * from t_bool where bool7 = true;")
    while (rs.next()) {
      assertEquals(true, rs.getObject(1))
    }
  }

  test("chinese string insert test") {
    val stmt = connect.createStatement()
    stmt.execute("""
                       |create table t_string10 (string6 string)
                       |""".stripMargin)

    stmt.execute("""
                       |insert into t_string10 values ('字符串')
                       |""".stripMargin)

    val rs = stmt.executeQuery("select * from t_string10")
    while (rs.next()) {
      assertEquals("字符串", rs.getObject(1))
    }
  }

  test("geometry equal test") {
    val stmt = connect.createStatement()
    stmt.execute("create table t_point (point13 point)")
    stmt.execute("""
                   |insert into t_point values (st_PointFromWkt("Point(10 20)"))
                   |""".stripMargin)

    val rs =
      stmt.executeQuery("""
                          |select * from t_point where point13 = st_PointFromWkt("Point(10 20)")
                          |""".stripMargin)
    var count = 0
    while (rs.next()) {
      count += 1
    }
    assertEquals(1, count)
  }
}

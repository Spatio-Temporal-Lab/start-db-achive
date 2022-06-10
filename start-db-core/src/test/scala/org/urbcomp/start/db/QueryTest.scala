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
import java.util.Date

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
          print(rs.getObject(i) + ", ")
        }
      }
      println()
    }
  }
}

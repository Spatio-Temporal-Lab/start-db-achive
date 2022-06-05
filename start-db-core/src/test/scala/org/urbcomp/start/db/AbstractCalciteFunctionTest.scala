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
import org.scalatest.{BeforeAndAfterAll, FunSuite}

import java.net.URLDecoder
import java.sql.{Connection, DriverManager}
import java.util.Properties

/**
  * Test for Calcite and Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
class AbstractCalciteFunctionTest extends FunSuite with BeforeAndAfterAll {

  var connect: Connection = _

  override protected def beforeAll(): Unit = {
    val url = this.getClass.getResource("/model.json")
    val str = URLDecoder.decode(url.toString, "UTF-8")
    val config = new Properties
    config.put("model", str.replace("file:", ""))
    config.put("caseSensitive", "false")
    connect = DriverManager.getConnection("jdbc:calcite:fun=spatial", config)
  }

  test("test query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select count(1) from t_test")
    rs.next()
    assertEquals(101, rs.getInt(1))
  }

  override protected def afterAll(): Unit = {
    connect.close()
  }
}

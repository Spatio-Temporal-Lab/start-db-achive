/*
 * Copyright 2022 ST-Lab

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

package org.urbcomp.start.db

import org.junit.Assert.assertNotNull
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.urbancomp.start.db.MiniHBaseCluster

import java.net.URLDecoder
import java.sql.DriverManager
import java.util.Properties

/**
  * Test for Calcite and Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
class CalciteGeomesaTest extends FunSuite with BeforeAndAfterAll {

  var config: Properties = _

  override protected def beforeAll(): Unit = {
    MiniHBaseCluster.start()

    val url = this.getClass.getResource("/model.json")
    val str = URLDecoder.decode(url.toString, "UTF-8")
    config = new Properties
    config.put("model", str.replace("file:", ""))
    config.put("caseSensitive", "false")
  }

  // TODO create table first
  ignore("calcite geomesa test") {
    val connect = DriverManager.getConnection("jdbc:calcite:", config)
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select * from test_table01 where age = 10")
    while (resultSet.next()) {
      assertNotNull(resultSet.getObject(1))
    }
  }

  override protected def afterAll(): Unit = {
    MiniHBaseCluster.shutdown()
  }
}

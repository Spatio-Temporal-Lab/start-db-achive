/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.slf4j.Logger
import org.urbcomp.cupid.db.metadata.CalciteHelper
import org.urbcomp.cupid.db.util.{LogUtil, SqlParam}

import java.sql.Connection
import java.util.TimeZone

/**
  * Test for Calcite and Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
abstract class AbstractCalciteFunctionTest extends FunSuite with BeforeAndAfterAll {
  var connect: Connection = _
  TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
  val log: Logger = LogUtil.getLogger

  override protected def beforeAll(): Unit = {
    SqlParam.CACHE.set(new SqlParam("root", "default"))
    connect = CalciteHelper.createConnection()
  }

  override protected def afterAll(): Unit = {
    connect.close()
  }
}

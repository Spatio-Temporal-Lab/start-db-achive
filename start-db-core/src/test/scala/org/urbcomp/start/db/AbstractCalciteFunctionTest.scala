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

package org.urbcomp.start.db

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.urbcomp.start.db.metadata.CalciteHelper
import org.urbcomp.start.db.util.SqlParam

import java.sql.Connection

/**
  * Test for Calcite and Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
abstract class AbstractCalciteFunctionTest extends FunSuite with BeforeAndAfterAll {

  var connect: Connection = _

  override protected def beforeAll(): Unit = {
    SqlParam.CACHE.set(new SqlParam("root", "default"))
    connect = CalciteHelper.createConnection()
  }

  override protected def afterAll(): Unit = {
    connect.close()
  }
}

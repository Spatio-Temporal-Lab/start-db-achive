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

import org.geotools.data.Query
import org.junit.Assert.assertEquals
import org.scalatest.FunSuite
import org.urbcomp.start.db.io.TrajectoryGeoMesaIO
import org.urbcomp.start.db.model.sample.ModelGenerator

import java.util

class TrajectoryGeoMesaIOTest extends FunSuite {
  test("test trajectory io") {
    val t = ModelGenerator.generateTrajectory
    val params = new java.util.HashMap[String, String]
    val CATALOG = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val tio = new TrajectoryGeoMesaIO("trajectory", params)
    val query = new Query("trajectory")
    tio.dropTable()
    tio.createTable()
    tio.trajectoryToGeoMesaObject(t)
    tio.writeClose()
    val result = tio.trajectoryFromGeoMesaObject(query)
    tio.close()
    assertEquals(false, result.isEmpty)
  }
}

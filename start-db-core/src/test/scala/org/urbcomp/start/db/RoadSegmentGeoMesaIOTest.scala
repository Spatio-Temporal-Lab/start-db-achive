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

import org.geotools.data.DataStoreFinder
import org.locationtech.jts.util.Assert
import org.scalatest.FunSuite
import org.urbcomp.start.db.io.RoadSegmentGeoMesaIO
import org.urbcomp.start.db.model.sample.ModelGenerator

class RoadSegmentGeoMesaIOTest extends FunSuite {
  test("test io") {
    val rs = ModelGenerator.generateRoadSegment()
    val params: java.util.Map[String, String] = new java.util.HashMap[String, String]
    val CATALOG: String = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val tableName = "RoadSegment"
    val io = new RoadSegmentGeoMesaIO(tableName, params)
    io.RoadSegmentToGeoMesaObject(rs)
    val bbox = "bbox (geom, -180.0, -90.0, 180.0, 90.0)"
    val result = io.RoadSegmentFromGeoMesaObject(bbox)
    Assert.equals(
      "LINESTRING (111.37939453125 54.00776876193478, 116.3671875 53.05442186546102)",
      result.get(0)
    )
  }
}

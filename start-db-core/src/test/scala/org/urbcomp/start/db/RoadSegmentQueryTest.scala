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
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.sample.ModelGenerator

/**
  * test for RoadSegmentQuery
  *
  * @author WangBohongd
  * @date 2022-06-16
  */
class RoadSegmentQueryTest extends AbstractCalciteFunctionTest {

  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rsGeoJson: String = rs.toGeoJSON

  test("basic roadSegment query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select count(1) from t_road_segment_test")
    assertTrue(rs.next())
  }

  /**
    * test for roadSegment type
    */
  test("roadSegment query") {
    val statement = connect.createStatement()
    statement.execute("create table if not exists t_road_segment_test (a Integer, b RoadSegment);")
    val set = statement.executeQuery("select count(1) from t_road_segment_test")
    set.next()
    val count = set.getObject(1)
    if (count == 0) {
      statement.execute(
        "insert into t_road_segment_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
      )
    }
    val rs = statement.executeQuery("select * from t_road_segment_test")
    while (rs.next()) {
      assertEquals(classOf[RoadSegment], rs.getObject(2).getClass)
    }
  }

  test("0626Test") {}
}

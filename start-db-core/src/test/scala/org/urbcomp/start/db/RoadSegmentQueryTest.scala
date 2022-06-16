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

/**
  * test for RoadSegmentQuery
  *
  * @author WangBohong
  * @date 2022-06-16
  */
class RoadSegmentQueryTest extends AbstractCalciteFunctionTest {

  test("basic roadSegment query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select count(1) from xxx")
    assertTrue(rs.next())
  }

  /**
    * test for roadSegment type
    */
  test("roadSegment query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select * from xxx")
    while (rs.next()) {
      assertEquals(classOf[RoadSegment], rs.getObject(2).getClass)
      assertEquals(classOf[RoadSegment], rs.getObject(3).getClass)
    }
  }

}

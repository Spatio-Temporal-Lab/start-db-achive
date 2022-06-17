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
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory

/**
  * TrajectoryQuery Test
  *
  * @author Wang Bohong
  * @date 2022-06-16
  */
class TrajectoryQueryTest extends AbstractCalciteFunctionTest {

  /**
    * test for trajectory
    */
  test("trajectory test") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select * from t_trajectory_test")
    while (rs.next()) {
      assertEquals(classOf[Trajectory], rs.getObject(2).getClass)
    }
  }
}

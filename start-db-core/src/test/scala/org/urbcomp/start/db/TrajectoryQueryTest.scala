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
import org.urbcomp.start.db.model.sample.ModelGenerator
import org.urbcomp.start.db.model.trajectory.Trajectory

/**
  * TrajectoryQuery Test
  *
  * @author Wang Bohong
  * @date 2022-06-16
  */
class TrajectoryQueryTest extends AbstractCalciteFunctionTest {

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  /**
    * test for trajectory
    */
  test("trajectory test") {
    val stmt = connect.createStatement()
    stmt.execute("create table if not exists t_trajectory_test (idx Integer, traj Trajectory)")
    val rsCount = stmt.executeQuery("select count(1) from t_trajectory_test")
    rsCount.next()
    if (rsCount.getObject(1) == 0) {
      stmt.execute(
        "insert into t_trajectory_test values (1, st_traj_fromGeoJSON(\'" + tGeo + "\'))"
      )
    }
    val rs = stmt.executeQuery("select * from t_trajectory_test")
    while (rs.next()) {
      assertEquals(classOf[Trajectory], rs.getObject(2).getClass)
    }
  }
}

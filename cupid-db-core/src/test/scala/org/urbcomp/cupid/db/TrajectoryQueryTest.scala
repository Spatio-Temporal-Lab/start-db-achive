/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db

import org.junit.Assert.assertEquals
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

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

  /**
    * test for trajectory field query
    */
  test("trajectory field query test") {
    val stmt = connect.createStatement()
    stmt.execute("create table if not exists t_trajectory_test03 (tid String, traj Trajectory)")
    val rsCount = stmt.executeQuery("select count(1) from t_trajectory_test03")
    rsCount.next()
    if (rsCount.getObject(1) == 0) {
      stmt.execute(
        "insert into t_trajectory_test03 values ('djfalkdjlafkj', st_traj_fromGeoJSON(\'" + tGeo + "\'))"
      )
    }
    val rs = stmt.executeQuery("select * from t_trajectory_test03 where tid = 'djfalkdjlafkj'")
    var count = 0
    while (rs.next()) {
      count += 1
    }
    assertEquals(1, count)
  }
}

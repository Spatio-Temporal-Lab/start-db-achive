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

import org.junit.Assert.{assertEquals, assertTrue}
import org.locationtech.jts.geom.Point
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

import java.util

/**
  * CollectList Test
  *
  * @author Hang Wu
  * @date 2023-02-11
  */
class CollectListTest extends AbstractCalciteFunctionTest {

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  test("collect list test") {
    val statement = connect.createStatement()
    statement.executeUpdate("create table list_test (points point)")
    statement.executeUpdate("insert into table list_test values (st_makePoint(1, 2))")
    statement.executeUpdate("insert into table list_test values (st_makePoint(3, 4))")
    statement.executeUpdate("insert into table list_test values (st_makePoint(5.5, 6))")
    val resultSet =
      statement.executeQuery("select st_collect_list(points) from list_test")
    resultSet.next()
    System.out.println(resultSet.getObject(1).toString)
    val collectListResult =
      resultSet.getObject(1).asInstanceOf[org.apache.calcite.avatica.util.ArrayImpl]
    assertTrue(collectListResult.getArray.asInstanceOf[Array[Object]].length == 3)
  }
}

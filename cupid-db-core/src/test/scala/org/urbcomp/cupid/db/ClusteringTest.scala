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
import org.locationtech.jts.geom.{MultiPoint, Point}
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

import java.util

/**
  * Clustering Test
  *
  * @author Hang Wu
  * @date 2023-02-11
  */
class ClusteringTest extends AbstractCalciteFunctionTest {

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  test("dbscan test1") {
    val statement = connect.createStatement()
    statement.executeUpdate("create table dbscan_test1 (points point)")
    statement.executeUpdate(
      "insert into table dbscan_test1 values (st_makePoint(1.000000, 2.000000))"
    )
    statement.executeUpdate(
      "insert into table dbscan_test1 values (st_makePoint(1.000010, 2.000010))"
    )
    statement.executeUpdate(
      "insert into table dbscan_test1 values (st_makePoint(1.000030, 2.000020))"
    )
    statement.executeUpdate(
      "insert into table dbscan_test1 values (st_makePoint(1.000040, 2.000030))"
    )
    val resultSet =
      statement.executeQuery(
        "select st_dbscan_clustering(st_collect_list(points), 1.6, 2) from dbscan_test1"
      )
    resultSet.next()
    var count = 0
    while (resultSet.next()) {
      System.out.println(resultSet.getObject(1).toString)
      //count = count + MultiPoint.fromString(resultSet.getObject(1).toString).getGPSPointList.size()
    }
    //assertEquals(trajectory.getGPSPointList.size, count)
  }

}

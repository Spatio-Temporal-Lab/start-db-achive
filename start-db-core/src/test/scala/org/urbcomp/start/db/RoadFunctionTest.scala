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

import org.junit.Assert.{assertEquals, assertNotNull}
import org.urbcomp.start.db.model.roadnetwork.{RoadNetwork, RoadSegment}
import org.urbcomp.start.db.model.sample.ModelGenerator
import org.urbcomp.start.db.model.trajectory.Trajectory

/**
  * Road Segment/Network Function test
  *
  * @author XiangHe
  */
class RoadFunctionTest extends AbstractCalciteFunctionTest {

  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rn: RoadNetwork = ModelGenerator.generateRoadNetwork()
  val rsGeoJson: String = rs.toGeoJSON
  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  test("st_rn_shortestPath") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_rn_shortestPath(st_makeRoadNetwork(collect_list(b))," +
          " st_makePoint(111.37939453125,54.00776876193478)," +
          " st_makePoint(116.3671875,53.05442186546102)) from t_road_segment_test"
      )
    resultSet.next()
    assertEquals(
      "Path{lengthInMeter=346582.30322217953, " +
        "points=[POINT (111.37939453125 54.00776876193478)," +
        " -1|346582.30322217953|0|0.0, -1|0.0|0|0.0, " +
        "POINT (116.3671875 53.05442186546102)], roadSegmentIds=[-1]}",
      resultSet.getObject(1).toString
    )
  }

  test("st_makeRoadNetwork") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_makeRoadNetwork(collect_list(b)) from t_road_segment_test")
    resultSet.next()
    assertEquals(
      "class org.urbcomp.start.db.model.roadnetwork.RoadNetwork",
      resultSet.getObject(1).getClass.toString
    )
  }

  test("st_makeRoadSegment") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makeRoadSegment(\'" + rsGeoJson + "\')")
    resultSet.next()
    assertEquals(rs, resultSet.getObject(1))
  }

  test("st_rs_rsid") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_rsid(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getRoadSegmentId.toString, resultSet.getObject(1))
  }

  test("st_rs_geom") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_geom(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertNotNull(resultSet.getObject(1))
  }

  test("st_rs_direction") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_direction(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getDirection.toString, resultSet.getObject(1))
  }

  test("st_rs_speedLimitInKMPerHour") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery(
        "select st_rs_speedLimitInKMPerHour(st_makeRoadSegment(\'" + rsGeoJson + "\'))"
      )
    resultSet.next()
    assertEquals(rs.getSpeedLimit, resultSet.getObject(1))
  }

  test("st_rs_level") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_level(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getLevel.value(), resultSet.getObject(1))
  }

  test("st_rs_startId") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_startId(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getStartNode.getNodeId.toString, resultSet.getObject(1))
  }

  test("st_rs_endId") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_endId(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getEndNode.getNodeId.toString, resultSet.getObject(1))
  }

  test("st_rs_lengthInKM") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_rs_lengthInKM(st_makeRoadSegment(\'" + rsGeoJson + "\'))")
    resultSet.next()
    assertEquals(rs.getLengthInMeter / 1000, resultSet.getObject(1))
  }

  test("st_traj_mapMatch(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_mapMatch(st_makeRoadNetwork(collect_list(b)), " +
          "st_traj_fromGeoJSON(\'" + tGeo + "\')) from t_road_segment_test"
      )
    resultSet.next()
    assertEquals(
      "{\"type\":\"FeatureCollection\",\"features\":[],\"properties\":" +
        "{\"oid\":\"afab91fa68cb417c2f663924a0ba1ff9\"," +
        "\"tid\":\"afab91fa68cb417c2f663924a0ba1ff92018-10-09 07:28:21.0\"}}",
      resultSet.getObject(1)
    )
  }
}

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

import org.junit.Assert.assertEquals
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

import scala.collection.JavaConverters.seqAsJavaList

class TrajectoryFunctionTest extends AbstractCalciteFunctionTest {
  val nameArray: Array[String] = Array[String]("int", "str", "double", "point")
  val typeArray: Array[String] = Array[String]("Integer", "String", "Double", "Point")
  val trajectory: Trajectory =
    ModelGenerator.generateTrajectory(seqAsJavaList(nameArray), seqAsJavaList(typeArray))
  val tGeo: String = trajectory.toGeoJSON

  test("st_traj_asGeoJSON(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_fromGeoJSON(\'" + tGeo + "\')")
    resultSet.next()
    assertEquals(trajectory, resultSet.getObject(1))
  }

  test("st_traj_fromGeoJSON(str)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_asGeoJSON(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals(tGeo, resultSet.getObject(1))
  }

  test("st_traj_oid(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_oid(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("afab91fa68cb417c2f663924a0ba1ff9", resultSet.getObject(1))
  }

  test("st_traj_tid(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_tid(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("afab91fa68cb417c2f663924a0ba1ff92018-10-09 07:28:21.0", resultSet.getObject(1))
  }

  test("st_traj_startTime(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_startTime(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("2018-10-09 07:28:21.0", resultSet.getObject(1).toString)
  }

  test("st_traj_endTime(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_endTime(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("2018-10-09 07:34:18.0", resultSet.getObject(1).toString)
  }

  test("st_traj_startPoint(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_startPoint(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("POINT (108.99553 34.27859)", resultSet.getObject(1).toString)
  }

  test("st_traj_endPoint(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_endPoint(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("POINT (108.98897 34.25815)", resultSet.getObject(1).toString)
  }

  test("st_traj_numOfPoints(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_numOfPoints(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("117", resultSet.getObject(1).toString)
  }

  test("st_traj_pointN(Trajectory,int)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_pointN(st_traj_fromGeoJSON(\'" + tGeo + "\'),2)")
    resultSet.next()
    assertEquals("POINT (108.99552 34.27786)", resultSet.getObject(1).toString)
  }

  test("st_traj_timeN(Trajectory,int)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_timeN(st_traj_fromGeoJSON(\'" + tGeo + "\'),2)")
    resultSet.next()
    assertEquals("2018-10-09 07:28:27.0", resultSet.getObject(1).toString)
  }

  test("st_traj_lengthInKM(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_lengthInKM(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals("2.9989194858191373", resultSet.getObject(1).toString)
  }

  test("st_traj_speedInKMPerHour(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_speedInKMPerHour(st_traj_fromGeoJSON(\'" + tGeo + "\'))"
      )
    resultSet.next()
    assertEquals("30.24120489901651", resultSet.getObject(1).toString)
  }

  test("st_traj_geom(Trajectory)") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery("select st_traj_geom(st_traj_fromGeoJSON(\'" + tGeo + "\'))")
    resultSet.next()
    assertEquals(
      "class org.locationtech.jts.geom.LineString",
      resultSet.getObject(1).getClass.toString
    )
  }

  test("st_traj_timeIntervalSegment") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_timeIntervalSegment(st_traj_fromGeoJSON(\'" + tGeo + "\')," + 2 + ")"
      )
    var count = 0
    while (resultSet.next()) {
      count = count + Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList.size()
    }
    assertEquals(trajectory.getGPSPointList.size, count)

  }

  test("st_traj_stayPointSegment") {
    val statement = connect.createStatement()
    val trajectorySeg: Trajectory =
      ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt")
    val tGeoSeg: String = trajectorySeg.toGeoJSON
    val resultSet =
      statement.executeQuery(
        "select st_traj_stayPointSegment(st_traj_fromGeoJSON(\'" + tGeoSeg + "\')," + 10 + "," + 10 + ")"
      )
    var count = 0
    var seg = 0
    while (resultSet.next()) {
      count = count + Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList.size()
      seg += 1
    }
    assertEquals(seg, 3)
    assertEquals(trajectorySeg.getGPSPointList.size - 8, count)

  }

  test("st_traj_hybridSegment") {
    val statement = connect.createStatement()
    val trajectorySeg: Trajectory =
      ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt")
    val tGeoSeg: String = trajectorySeg.toGeoJSON
    val resultSet =
      statement.executeQuery(
        "select st_traj_hybridSegment(st_traj_fromGeoJSON(\'" + tGeoSeg + "\')," + 10 + "," + 10 + "," + 10 + ")"
      )
    var count = 0
    var seg = 0
    while (resultSet.next()) {
      count = count + Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList.size()
      seg += 1
    }
    assertEquals(seg, 5)
    assertEquals(trajectorySeg.getGPSPointList.size - 8, count)
  }

  test("st_traj_stayPointDetect") {
    val statement = connect.createStatement()
    val trajectoryStp: Trajectory =
      ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt")
    val tGeoStp: String = trajectoryStp.toGeoJSON
    val resultSet1 = statement.executeQuery(
      "select st_traj_stayPointDetect(st_traj_fromGeoJSON(\'" + tGeoStp + "\'),10,10)"
    )
    resultSet1.next()
    assertEquals("2018-10-09 07:28:24.0", resultSet1.getObject(1).toString)
    assertEquals("2018-10-09 07:28:39.0", resultSet1.getObject(2).toString)
    assertEquals(
      "[POINT (108.99552 34.27822), POINT (108.99552 34.27822), POINT (108.99552 34.27822), POINT (108.99552 34.27822), POINT (108.99552 34.27822), POINT (108.99552 34.27822)]",
      resultSet1.getObject(3).toString
    )
    resultSet1.next()
    assertEquals("2018-10-09 07:30:01.0", resultSet1.getObject(1).toString)
    assertEquals("2018-10-09 07:30:15.0", resultSet1.getObject(2).toString)
    assertEquals(
      "[POINT (108.99546 34.26891), POINT (108.99546 34.26891), POINT (108.99546 34.26891), POINT (108.99546 34.26891), POINT (108.99546 34.26891), POINT (108.99546 34.26891)]",
      resultSet1.getObject(3).toString
    )
  }

  test("st_traj_noiseFilter_test1") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_noiseFilter(st_traj_fromGeoJSON(\'" + tGeo + "\')," + "1)"
      )
    resultSet.next()
    assertEquals(
      trajectory.getGPSPointList.subList(0, 1),
      Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList
    )
  }
  test("st_traj_noiseFilter_test2") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_noiseFilter(st_traj_fromGeoJSON(\'" + tGeo + "\')," + "8.5)"
      )
    resultSet.next()
    assertEquals(
      "[POINT (108.99553 34.27859), POINT (108.99655 34.25891), POINT (108.99657 34.25875), POINT (108.99655 34.25857), POINT (108.99654 34.25837), POINT (108.99652 34.25826), POINT (108.99647 34.25821), POINT (108.99639 34.25818), POINT (108.99624 34.25818), POINT (108.99598 34.25819), POINT (108.99433 34.25818), POINT (108.99391 34.25818), POINT (108.99337 34.25817), POINT (108.99312 34.25817), POINT (108.99287 34.25817), POINT (108.9926 34.25816), POINT (108.99245 34.25816), POINT (108.9923 34.25816), POINT (108.99205 34.25815)]",
      Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList.toString
    )
  }
  test("st_traj_noiseFilter_test3") {
    val statement = connect.createStatement()
    val resultSet =
      statement.executeQuery(
        "select st_traj_noiseFilter(st_traj_fromGeoJSON(\'" + tGeo + "\')," + "30)"
      )
    resultSet.next()
    val correctResult = trajectory.getGPSPointList
    correctResult.remove(64)
    assertEquals(
      correctResult,
      Trajectory.fromGeoJSON(resultSet.getObject(1).toString).getGPSPointList
    )
  }
}

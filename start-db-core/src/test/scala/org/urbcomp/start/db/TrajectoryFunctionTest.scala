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
import org.urbcomp.start.db.model.sample.ModelGenerator
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.TrajStringToList

import scala.collection.JavaConverters.seqAsJavaList
import scala.collection.JavaConverters._

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
        "select st_traj_timeIntervalSegment(st_traj_fromGeoJSON(\'" + tGeo + "\')," + 120 + ")"
      )
    resultSet.next()
    val subTrajStr = resultSet.getObject(1).toString
    val subTrajStream = TrajStringToList.stringToList(subTrajStr).asScala.toStream
    var totalSize = 0
    subTrajStream
      .map(x => {
        totalSize += Trajectory.fromGeoJSON(x).getGPSPointList.size()
      })
      .toList
    assertEquals(trajectory.getGPSPointList.size, totalSize)
  }
}

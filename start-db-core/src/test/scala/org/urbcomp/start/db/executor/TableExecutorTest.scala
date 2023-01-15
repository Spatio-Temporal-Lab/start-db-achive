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

package org.urbcomp.start.db.executor

import org.junit.Assert.{assertEquals, assertNotNull}
import org.urbcomp.start.db.AbstractCalciteFunctionTest
import org.urbcomp.start.db.model.sample.ModelGenerator
import org.urbcomp.start.db.model.trajectory.Trajectory

import scala.collection.mutable.ArrayBuffer

class TableExecutorTest extends AbstractCalciteFunctionTest {
  test("test create table") {
    val randomNum = scala.util.Random.nextInt(100000)
    val createTableSQL = s"""CREATE TABLE start_db_table_test_%d (
                                  |    idx Integer,
                                  |    ride_id String,
                                  |    started_at Timestamp,
                                  |    ended_at Timestamp,
                                  |    start_station_name String,
                                  |    start_station_id Double,
                                  |    start_point Point,
                                  |    end_station_name String,
                                  |    end_station_id Double,
                                  |    end_point Point,
                                  |    track LineString,
                                  |    member_casual String,
                                  |    tr Trajectory,
                                  |    rs RoadSegment,
                                  |    gm Geometry,
                                  |    rn RoadNetwork,
                                  |    bi Binary,
                                  |    mp MultiPoint,
                                  |    gc GeometryCollection,
                                  |    int_val int
                                  |);""".format(randomNum).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
  }

  test("test show tables") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("show tables")
    rs.next()
    assertNotNull(rs.getString(1))
  }

  test("test drop table") {
    val randomNum = scala.util.Random.nextInt(100000)
    val createTableSQL = s"""CREATE TABLE xxx_%d (
                            |    idx Integer,
                            |    ride_id String,
                            |    x1 String,
                            |    x2 String
                            |);""".format(randomNum).stripMargin
    val stmt = connect.createStatement()

    val rs1 = stmt.executeQuery("show tables")
    val tablesBefore = ArrayBuffer[String]()
    while (rs1.next()) {
      tablesBefore += rs1.getString(1)
    }

    stmt.executeUpdate(createTableSQL)

    val dropTableSQL = s"""DROP TABLE xxx_%d;""".format(randomNum).stripMargin
    stmt.executeUpdate(dropTableSQL)

    val rs2 = stmt.executeQuery("show tables")
    val tablesAfter = ArrayBuffer[String]()
    while (rs2.next()) {
      tablesAfter += rs2.getString(1)
    }

    assertEquals(tablesBefore.sorted, tablesAfter.sorted)
  }

  test("test drop table if exists") {
    val randomNum = scala.util.Random.nextInt(100000)
    val createTableSQL = s"""CREATE TABLE xxx_%d (
                            |    idx Integer,
                            |    ride_id String,
                            |    x1 String,
                            |    x2 String
                            |);""".format(randomNum).stripMargin
    val stmt = connect.createStatement()

    val rs1 = stmt.executeQuery("show tables")
    val tablesBefore = ArrayBuffer[String]()
    while (rs1.next()) {
      tablesBefore += rs1.getString(1)
    }

    stmt.executeUpdate(createTableSQL)

    val dropTableSQL = s"""DROP TABLE IF EXISTS xxx_%d;""".format(randomNum).stripMargin
    stmt.executeUpdate(dropTableSQL)

    val rs2 = stmt.executeQuery("show tables")
    val tablesAfter = ArrayBuffer[String]()
    while (rs2.next()) {
      tablesAfter += rs2.getString(1)
    }

    assertEquals(tablesBefore.sorted, tablesAfter.sorted)
  }

  test("test describe table") {
    val tableName = "test_describe_table_" + scala.util.Random.nextInt(Integer.MAX_VALUE)
    val createTableSQL = s"""CREATE TABLE $tableName (
                            |    tr Trajectory,
                            |    rs RoadSegment,
                            |    gm Geometry
                            |);""".stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rss = stmt.executeQuery(s"describe $tableName")
    var fields = List[String]()
    while (rss.next()) {
      fields = fields :+ s"${rss.getString(1)}:${rss.getString(2)}:${rss.getString(3)}"
    }
    assertEquals(3, fields.length)
  }

  test("test show create table") {
    val tableName = "test_show_create_table"
    val createTableSQL = s"""CREATE TABLE IF NOT EXISTS $tableName (
                            |    tr Trajectory,
                            |    rs RoadSegment,
                            |    gm Geometry
                            |);""".stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rss = stmt.executeQuery(s"show create table $tableName")
    if (!rss.next()) {
      throw new AssertionError("unexpected show create table no result");
    }
    val sql = rss.getString(2);
    assertEquals(
      "CREATE TABLE test_show_create_table (tr Trajectory, rs RoadSegment, gm Geometry)",
      sql
    )
  }

  test("test truncate table") {
    val trajectory: Trajectory = ModelGenerator.generateTrajectory()
    val tGeo: String = trajectory.toGeoJSON
    val randomNum = scala.util.Random.nextInt(100000)
    val tableName = "xxx_" + randomNum

    val createTableSQL = s"""CREATE TABLE %s (
                            |    idx Integer,
                            |    traj Trajectory
                            |);""".format(tableName).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    stmt.execute(
      "INSERT INTO " + tableName + " (idx, traj) values " + "(1, st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    val selectSQL = s"""SELECT * FROM xxx_%d;""".format(randomNum)
    val result1 = stmt.executeQuery(selectSQL)
    var resultSize1 = 0
    while (result1.next()) {
      resultSize1 = resultSize1 + 1
    }
    assertEquals(resultSize1, 1)

    val truncateTableSQL = s"""TRUNCATE TABLE xxx_%d;""".format(randomNum)
    stmt.executeUpdate(truncateTableSQL)
    stmt.execute(
      "INSERT INTO " + tableName + " (idx, traj) values " + "(1, st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    val result2 = stmt.executeQuery(selectSQL)
    var resultSize2 = 0
    while (result2.next()) {
      resultSize2 = resultSize2 + 1
    }
    assertEquals(resultSize2, 1)
  }
}

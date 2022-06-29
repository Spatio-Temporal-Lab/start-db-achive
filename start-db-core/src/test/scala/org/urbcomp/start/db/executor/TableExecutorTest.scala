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

package org.urbcomp.start.db.executor

import org.junit.Assert.{assertEquals, assertNotNull}
import org.urbcomp.start.db.AbstractCalciteFunctionTest

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
//    val randomNum = scala.util.Random.nextInt(100000)
    val randomNum = 8979
//    val createTableSQL = s"""CREATE TABLE xxx_%d (
//                            |    idx Integer,
//                            |    ride_id String,
//                            |    x1 String,
//                            |    x2 String
//                            |);""".format(randomNum).stripMargin
    val stmt = connect.createStatement()

//    val rs1 = stmt.executeQuery("show tables")
//    val tablesBefore = ArrayBuffer[String]()
//    while (rs1.next()) {
//      tablesBefore += rs1.getString(1)
//    }

//    stmt.executeUpdate(createTableSQL)

    val dropTableSQL = s"""DROP TABLE start_db_table_test_%d;""".format(randomNum).stripMargin
    stmt.executeUpdate(dropTableSQL)

//    val rs2 = stmt.executeQuery("show tables")
//    val tablesAfter = ArrayBuffer[String]()
//    while (rs2.next()) {
//      tablesAfter += rs2.getString(1)
//    }

//    assertEquals(tablesBefore.sorted, tablesAfter.sorted)
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
}

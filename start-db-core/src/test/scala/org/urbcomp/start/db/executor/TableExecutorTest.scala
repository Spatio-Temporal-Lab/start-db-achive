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

import org.urbcomp.start.db.AbstractCalciteFunctionTest

class TableExecutorTest extends AbstractCalciteFunctionTest {

  private val randomNum = scala.util.Random.nextInt(100000)
  private val CREATE_TABLE_EXAMPLE = s"""CREATE TABLE start_db_table_test_%d (
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

  test("test create table") {
    val stmt = connect.createStatement()
    stmt.executeUpdate(CREATE_TABLE_EXAMPLE)
  }
}

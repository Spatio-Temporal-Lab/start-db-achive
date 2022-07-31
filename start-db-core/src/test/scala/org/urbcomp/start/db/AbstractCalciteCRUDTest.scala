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

import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.sample.ModelGenerator
import org.urbcomp.start.db.model.trajectory.Trajectory

import java.sql.Statement

/**
  * test for DML & DQL
  * @author Wang Bohong
  * @Date 2022-07-22
  */
class AbstractCalciteCRUDTest extends AbstractCalciteFunctionTest {

  var statement: Statement = _

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rsGeoJson: String = rs.toGeoJSON

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    statement = connect.createStatement()
    statement.executeUpdate(
      "create table if not exists t_crud_test (idx Integer, rs RoadSegment, traj Trajectory)"
    )
  }

  override protected def afterAll(): Unit = {
    statement.execute("drop table if exists t_crud_test")
    super.afterAll()
  }
}

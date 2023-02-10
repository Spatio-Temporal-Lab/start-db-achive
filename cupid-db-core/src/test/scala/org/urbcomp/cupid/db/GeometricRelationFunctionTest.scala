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

/**
  * Geometry relation Function test
  *
  * @author XiangHe
  */
// TODO test the relation between linestring and polygon
class GeometricRelationFunctionTest extends AbstractCalciteFunctionTest {
  val nameArray: Array[String] = Array[String]("int", "str", "double", "point")
  val typeArray: Array[String] = Array[String]("Integer", "String", "Double", "Point")
  val trajectory: Trajectory =
    ModelGenerator.generateTrajectory(seqAsJavaList(nameArray), seqAsJavaList(typeArray))
  val tGeo: String = trajectory.toGeoJSON
  test("st_equals") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_equals(st_makePoint(1, 2), st_makePoint(2, 3)), " +
        "st_equals(st_makePoint(1, 2), st_makeBBox(1, 2, 3, 4))," +
        "st_equals(st_makeBBox(1, 2, 3, 4), st_makeBBox(1, 2, 3, 4))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
  }

  test("st_contains") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_contains(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_contains(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_contains(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))," +
        "st_contains(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_covers") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_covers(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_covers(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_covers(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))," +
        "st_covers(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_crosses") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_crosses(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_crosses(st_makeBBox(1, 1, 3, 2), st_makeBBox(2, 1, 4, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
  }

  test("st_disjoint") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_disjoint(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_disjoint(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_disjoint(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_disjoint(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_intersects") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_intersects(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_intersects(st_makeBBox(1, 1, 2, 2), st_makeBBox(0, 0, 2, 2))," +
        "st_intersects(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_intersects(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(true, resultSet.getObject(4))
  }

  test("st_touches") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_touches(st_makeBBox(0, 0, 4, 4), st_makePoint(1, 2))," +
        "st_touches(st_makeBBox(1, 1, 2, 2), st_makeBBox(2, 1, 3, 2))," +
        "st_touches(st_makeBBox(0, 0, 2, 2), st_makePoint(3, 3))," +
        "st_touches(st_makeBBox(0, 0, 2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(true, resultSet.getObject(4))
  }

  test("st_within") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_within(st_makePoint(1, 2), st_makeBBox(0, 0, 4, 4))," +
        "st_within(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_within(st_makePoint(2, 2), st_makeBBox(0, 0, 2, 2))," +
        "st_within(st_makePoint(3, 3), st_makeBBox(0, 0, 2, 2))"
    )
    resultSet.next()
    assertEquals(true, resultSet.getObject(1))
    assertEquals(true, resultSet.getObject(2))
    assertEquals(false, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_overlaps") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_overlaps(st_makePoint(1, 2), st_makeBBox(0, 0, 4, 4))," +
        "st_overlaps(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_overlaps(st_makeBBox(1, 1, 3, 3), st_makeBBox(2, 2, 4, 4))," +
        "st_overlaps(st_makePoint(2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals(false, resultSet.getObject(1))
    assertEquals(false, resultSet.getObject(2))
    assertEquals(true, resultSet.getObject(3))
    assertEquals(false, resultSet.getObject(4))
  }

  test("st_relate") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_relate(st_makePoint(1, 2), st_makeBBox(0, 0, 4, 4))," +
        "st_relate(st_makeBBox(1, 1, 2, 2), st_makeBBox(1, 1, 2, 2))," +
        "st_relate(st_makePoint(2, 2), st_makePoint(2, 2))"
    )
    resultSet.next()
    assertEquals("0FFFFF212", resultSet.getObject(1))
    assertEquals("2FFF1FFF2", resultSet.getObject(2))
    assertEquals("0FFFFFFF2", resultSet.getObject(3))
  }

  test("fibonacci") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select fibonacci(20)")
    resultSet.next()
    assertEquals(1L, resultSet.getObject(1))
    resultSet.next()
    assertEquals(1L, resultSet.getObject(1))
    resultSet.next()
    assertEquals(2L, resultSet.getObject(1))
    resultSet.next()
    assertEquals(3L, resultSet.getObject(1))
    resultSet.next()
    assertEquals(5L, resultSet.getObject(1))
    resultSet.next()
    assertEquals(8L, resultSet.getObject(1))
  }

  test("st_traj_stayPointDetect") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_traj_stayPointDetect(st_traj_fromGeoJSON(\'" + tGeo + "\'),10,10)"
    )
    resultSet.next()
    // FIXME timezone
    // assertEquals("2018-10-08 23:30:21.0", resultSet.getObject(1).toString)
    // assertEquals("2018-10-08 23:30:27.0", resultSet.getObject(2).toString)
    assertEquals(
      "[POINT (108.99549 34.26714), POINT (108.9955 34.26707), POINT (108.99549 34.26704)]",
      resultSet.getObject(3).toString
    )

  }

}

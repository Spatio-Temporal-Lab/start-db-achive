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
import org.urbcomp.start.db.model.roadnetwork.{RoadNetwork, RoadSegment}
import org.urbcomp.start.db.model.sample.ModelGenerator

/**
  * test for Insert
  * @author  WangBohong
  * @date    2022-06-08
  */
class InsertTest extends AbstractCalciteFunctionTest {

  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rsGeoJson: String = rs.toGeoJSON

  /**
    * test for insert
    */
  test("testInsert") {
    val statement = connect.createStatement()
    val set = statement.executeQuery("select count(1) from t_test")
    set.next()
    val valueBefore: Long = set.getObject(1).asInstanceOf[Long]
    statement.execute(
      "Insert into t_test (idx, ride_id, start_point) values (171, '05608CC867EBDF63', st_makePoint(2.1, 2))"
    )
    val set1 = statement.executeQuery("select count(1) from t_test")
    set1.next()
    val valueAfter: Long = set1.getObject(1).asInstanceOf[Long]
    assertEquals(1, valueAfter - valueBefore)
  }

  /**
    * test for roadsegment insert
    */
  test("roadsegment insert") {
    val statement = connect.createStatement()
    val rsBefore = statement.executeQuery("select count(1) from t_road_segment_test")
    rsBefore.next()
    val beforeValue = rsBefore.getObject(1).asInstanceOf[Long]
    val set = statement.execute(
      "insert into t_road_segment_test (a, b, c) values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
    )
    val rsAfter = statement.executeQuery("select count(1) from t_road_segment_test")
    rsAfter.next()
    val afterValue = rsAfter.getObject(1).asInstanceOf[Long]
    assertEquals(1, afterValue - beforeValue)
  }

  /**
    * test for multiple data insert (insert into t (a, b) values (1, 2), (3, 4);)
    */
  test("multiple data insert") {
    val statement = connect.createStatement()
    val set = statement.executeQuery("select count(1) from t_test")
    set.next()
    val valueBefore: Long = set.getObject(1).asInstanceOf[Long]
    statement.execute(
      "Insert into t_test (idx, ride_id, start_point) values (171, '05608CC867EBDF63', st_makePoint(2.1, 2)), (172, '05608CC867EBDF63', st_makePoint(4.1, 2))"
    )
    val set1 = statement.executeQuery("select count(1) from t_test")
    set1.next()
    val valueAfter: Long = set1.getObject(1).asInstanceOf[Long]
    assertEquals(2, valueAfter - valueBefore)
  }

  /**
   * test for insert (insert into t values (1, 2))
   */
  test("insert test (without target column)") {
    val statement = connect.createStatement()
    val rsBefore = statement.executeQuery("select count(1) from t_road_segment_test")
    rsBefore.next()
    val beforeValue = rsBefore.getObject(1).asInstanceOf[Long]
    val set = statement.execute(
      "insert into t_road_segment_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
    )
    val rsAfter = statement.executeQuery("select count(1) from t_road_segment_test")
    rsAfter.next()
    val afterValue = rsAfter.getObject(1).asInstanceOf[Long]
    assertEquals(1, afterValue - beforeValue)
  }

  /**
   * test for insert (insert into t values (1, 2), (3, 4))
   */
  test("multiple data insert test (without target column)") {
    val statement = connect.createStatement()
    val rsBefore = statement.executeQuery("select count(1) from t_road_segment_test")
    rsBefore.next()
    val beforeValue = rsBefore.getObject(1).asInstanceOf[Long]
    val set = statement.execute(
      "insert into t_road_segment_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_rs_fromGeoJSON(\'" + rsGeoJson + "\')), (3, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
    )
    val rsAfter = statement.executeQuery("select count(1) from t_road_segment_test")
    rsAfter.next()
    val afterValue = rsAfter.getObject(1).asInstanceOf[Long]
    assertEquals(2, afterValue - beforeValue)
  }

}

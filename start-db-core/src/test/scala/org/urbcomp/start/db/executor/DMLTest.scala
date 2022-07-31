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

import org.junit.Assert.assertEquals
import org.urbcomp.start.db.AbstractCalciteCRUDTest

/**
  * test for DML
  * @author Wang Bohong
  * @Date 2022-07-22
  */
class DMLTest extends AbstractCalciteCRUDTest {

  /**
    * insert one piece of data test and delete test
    */
  test("basic insert and delete") {
    // insert into t (a, b, c) values (1, 2, 3)
    val i1 = statement.executeUpdate(
      "insert into t_crud_test (idx, rs, traj) values (1, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    assertEquals(1, i1)
    // insert into t (a, b) values (1, 2)
    val i2 = statement.executeUpdate(
      "insert into t_crud_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    assertEquals(1, i2)
    val resultSet = statement.executeQuery("select count(1) from t_crud_test")
    resultSet.next()
    val cnt0 = resultSet.getObject(1)
    assertEquals(2L, cnt0)
    val i3 = statement.executeUpdate("delete from t_crud_test where idx = 1")
    assertEquals(1, i3)
    val i4 = statement.executeUpdate("delete from t_crud_test")
    assertEquals(1, i4)
    val resultSet1 = statement.executeQuery("select count(1) from t_crud_test")
    resultSet1.next()
    val cnt1 = resultSet1.getObject(1)
    assertEquals(0L, cnt1)
  }

  /**
    * insert multiple pieces of data test
    */
  test("multiple insert") {
    // insert into t (a, b, c) values (1, 2, 3), (4, 5, 6)
    val i1 = statement.executeUpdate(
      "insert into t_crud_test (idx, rs, traj) values (1, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))," +
        "(2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    assertEquals(2, i1)
    // insert into t (a, b) values (1, 2), (3, 4)
    val i2 = statement.executeUpdate(
      "insert into t_crud_test (idx, rs) values (3, st_rs_fromGeoJSON(\'" + rsGeoJson + "\')), (4, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
    )
    assertEquals(2, i2)
    val i3 = statement.executeUpdate("delete from t_crud_test where 1 = 1")
    assertEquals(4, i3)
  }

  /**
    * update data test
    */
  test("update test") {
    statement.executeUpdate(
      "insert into t_crud_test (idx, rs, traj) values (1, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    statement.executeUpdate(
      "insert into t_crud_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'), st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    val i1 = statement.executeUpdate("update t_crud_test set idx = 3 where idx = 1")
    assertEquals(1, i1)
    val resultSet0 = statement.executeQuery("select count(1) from t_crud_test where idx = 3")
    resultSet0.next()
    val cnt0 = resultSet0.getObject(1)
    assertEquals(1L, cnt0)
    val i2 = statement.executeUpdate("update t_crud_test set idx = 4 where 1 = 1")
    assertEquals(2, i2)
    val resultSet1 = statement.executeQuery("select count(1) from t_crud_test where idx = 4")
    resultSet1.next()
    val cnt1 = resultSet1.getObject(1)
    assertEquals(2L, cnt1)
  }
}

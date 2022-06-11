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

import org.geotools.data.DataStoreFinder
import org.junit.Assert.assertEquals
import org.locationtech.geomesa.utils.io.WithClose

import java.sql.DriverManager
import java.util
import java.util.Properties

/**
  * test for Insert
  * @author  WangBohong
  * @date    2022-06-08
  */
class InsertTest extends AbstractCalciteFunctionTest {

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

}

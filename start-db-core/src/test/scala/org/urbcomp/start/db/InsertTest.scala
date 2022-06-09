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
  test("testInsert") {
    val statement = connect.createStatement()
    // ToDO   返回值
//    statement.execute("Insert into t_test (idx, ride_id, start_point) values (156, '05608CC867EBDF63', st_makePoint(1.1, 2))")
  }

}

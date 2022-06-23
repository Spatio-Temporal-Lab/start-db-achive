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
import org.urbcomp.start.db.AbstractCalciteFunctionTest

/**
  * test for delete executor
  * @author Wang Bohong
  * @date 2022-06-21
  */
class DeleteTest extends AbstractCalciteFunctionTest {

  test("test for delete") {
    val statement = connect.createStatement()
    val set = statement.executeQuery("select count(1) from t_test")
    set.next()
    val valueBefore: Long = set.getObject(1).asInstanceOf[Long]
    val resultSet = statement.executeQuery("select max(idx) from t_test")
    resultSet.next()
    val maxIdx = resultSet.getObject(1)
    val id = maxIdx.asInstanceOf[Int] + 1
    statement.execute(
      s"Insert into t_test (idx, ride_id, start_point) values ($id, '05608CC867EBDF63', st_makePoint(2.1, 2))"
    )
    val setMid = statement.executeQuery("select count(1) from t_test")
    setMid.next()
    val valueMid = setMid.getObject(1).asInstanceOf[Long]
    // check insert
    assertEquals(valueMid - 1, valueBefore)
    statement.execute(s"Delete from t_test where idx = $id")
    val set1 = statement.executeQuery("select count(1) from t_test")
    set1.next()
    val valueAfter: Long = set1.getObject(1).asInstanceOf[Long]
    // check delete
    assertEquals(valueAfter, valueBefore)
  }
}

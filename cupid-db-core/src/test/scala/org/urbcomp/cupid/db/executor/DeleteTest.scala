/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.executor

import org.junit.Assert.assertEquals
import org.urbcomp.cupid.db.AbstractCalciteFunctionTest

/**
  * test for delete executor
  * @author Wang Bohong
  * @date 2022-06-21
  */
class DeleteTest extends AbstractCalciteFunctionTest {

  /**
    * test for delete
    */
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

  /**
    * test for delete filter (1 = 1 and no where condition)
    */
  test("test for filter") {
    val statement = connect.createStatement()
    statement.execute("create table if not exists t_test_delete (idx integer, name string)")
    statement.execute("insert into t_test_delete values (1, 'hate')")
    val set0 = statement.executeQuery("select count(1) from t_test_delete")
    set0.next()
    assertEquals(1L, set0.getObject(1))
    statement.execute("delete from t_test_delete")
    val set1 = statement.executeQuery("select count(1) from t_test_delete")
    set1.next()
    assertEquals(0L, set1.getObject(1))
    statement.execute("insert into t_test_delete values (1, 'hate')")
    statement.execute("delete from t_test_delete where 1 = 1")
    val set2 = statement.executeQuery("select count(1) from t_test_delete")
    set2.next()
    assertEquals(0L, set2.getObject(1))
  }
}

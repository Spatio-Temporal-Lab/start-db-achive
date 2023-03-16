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
package org.urbcomp.cupid.db

import org.junit.Assert.assertEquals

class UpdateTest extends AbstractCalciteFunctionTest {

  /**
    * test for update
    */
  test("update data") {
    val statement = connect.createStatement()
    val resultSet = statement.executeQuery("select max(idx) from t_test")
    resultSet.next()
    val maxIdx = resultSet.getObject(1)
    val id = maxIdx.asInstanceOf[Int] + 1
    statement.execute(
      s"Insert into t_test (idx, ride_id, start_point) values ($id, '05608CC867EBDF63', st_makePoint(2.1, 2))"
    )
    statement.execute(
      s"update default.t_test set ride_id = 'temp', start_point = st_makePoint(3.1, 2) where idx = $id"
    )
    val resultSet1 = statement.executeQuery(s"select ride_id from t_test where idx = $id")
    resultSet1.next()
    val value = resultSet1.getObject(1).asInstanceOf[String]
    assertEquals("temp", value)
  }

}

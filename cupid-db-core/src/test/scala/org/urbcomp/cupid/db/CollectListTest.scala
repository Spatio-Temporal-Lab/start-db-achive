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

import org.junit.Assert.{assertNull, assertTrue}
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

/**
  * Collect List Test
  *
  * @author Hang Wu
  * @date 2023-02-11
  */
class CollectListTest extends AbstractCalciteFunctionTest {

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON

  test("collect list test1") {
    val statement = connect.createStatement()
    statement.executeUpdate("DROP TABLE IF EXISTS list_test1")
    statement.executeUpdate("create table list_test1 (points point)")
    val resultSet =
      statement.executeQuery("select st_collect_list(points) from list_test1")
    resultSet.next()
    assertNull(resultSet.getObject(1))
    assertTrue(!resultSet.next())
  }

  test("collect list test2") {
    val statement = connect.createStatement()
    statement.executeUpdate("DROP TABLE IF EXISTS list_test2")
    statement.executeUpdate("create table list_test2 (points point)")
    statement.executeUpdate("insert into table list_test2 values (st_makePoint(1, 2))")
    statement.executeUpdate("insert into table list_test2 values (st_makePoint(3, 4))")
    statement.executeUpdate("insert into table list_test2 values (st_makePoint(5.5, 6))")
    val resultSet =
      statement.executeQuery("select st_collect_list(points) from list_test2")
    resultSet.next()
    val collectListResult =
      resultSet.getObject(1).asInstanceOf[org.apache.calcite.avatica.util.ArrayImpl]
    assertTrue(collectListResult.getArray.asInstanceOf[Array[Object]].length == 3)
  }
}

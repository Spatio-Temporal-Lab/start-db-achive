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

import org.junit.Assert.{assertEquals, assertTrue}
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.sample.ModelGenerator

/**
  * test for RoadSegmentQuery
  *
  * @author WangBohongd
  * @date 2022-06-16
  */
class RoadSegmentQueryTest extends AbstractCalciteFunctionTest {

  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rsGeoJson: String = rs.toGeoJSON

  test("basic roadSegment query") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("select count(1) from t_road_segment_test")
    assertTrue(rs.next())
  }

  /**
    * test for roadSegment type
    */
  test("roadSegment query") {
    val statement = connect.createStatement()
    statement.execute("create table if not exists t_road_segment_test (a Integer, b RoadSegment);")
    val set = statement.executeQuery("select count(1) from t_road_segment_test")
    set.next()
    val count = set.getObject(1)
    if (count == 0) {
      statement.execute(
        "insert into t_road_segment_test values (2, st_rs_fromGeoJSON(\'" + rsGeoJson + "\'))"
      )
    }
    val rs = statement.executeQuery("select * from t_road_segment_test")
    while (rs.next()) {
      assertEquals(classOf[RoadSegment], rs.getObject(2).getClass)
    }
  }

  test("0626Test") {}
}

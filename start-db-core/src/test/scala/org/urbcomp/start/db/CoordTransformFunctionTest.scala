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

class CoordTransformFunctionTest extends AbstractCalciteFunctionTest {

  test("st_BD09ToWGS84(point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_BD09ToWGS84(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (0.9935048779206697 1.9940125213262534)", resultSet.getObject(1).toString)
  }

  test("st_BD09ToWGS84(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "LINESTRING (-0.0065045583144138 -0.0060041736071982," +
        " 0.9934856269655111 0.9939867065696584, 0.9935048779206697 1.9940125213262534)",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToWGS84(polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((0.9934856269655111 0.9939867065696584, 4.993478545947438 0.9940075719704773," +
        " 4.993498070025277 4.994020854679671, 0.9934998808909472 4.994013668556448," +
        " 0.9934856269655111 0.9939867065696584), (1.9935049129738731 1.9940140117465595," +
        " 1.9934965952780361 2.9940096919432193, 2.993512836601552 2.9939959051089304," +
        " 2.9935167767580073 1.9939989536125435, 1.9935049129738731 1.9940140117465595))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToWGS84(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((2.9934995619203466 3.993975880501857, 0.9934998808909472 4.994013668556448," +
        " 1.9934935689438622 4.994016976565128), (-5.006485250634924 -8.00598615029063, " +
        "-10.006466461068063 -8.006010605327319, -15.00652425844692 -4.005961014330163))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToWGS84(mPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((0.9934856269655111 0.9939867065696584, 4.993478545947438 0.9940075719704773," +
        " 4.993498070025277 4.994020854679671, 0.9934998808909472 4.994013668556448," +
        " 0.9934856269655111 0.9939867065696584), (1.9935049129738731 1.9940140117465595," +
        " 1.9934965952780361 2.9940096919432193, 2.993512836601552 2.9939959051089304," +
        " 2.9935167767580073 1.9939989536125435, 1.9935049129738731 1.9940140117465595))," +
        " ((5.993513995668118 2.9939858127094454, 8.993518704186377 1.9939774638055094," +
        " 8.993493415525771 3.993966626993571, 5.993513995668118 2.9939858127094454)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_WGS84ToBD09(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1.006495254008945 2.005983008075984)", resultSet.getObject(1).toString)
  }

}

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
import org.urbcomp.cupid.db.model.roadnetwork.{RoadNetwork, RoadSegment}
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

class CoordTransformFunctionTest extends AbstractCalciteFunctionTest {

  val trajectory: Trajectory = ModelGenerator.generateTrajectory()
  val tGeo: String = trajectory.toGeoJSON
  val rs: RoadSegment = ModelGenerator.generateRoadSegment()
  val rn: RoadNetwork = ModelGenerator.generateRoadNetwork()
  val rsGeoJson: String = rs.toGeoJSON

  test("st_BD09ToWGS84(Point)") {
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

  test("st_BD09ToWGS84(Polygon)") {
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

  test("st_BD09ToWGS84(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BD09ToWGS84(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534), (2.9934995619203466 3.993975880501857))",
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

  test("st_BD09ToWGS84(MPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))" +
        ",((6 3,9 2,9 4,6 3)))'))"
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

  test("st_BD09ToWGS84(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BD09ToWGS84(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534)," +
        " (2.9934995619203466 3.993975880501857))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToWGS84(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToWGS84(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534), " +
        "(2.9934995619203466 3.993975880501857))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(Point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_WGS84ToBD09(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1.006495254008945 2.005983008075984)", resultSet.getObject(1).toString)
  }

  test("st_WGS84ToBD09(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToBD09(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "LINESTRING (0.0065 0.006, 1.0065137474659602 1.0060107474292177," +
        " 1.006495254008945 2.005983008075984)",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(Polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToBD09(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((1.0065137474659602 1.0060107474292177, 5.006518484154982 1.0059958968045013," +
        " 5.00649525252729 5.005980252564032, 1.006504103142296 5.005981515843958, " +
        "1.0065137474659602 1.0060107474292177), (2.006490752530665 2.005984752567407," +
        " 2.00650449999775 3.0059969999966243, 3.0064909999865 3.0060089999864994, 3.0064795884814806" +
        " 2.0059993922585364, 2.006490752530665 2.005984752567407))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_WGS84ToBD09(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), " +
        "(3.0064983922497763 4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToBD09(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3.0064983922497763 4.006022856419637, 1.006504103142296" +
        " 5.005981515843958, 2.0065010672984185 5.005980918316001), (-4.993521179867331 -7.994007187738699," +
        " -9.9935255250495 -7.993995820006325, -14.993471264265814 -3.9940405370837717))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(MultiPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToBD09(st_mPolygonFromWKT(" +
        "'MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1.0065137474659602 1.0060107474292177, 5.006518484154982" +
        " 1.0059958968045013, 5.00649525252729 5.005980252564032, 1.006504103142296 5.005981515843958, " +
        "1.0065137474659602 1.0060107474292177), (2.006490752530665 2.005984752567407, 2.00650449999775" +
        " 3.0059969999966243, 3.0064909999865 3.0060089999864994, 3.0064795884814806 2.0059993922585364," +
        " 2.006490752530665 2.005984752567407)), ((6.006490999973001 3.0060179999864993, 9.006477091914913" +
        " 2.0060232425945292, 9.006503827618703 4.006034034554063, 6.006490999973001 3.0060179999864993)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_WGS84ToBD09(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), (3.0064983922497763 " +
        "4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToBD09(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToBD09(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), (3.0064983922497763 " +
        "4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(Point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_GCJ02ToBD09(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1.006495254008945 2.005983008075984)", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToBD09(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToBD09(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "LINESTRING (0.0065 0.006, 1.0065137474659602 1.0060107474292177, " +
        "1.006495254008945 2.005983008075984)",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(Polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToBD09(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((1.0065137474659602 1.0060107474292177, 5.006518484154982 1.0059958968045013," +
        " 5.00649525252729 5.005980252564032, 1.006504103142296 5.005981515843958, 1.0065137474659602" +
        " 1.0060107474292177), (2.006490752530665 2.005984752567407, 2.00650449999775 3.0059969999966243," +
        " 3.0064909999865 3.0060089999864994, 3.0064795884814806 2.0059993922585364, 2.006490752530665" +
        " 2.005984752567407))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_GCJ02ToBD09(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), (3.0064983922497763" +
        " 4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToBD09(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3.0064983922497763 4.006022856419637, 1.006504103142296" +
        " 5.005981515843958, 2.0065010672984185 5.005980918316001), (-4.993521179867331 -7.994007187738699," +
        " -9.9935255250495 -7.993995820006325, -14.993471264265814 -3.9940405370837717))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(MultiPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToBD09(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))," +
        "((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1.0065137474659602 1.0060107474292177, 5.006518484154982 " +
        "1.0059958968045013, 5.00649525252729 5.005980252564032, 1.006504103142296 5.005981515843958," +
        " 1.0065137474659602 1.0060107474292177), (2.006490752530665 2.005984752567407, 2.00650449999775" +
        " 3.0059969999966243, 3.0064909999865 3.0060089999864994, 3.0064795884814806 2.0059993922585364," +
        " 2.006490752530665 2.005984752567407)), ((6.006490999973001 3.0060179999864993, 9.006477091914913" +
        " 2.0060232425945292, 9.006503827618703 4.006034034554063, 6.006490999973001 3.0060179999864993)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_GCJ02ToBD09(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), (3.0064983922497763 " +
        "4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToBD09(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToBD09(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((1.006495254008945 2.005983008075984), (3.0064983922497763 4.006022856419637))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(Point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_BD09ToGCJ02(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (0.9935048779206697 1.9940125213262534)", resultSet.getObject(1).toString)
  }

  test("st_BD09ToGCJ02(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToGCJ02(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "LINESTRING (-0.0065045583144138 -0.0060041736071982, 0.9934856269655111 0.9939867065696584," +
        " 0.9935048779206697 1.9940125213262534)",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(Polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToGCJ02(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((0.9934856269655111 0.9939867065696584, 4.993478545947438 0.9940075719704773, " +
        "4.993498070025277 4.994020854679671, 0.9934998808909472 4.994013668556448, 0.9934856269655111 " +
        "0.9939867065696584), (1.9935049129738731 1.9940140117465595, 1.9934965952780361 2.9940096919432193, " +
        "2.993512836601552 2.9939959051089304, 2.9935167767580073 1.9939989536125435, 1.9935049129738731 " +
        "1.9940140117465595))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BD09ToGCJ02(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534), (2.9934995619203466 3.993975880501857))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToGCJ02(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((2.9934995619203466 3.993975880501857, 0.9934998808909472 4.994013668556448, " +
        "1.9934935689438622 4.994016976565128), (-5.006485250634924 -8.00598615029063, -10.006466461068063 " +
        "-8.006010605327319, -15.00652425844692 -4.005961014330163))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(MultiPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToGCJ02(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))," +
        "((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((0.9934856269655111 0.9939867065696584, 4.993478545947438 0.9940075719704773, " +
        "4.993498070025277 4.994020854679671, 0.9934998808909472 4.994013668556448, 0.9934856269655111 " +
        "0.9939867065696584), (1.9935049129738731 1.9940140117465595, 1.9934965952780361 2.9940096919432193, " +
        "2.993512836601552 2.9939959051089304, 2.9935167767580073 1.9939989536125435, 1.9935049129738731 " +
        "1.9940140117465595)), ((5.993513995668118 2.9939858127094454, 8.993518704186377 1.9939774638055094, " +
        "8.993493415525771 3.993966626993571, 5.993513995668118 2.9939858127094454)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_BD09ToGCJ02(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534), (2.9934995619203466 3.993975880501857))",
      resultSet.getObject(1).toString
    )
  }

  test("st_BD09ToGCJ02(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_BD09ToGCJ02(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOINT ((0.9935048779206697 1.9940125213262534), (2.9934995619203466 3.993975880501857))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToGCJ02(Point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_WGS84ToGCJ02(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_WGS84ToGCJ02(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToGCJ02(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
  }

  test("st_WGS84ToGCJ02(Polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToGCJ02(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToGCJ02(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_WGS84ToGCJ02(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }

  test("st_WGS84ToGCJ02(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToGCJ02(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToGCJ02(MultiPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToGCJ02(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))," +
        "((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_WGS84ToGCJ02(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_WGS84ToGCJ02(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }

  test("st_WGS84ToGCJ02(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_WGS84ToGCJ02(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToWGS84(Point)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_GCJ02ToWGS84(st_makePoint(1, 2))")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToWGS84(LineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToWGS84(st_lineStringFromWKT('LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals("LINESTRING (0 0, 1 1, 1 2)", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToWGS84(Polygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToWGS84(st_polygonFromWKT('POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))'))"
    )
    resultSet.next()
    assertEquals(
      "POLYGON ((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToWGS84(MultiPoint)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_GCJ02ToWGS84(st_mPointFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToWGS84(MultiLineString)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToWGS84(st_mLineStringFromWKT('MULTILINESTRING((3 4,1 5,2 5),(-5 -8,-10 -8,-15 -4))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTILINESTRING ((3 4, 1 5, 2 5), (-5 -8, -10 -8, -15 -4))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToWGS84(MultiPolygon)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToWGS84(st_mPolygonFromWKT('MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2))," +
        "((6 3,9 2,9 4,6 3)))'))"
    )
    resultSet.next()
    assertEquals(
      "MULTIPOLYGON (((1 1, 5 1, 5 5, 1 5, 1 1), (2 2, 2 3, 3 3, 3 2, 2 2)), ((6 3, 9 2, 9 4, 6 3)))",
      resultSet.getObject(1).toString
    )
  }

  test("st_GCJ02ToWGS84(Geometry)") {
    val statement = connect.createStatement
    val resultSet =
      statement.executeQuery("select st_GCJ02ToWGS84(st_geomFromWKT('MULTIPOINT((1 2),(3 4))'))")
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }

  test("st_GCJ02ToWGS84(GeometryCollection)") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery(
      "select st_GCJ02ToWGS84(st_geomFromWKT(" +
        "'MULTIPOINT((1 2),(3 4)),LINESTRING(0 0,1 1,1 2)'))"
    )
    resultSet.next()
    assertEquals("MULTIPOINT ((1 2), (3 4))", resultSet.getObject(1).toString)
  }
}

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

import org.junit.Assert.{assertEquals, assertFalse, assertNotNull, assertNull, assertTrue}
import org.urbcomp.cupid.db.AbstractCalciteFunctionTest
import org.urbcomp.cupid.db.model.sample.ModelGenerator
import org.urbcomp.cupid.db.model.trajectory.Trajectory

import java.util.UUID
import scala.collection.mutable.ArrayBuffer

class TableExecutorTest extends AbstractCalciteFunctionTest {

  private def generateUniqueId(): String = {
    UUID.randomUUID().toString.replace("-", "_")
  }

  test("test create table") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE start_db_table_test_%s (
                                  |    idx Integer,
                                  |    ride_id String,
                                  |    started_at Timestamp,
                                  |    ended_at Timestamp,
                                  |    start_station_name String,
                                  |    start_station_id Double,
                                  |    start_point Point,
                                  |    end_station_name String,
                                  |    end_station_id Double,
                                  |    end_point Point,
                                  |    track LineString,
                                  |    member_casual String,
                                  |    tr Trajectory,
                                  |    rs RoadSegment,
                                  |    gm Geometry,
                                  |    rn RoadNetwork,
                                  |    bi Binary,
                                  |    mp MultiPoint,
                                  |    gc GeometryCollection,
                                  |    int_val int
                                  |);""".format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
  }

  test("test create table with index") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE gemo_%s (
                            |    name String,
                            |    st Point,
                            |    et Point,
                            |    dtg Datetime,
                            |    SPATIAL INDEX (st, dtg),
                            |    SPATIAL INDEX spatial_index(et, dtg)
                            |)""".stripMargin.format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
  }

  test("test create table with specify concrete index type") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE gemo_%s (
                            |    name String,
                            |    st Point,
                            |    dtg Datetime,
                            |    SPATIAL INDEX spatial_index2(st, dtg) type z3
                            |)""".stripMargin.format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rs = stmt.executeQuery("""show index from gemo_%s""".format(uniqueId))
    rs.next()
    assertEquals(rs.getString(3), "z3")
  }

  test("test create table with invalid index type will throw error") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE gemo_%s (
                            |    name String,
                            |    st Point,
                            |    dtg Datetime,
                            |    SPATIAL INDEX spatial_index2(st, dtg) type nonsense
                            |)""".stripMargin.format(uniqueId).stripMargin

    val stmt = connect.createStatement()
    val thrown = intercept[Exception] {
      stmt.executeUpdate(createTableSQL)
    }
    assertTrue(thrown.getMessage.contains("nonsense:st:dtg"))
    assertTrue(thrown.getMessage.contains("does not support"))
  }

  test("test create table with attribute secondary temporal/Z2/Z3 index") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE gemo_%s (
                            |    name String,
                            |    st Point,
                            |    et Point,
                            |    dtg Datetime,
                            |    ATTRIBUTE INDEX attribute_temporal_index(name, dtg),
                            |    ATTRIBUTE INDEX attribute_z2_index(name, st),
                            |    ATTRIBUTE INDEX attribute_z3_index(name, st, dtg)
                            |)""".stripMargin.format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
  }

  test("test create table with single string column") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE gemo_%s (
                            |    name String
                            |)""".stripMargin.format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rs = stmt.executeQuery("""show index from gemo_%s""".format(uniqueId))
    // we have no way to get geomesa inner id attribute so no index recorded
    assertFalse(rs.next())
  }

  test("test create then insert") {
    val randomId = scala.util.Random.nextInt(Integer.MAX_VALUE)
    val tableName = "test_create_insert_%d".format(randomId)
    val stmt = connect.createStatement()
    stmt.execute("create table %s (tid integer, name string)".format(tableName))
    stmt.execute("insert into %s values (1, 'tmp')".format(tableName))
  }

  test("test show tables") {
    val stmt = connect.createStatement()
    val rs = stmt.executeQuery("show tables")
    rs.next()
    assertNotNull(rs.getString(1))
  }

  test("test show index") {
    val uniqueId = generateUniqueId()
    val createTableSQL =
      s"""CREATE TABLE gemo_%s (
         |    name String,
         |    st Point,
         |    et Point,
         |    dtg Datetime,
         |    SPATIAL INDEX spatial_index(et, dtg)
         |)""".stripMargin.format(uniqueId).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rs = stmt.executeQuery("""show index from gemo_%s""".format(uniqueId))
    rs.next()
    assertEquals(rs.getString(1), "gemo_%s".format(uniqueId))
    assertEquals(rs.getString(2), "et,dtg")
    assertEquals(rs.getString(3), "z3")
  }

  test("test drop table") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE xxx_%s (
                            |    idx Integer,
                            |    ride_id String,
                            |    x1 String,
                            |    x2 String
                            |);""".format(uniqueId).stripMargin
    val stmt = connect.createStatement()

    val rs1 = stmt.executeQuery("show tables")
    val tablesBefore = ArrayBuffer[String]()
    while (rs1.next()) {
      tablesBefore += rs1.getString(1)
    }

    stmt.executeUpdate(createTableSQL)

    val dropTableSQL = s"""DROP TABLE xxx_%s;""".format(uniqueId).stripMargin
    stmt.executeUpdate(dropTableSQL)

    val rs2 = stmt.executeQuery("show tables")
    val tablesAfter = ArrayBuffer[String]()
    while (rs2.next()) {
      tablesAfter += rs2.getString(1)
    }

    assertEquals(tablesBefore.sorted, tablesAfter.sorted)
  }

  test("test drop table if exists") {
    val uniqueId = generateUniqueId()
    val createTableSQL = s"""CREATE TABLE xxx_%s (
                            |    idx Integer,
                            |    ride_id String,
                            |    x1 String,
                            |    x2 String
                            |);""".format(uniqueId).stripMargin
    val stmt = connect.createStatement()

    val rs1 = stmt.executeQuery("show tables")
    val tablesBefore = ArrayBuffer[String]()
    while (rs1.next()) {
      tablesBefore += rs1.getString(1)
    }

    stmt.executeUpdate(createTableSQL)

    val dropTableSQL = s"""DROP TABLE IF EXISTS xxx_%s;""".format(uniqueId).stripMargin
    stmt.executeUpdate(dropTableSQL)

    val rs2 = stmt.executeQuery("show tables")
    val tablesAfter = ArrayBuffer[String]()
    while (rs2.next()) {
      tablesAfter += rs2.getString(1)
    }

    assertEquals(tablesBefore.sorted, tablesAfter.sorted)
  }

  test("test describe table") {
    val tableName = "test_describe_table_" + generateUniqueId()
    val createTableSQL = s"""CREATE TABLE $tableName (
                            |    tr Trajectory,
                            |    rs RoadSegment,
                            |    gm Geometry
                            |);""".stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rss = stmt.executeQuery("describe %s".format(tableName))
    var fields = List[String]()
    while (rss.next()) {
      fields = fields :+ s"${rss.getString(1)}:${rss.getString(2)}:${rss.getString(3)}"
    }
    assertEquals(3, fields.length)
  }

  test("test show create table") {
    val tableName = "test_show_create_table"
    val createTableSQL = s"""CREATE TABLE IF NOT EXISTS $tableName (
                            |    tr Trajectory,
                            |    rs RoadSegment,
                            |    gm Geometry
                            |);""".stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    val rss = stmt.executeQuery("show create table %s".format(tableName))
    if (!rss.next()) {
      throw new AssertionError("unexpected show create table no result")
    }
    val sql = rss.getString(2)
    assertEquals(
      "CREATE TABLE test_show_create_table (tr Trajectory, rs RoadSegment, gm Geometry)",
      sql
    )
  }

  test("test truncate table") {
    val trajectory: Trajectory = ModelGenerator.generateTrajectory()
    val tGeo: String = trajectory.toGeoJSON
    val uniqueId = generateUniqueId()
    val tableName = "xxx_" + uniqueId

    val createTableSQL = s"""CREATE TABLE %s (
                            |    idx Integer,
                            |    traj Trajectory
                            |);""".format(tableName).stripMargin
    val stmt = connect.createStatement()
    stmt.executeUpdate(createTableSQL)
    stmt.execute(
      "INSERT INTO " + tableName + " (idx, traj) values " + "(1, st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    val selectSQL = s"""SELECT * FROM xxx_%s;""".format(uniqueId)
    val result1 = stmt.executeQuery(selectSQL)
    var resultSize1 = 0
    while (result1.next()) {
      resultSize1 = resultSize1 + 1
    }
    assertEquals(resultSize1, 1)

    val truncateTableSQL = s"""TRUNCATE TABLE xxx_%s;""".format(uniqueId)
    stmt.executeUpdate(truncateTableSQL)
    stmt.execute(
      "INSERT INTO " + tableName + " (idx, traj) values " + "(1, st_traj_fromGeoJSON(\'" + tGeo + "\'))"
    )
    val result2 = stmt.executeQuery(selectSQL)
    var resultSize2 = 0
    while (result2.next()) {
      resultSize2 = resultSize2 + 1
    }
    assertEquals(resultSize2, 1)
  }
}

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

package org.urbcomp.start.db.parser.visitor
import org.apache.calcite.sql.ddl.{SqlCreateSchema, SqlDropSchema, SqlDropTable}
import org.apache.calcite.sql.parser.SqlParser
import org.apache.calcite.sql.{SqlKind, SqlNode}
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.scalatest.FunSuite
import org.urbcomp.start.db.parser.StartDBSQLSamples
import org.urbcomp.start.db.parser.ddl.SqlUseDatabase
import org.urbcomp.start.db.parser.dql.{SqlShowDatabases, SqlShowTables}
import org.urbcomp.start.db.parser.driver.StartDBParseDriver
import org.urbcomp.start.db.util.MetadataUtil

class StartDBVisitorTest extends FunSuite {

  def driver = StartDBParseDriver

  def testUser = "start_db";
  def testDatabase = "db_test";
  def tableName = "table_name";

  def calciteParse(sql: String): SqlNode = {
    val parser = SqlParser.create(sql);
    parser.parseQuery();
  }

  test("convert show databases to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.SHOW_DATABASES)
    assertTrue(parsed.isInstanceOf[SqlShowDatabases])
  }

  test("convert show tables to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.SHOW_TABLES)
    assertTrue(parsed.isInstanceOf[SqlShowTables])
    val node = parsed.asInstanceOf[SqlShowTables];
    assertEquals(MetadataUtil.combineUserDbKey(testUser, testDatabase), node.fullDatabaseName())
  }

  test("convert create dababase statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.CREATE_DATABASE_SAMPLE)
    val node = parsed.asInstanceOf[SqlCreateSchema]
    assertEquals(SqlKind.CREATE_SCHEMA, node.getKind)
    assertEquals("database_name", node.name.names.get(0))
    assertFalse(node.ifNotExists)
  }

  test("convert use dababase statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.USE_DATABSE_SAMPLE)
    val node = parsed.asInstanceOf[SqlUseDatabase]
    assertEquals("database_name", node.getFullDatabaseName);
  }

  test("convert create dababase if not exists statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.CREATE_DATABASE_IF_NOT_EXISTS_SAMPLE)
    val node = parsed.asInstanceOf[SqlCreateSchema]
    assertEquals(SqlKind.CREATE_SCHEMA, node.getKind)
    assertEquals("database_name", node.name.names.get(0))
    assertTrue(node.ifNotExists);
  }

  test("convert drop dababase statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.DROP_DATABASE_SAMPLE)
    val node = parsed.asInstanceOf[SqlDropSchema]
    assertEquals(SqlKind.DROP_SCHEMA, node.getKind)
    assertEquals("database_name", node.name.names.get(0))
  }

  test("convert drop table statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.DROP_TABLE_IF_EXISTS_SAMPLE)
    val node = parsed.asInstanceOf[SqlDropTable]
    println(node.toString);
    assertEquals(SqlKind.DROP_TABLE, node.getKind)
    assertEquals(
      MetadataUtil.combineUserDbTableKey(testUser, testDatabase, tableName),
      node.name.names.get(0)
    );
  }
}

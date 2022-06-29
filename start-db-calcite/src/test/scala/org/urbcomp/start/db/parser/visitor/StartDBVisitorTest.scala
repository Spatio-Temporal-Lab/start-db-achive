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
import org.apache.calcite.sql._
import org.apache.calcite.sql.ddl.{SqlCreateTable, SqlDropSchema, SqlDropTable}
import org.apache.calcite.sql.parser.SqlParser
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.scalatest.FunSuite
import org.urbcomp.start.db.parser.StartDBSQLSamples
import org.urbcomp.start.db.parser.dcl.SqlCreateUser
import org.urbcomp.start.db.parser.ddl.{SqlCreateDatabase, SqlTruncateTable, SqlUseDatabase}
import org.urbcomp.start.db.parser.dql.{SqlShowCreateTable, SqlShowDatabases, SqlShowTables}
import org.urbcomp.start.db.parser.driver.StartDBParseDriver
import org.urbcomp.start.db.util.MetadataUtil

class StartDBVisitorTest extends FunSuite {

  def driver = StartDBParseDriver

  def testUser = "start_db";
  def testDatabase = "default";
  def tableName = "table_name";

  def calciteParse(sql: String): SqlNode = {
    val parser = SqlParser.create(sql);
    parser.parseStmt();
  }

  test("convert show databases to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.SHOW_DATABASES)
    assertTrue(parsed.isInstanceOf[SqlShowDatabases])
  }

  test("convert describe statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.DESCRIBE_TABLE_SAMPLE)
    assertTrue(parsed.isInstanceOf[SqlDescribeTable])
  }

  test("convert truncate table statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.TRUNCATE_TABLE_SAMPLE)
    assertTrue(parsed.isInstanceOf[SqlTruncateTable])
  }

  test("convert show tables to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.SHOW_TABLES)
    assertTrue(parsed.isInstanceOf[SqlShowTables])
    val node = parsed.asInstanceOf[SqlShowTables];
    assertEquals(MetadataUtil.combineUserDbKey(testUser, testDatabase), node.fullDatabaseName())
  }

  test("convert create dababase statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.CREATE_DATABASE_SAMPLE)
    val node = parsed.asInstanceOf[SqlCreateDatabase]
    assertEquals("database_name", node.getDatabaseName.names.get(0))
    assertFalse(node.ifNotExists)
  }

  test("convert use dababase statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.USE_DATABASE_SAMPLE)
    val node = parsed.asInstanceOf[SqlUseDatabase]
    assertEquals("database_name", node.getFullDatabaseName);
  }

  test("convert create dababase if not exists statement to SqlNode") {
    val parsed = driver.parseSql(StartDBSQLSamples.CREATE_DATABASE_IF_NOT_EXISTS_SAMPLE)
    val node = parsed.asInstanceOf[SqlCreateDatabase]
    assertEquals("database_name", node.getDatabaseName.names.get(0))
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
    assertEquals(SqlKind.DROP_TABLE, node.getKind)
    assertEquals(tableName, node.name.names.get(0))
  }

  test("convert delete statement to SqlNode") {
    val sql = StartDBSQLSamples.DELETE_SAMPLE
    val parsed = driver.parseSql(sql)
    val node = parsed.asInstanceOf[SqlDelete]
    val cond = node.getCondition.asInstanceOf[SqlBasicCall]
    assertEquals(SqlKind.EQUALS, cond.getKind)
    assertEquals(2, cond.getOperands.length)
  }

  test("convert show create table statement to SqlNode") {
    val sql = StartDBSQLSamples.SHOW_CREATE_TABLE_SAMPLE
    val parsed = driver.parseSql(sql)
    val node = parsed.asInstanceOf[SqlShowCreateTable]
    assertEquals(tableName, node.getTableName.names.get(0));
  }

  test("convert create table statement to SqlNode") {
    val sql = StartDBSQLSamples.CREATE_TABLE_SAMPLE
    val parsed = driver.parseSql(sql)
    val node = parsed.asInstanceOf[SqlCreateTable]
    assertEquals("start_default_table", node.name.names.get(0))
    assertEquals(12, node.columnList.size())
  }

  test("convert update table statement to SqlNode") {
    val sql = StartDBSQLSamples.UPDATE_SAMPLE;
    val parser = SqlParser.create(sql);
    val calciteNode = parser.parseStmt().asInstanceOf[SqlUpdate];
    val parsed = driver.parseSql(sql);
    val node = parsed.asInstanceOf[SqlUpdate];
    assertEquals(calciteNode.getTargetColumnList.size(), node.getTargetColumnList.size());
    assertEquals(calciteNode.getSourceExpressionList.size(), node.getSourceExpressionList.size());
  }

  test("convert create user statement to SqlNode") {
    val sql = StartDBSQLSamples.CREATE_USER_SAMPLE;
    val parsed = driver.parseSql(sql)
    val node = parsed.asInstanceOf[SqlCreateUser]
    assertEquals("test_user", node.getUserName.names.get(0));
    assertEquals("password", node.getPassword)
  }

}

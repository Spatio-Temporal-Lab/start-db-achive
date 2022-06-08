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

import org.apache.calcite.sql.{SqlBasicCall, SqlIdentifier, SqlInsert}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.infra.BaseExecutor

import java.sql.{DriverManager, ResultSet}
import java.util
import java.util.Properties

/**
  * @author zaiyuan
  * @param n
  */
case class InsertExecutor(n: SqlInsert) extends BaseExecutor {

  override def execute(): Unit = {
    // extract database name and table name
    val userName = ""
    val envDbName = ""
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(2), targetTable.names.get(2))
      case 1 =>
        (envDbName, targetTable.names.get(2))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }

    // TODO validate metadata

    // construct sql
    val resultObjs: Array[util.ArrayList[AnyRef]] =
      n.getSource
        .asInstanceOf[SqlBasicCall] // Values level
        .operands
        .map { i => // Row level
          val queryItem = i
            .asInstanceOf[SqlBasicCall]
            .operands
            .map(j => j.toString) // TODO nee test
            .mkString(" , ")
          val querySql =
            s"""
             |SELECT $queryItem
             |""".stripMargin
          val rs = executeQuery(userName, dbName, querySql)
          val count = rs.getMetaData.getColumnCount
          val result = new util.ArrayList[AnyRef](count)
          for (x <- 1 until count) {
            result.add(rs.getObject(x))
          }
          result
        }

    // insert data
    val dataStore = DataStoreFinder.getDataStore(new util.HashMap[String, String]())
    WithClose(dataStore.getFeatureWriterAppend(tableName, Transaction.AUTO_COMMIT)) { writer =>
      resultObjs.foreach { i =>
        val sf = writer.next()
        val count = i.size()
        for (x <- 1 until count) {
          sf.setAttribute(n.getTargetColumnList.get(x).toString, i.get(x))
        }
        writer.write()
      }
    }
    dataStore.dispose()
  }

  def executeQuery[R](user: String, dbName: String, querySql: String): ResultSet = {
    System.setProperty("jdbc.drivers", "org.apache.calcite.jdbc.Driver")
    val driver = Class.forName("org.apache.calcite.jdbc.Driver")
    assert(driver != null)
    val properties = new Properties()
    properties.setProperty("user", user)
    properties.setProperty("db", dbName)
    properties.setProperty("printLog", "false")
    properties.setProperty("recordHistory", "false")

    WithClose(DriverManager.getConnection("jdbc:calcite:fun=spatial", properties)) { conn =>
      WithClose(conn.createStatement()) { stmt =>
        stmt.executeQuery(querySql)
      }
    }
  }

}

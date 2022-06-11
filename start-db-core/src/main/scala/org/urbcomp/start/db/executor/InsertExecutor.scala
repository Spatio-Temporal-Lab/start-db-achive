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
import org.apache.hbase.thirdparty.io.netty.handler.codec.mqtt.MqttMessageBuilders.connect
import org.geotools.data.{DataStoreFinder, Transaction}
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.infra.BaseExecutor
import org.urbcomp.start.db.metadata.AccessorFactory

import java.nio.file.{Path, Paths}
import java.sql.{DriverManager, ResultSet}
import java.util
import java.util.Properties

/**
  * @author zaiyuan
  * @param n
  */
case class InsertExecutor(n: SqlInsert) extends BaseExecutor {

  val path: Path = Paths.get("../start-db-server/src/main/resources/model.json")

  // ToDO 整合棚哥的metaResult
  override def execute(): Unit = {
    // extract database name and table name
    // ToDO 与path一样，需要封装统一的传入参数（先写死）
    val userName = ""
    val envDbName = ""
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }

    // ToDO get through metaData
//    if (!metaDataVerify(userName, envDbName, tableName)) throw new RuntimeException("There is no corresponding table!")

    // construct sql
    val resultObjs: Array[util.ArrayList[AnyRef]] =
      n.getSource
        .asInstanceOf[SqlBasicCall] // Values level
        .operands
        .map { i => // Row level
          val queryItem = i
            .asInstanceOf[SqlBasicCall]
            .operands
            .map(j => j.toString)
            .mkString(" , ")
          val originalQuerySql =
            s"""
             |SELECT $queryItem
             |""".stripMargin
          val querySql = originalQuerySql.replace("`", "")
          WithClose(executeQuery(userName, dbName, querySql)) { rs =>
            {
              val count = rs.getMetaData.getColumnCount
              val result = new util.ArrayList[AnyRef](count)
              rs.next()
              for (x <- 1 to count) {
                result.add(rs.getObject(x))
              }
              result
            }
          }
        }

    // insert data
    val params = new util.HashMap[String, String]()
    // ToDO 传入参数的问题(先写死)
    val CATALOG = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    WithClose(dataStore.getFeatureWriterAppend(tableName, Transaction.AUTO_COMMIT)) { writer =>
      resultObjs.foreach { i =>
        val sf = writer.next()
        val count = i.size()
        for (x <- 0 until count) {
          sf.setAttribute(n.getTargetColumnList.get(x).toString, i.get(x))

        }
        writer.write()
      }
    }
    dataStore.dispose()
  }

  /**
    * Execute the SQL parsed from the contents of values
    */
  def executeQuery[R](user: String, dbName: String, querySql: String): ResultSet = {
    val url = path.toAbsolutePath.toString
    val config = new Properties
    config.put("model", url)
    config.put("caseSensitive", "false")
    val connect = DriverManager.getConnection("jdbc:calcite:fun=spatial", config)
    val statement = connect.createStatement()
    statement.executeQuery(querySql)
  }

  /**
    * Verify if corresponding table exists in the metadata
    */
  def metaDataVerify(userName: String, dbName: String, tableName: String): Boolean = {
    val userAccessor = AccessorFactory.getUserAccessor
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val tableAccessor = AccessorFactory.getTableAccessor
    val user = userAccessor.selectByFidAndName(0L, userName, true)
    if (user == null) return false
    val userId = user.getId
    val database = databaseAccessor.selectByFidAndName(userId, dbName, true)
    if (database == null) return false
    val dbId = database.getId
    val table = tableAccessor.selectByFidAndName(dbId, tableName, true)
    if (table == null) return false
    true
  }

}

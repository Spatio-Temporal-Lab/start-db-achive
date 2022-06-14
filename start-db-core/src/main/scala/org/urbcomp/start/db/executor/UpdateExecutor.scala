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

import org.apache.calcite.sql.{SqlIdentifier, SqlUpdate}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.geotools.filter.text.cql2.CQL
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.AccessorFactory

import java.nio.file.{Path, Paths}
import java.sql.{DriverManager, ResultSet}
import java.util
import java.util.Properties
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

/**
  * executor for update operations
  * @param n  SqlUpdate instance
  * @author   Wang Bohong
  * @date     2022-06-13
  */
case class UpdateExecutor(n: SqlUpdate) extends BaseExecutor {

  val path: Path = Paths.get("../start-db-server/src/main/resources/model.json")

  override def execute(): MetadataResult[Int] = {
    // extract database name and table name
    // ToDO 传入参数
    val userName = "start_db"
    val envDbName = "db_test"
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val str = targetTable.names.get(0)
    val target = targetTable.names.get(0).split('.')
    val (dbName, tableName) = target.length match {
      case 3 =>
        (target(1), target(2))
      case 2 =>
        (target(0), target(1))
      case 1 =>
        (envDbName, target(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }
    if (!metaDataVerify(userName, envDbName, tableName))
      throw new RuntimeException("There is no corresponding table!")
    val condition = n.getCondition.toString.replace("`", "")

    // construct sql
    val list = n.getSourceExpressionList.getList
    val queryItem = list.map(j => j.toString).mkString(",")
    val originalQuerySql =
      s"""
         |SELECT $queryItem
         |""".stripMargin
    val querySql = originalQuerySql.replace("`", "")
    val result = new util.ArrayList[AnyRef]()
    WithClose(executeQuery(userName, dbName, querySql)) { rs =>
      {
        rs.next()
        val count = rs.getMetaData.getColumnCount
        for (x <- 1 to count) {
          result.add(rs.getObject(x))
        }
      }
    }
    // update data
    var affectRows = 0
    val params = new util.HashMap[String, String]()
    // ToDO 传入参数的问题(先写死)
    val CATALOG = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val filter = CQL.toFilter(condition)
    // 行数怎么处理
    WithClose(dataStore.getFeatureWriter(tableName, filter, Transaction.AUTO_COMMIT)) { writer =>
      {
        while (writer.hasNext) {
          val sf = writer.next()
          val count = result.size()
          for (x <- 0 until count) {
            sf.setAttribute(n.getTargetColumnList.get(x).toString, result.get(x))
          }
          affectRows += 1
          writer.write()
        }
      }
    }
    MetadataResult.buildDDLResult(affectRows)
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

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
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{CalciteHelper, MetadataVerifyUtil}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory

import java.sql.ResultSet
import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

/**
  * executor for update operations
  *
  * @param n SqlUpdate instance
  * @author Wang Bohong
  * @date 2022-06-13
  */
case class UpdateExecutor(n: SqlUpdate) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    // extract database name and table name
    // ToDO Sql Param
    val userName = "start_db"
    val envDbName = "db_test"
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
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
    // metadata verify
    if (!MetadataVerifyUtil.tableVerify(userName, dbName, tableName))
      throw new RuntimeException("There is no corresponding table!")
    val fields = MetadataVerifyUtil.getFields(userName, dbName, tableName)
    if (fields == null) throw new RuntimeException("There is no corresponding fields!")
    // filter condition
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
    WithClose(executeQuery(querySql)) { rs =>
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
    // ToDO: SqlParam
    val CATALOG = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val filter = CQL.toFilter(condition)
    WithClose(dataStore.getFeatureWriter(tableName, filter, Transaction.AUTO_COMMIT)) { writer =>
      {
        while (writer.hasNext) {
          val sf = writer.next()
          val count = result.size()
          for (x <- 0 until count) {
            val name = n.getTargetColumnList.get(x).toString
            if (result.get(x).isInstanceOf[RoadSegment]) {
              val rs = result.get(x).asInstanceOf[RoadSegment]
              ExecutorUtil.writeRoadSegment(name, sf, rs)
            } else if (result.get(x).isInstanceOf[Trajectory]) {
              val traj = result.get(x).asInstanceOf[Trajectory]
              ExecutorUtil.writeTrajectory(name, sf, traj)
            } else {
              sf.setAttribute(name, result.get(x))
            }
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
  def executeQuery[R](querySql: String): ResultSet = {
    val statement = CalciteHelper.createConnection().createStatement()
    statement.executeQuery(querySql)
  }

}

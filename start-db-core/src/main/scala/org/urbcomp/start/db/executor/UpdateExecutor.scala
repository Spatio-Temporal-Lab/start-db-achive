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

import org.apache.calcite.sql.{SqlBasicCall, SqlIdentifier, SqlUpdate}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.geotools.filter.text.ecql.ECQL
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{CalciteHelper, MetadataAccessUtil}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.MetadataUtil
import org.urbcomp.start.db.utils.SqlLiteralHandler

import java.sql.ResultSet
import java.util
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

/**
  * executor for update operations
  *
  * @param n SqlUpdate instance
  * @author Wang Bohong
  * */
case class UpdateExecutor(n: SqlUpdate) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)
    // metadata verify
    val table = MetadataAccessUtil.getTable(userName, dbName, tableName)
    if (table == null) {
      throw new RuntimeException("There is no corresponding table!")
    }
    val fields = MetadataAccessUtil.getFields(userName, dbName, tableName)
    if (fields == null) throw new RuntimeException("There is no corresponding fields!")
    // filter condition
    val condition = n.getCondition.toString.replace("`", "")
    // construct sql
    val list = n.getSourceExpressionList.getList
    val queryItem = list
      .map(SqlLiteralHandler.handleLiteral)
      .mkString(" , ")
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
    val params = ExecutorUtil.getDataStoreParams(userName, dbName)
    val dataStore = DataStoreFinder.getDataStore(params)
    val filter = ECQL.toFilter(condition)
    val schemaName = MetadataUtil.makeSchemaName(table.getId)
    WithClose(dataStore.getFeatureWriter(schemaName, filter, Transaction.AUTO_COMMIT)) { writer =>
      {
        while (writer.hasNext) {
          val sf = writer.next()
          val count = result.size()
          for (x <- 0 until count) {
            val name = n.getTargetColumnList.get(x).toString
            result.get(x) match {
              case rs: RoadSegment =>
                ExecutorUtil.writeRoadSegment(name, sf, rs)
              case traj: Trajectory =>
                ExecutorUtil.writeTrajectory(name, sf, traj)
              case _ =>
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

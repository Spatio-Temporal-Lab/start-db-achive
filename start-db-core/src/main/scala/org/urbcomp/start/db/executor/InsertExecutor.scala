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
import org.urbcomp.start.db.executor.utils.ExecutorUtil
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{CalciteHelper, MetadataVerifyUtil}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.SqlParam

import java.sql.ResultSet
import java.util

/**
  * @author zaiyuan
  */
case class InsertExecutor(n: SqlInsert) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    // extract database name and table name
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val envDbName = param.getDbName
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }
    // metaDataVerify
    if (!MetadataVerifyUtil.tableVerify(userName, dbName, tableName))
      throw new RuntimeException("There is no corresponding table!")
    val fields = MetadataVerifyUtil.getFields(userName, dbName, tableName)
    if (fields == null) throw new RuntimeException("There is no corresponding fields!")
    val tableId = fields.get(0).getTableId
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
          WithClose(executeQuery(querySql)) { rs =>
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
    var affectRows = 0
    val params = new util.HashMap[String, String]()
    // ToDO 传入参数的问题(先写死)
    val CATALOG = userName + "." + dbName
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    WithClose(dataStore.getFeatureWriterAppend("t_" + tableId.toString, Transaction.AUTO_COMMIT)) {
      writer =>
        resultObjs.foreach { i =>
          var fieldIndex = 0
          val sf = writer.next()
          val count = i.size()
          for (x <- 0 until count) {
            var name: String = null
            if (n.getTargetColumnList == null) {
              name = fields.get(fieldIndex).getName
            } else {
              name = n.getTargetColumnList.get(x).toString
            }
            while (fields.get(fieldIndex).getName != name) {
              fieldIndex += 1
            }
            if (fields.get(fieldIndex).getType == "RoadSegment") {
              val rs = i.get(x).asInstanceOf[RoadSegment]
              ExecutorUtil.writeRoadSegment(name, sf, rs)
            } else if (fields.get(fieldIndex).getType == "Trajectory") {
              val traj = i.get(x).asInstanceOf[Trajectory]
              ExecutorUtil.writeTrajectory(name, sf, traj)
            } else {
              sf.setAttribute(name, i.get(x))
            }
            fieldIndex += 1
          }
          affectRows += 1
          writer.write()
        }
    }
    dataStore.dispose()
    MetadataResult.buildDDLResult(affectRows)
  }

  /**
    * Execute the SQL parsed from the contents of values
    */
  def executeQuery[R](querySql: String): ResultSet = {
    val connection = CalciteHelper.createConnection()
    val statement = connection.createStatement()
    statement.executeQuery(querySql)
  }

}

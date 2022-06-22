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
import org.locationtech.jts.geom.LineString
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.{AccessorFactory, CalciteHelper, MetadataVerifyUtil}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.{GeoFunctions, MetadataUtil, WKTUtils}

import java.sql.ResultSet
import java.util
import scala.collection.JavaConverters.asScalaBufferConverter

/**
  * @author zaiyuan
  */
case class InsertExecutor(n: SqlInsert) extends BaseExecutor {

  val set = Set("RoadSegment", "Trajectory")

  override def execute[Int](): MetadataResult[Int] = {
    // extract database name and table name
    // ToDO 与path一样，需要封装统一的传入参数（先写死）
    val userName = "start_db"
    val envDbName = "db_test"
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
    val fields = MetadataVerifyUtil.getFields(userName, dbName, tableName)
    if (fields == null) throw new RuntimeException("There is no corresponding table!")
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
    var affectRows = 0
    val params = new util.HashMap[String, String]()
    // ToDO 传入参数的问题(先写死)
    val CATALOG = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    var fieldIndex = 0
    WithClose(dataStore.getFeatureWriterAppend(tableName, Transaction.AUTO_COMMIT)) { writer =>
      resultObjs.foreach { i =>
        val sf = writer.next()
        val count = i.size()
        // 這個地方需要處理特殊字段的邏輯
        for (x <- 0 until count) {
//          sf.setAttribute(n.getTargetColumnList.get(x).toString, i.get(x))
          val name = n.getTargetColumnList.get(x).toString
          while (fields.get(fieldIndex).getName != name) {
            fieldIndex += 1
          }
          if (fields.get(fieldIndex).getType == "RoadSegment") {
            val rs = i.get(x).asInstanceOf[RoadSegment]
            val item = rs.getPoints.asScala
              .map { i =>
                s"${i.getLng} ${i.getLat}"
              }
              .mkString(", ")
            val wkt = s"LINESTRING($item)"
            val geom = WKTUtils.read(wkt).asInstanceOf[LineString]
            sf.setAttribute(name + ".rsId", rs.getRoadSegmentId)
            sf.setAttribute(name + ".geom", geom)
            sf.setAttribute(name + ".rsGeoJson", rs.toGeoJSON)
          } else if (fields.get(fieldIndex).getType == "Trajectory") {
            val traj = i.get(x).asInstanceOf[Trajectory]
            sf.setAttribute(name + ".tid", traj.getTid)
            sf.setAttribute(name + ".oid", traj.getOid)
            sf.setAttribute(name + ".start_time", traj.getStartTime)
            sf.setAttribute(name + ".end_time", traj.getEndTime)
            sf.setAttribute(name + ".geom", GeoFunctions.bboxFromEnvelopeToPolygon(traj.getBBox))
            sf.setAttribute(name + ".geoJson", traj.toGeoJSON)
          } else {
            sf.setAttribute(name, i.get(x))
          }
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
  def executeQuery[R](user: String, dbName: String, querySql: String): ResultSet = {
    val connection = CalciteHelper.createConnection()
    val statement = connection.createStatement()
    statement.executeQuery(querySql)
  }

}

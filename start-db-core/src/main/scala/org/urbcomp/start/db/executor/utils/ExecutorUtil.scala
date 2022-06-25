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

package org.urbcomp.start.db.executor.utils

import org.apache.calcite.sql.SqlIdentifier
import org.locationtech.jts.geom.LineString
import org.opengis.feature.simple.SimpleFeature
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.{GeoFunctions, SqlParam, WKTUtils}

import scala.collection.JavaConverters.asScalaBufferConverter

/**
  * universal methods for executors
  * @author Wang Bohong
  * @date  2022-06-23
  */
object ExecutorUtil {

  /**
    * write road segment instance
    * @param name field name
    * @param sf simple feature
    * @param rs road segment instance
    */
  def writeRoadSegment(name: String, sf: SimpleFeature, rs: RoadSegment): Unit = {
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
  }

  /**
    * write trajectory instance
    * @param name field name
    * @param sf simple feature
    * @param traj trajectory instance
    */
  def writeTrajectory(name: String, sf: SimpleFeature, traj: Trajectory): Unit = {
    sf.setAttribute(name + ".tid", traj.getTid)
    sf.setAttribute(name + ".oid", traj.getOid)
    sf.setAttribute(name + ".start_time", traj.getStartTime)
    sf.setAttribute(name + ".end_time", traj.getEndTime)
    sf.setAttribute(name + ".geom", GeoFunctions.bboxFromEnvelopeToPolygon(traj.getBBox))
    sf.setAttribute(name + ".geoJson", traj.toGeoJSON)
  }

  def getUserNameDbNameAndTableName(targetTable: SqlIdentifier): (String, String, String) = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val envDbName = param.getDbName
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }
    (userName, dbName, tableName)
  }
}

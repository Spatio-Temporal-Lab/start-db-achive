/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.executor.utils

import org.apache.calcite.sql.SqlIdentifier
import org.locationtech.jts.geom.LineString
import org.opengis.feature.simple.SimpleFeature
import org.urbcomp.cupid.db.common.{ConfigProvider, ConfigurationConstants}
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.trajectory.Trajectory
import org.urbcomp.cupid.db.util.{GeoFunctions, SqlParam, WKTUtils}

import java.util
import scala.collection.JavaConverters.asScalaBufferConverter

/**
  * universal methods for executors
  * @author Wang Bohong
  * */
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
    targetTable.names.size() match {
      case 3 =>
        (targetTable.names.get(0), targetTable.names.get(1), targetTable.names.get(2))
      case 2 =>
        (userName, targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (userName, envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }
  }

  def getDataStoreParams(userName: String, dbName: String): util.Map[String, String] = {
    val params: util.Map[String, String] = new util.HashMap[String, String]
    val CATALOG: String = userName + "." + dbName
    params.put(ConfigurationConstants.GEOMESA_HBASE_CATALOG, CATALOG)
    params.put(ConfigurationConstants.GEOMESA_HBASE_ZOOKEEPERS, ConfigProvider.getHBaseZookeepers)
    params
  }
}

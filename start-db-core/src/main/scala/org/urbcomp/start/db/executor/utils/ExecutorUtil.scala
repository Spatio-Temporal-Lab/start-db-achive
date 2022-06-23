package org.urbcomp.start.db.executor.utils

import org.locationtech.jts.geom.LineString
import org.opengis.feature.simple.SimpleFeature
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.{GeoFunctions, WKTUtils}

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
  def writeRoadSegment(name: String, sf :SimpleFeature, rs: RoadSegment):Unit = {
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
  def writeTrajectory(name: String, sf :SimpleFeature, traj: Trajectory):Unit = {
    sf.setAttribute(name + ".tid", traj.getTid)
    sf.setAttribute(name + ".oid", traj.getOid)
    sf.setAttribute(name + ".start_time", traj.getStartTime)
    sf.setAttribute(name + ".end_time", traj.getEndTime)
    sf.setAttribute(name + ".geom", GeoFunctions.bboxFromEnvelopeToPolygon(traj.getBBox))
    sf.setAttribute(name + ".geoJson", traj.toGeoJSON)
  }
}

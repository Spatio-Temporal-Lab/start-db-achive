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

package org.urbcomp.start.db.function

import org.locationtech.jts.geom._
import org.locationtech.jts.geom.prep._

/**
  * This class is used to register spatial functions.
  * Although compute natively supports spatial functions, it uses the ESRI geometry Java library,
  * which has not been maintained for a long time. Therefore, it switches the spatial data model
  * to a more active Java topology suite library.
  *
  * @see <a href="https://github.com/Esri/geometry-api-java"></a>
  * @see <a href="https://github.com/locationtech/jts"></a>
  *
  * @author zaiyuan
  * @date 2022-05-01 09:12:07
  * @since 0.1.0
  */
class SpatialFunction {

  @StartDBFunction
  def intersects(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.intersects(geom2)
      case g: Option[PreparedGeometry] => g.get.intersects(geom2)
    }
  }

  @StartDBFunction
  def within(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.within(geom2)
      case g: Option[PreparedGeometry] => g.get.within(geom2)
    }
  }

  @StartDBFunction
  def touches(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.touches(geom2)
      case g: Option[PreparedGeometry] => g.get.touches(geom2)
    }
  }

  @StartDBFunction
  def overlaps(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.overlaps(geom2)
      case g: Option[PreparedGeometry] => g.get.overlaps(geom2)
    }
  }

  @StartDBFunction
  def equals(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.equals(geom2)
      case g: Option[PreparedGeometry] => g.get.equals(geom2)
    }
  }

  @StartDBFunction
  def disjoint(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.disjoint(geom2)
      case g: Option[PreparedGeometry] => g.get.disjoint(geom2)
    }
  }

  @StartDBFunction
  def covers(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.covers(geom2)
      case g: Option[PreparedGeometry] => g.get.covers(geom2)
    }
  }

  @StartDBFunction
  def crosses(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.crosses(geom2)
      case g: Option[PreparedGeometry] => g.get.crosses(geom2)
    }
  }

  @StartDBFunction
  def contains(geom1: Geometry, geom2: Geometry): Boolean = {
    prepareGeometry(geom1) match {
      case None                        => geom1.contains(geom2)
      case g: Option[PreparedGeometry] => g.get.contains(geom2)
    }
  }

  /**
    * Prepareometry is an advanced scheme of spatial object processing provided by JTS.
    * In the original JTS spatial objects, some spatial relationships are judged by very
    * complex algorithms, which greatly increases the execution time of the algorithm.
    * Some spatial data and some spatial relationships are optimized in prepareometry,
    * which greatly improves the execution efficiency of the algorithm.
    *
    * @param geom  Geometry
    * @return  Option[PreparedGeometry]
    */
  def prepareGeometry(geom: Geometry): Option[PreparedGeometry] = geom match {
    case g: Point      => Option(new PreparedPoint(g))
    case g: MultiPoint => Option(new PreparedPoint(g))
    case g: LineString => Option(new PreparedLineString(g))
    case g: Polygon    => Option(new PreparedPolygon(g))
    case _             => None
  }

}

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

package org.urbcomp.start.db.model.basic.spatial

import org.locationtech.jts.geom.impl.CoordinateArraySequence
import org.locationtech.jts.geom.{Coordinate, GeometryFactory, Point}

class SpatialPoint(spatialCoord: SpatialCoord, factory: GeometryFactory)
    extends Point(
      new CoordinateArraySequence(Array(spatialCoord.asInstanceOf[Coordinate])),
      factory
    ) {

  /**
    * create point using default GeometryFactory(srid=4326)
    *
    * @param spatialCoord spatial coordinate containing meta info
    */
  def this(spatialCoord: SpatialCoord) {
    this(spatialCoord, SpatialUtils.defaultGeomFactory)
  }

  /**
    * construct point by longitude and latitude
    *
    * @param lng longitude
    * @param lat latitude
    */
  def this(lng: Double, lat: Double) {
    this(new SpatialCoord(lng, lat))
  }

  /**
    * create point using default GeometryFactory(srid=4326)
    *
    * @param coordinate spatial coordinate without meta
    */
  def this(coordinate: Coordinate) {
    this(coordinate.getX, coordinate.getY)
  }

  /**
    * get longitude
    */
  def getLng: Double = getX

  /**
    * get latitude
    */
  def getLat: Double = getY
}

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

import org.locationtech.jts.geom.Coordinate

/**
  * two dimensional spatial coordinate containing meta info
  * use lng and lat to represent x and y
  */
class SpatialCoord(lng: Double, lat: Double) extends Coordinate(lng, lat) {

  def this(coordinate: Coordinate) {
    this(coordinate.getX, coordinate.getY)
  }

  /**
    * get longitude
    */
  def getLng: Double = x

  /**
    * get latitude
    */
  def getLat: Double = y
}

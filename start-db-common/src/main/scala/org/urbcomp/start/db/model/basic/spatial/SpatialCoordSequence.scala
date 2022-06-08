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
import org.locationtech.jts.geom.impl.CoordinateArraySequence

class SpatialCoordSequence(spatialCoords: Array[SpatialCoord])
    extends CoordinateArraySequence(spatialCoords.map(_.asInstanceOf[Coordinate])) {

  /**
    * get spatial coordinates with meta
    */
  def getSpatialCoords: Array[SpatialCoord] = spatialCoords

  /**
    * deep copy of this Sequence
    */
  override def copy(): SpatialCoordSequence = {
    val cloneCoordinates = spatialCoords.map(o => new SpatialCoord(o))
    new SpatialCoordSequence(cloneCoordinates)
  }
}

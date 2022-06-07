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

package org.urbcomp.start.db.model.basic.spatiotemporal

import java.sql.Timestamp

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.impl.CoordinateArraySequence

class STCoordSequence(var stCoords: Array[STCoord])
    extends CoordinateArraySequence(stCoords.map(_.asInstanceOf[Coordinate])) {

  /**
    * get st coord sequence
    */
  def getStCoords: Array[STCoord] = stCoords

  override def createCoordinate(): Coordinate = new STCoord(0.0, 0.0, new Timestamp(0L))

  /**
    * deep copy of this Sequence
    */
  override def copy(): STCoordSequence = {
    val cloneCoordinates = for (stCoord <- stCoords) yield {
      val duplicate = createCoordinate().asInstanceOf[STCoord]
      duplicate.setCoordinate(stCoord)
      duplicate
    }
    new STCoordSequence(cloneCoordinates)
  }
}

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

import org.urbcomp.start.db.model.basic.spatial.SpatialPoint
import org.urbcomp.start.db.model.basic.temporal.TemporalEntity
import org.locationtech.jts.geom.Coordinate

class STPoint(stCoord: STCoord) extends SpatialPoint(stCoord) with TemporalEntity {

  /**
    * construct STPoint with its properties
    *
    * @param coordinate Coordinate without meta
    * @param time       time
    */
  def this(coordinate: Coordinate, time: Timestamp) {
    this(new STCoord(coordinate.getX, coordinate.getY, time))
  }

  /**
    * construct STPoint with its properties
    *
    * @param lon  longitude
    * @param lat  latitude
    * @param time time
    */
  def this(lon: Double, lat: Double, time: Timestamp) {
    this(new STCoord(lon, lat, time))
  }

  /**
    * get time attribute
    */
  override def getTime: Timestamp = stCoord.getTime

  /**
    * get spatial coordinate
    */
  def getSTCoord: STCoord = stCoord
}

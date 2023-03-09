/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.cupid.db.geomesa.storage.curve

import org.locationtech.geomesa.curve.NormalizedDimension.{NormalizedLat, NormalizedLon}
import org.locationtech.geomesa.curve.{NormalizedDimension, SpaceFillingCurve}
import org.locationtech.sfcurve.IndexRange
import org.locationtech.sfcurve.zorder.{Z2, ZRange}

/**
  * Z2T space filling curve
  *
  * @param precision bits used per dimension - note all precisions must sum to less than 64
  */
class Z2TSFC(precision: Int) extends SpaceFillingCurve {

  val lon: NormalizedDimension = NormalizedLon(precision)
  val lat: NormalizedDimension = NormalizedLat(precision)

  override def index(x: Double, y: Double, lenient: Boolean = false): Long = {
    try {
      require(
        x >= lon.min && x <= lon.max && y >= lat.min && y <= lat.max,
        s"Value(s) out of bounds ([${lon.min},${lon.max}], [${lat.min},${lat.max}]): $x, $y"
      )
      Z2(lon.normalize(x), lat.normalize(y)).z
    } catch {
      case _: IllegalArgumentException if lenient => lenientIndex(x, y)
    }
  }

  protected def lenientIndex(x: Double, y: Double): Long = {
    val bx = if (x < lon.min) {
      lon.min
    } else if (x > lon.max) {
      lon.max
    } else {
      x
    }
    val by = if (y < lat.min) {
      lat.min
    } else if (y > lat.max) {
      lat.max
    } else {
      y
    }
    Z2(lon.normalize(bx), lat.normalize(by)).z
  }

  override def invert(z: Long): (Double, Double) = {
    val (x, y) = Z2(z).decode
    (lon.denormalize(x), lat.denormalize(y))
  }

  override def ranges(
      xy: Seq[(Double, Double, Double, Double)],
      precision: Int,
      maxRanges: Option[Int]
  ): Seq[IndexRange] = {
    val zbounds = xy.map {
      case (xmin, ymin, xmax, ymax) => ZRange(index(xmin, ymin), index(xmax, ymax))
    }
    Z2.zranges(zbounds.toArray, precision, maxRanges)
  }
}

object Z2TSFC extends Z2TSFC(31)

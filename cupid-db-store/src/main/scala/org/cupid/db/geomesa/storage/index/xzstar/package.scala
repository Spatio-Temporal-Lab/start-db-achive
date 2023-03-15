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

package org.cupid.db.geomesa.storage.index

import org.cupid.db.geomesa.storage.curve.XZStarSFC
import org.locationtech.geomesa.filter.FilterValues
import org.locationtech.geomesa.index.index.SpatialIndexValues
import org.locationtech.jts.geom.Geometry

package object xzstar {

  case class XZStarIndexValues(
      sfc: XZStarSFC,
      geometries: FilterValues[Geometry],
      @deprecated("Use spatialBounds instead.")
      bounds: Seq[(Double, Double, Double, Double)]
  ) extends SpatialIndexValues {
    override def spatialBounds: Seq[(Double, Double, Double, Double)] = bounds
  }

}

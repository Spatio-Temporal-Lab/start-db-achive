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

import org.urbcomp.start.db.model.basic.spatial.SpatialLine
import org.urbcomp.start.db.model.basic.temporal.TemporalLine

class STLine(stCoordSeq: STCoordSequence)
    extends SpatialLine(stCoordSeq)
    with TemporalLine[STCoord] {

  /**
    * time entities
    */
  override var temporalEntities: Array[STCoord] = stCoordSeq.getStCoords

  /**
    * get st coord sequence
    */
  def getStCoordSequence: STCoordSequence = stCoordSeq
}

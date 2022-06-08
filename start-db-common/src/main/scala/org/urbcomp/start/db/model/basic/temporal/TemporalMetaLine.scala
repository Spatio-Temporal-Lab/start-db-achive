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

package org.urbcomp.start.db.model.basic.temporal

import java.sql.Timestamp

class TemporalMetaLine(temporalMetas: Array[TemporalMeta]) extends TemporalLine[TemporalMeta] {

  /**
    * temporal entities
    **/
  override protected var temporalEntities: Array[TemporalMeta] = temporalMetas

  /**
    * get time by index
    *
    * @param i index
    **/
  def getTime(i: Int): Timestamp = get(i).getTime
}

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

trait TemporalEntity {

  /**
    * get time attribute
    **/
  def getTime: Timestamp

  /**
    * compare two time entity by time
    *
    * @param otherTimeEntity time entity
    **/
  def compareTime(otherTimeEntity: TemporalEntity): Int = {
    if (null == otherTimeEntity) return 1
    this.getTime.compareTo(otherTimeEntity.getTime)
  }
}

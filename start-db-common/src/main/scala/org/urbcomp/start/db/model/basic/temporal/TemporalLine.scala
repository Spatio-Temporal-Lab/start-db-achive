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

import org.urbcomp.start.db.model.basic.temporal.util.DateTimeUtils

import scala.collection.mutable.ArrayBuffer

/**
  * interface for spatio-temporal line or time series
  **/
trait TemporalLine[T <: TemporalEntity] {

  /**
    * temporal entities
    **/
  protected var temporalEntities: Array[T]

  /**
    * get temporal entities
    **/
  def getTemporalEntities: Array[T] = temporalEntities

  /**
    * truncate time line into sub time lines of each time interval is less than timeSpanInSec
    *
    * @param timeSpanInSec max time span of sub time line
    **/
  def truncateByTimeSpan(timeSpanInSec: Long): Seq[Array[T]] = {
    if (getTimeSpanInSec <= timeSpanInSec) return Seq(temporalEntities)

    var startIndex = 0
    var startTime = getStartTime.toInstant.getEpochSecond
    val subTimeEntities = new ArrayBuffer[Array[T]]()
    while (startIndex < temporalEntities.length) {
      var cutIndex = temporalEntities.indexWhere(
        (currentEntity: T) =>
          currentEntity.getTime.toInstant.getEpochSecond - startTime > timeSpanInSec,
        startIndex
      )
      if (cutIndex == -1) cutIndex = temporalEntities.length
      else startTime = temporalEntities(cutIndex).getTime.toInstant.getEpochSecond

      subTimeEntities += temporalEntities.slice(startIndex, cutIndex)
      startIndex = cutIndex
    }
    subTimeEntities
  }

  /**
    * truncate time line when time interval between two near time entities
    * is bigger than timeIntervalInSec
    *
    * @param timeIntervalInSec max time interval between two near time entities
    **/
  def truncateByTimeInterval(timeIntervalInSec: Long): Seq[Array[T]] = {
    val subTimeEntities = new ArrayBuffer[Array[T]]()
    var startIndex = 0
    for (index <- 1 until temporalEntities.length) {
      val timeDelta = temporalEntities(index).getTime.toInstant.getEpochSecond -
        temporalEntities(index - 1).getTime.toInstant.getEpochSecond
      if (timeDelta >= timeIntervalInSec) {
        subTimeEntities += temporalEntities.slice(startIndex, index)
        startIndex = index
      }
    }
    subTimeEntities += temporalEntities.slice(startIndex, temporalEntities.length)

    subTimeEntities
  }

  /**
    * truncate time line into n sub time lines on average
    * if the length of current time line is less than numOfSegments,
    * the result will be sub time lines, each one contains only one TimeEntity
    *
    * @param n number of sub time line
    **/
  def truncateToN(n: Int): Seq[Array[T]] = {
    require(n > 0, "n must bigger than 0")
    val stepLength = Math.max(length / n, 1)
    temporalEntities.grouped(stepLength).toSeq
  }

  /**
    * number of time entities
    **/
  def length: Int = temporalEntities.length

  /**
    * get time entity by index
    **/
  def get(i: Int): T = temporalEntities(i)

  /**
    * start time of time line
    **/
  def getStartTime: Timestamp = temporalEntities.head.getTime

  /**
    * end time of time line
    **/
  def getEndTime: Timestamp = temporalEntities.last.getTime

  /**
    * time span of the time line(seconds)
    **/
  def getTimeSpanInSec: Long =
    getEndTime.toInstant.getEpochSecond - getStartTime.toInstant.getEpochSecond

  /**
    * time span of the time line(hour)
    **/
  def getTimeSpanInHour: Double =
    getTimeSpanInSec.asInstanceOf[Double] / DateTimeUtils.SECONDS_PER_HOUR
}

object TemporalLine {

  /**
    * check whether time line is in ascending order by time
    **/
  def isSortedByTime[T <: TemporalEntity](timeEntities: Array[T]): Boolean = {
    for (index <- 0 until timeEntities.length - 1) {
      if (timeEntities(index).compareTime(timeEntities(index + 1)) < 0)
        return false
    }
    true
  }

  /**
    * sort time line according to time
    **/
  def sortByTime[T <: TemporalEntity](timeEntities: Array[T]): Array[T] = {
    timeEntities.sorted((x: TemporalEntity, y: TemporalEntity) => {
      x.compareTime(y)
    })
  }
}

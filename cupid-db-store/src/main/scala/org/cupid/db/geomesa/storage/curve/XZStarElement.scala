/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cupid.db.geomesa.storage.curve

import org.cupid.db.geomesa.storage.curve.XZStarSFC.QueryWindow
import org.locationtech.jts.geom.{
  Coordinate,
  Envelope,
  Geometry,
  LinearRing,
  Polygon,
  PrecisionModel
}
import org.locationtech.sfcurve.IndexRange
import java.util
import scala.collection.JavaConverters._

class XZStarElement(
    val xmin: Double,
    val ymin: Double,
    val xmax: Double,
    val ymax: Double,
    val level: Int,
    val g: Int,
    val pre: PrecisionModel,
    val elementCode: Long
) {
  var checked = false
  var addedPositionCodes = 0
  var checkedPositionCodes = 0

  val xLength: Double = xmax - xmin
  val yLength: Double = ymax - ymin
  val psMaximum: Array[Int] = Array(0, 10, 0, 1, 0, 2, 9, 3, 0, 8, 0, 5, 0, 6, 7, 4)
  val positionIndex: Array[Int] = Array(3, 5, 7, 15, 11, 13, 14, 9, 6, 1)
  val positionDisMap = new util.HashMap[Long, (Double, Int)]()
  val positionDisMap2 = new util.HashMap[Long, Boolean]()
  val children = new java.util.ArrayList[XZStarElement](4)

  def insertion(window: QueryWindow): Boolean = {
    window.xmax >= xmin && window.ymax >= ymin && window.xmin <= xmax + xLength && window.ymin <= ymax + yLength
  }

  def insertion(window: QueryWindow, x1: Double, y1: Double, x2: Double, y2: Double): Boolean = {
    window.xmax >= x1 && window.ymax >= y1 && window.xmin <= x2 && window.ymin <= y2
  }

  def isContained(window: QueryWindow): Boolean = {
    window.xmin <= xmin && window.ymin <= ymin && window.xmax >= xmax + xLength && window.ymax >= ymax + yLength
  }

  def insertCodes(window: QueryWindow): util.List[IndexRange] = {
    var pos = 0
    val xeMax = xmax + xLength
    val yeMax = ymax + yLength
    val xCenter = xmax
    val yCenter = ymax

    if (insertion(window, xmin, ymin, xCenter, yCenter)) {
      pos |= 1
    }
    if (insertion(window, xCenter, ymin, xeMax, yCenter)) {
      pos |= 2
    }
    if (insertion(window, xmin, yCenter, xCenter, yeMax)) {
      pos |= 4
    }
    if (insertion(window, xCenter, yCenter, xeMax, yeMax)) {
      pos |= 8
    }
    val results = new java.util.ArrayList[Long](8)

    var pSize = 9L
    if (level < g) {
      pSize = 8L
    }
    for (i <- 0L to pSize) {
      if ((positionIndex(i.toInt) & pos) != 0) {
        results.add(i + 1L)
      }
    }

    results.asScala
      .map(v => {
        IndexRange(v + elementCode - 10L, v + elementCode - 10L, contained = false)
      })
      .asJava
  }

  def neededToCheck(traj: Envelope, threshold: Double): Boolean = {
    if (checked) {
      return checked
    }
    val enlElement = new Envelope(xmin, xmax + xLength, ymin, ymax + yLength)
    enlElement.expandBy(threshold)
    checked = enlElement.contains(traj)
    checked
  }

  def neededToCheckXZ(traj: Envelope, threshold: Double): Boolean = {
    if (checked) {
      return checked
    }
    val enlElement = new Envelope(xmin, xmax + xLength, ymin, ymax + yLength)
    enlElement.expandBy(threshold)
    checked = enlElement.contains(traj)
    checked
  }

  def neededToCheckQuad(traj: Envelope, threshold: Double): Boolean = {
    if (checked) {
      return checked
    }
    val enlElement = new Envelope(xmin, xmax, ymin, ymax)
    enlElement.expandBy(threshold)
    checked = enlElement.contains(traj)
    checked
  }

  def split(): Unit = {
    if (children.isEmpty) {
      val xCenter = (xmax + xmin) / 2.0
      val yCenter = (ymax + ymin) / 2.0
      children.add(
        new XZStarElement(xmin, ymin, xCenter, yCenter, level + 1, g, pre, elementCode + 9L)
      )
      children.add(
        new XZStarElement(
          xCenter,
          ymin,
          xmax,
          yCenter,
          level + 1,
          g,
          pre,
          elementCode + 9L + 1L * IS(level + 1)
        )
      )
      children.add(
        new XZStarElement(
          xmin,
          yCenter,
          xCenter,
          ymax,
          level + 1,
          g,
          pre,
          elementCode + 9L + 2L * IS(level + 1)
        )
      )
      children.add(
        new XZStarElement(
          xCenter,
          yCenter,
          xmax,
          ymax,
          level + 1,
          g,
          pre,
          elementCode + 9L + 3L * IS(level + 1)
        )
      )
    }
  }

  def split1(): Unit = {
    if (children.isEmpty) {
      val xCenter = (xmax + xmin) / 2.0
      val yCenter = (ymax + ymin) / 2.0
      children.add(
        new XZStarElement(xmin, ymin, xCenter, yCenter, level + 1, g, pre, elementCode + 1L)
      )
      children.add(
        new XZStarElement(
          xCenter,
          ymin,
          xmax,
          yCenter,
          level + 1,
          g,
          pre,
          elementCode + 1L + +1L * (math.pow(4, g - level).toLong - 1L) / 3L
        )
      )
      children.add(
        new XZStarElement(
          xmin,
          yCenter,
          xCenter,
          ymax,
          level + 1,
          g,
          pre,
          elementCode + 1L + +2L * (math.pow(4, g - level).toLong - 1L) / 3L
        )
      )
      children.add(
        new XZStarElement(
          xCenter,
          yCenter,
          xmax,
          ymax,
          level + 1,
          g,
          pre,
          elementCode + 1L + +3L * (math.pow(4, g - level).toLong - 1L) / 3L
        )
      )
    }
  }

  def IS(i: Int): Long = {
    (39L * math.pow(4, g - i).toLong - 9L) / 3L
  }

  def search(root: XZStarElement, x: Double, y: Double, l: Int): XZStarElement = {
    var i = root.level
    var currentElement = root
    while (i < l) {
      val xCenter = (currentElement.xmin + currentElement.xmax) / 2.0
      val yCenter = (currentElement.ymin + currentElement.ymax) / 2.0
      (x < xCenter, y < yCenter) match {
        case (true, true)   => currentElement = currentElement.getChildren.get(0)
        case (false, true)  => currentElement = currentElement.getChildren.get(1)
        case (true, false)  => currentElement = currentElement.getChildren.get(2)
        case (false, false) => currentElement = currentElement.getChildren.get(3)
      }
      i += 1
    }
    currentElement
  }

  def getChildren: util.ArrayList[XZStarElement] = {
    if (children.isEmpty) {
      split()
    }
    children
  }
  def getChildrenQuadTree: util.ArrayList[XZStarElement] = {
    if (children.isEmpty) {
      split1()
    }
    children
  }

  def dis(env: Envelope, geo: Geometry): Double = {
    val cps = Array(
      new Coordinate(env.getMinX, env.getMinY),
      new Coordinate(env.getMinX, env.getMaxY),
      new Coordinate(env.getMaxX, env.getMaxY),
      new Coordinate(env.getMaxX, env.getMinY),
      new Coordinate(env.getMinX, env.getMinY)
    )
    val line = new LinearRing(cps, pre, 4326)
    val polygon = new Polygon(line, null, pre, 4326)
    polygon.distance(geo)
  }
}

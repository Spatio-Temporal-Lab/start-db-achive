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
import org.locationtech.geomesa.curve.XZSFC
import org.locationtech.jts.geom.{Coordinate, Geometry, LinearRing, Polygon, PrecisionModel}
import org.locationtech.sfcurve.IndexRange
import scala.collection.JavaConverters.asScalaBufferConverter
import scala.collection.mutable.ArrayBuffer

class XZStarSFC(g: Short, xBounds: (Double, Double), yBounds: (Double, Double), beta: Int)
    extends Serializable {

  private val xLo = xBounds._1
  private val xHi = xBounds._2
  private val yLo = yBounds._1
  private val yHi = yBounds._2

  private val xSize = xHi - xLo
  private val ySize = yHi - yLo

  /**
    * Index a polygon by it's bounding box
    *
    * @param geometry geometry object
    * @param lenient standardize boundaries to valid values, or raise an exception
    * @return xz+Pos value for the geometry object
    */
  def index(geometry: Geometry, lenient: Boolean): Long = {
    index2(geometry, lenient)._1
  }

  def indexLength(geometry: Geometry, lenient: Boolean = false): String = {
    var s = ""
    for (_ <- 0 to index2(geometry, lenient)._3) {
      s = s + "1"
    }
    s
  }

  def index2(geometry: Geometry, lenient: Boolean = false): (Long, Long, Int) = {
    // get the MBR of geometry
    val mbr = geometry.getEnvelopeInternal
    val (nxmin, nymin, nxmax, nymax) =
      normalize(mbr.getMinX, mbr.getMinY, mbr.getMaxX, mbr.getMaxY, lenient)
    val maxDim = math.max(nxmax - nxmin, nymax - nymin)

    // l1 (el-one) is a bit confusing to read, but corresponds with the paper's definitions
    val l1 = math.floor(math.log(maxDim) / XZSFC.LogPointFive).toInt

    // the length will either be (l1) or (l1 + 1)
    val length = if (l1 >= g) {
      g
    } else {
      val w2 = math.pow(0.5, l1 + 1) // width of an element at resolution l2 (l1 + 1)

      // predicate for checking how many axis the polygon intersects
      // math.floor(min / w2) * w2 == start of cell containing min
      def predicate(min: Double, max: Double): Boolean =
        max <= (math.floor(min / w2) * w2) + (2 * w2)

      if (predicate(nxmin, nxmax) && predicate(nymin, nymax)) l1 + 1 else l1
    }

    val w = math.pow(0.5, length)
    val x = math.floor(nxmin / w) * w
    val y = math.floor(nymin / w) * w

    val poc = signature(
      x * xSize + xLo,
      y * ySize + yLo,
      (x + 2 * w) * xSize + xLo,
      (y + 2 * w) * ySize + yLo,
      geometry
    )

    (sequenceCode(nxmin, nymin, length, poc), poc, length)
  }

  def indexQuadTree(geometry: Geometry, lenient: Boolean = false): Long = {
    val mbr = geometry.getEnvelopeInternal
    val (nxmin, nymin, nxmax, nymax) =
      normalize(mbr.getMinX, mbr.getMinY, mbr.getMaxX, mbr.getMaxY, lenient)
    encode(nxmin, nymin, nxmax, nymax)
  }

  def indexQuadTree2(nxmin: Double, nymin: Double, nxmax: Double, nymax: Double): Long = {
    encode(nxmin, nymin, nxmax, nymax)
  }

  def encode(nxmin: Double, nymin: Double, nxmax: Double, nymax: Double): Long = {
    var xmin = 0.0
    var ymin = 0.0
    var xmax = 1.0
    var ymax = 1.0

    var cs = 0L
    var i = 0
    var flag = true
    while (i < g && flag) {
      val xCenter = (xmin + xmax) / 2.0
      val yCenter = (ymin + ymax) / 2.0
      if (nxmin < xCenter && nxmax > xCenter) {
        flag = false
      }
      if (nymin < yCenter && nymax > yCenter) {
        flag = false
      }
      if (flag) {
        (nxmin < xCenter, nymin < yCenter) match {
          case (true, true) => cs += 1L; xmax = xCenter; ymax = yCenter
          case (false, true) =>
            cs += 1L + 1L * (math.pow(4, g - i).toLong - 1L) / 3L; xmin = xCenter; ymax = yCenter
          case (true, false) =>
            cs += 1L + 2L * (math.pow(4, g - i).toLong - 1L) / 3L; xmax = xCenter; ymin = yCenter
          case (false, false) =>
            cs += 1L + 3L * (math.pow(4, g - i).toLong - 1L) / 3L; xmin = xCenter; ymin = yCenter
        }
        i += 1
      }
    }
    cs
  }

  val psMaximum = Array(0, 10, 0, 1, 0, 2, 9, 3, 0, 8, 0, 5, 0, 6, 7, 4)
  val positionIndex = Array(3, 5, 7, 15, 11, 13, 14, 9, 6, 1)
  val pre = new PrecisionModel()

  def signature(x1: Double, y1: Double, x2: Double, y2: Double, traj: Geometry): Long = {
    val remaining = new java.util.ArrayDeque[Element2](Math.pow(4, beta).toInt)
    val levelOneElements = Element2(x1, y1, x2, y2, 1, 0L).children
    val levelTerminator = Element2(-1.0, -1.0, -1.0, -1.0, 0, 0L)
    levelOneElements.foreach(remaining.add)
    remaining.add(levelTerminator)
    var level = 1
    var sig = 0
    while (!remaining.isEmpty) {
      val next = remaining.poll
      if (next.eq(levelTerminator)) {
        if (!remaining.isEmpty && level < beta) {
          level = (level + 1).toShort
          remaining.add(levelTerminator)
        }
      } else {
        if (next.overlaps(traj)) {
          if (level < beta) {
            next.children.foreach(remaining.add)
          } else {
            sig |= 1 << next.code
          }
        }
      }
    }
    psMaximum(sig).toLong
  }

  def sequenceCode(x: Double, y: Double, length: Int, posCode: Long): Long = {
    var xmin = 0.0
    var ymin = 0.0
    var xmax = 1.0
    var ymax = 1.0

    var cs = 0L

    def IS(i: Int): Long = {
      (39L * math.pow(4, g - i).toLong - 9L) / 3L
    }

    var i = 1
    while (i <= length) {
      val xCenter = (xmin + xmax) / 2.0
      val yCenter = (ymin + ymax) / 2.0
      (x < xCenter, y < yCenter) match {
        case (true, true)   => cs += 9L; xmax = xCenter; ymax = yCenter
        case (false, true)  => cs += 9L + 1L * IS(i); xmin = xCenter; ymax = yCenter
        case (true, false)  => cs += 9L + 2L * IS(i); xmax = xCenter; ymin = yCenter
        case (false, false) => cs += 9L + 3L * IS(i); xmin = xCenter; ymin = yCenter
      }
      i += 1
    }
    cs - 10L + posCode
  }

  case class Element2(
      xmin: Double,
      ymin: Double,
      xmax: Double,
      ymax: Double,
      level: Int,
      code: Long
  ) {

    def overlaps(traj: Geometry): Boolean = {
      val cps = Array(
        new Coordinate(xmin, ymin),
        new Coordinate(xmin, ymax),
        new Coordinate(xmax, ymax),
        new Coordinate(xmax, ymin),
        new Coordinate(xmin, ymin)
      )
      val line = new LinearRing(cps, pre, 4326)
      val polygon = new Polygon(line, null, pre, 4326)
      for (i <- 0 until traj.getNumGeometries) {
        if (polygon.intersects(traj.getGeometryN(i))) {
          return true
        }
      }
      false
    }

    def children: Seq[Element2] = {
      val xCenter = (xmin + xmax) / 2.0
      val yCenter = (ymin + ymax) / 2.0
      val c0 = copy(xmax = xCenter, ymax = yCenter, level = level + 1, code = code)
      val c1 = copy(
        xmin = xCenter,
        ymax = yCenter,
        level = level + 1,
        code = code + 1L * Math.pow(4, beta - level).toLong
      )
      val c2 = copy(
        xmax = xCenter,
        ymin = yCenter,
        level = level + 1,
        code = code + 2L * Math.pow(4, beta - level).toLong
      )
      val c3 = copy(
        xmin = xCenter,
        ymin = yCenter,
        level = level + 1,
        code = code + 3L * Math.pow(4, beta - level).toLong
      )
      Seq(c0, c1, c2, c3)
    }
  }

  /**
    * Normalize user space values to [0,1]
    *
    * @param xmin min x value in user space
    * @param ymin min y value in user space
    * @param xmax max x value in user space, must be >= xmin
    * @param ymax max y value in user space, must be >= ymin
    * @param lenient standardize boundaries to valid values, or raise an exception
    * @return
    */
  private def normalize(
      xmin: Double,
      ymin: Double,
      xmax: Double,
      ymax: Double,
      lenient: Boolean
  ): (Double, Double, Double, Double) = {
    require(xmin <= xmax && ymin <= ymax, s"Bounds must be ordered: [$xmin $xmax] [$ymin $ymax]")

    try {
      require(
        xmin >= xLo && xmax <= xHi && ymin >= yLo && ymax <= yHi,
        s"Values out of bounds ([$xLo $xHi] [$yLo $yHi]): [$xmin $xmax] [$ymin $ymax]"
      )

      val nxmin = (xmin - xLo) / xSize
      val nymin = (ymin - yLo) / ySize
      val nxmax = (xmax - xLo) / xSize
      val nymax = (ymax - yLo) / ySize

      (nxmin, nymin, nxmax, nymax)
    } catch {
      case _: IllegalArgumentException if lenient =>
        val bxmin = if (xmin < xLo) {
          xLo
        } else if (xmin > xHi) {
          xHi
        } else {
          xmin
        }
        val bymin = if (ymin < yLo) {
          yLo
        } else if (ymin > yHi) {
          yHi
        } else {
          ymin
        }
        val bxmax = if (xmax < xLo) {
          xLo
        } else if (xmax > xHi) {
          xHi
        } else {
          xmax
        }
        val bymax = if (ymax < yLo) {
          yLo
        } else if (ymax > yHi) {
          yHi
        } else {
          ymax
        }

        val nxmin = (bxmin - xLo) / xSize
        val nymin = (bymin - yLo) / ySize
        val nxmax = (bxmax - xLo) / xSize
        val nymax = (bymax - yLo) / ySize

        (nxmin, nymin, nxmax, nymax)
    }
  }

  /**
    * Determine XZStar-curve ranges that will cover a given query window
    *
    * @param query a window to cover in the form (xmin, ymin, xmax, ymax) where: all values are in user space
    * @return
    */
  def ranges(query: (Double, Double, Double, Double)): Seq[IndexRange] = ranges(Seq(query))

  /**
    * Determine XZStar-curve ranges that will cover a given query window
    *
    * @param query a window to cover in the form (xmin, ymin, xmax, ymax) where all values are in user space
    * @param maxRanges a rough upper limit on the number of ranges to generate
    * @return
    */
  def ranges(query: (Double, Double, Double, Double), maxRanges: Option[Int]): Seq[IndexRange] =
    ranges(Seq(query), maxRanges)

  /**
    * Determine XZStar-curve ranges that will cover a given query window
    *
    * @param xmin min x value in user space
    * @param ymin min y value in user space
    * @param xmax max x value in user space, must be >= xmin
    * @param ymax max y value in user space, must be >= ymin
    * @return
    */
  def ranges(xmin: Double, ymin: Double, xmax: Double, ymax: Double): Seq[IndexRange] =
    ranges(Seq((xmin, ymin, xmax, ymax)))

  /**
    * Determine XZStar-curve ranges that will cover a given query window
    *
    * @param xmin min x value in user space
    * @param ymin min y value in user space
    * @param xmax max x value in user space, must be >= xmin
    * @param ymax max y value in user space, must be >= ymin
    * @param maxRanges a rough upper limit on the number of ranges to generate
    * @return
    */
  def ranges(
      xmin: Double,
      ymin: Double,
      xmax: Double,
      ymax: Double,
      maxRanges: Option[Int]
  ): Seq[IndexRange] =
    ranges(Seq((xmin, ymin, xmax, ymax)), maxRanges)

  /**
    * Determine XZStar-curve ranges that will cover a given query window
    *
    * @param queries a sequence of OR'd windows to cover. Each window is in the form
    *                (xmin, ymin, xmax, ymax) where all values are in user space
    * @param maxRanges a rough upper limit on the number of ranges to generate
    * @return
    */
  def ranges(
      queries: Seq[(Double, Double, Double, Double)],
      maxRanges: Option[Int] = None
  ): Seq[IndexRange] = {

    val queryWindow = queries.map {
      case (xmin, ymin, xmax, ymax) =>
        QueryWindow(xmin, ymin, xmax, ymax)
    }

    // stores our results - initial size of 100 in general saves us some re-allocation
    val ranges = new java.util.ArrayList[IndexRange](100)

    // values remaining to process - initial size of 100 in general saves us some re-allocation
    val remaining = new java.util.ArrayDeque[XZStarElement](100)

    val levelStop = new XZStarElement(-1, -1, -1, -1, -1, -1, pre, 0)
    val root = new XZStarElement(-180.0, -90.0, 180.0, 90.0, 0, g, new PrecisionModel, 0L)
    root.split()
    root.children.asScala.foreach(remaining.add)
    remaining.add(levelStop)
    var level: Short = 1

    while (!remaining.isEmpty) {
      val next = remaining.poll
      if (next.eq(levelStop)) {
        // we've fully processed a level, increment our state
        if (!remaining.isEmpty && level < g) {
          level = (level + 1).toShort
          remaining.add(levelStop)
        }
      } else {
        checkValue(next, level)
      }
    }

    def checkValue(quad: XZStarElement, level: Short): Unit = {
      if (quad.isContained(queryWindow.head)) {
        val (min, max) = (quad.elementCode + 1L, quad.elementCode + quad.IS(level) - 1L)
        ranges.add(IndexRange(min, max, contained = true))
      } else if (quad.insertion(queryWindow.head)) {
        ranges.addAll(quad.insertCodes(queryWindow.head))
        if (level < g) {
          quad.split()
          quad.children.asScala.foreach(remaining.add)
        }
      }
    }

    if (ranges.size() > 0) {
      ranges.sort(IndexRange.IndexRangeIsOrdered)
      var current = ranges.get(0) // note: should always be at least one range
      val result = ArrayBuffer.empty[IndexRange]
      var i = 1
      while (i < ranges.size()) {
        val range = ranges.get(i)
        if (range.lower <= current.upper + 1) {
          current = IndexRange(
            current.lower,
            math.max(current.upper, range.upper),
            current.contained && range.contained
          )
        } else {
          result.append(current)
          current = range
        }
        i += 1
      }
      result.append(current)
      result
    } else {
      ranges.asScala
    }
  }

}

object XZStarSFC extends Serializable {

  private val cache = new java.util.concurrent.ConcurrentHashMap[(Short, Int), XZStarSFC]()

  /**
    * Region being queried. Bounds are normalized to [0-1].
    *
    * @param xmin x lower bound in [0-1]
    * @param ymin y lower bound in [0-1]
    * @param xmax x upper bound in [0-1], must be >= xmin
    * @param ymax y upper bound in [0-1], must be >= ymin
    */
  case class QueryWindow(xmin: Double, ymin: Double, xmax: Double, ymax: Double)

  def apply(g: Short, beta: Int): XZStarSFC = {
    var sfc = cache.get((g, beta))
    if (sfc == null) {
      sfc = new XZStarSFC(g, (-180.0, 180.0), (-90.0, 90.0), beta)
      cache.put((g, beta), sfc)
    }
    sfc
  }

}

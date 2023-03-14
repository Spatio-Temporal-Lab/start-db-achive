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
package org.cupid.db.geomesa.storage.index.z2t

import com.typesafe.scalalogging.LazyLogging
import org.cupid.db.geomesa.storage.curve.XZ2TSFC
import org.geotools.util.factory.Hints
import org.locationtech.geomesa.curve.BinnedTime
import org.locationtech.geomesa.curve.BinnedTime.{DateToBin, TimeToBin}
import org.locationtech.geomesa.filter.FilterValues
import org.locationtech.geomesa.index.api.IndexKeySpace.IndexKeySpaceFactory
import org.locationtech.geomesa.index.api.ShardStrategy.{NoShardStrategy, ZShardStrategy}
import org.locationtech.geomesa.index.api.{
  BoundedByteRange,
  BoundedRange,
  ByteRange,
  IndexKeySpace,
  LowerBoundedRange,
  RowKeyValue,
  ScanRange,
  ShardStrategy,
  SingleRowKeyValue,
  UnboundedRange,
  UpperBoundedRange,
  WritableFeature
}
import org.locationtech.geomesa.index.conf.QueryProperties
import org.locationtech.geomesa.index.geotools.GeoMesaDataStoreFactory.GeoMesaDataStoreConfig
import org.locationtech.geomesa.index.utils.Explainer
import org.locationtech.geomesa.utils.geotools.{GeometryUtils, WholeWorldPolygon}
import org.locationtech.geomesa.utils.index.ByteArrays
import org.locationtech.jts.geom.{Geometry, Point}
import org.locationtech.sfcurve.IndexRange
import org.opengis.feature.simple.SimpleFeatureType
import org.opengis.filter.Filter
import java.util.Date
import scala.util.control.NonFatal

class XZ2TIndexKeySpace(
    val sft: SimpleFeatureType,
    val sharding: ShardStrategy,
    geomField: String,
    dtgField: String
) extends IndexKeySpace[XZ2TIndexValues, Z2TIndexKey]
    with LazyLogging {

  import org.locationtech.geomesa.utils.geotools.RichSimpleFeatureType.RichSimpleFeatureType

  require(
    classOf[Geometry].isAssignableFrom(sft.getDescriptor(geomField).getType.getBinding),
    s"Expected field $geomField to have a geometry binding, but instead it has: " +
      sft.getDescriptor(geomField).getType.getBinding.getSimpleName
  )
  require(
    classOf[Date].isAssignableFrom(sft.getDescriptor(dtgField).getType.getBinding),
    s"Expected field $dtgField to have a date binding, but instead it has: " +
      sft.getDescriptor(dtgField).getType.getBinding.getSimpleName
  )

  protected val geomIndex: Int = sft.indexOf(geomField)
  protected val dtgIndex: Int = sft.indexOf(dtgField)

  protected val sfc = XZ2TSFC(sft.getXZPrecision)

  // Used to convert the time of type Long to type Short, and is used to generate the time period in the index
  protected val timeToIndex: TimeToBin = BinnedTime.timeToBin(sft.getZ3Interval)
  // used to convert the ZonedDateTime into Short type, and is used to obtain the time period list of the query time interval during query
  private val dateToIndex: DateToBin = BinnedTime.dateToBin(sft.getZ3Interval)

  private val boundsToDates = BinnedTime.boundsToIndexableDates(sft.getZ3Interval)
  private val isPoints =
    classOf[Point].isAssignableFrom(sft.getDescriptor(geomIndex).getType.getBinding)

  override val attributes: Seq[String] = Seq(geomField, dtgField)

  override val indexKeyByteLength: Right[(Array[Byte], Int, Int) => Int, Int] = Right(
    10 + sharding.length
  )

  override val sharing: Array[Byte] = Array.empty

  override def toIndexKey(
      writable: WritableFeature,
      tier: Array[Byte],
      id: Array[Byte],
      lenient: Boolean
  ): RowKeyValue[Z2TIndexKey] = {
    val geom = writable.getAttribute[Geometry](geomIndex)
    if (geom == null) {
      throw new IllegalArgumentException(s"Null geometry in feature ${writable.feature.getID}")
    }
    val envelope = geom.getEnvelopeInternal
    // TODO support date intervals (remember to remove disjoint data check in getRanges)
    val dtg = writable.getAttribute[Date](dtgIndex)
    val time = if (dtg == null) {
      0L
    } else {
      dtg.getTime
    }
    val b = timeToIndex(time)
    val xz = try {
      sfc.index(envelope.getMinX, envelope.getMinY, envelope.getMaxX, envelope.getMaxY, lenient)
    } catch {
      case NonFatal(e) =>
        throw new IllegalArgumentException(s"Invalid xz value from geometry: $geom", e)
    }
    val shard = sharding(writable)

    // create the byte array - allocate a single array up front to contain everything
    // ignore tier, not used here
    val bytes = Array.ofDim[Byte](shard.length + 10 + id.length)

    if (shard.isEmpty) {
      ByteArrays.writeShort(b, bytes, 0)
      ByteArrays.writeLong(xz, bytes, 2)
      System.arraycopy(id, 0, bytes, 10, id.length)
    } else {
      bytes(0) = shard.head // shard is only a single byte
      ByteArrays.writeShort(b, bytes, 1)
      ByteArrays.writeLong(xz, bytes, 3)
      System.arraycopy(id, 0, bytes, 11, id.length)
    }

    SingleRowKeyValue(bytes, sharing, shard, Z2TIndexKey(b, xz), tier, id, writable.values)
  }

  override def getIndexValues(filter: Filter, explain: Explainer): XZ2TIndexValues = {

    import org.locationtech.geomesa.filter.FilterHelper._

    // standardize the two key query arguments:  polygon and date-range

    val geometries: FilterValues[Geometry] = {
      val extracted = extractGeometries(filter, geomField, isPoints)
      if (extracted.nonEmpty) {
        extracted
      } else {
        FilterValues(Seq(WholeWorldPolygon))
      }
    }

    // since we don't apply a temporal filter, we pass handleExclusiveBounds to
    // make sure we exclude the non-inclusive endpoints of a during filter.
    // note that this isn't completely accurate, as we only index down to the second
    val intervals = extractIntervals(filter, dtgField, handleExclusiveBounds = true)

    explain(s"Geometries: $geometries")
    explain(s"Intervals: $intervals")

    // disjoint geometries are ok since they could still intersect a polygon
    if (intervals.disjoint) {
      explain("Disjoint dates extracted, short-circuiting to empty query")
      return XZ2TIndexValues(sfc, geometries, Seq.empty, intervals, Seq.empty, Seq.empty)
    }

    // compute our ranges based on the coarse bounds for our query
    val xy: Seq[(Double, Double, Double, Double)] = {
      val multiplier = QueryProperties.PolygonDecompMultiplier.toInt.get
      val bits = QueryProperties.PolygonDecompBits.toInt.get
      geometries.values.flatMap(GeometryUtils.bounds(_, multiplier, bits))
    }

    // calculate map of weeks to time intervals in that week
    val timesByBin = Seq.newBuilder[Short]
    val unboundedBins = Seq.newBuilder[(Short, Short)]

    intervals.foreach { interval =>
      val (lower, upper) = boundsToDates(interval.bounds)
      val lb = dateToIndex(lower)
      val ub = dateToIndex(upper)

      if (interval.isBoundedBothSides) {
        if (lb == ub) {
          timesByBin += lb
        } else {
          timesByBin += lb
          timesByBin += ub
          Range.inclusive(lb + 1, ub - 1).foreach(b => timesByBin += b.toShort)
        }
      } else if (interval.lower.value.isDefined) {
        timesByBin += lb
        unboundedBins += (((lb + 1).toShort, Short.MaxValue))
      } else if (interval.upper.value.isDefined) {
        timesByBin += ub
        unboundedBins += ((0, (ub - 1).toShort))
      }

    }
    // make our underlying index values available to other classes in the pipeline for processing
    XZ2TIndexValues(sfc, geometries, xy, intervals, timesByBin.result(), unboundedBins.result())

  }

  override def getRanges(
      values: XZ2TIndexValues,
      multiplier: Int
  ): Iterator[ScanRange[Z2TIndexKey]] = {
    val XZ2TIndexValues(xz2t, _, xy, _, timesByBin, unboundedBins) = values

    // note: `target` will always be Some, as ScanRangesTarget has a default value
    val target = QueryProperties.ScanRangesTarget.option.map { t =>
      math.max(1, if (timesByBin.isEmpty) {
        t.toInt
      } else { t.toInt / timesByBin.size } / multiplier)
    }

    def toZRanges(): Seq[IndexRange] =
      xz2t.ranges(xy.map { case (xmin, ymin, xmax, ymax) => (xmin, ymin, xmax, ymax) }, target)

    val bounded = timesByBin.iterator.flatMap {
      case bin =>
        val zs = toZRanges()
        zs.map(range => BoundedRange(Z2TIndexKey(bin, range.lower), Z2TIndexKey(bin, range.upper)))
    }

    val unbounded = unboundedBins.iterator.map {
      case (lower, Short.MaxValue) => LowerBoundedRange(Z2TIndexKey(lower, 0L))
      case (0, upper)              => UpperBoundedRange(Z2TIndexKey(upper, Long.MaxValue))
      case (lower, upper) =>
        logger.error(s"Unexpected unbounded bin endpoints: $lower:$upper")
        UnboundedRange(Z2TIndexKey(0, 0L))
    }

    bounded ++ unbounded
  }

  override def getRangeBytes(
      ranges: Iterator[ScanRange[Z2TIndexKey]],
      tier: Boolean
  ): Iterator[ByteRange] = {
    if (sharding.length == 0) {
      ranges.map {
        case BoundedRange(lo, hi) =>
          BoundedByteRange(
            ByteArrays.toBytes(lo.bin, lo.z),
            ByteArrays.toBytesFollowingPrefix(hi.bin, hi.z)
          )

        case LowerBoundedRange(lo) =>
          BoundedByteRange(ByteArrays.toBytes(lo.bin, lo.z), ByteRange.UnboundedUpperRange)

        case UpperBoundedRange(hi) =>
          BoundedByteRange(
            ByteRange.UnboundedLowerRange,
            ByteArrays.toBytesFollowingPrefix(hi.bin, hi.z)
          )

        case UnboundedRange(_) =>
          BoundedByteRange(ByteRange.UnboundedLowerRange, ByteRange.UnboundedUpperRange)

        case r =>
          throw new IllegalArgumentException(s"Unexpected range type $r")
      }
    } else {
      ranges.flatMap {
        case BoundedRange(lo, hi) =>
          val lower = ByteArrays.toBytes(lo.bin, lo.z)
          val upper = ByteArrays.toBytesFollowingPrefix(hi.bin, hi.z)
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )

        case LowerBoundedRange(lo) =>
          val lower = ByteArrays.toBytes(lo.bin, lo.z)
          val upper = ByteRange.UnboundedUpperRange
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )

        case UpperBoundedRange(hi) =>
          val lower = ByteRange.UnboundedLowerRange
          val upper = ByteArrays.toBytesFollowingPrefix(hi.bin, hi.z)
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )

        case UnboundedRange(_) =>
          Seq(BoundedByteRange(ByteRange.UnboundedLowerRange, ByteRange.UnboundedUpperRange))

        case r =>
          throw new IllegalArgumentException(s"Unexpected range type $r")
      }
    }
  }

  // always apply the full filter to xz2t queries
  override def useFullFilter(
      values: Option[XZ2TIndexValues],
      config: Option[GeoMesaDataStoreConfig],
      hints: Hints
  ): Boolean = true

}

object XZ2TIndexKeySpace extends IndexKeySpaceFactory[XZ2TIndexValues, Z2TIndexKey] {

  override def supports(sft: SimpleFeatureType, attributes: Seq[String]): Boolean =
    attributes.lengthCompare(2) == 0 && attributes.forall(sft.indexOf(_) != -1) &&
      classOf[Geometry].isAssignableFrom(sft.getDescriptor(attributes.head).getType.getBinding) &&
      classOf[Date].isAssignableFrom(sft.getDescriptor(attributes.last).getType.getBinding)

  override def apply(
      sft: SimpleFeatureType,
      attributes: Seq[String],
      tier: Boolean
  ): XZ2TIndexKeySpace = {
    val shards = if (tier) {
      NoShardStrategy
    } else {
      ZShardStrategy(sft)
    }
    new XZ2TIndexKeySpace(sft, shards, attributes.head, attributes.last)
  }
}

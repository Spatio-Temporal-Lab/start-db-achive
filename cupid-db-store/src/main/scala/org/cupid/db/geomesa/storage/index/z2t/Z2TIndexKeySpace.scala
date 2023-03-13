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

package org.cupid.db.geomesa.storage.index.z2t

import com.typesafe.scalalogging.LazyLogging
import org.cupid.db.geomesa.storage.curve.Z2TSFC
import org.geotools.util.factory.Hints
import org.locationtech.geomesa.curve.BinnedTime.{DateToBin, TimeToBin}
import org.locationtech.geomesa.curve.BinnedTime
import org.locationtech.geomesa.filter.FilterValues
import org.locationtech.geomesa.index.api.IndexKeySpace.IndexKeySpaceFactory
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
import org.locationtech.geomesa.index.api.ShardStrategy.{NoShardStrategy, ZShardStrategy}
import org.locationtech.geomesa.index.conf.QueryProperties
import org.locationtech.geomesa.index.geotools.GeoMesaDataStoreFactory.GeoMesaDataStoreConfig
import org.locationtech.geomesa.index.utils.Explainer
import org.locationtech.geomesa.utils.geotools.{GeometryUtils, WholeWorldPolygon}
import org.locationtech.geomesa.utils.index.ByteArrays
import org.opengis.feature.simple.SimpleFeatureType
import org.locationtech.jts.geom.{Geometry, Point}
import org.locationtech.sfcurve.IndexRange
import org.opengis.filter.Filter
import java.util.Date
import scala.util.control.NonFatal

class Z2TIndexKeySpace(
    val sft: SimpleFeatureType,
    val sharding: ShardStrategy,
    geomField: String,
    dtgField: String
) extends IndexKeySpace[Z2TIndexValues, Z2TIndexKey]
    with LazyLogging {

  import org.locationtech.geomesa.utils.geotools.RichSimpleFeatureType.RichSimpleFeatureType

  require(
    classOf[Point].isAssignableFrom(sft.getDescriptor(geomField).getType.getBinding),
    s"Expected field $geomField to have a point binding, but instead it has: " +
      sft.getDescriptor(geomField).getType.getBinding.getSimpleName
  )
  require(
    classOf[Date].isAssignableFrom(sft.getDescriptor(dtgField).getType.getBinding),
    s"Expected field $dtgField to have a date binding, but instead it has: " +
      sft.getDescriptor(dtgField).getType.getBinding.getSimpleName
  )

  protected val sfc: Z2TSFC = Z2TSFC

  protected val geomIndex: Int = sft.indexOf(geomField)
  protected val dtgIndex: Int = sft.indexOf(dtgField)

  // Used to convert the time of type Long to type Short, and is used to generate the time period in the index
  protected val timeToIndex: TimeToBin = BinnedTime.timeToBin(sft.getZ3Interval)
  // used to convert the ZonedDateTime into Short type, and is used to obtain the time period list of the query time interval during query
  protected val dateToIndex: DateToBin = BinnedTime.dateToBin(sft.getZ3Interval)

  private val boundsToDates = BinnedTime.boundsToIndexableDates(sft.getZ3Interval)

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
    val geom = writable.getAttribute[Point](geomIndex)
    if (geom == null) {
      throw new IllegalArgumentException(s"Null geometry in feature ${writable.feature.getID}")
    }
    val dtg = writable.getAttribute[Date](dtgIndex)
    val time = if (dtg == null) {
      0
    } else {
      dtg.getTime
    }
    val b = timeToIndex(time)
    val z = try {
      sfc.index(geom.getX, geom.getY, lenient)
    } catch {
      case NonFatal(e) =>
        throw new IllegalArgumentException(s"Invalid z value from geometry: $geom", e)
    }
    val shard = sharding(writable)

    // create the byte array - allocate a single array up front to contain everything
    // ignore tier, not used here
    val bytes = Array.ofDim[Byte](shard.length + 10 + id.length)

    if (shard.isEmpty) {
      ByteArrays.writeShort(b, bytes, 0)
      ByteArrays.writeLong(z, bytes, 2)
      System.arraycopy(id, 0, bytes, 10, id.length)
    } else {
      bytes(0) = shard.head // shard is only a single byte
      ByteArrays.writeShort(b, bytes, 1)
      ByteArrays.writeLong(z, bytes, 3)
      System.arraycopy(id, 0, bytes, 11, id.length)
    }

    SingleRowKeyValue(bytes, sharing, shard, Z2TIndexKey(b, z), tier, id, writable.values)
  }

  override def getIndexValues(filter: Filter, explain: Explainer): Z2TIndexValues = {

    import org.locationtech.geomesa.filter.FilterHelper._

    // standardize the two key query arguments:  polygon and date-range

    val geometries: FilterValues[Geometry] = {
      val extracted = extractGeometries(filter, geomField, intersect = true) // intersect since we have points
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

    if (geometries.disjoint || intervals.disjoint) {
      explain("Disjoint geometries or dates extracted, short-circuiting to empty query")
      return Z2TIndexValues(sfc, geometries, Seq.empty, intervals, Seq.empty, Seq.empty)
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

    Z2TIndexValues(sfc, geometries, xy, intervals, timesByBin.result(), unboundedBins.result())
  }

  override def getRanges(
      values: Z2TIndexValues,
      multiplier: Int
  ): Iterator[ScanRange[Z2TIndexKey]] = {
    val Z2TIndexValues(z2t, _, xy, _, timesByBin, unboundedBins) = values

    // note: `target` will always be Some, as ScanRangesTarget has a default value
    val target = QueryProperties.ScanRangesTarget.option.map { t =>
      math.max(1, if (timesByBin.isEmpty) {
        t.toInt
      } else { t.toInt / timesByBin.size } / multiplier)
    }

    //def toZRanges(t: Seq[(Long, Long)]): Seq[IndexRange] = z2t.ranges(xy, t, 64, target)
    def toZRanges(): Seq[IndexRange] = z2t.ranges(xy, 64, target)

    val bounded = timesByBin.iterator.flatMap {
      case bin =>
        val zs = toZRanges()
        zs.map(range => BoundedRange(Z2TIndexKey(bin, range.lower), Z2TIndexKey(bin, range.upper)))
    }

    val unbounded = unboundedBins.iterator.map {
      case (0, Short.MaxValue)     => UnboundedRange(Z2TIndexKey(0, 0L))
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

  // always apply the full filter to z2t queries
  override def useFullFilter(
      values: Option[Z2TIndexValues],
      config: Option[GeoMesaDataStoreConfig],
      hints: Hints
  ): Boolean = true
}

object Z2TIndexKeySpace extends IndexKeySpaceFactory[Z2TIndexValues, Z2TIndexKey] {

  override def supports(sft: SimpleFeatureType, attributes: Seq[String]): Boolean =
    attributes.lengthCompare(2) == 0 && attributes.forall(sft.indexOf(_) != -1) &&
      classOf[Point].isAssignableFrom(sft.getDescriptor(attributes.head).getType.getBinding) &&
      classOf[Date].isAssignableFrom(sft.getDescriptor(attributes.last).getType.getBinding)

  override def apply(
      sft: SimpleFeatureType,
      attributes: Seq[String],
      tier: Boolean
  ): Z2TIndexKeySpace = {
    val shards = if (tier) {
      NoShardStrategy
    } else {
      ZShardStrategy(sft)
    }
    new Z2TIndexKeySpace(sft, shards, attributes.head, attributes.last)
  }
}

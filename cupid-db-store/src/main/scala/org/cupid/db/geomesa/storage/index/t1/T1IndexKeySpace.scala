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
package org.cupid.db.geomesa.storage.index.t1

import org.geotools.util.factory.Hints
import org.locationtech.geomesa.filter.{Bounds, FilterHelper, FilterValues}
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
  SingleRowByteRange,
  SingleRowKeyValue,
  SingleRowRange,
  UnboundedByteRange,
  UnboundedRange,
  UpperBoundedRange,
  WritableFeature
}
import org.locationtech.geomesa.index.geotools.GeoMesaDataStoreFactory.GeoMesaDataStoreConfig
import org.locationtech.geomesa.index.utils.Explainer
import org.locationtech.geomesa.utils.index.ByteArrays
import org.opengis.feature.simple.SimpleFeatureType
import org.opengis.filter.Filter
import org.cupid.db.geomesa.storage.index.CupidShardStrategy.T1ShardStrategy

import java.time.ZonedDateTime
import java.util.Date

class T1IndexKeySpace(val sft: SimpleFeatureType, val sharding: ShardStrategy, dtgField: String)
    extends IndexKeySpace[FilterValues[Bounds[ZonedDateTime]], Long] {

  import T1IndexKeySpace.{Empty, MaxUpperBound, MinLowerBound}

  require(
    classOf[Date].isAssignableFrom(sft.getDescriptor(dtgField).getType.getBinding),
    s"Expected field $dtgField to have a date binding, but instead it has: " +
      sft.getDescriptor(dtgField).getType.getBinding.getName
  )

  private val dtgIndex = sft.indexOf(dtgField)

  override val attributes: Seq[String] = Seq(dtgField)

  override val indexKeyByteLength: Right[(Array[Byte], Int, Int) => Int, Int] = Right(
    8 + sharding.length
  )

  override val sharing: Array[Byte] = Empty

  override def toIndexKey(
      writable: WritableFeature,
      tier: Array[Byte],
      id: Array[Byte],
      lenient: Boolean
  ): RowKeyValue[Long] = {
    val dtg = writable.getAttribute[Date](dtgIndex)
    val time = if (dtg == null) {
      Long.MinValue
    } else {
      dtg.getTime
    }

    val shard = sharding(writable)
    val bytes = Array.ofDim[Byte](shard.length + 8 + id.length)

    if (shard.isEmpty) {
      ByteArrays.writeLong(time, bytes, 0);
      System.arraycopy(id, 0, bytes, 8, id.length)
    } else {
      bytes(0) = shard.head
      ByteArrays.writeLong(time, bytes, 1);
      System.arraycopy(id, 0, bytes, 9, id.length)
    }
    SingleRowKeyValue(bytes, Empty, shard, time, tier, id, writable.values)
  }

  override def getIndexValues(
      filter: Filter,
      explain: Explainer
  ): FilterValues[Bounds[ZonedDateTime]] =
    FilterHelper.extractIntervals(filter, dtgField)

  override def getRanges(
      values: FilterValues[Bounds[ZonedDateTime]],
      multiplier: Int
  ): Iterator[ScanRange[Long]] = {
    if (values.isEmpty) {
      Iterator.single(UnboundedRange(-1))
    } else if (values.disjoint) {
      Iterator.empty
    } else {
      values.values.iterator.map { bounds =>
        if (bounds.isEquals) {
          SingleRowRange(bounds.lower.value.get.toInstant.toEpochMilli)
        } else {
          val lower = bounds.lower.value.map { v =>
            val millis = v.toInstant.toEpochMilli
            if (bounds.lower.inclusive) {
              millis
            } else {
              millis + 1L
            }
          }
          val upper = bounds.upper.value.map { v =>
            val millis = v.toInstant.toEpochMilli
            if (bounds.upper.inclusive) {
              millis + 1L
            } else {
              millis
            }
          }
          BoundedRange(lower.getOrElse(MinLowerBound), upper.getOrElse(MaxUpperBound))
        }
      }
    }
  }

  override def getRangeBytes(
      ranges: Iterator[ScanRange[Long]],
      tier: Boolean
  ): Iterator[ByteRange] = {
    if (sharding.length == 0) {
      ranges.map {
        case BoundedRange(lo, hi) =>
          BoundedByteRange(ByteArrays.toBytes(lo), ByteArrays.toBytesFollowingPrefix(hi))
        case SingleRowRange(row) =>
          BoundedByteRange(ByteArrays.toBytes(row), ByteArrays.toBytesFollowingPrefix(row))
        case LowerBoundedRange(lo) =>
          BoundedByteRange(ByteArrays.toBytes(lo), ByteRange.UnboundedUpperRange)
        case UpperBoundedRange(hi) =>
          BoundedByteRange(ByteRange.UnboundedLowerRange, ByteArrays.toBytesFollowingPrefix(hi))
        case UnboundedRange(_) =>
          BoundedByteRange(ByteRange.UnboundedLowerRange, ByteRange.UnboundedUpperRange)
        case r =>
          throw new IllegalArgumentException(s"Unexpected range type $r")
      }
    } else {
      ranges.flatMap {
        case BoundedRange(lo, hi) =>
          val lower = ByteArrays.toBytes(lo)
          val upper = ByteArrays.toBytesFollowingPrefix(hi)
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )
        case SingleRowRange(row) =>
          val lower = ByteArrays.toBytes(row)
          val upper = ByteArrays.toBytesFollowingPrefix(row)
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )
        case LowerBoundedRange(lo) =>
          val lower = ByteArrays.toBytes(lo)
          val upper = ByteRange.UnboundedUpperRange
          sharding.shards.map(
            p => BoundedByteRange(ByteArrays.concat(p, lower), ByteArrays.concat(p, upper))
          )
        case UpperBoundedRange(hi) =>
          val lower = ByteRange.UnboundedLowerRange
          val upper = ByteArrays.toBytesFollowingPrefix(hi)
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

  override def useFullFilter(
      values: Option[FilterValues[Bounds[ZonedDateTime]]],
      config: Option[GeoMesaDataStoreConfig],
      hints: Hints
  ): Boolean = false
}

object T1IndexKeySpace extends IndexKeySpaceFactory[FilterValues[Bounds[ZonedDateTime]], Long] {

  // note: add 1 to exclude null values
  private val MinLowerBound = Long.MinValue + 1
  private val MaxUpperBound = Long.MaxValue

  private val Empty = Array.empty[Byte]

  override def supports(sft: SimpleFeatureType, attributes: Seq[String]): Boolean =
    attributes.lengthCompare(1) == 0 && sft.indexOf(attributes.head) != -1 &&
      classOf[Date].isAssignableFrom(sft.getDescriptor(attributes.head).getType.getBinding)

  override def apply(
      sft: SimpleFeatureType,
      attributes: Seq[String],
      tier: Boolean
  ): T1IndexKeySpace = {
    new T1IndexKeySpace(sft, T1ShardStrategy(sft), attributes.head)
  }
}

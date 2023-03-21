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
package org.cupid.db.geomesa.storage.index.xzstar

import org.cupid.db.geomesa.storage.curve.XZStarSFC
import org.geotools.util.factory.Hints
import org.locationtech.geomesa.filter.{FilterHelper, FilterValues}
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
import org.locationtech.geomesa.index.api.IndexKeySpace.IndexKeySpaceFactory
import org.locationtech.geomesa.index.api.ShardStrategy.{NoShardStrategy, ZShardStrategy}
import org.locationtech.geomesa.index.conf.QueryProperties
import org.locationtech.geomesa.index.geotools.GeoMesaDataStoreFactory.GeoMesaDataStoreConfig
import org.locationtech.geomesa.index.utils.Explainer
import org.locationtech.geomesa.utils.geotools.{GeometryUtils, WholeWorldPolygon}
import org.locationtech.geomesa.utils.index.ByteArrays
import org.locationtech.jts.geom.{Geometry, Point}
import org.opengis.feature.simple.SimpleFeatureType
import org.opengis.filter.Filter
import scala.util.control.NonFatal

class XZStarIndexKeySpace(
    val sft: SimpleFeatureType,
    val sharding: ShardStrategy,
    geomField: String
) extends IndexKeySpace[XZStarIndexValues, Long] {

  import org.locationtech.geomesa.utils.geotools.RichSimpleFeatureType.RichSimpleFeatureType

  require(
    classOf[Geometry].isAssignableFrom(sft.getDescriptor(geomField).getType.getBinding),
    s"Expected field $geomField to have a geometry binding, but instead it has: " +
      sft.getDescriptor(geomField).getType.getBinding.getSimpleName
  )

  protected val geomIndex: Int = sft.indexOf(geomField)
  protected val sfc = XZStarSFC(sft.getXZPrecision, 1)

  private val isPoints = sft.getDescriptor(geomIndex).getType.getBinding == classOf[Point]
  override val attributes: Seq[String] = Seq(geomField)

  override val indexKeyByteLength: Right[(Array[Byte], Int, Int) => Int, Int] = Right(
    8 + sharding.length
  )
  override val sharing: Array[Byte] = Array.empty

  override def toIndexKey(
      writable: WritableFeature,
      tier: Array[Byte],
      id: Array[Byte],
      lenient: Boolean
  ): RowKeyValue[Long] = {
    val geom = writable.getAttribute[Geometry](geomIndex)
    if (geom == null) {
      throw new IllegalArgumentException(s"Null geometry in feature ${writable.feature.getID}")
    }
    val xz = try {
      sfc.index(geom, lenient)
    } catch {
      case NonFatal(e) =>
        throw new IllegalArgumentException(s"Invalid xz value from geometry: $geom", e)
    }

    val shard = sharding(writable)
    // create the byte array - allocate a single array up front to contain everything
    // ignore tier, not used here
    val bytes = Array.ofDim[Byte](shard.length + 8 + id.length)

    if (shard.isEmpty) {
      ByteArrays.writeLong(xz, bytes, 0)
      System.arraycopy(id, 0, bytes, 8, id.length)
    } else {
      bytes(0) = shard.head // shard is only a single byte
      ByteArrays.writeLong(xz, bytes, 1)
      System.arraycopy(id, 0, bytes, 9, id.length)
    }

    SingleRowKeyValue(bytes, sharing, shard, xz, tier, id, writable.values)
  }

  override def getIndexValues(filter: Filter, explain: Explainer): XZStarIndexValues = {

    val geometries: FilterValues[Geometry] = {
      val extracted = FilterHelper.extractGeometries(filter, geomField, isPoints)
      if (extracted.nonEmpty) {
        extracted
      } else {
        FilterValues(Seq(WholeWorldPolygon))
      }
    }
    explain(s"Geometries: $geometries")

    // compute our ranges based on the coarse bounds for our query
    val xy: Seq[(Double, Double, Double, Double)] = {
      val multiplier = QueryProperties.PolygonDecompMultiplier.toInt.get
      val bits = QueryProperties.PolygonDecompBits.toInt.get
      geometries.values.flatMap(GeometryUtils.bounds(_, multiplier, bits))
    }

    XZStarIndexValues(sfc, geometries, xy)
  }

  override def getRanges(values: XZStarIndexValues, multiplier: Int): Iterator[ScanRange[Long]] = {
    val XZStarIndexValues(sfc, _, xy) = values

    // note: `target` will always be Some, as ScanRangesTarget has a default value
    val target = QueryProperties.ScanRangesTarget.option.map(t => math.max(1, t.toInt / multiplier))
    sfc
      .ranges(xy.map { case (xmin, ymin, xmax, ymax) => (xmin, ymin, xmax, ymax) }, target)
      .iterator
      .map(r => BoundedRange(r.lower, r.upper))
  }

  override def getRangeBytes(
      ranges: Iterator[ScanRange[Long]],
      tier: Boolean
  ): Iterator[ByteRange] = {
    if (sharding.length == 0) {
      ranges.map {
        case BoundedRange(lo, hi) =>
          BoundedByteRange(ByteArrays.toBytes(lo), ByteArrays.toBytesFollowingPrefix(hi))

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

  // always apply the full filter to xzstar queries
  override def useFullFilter(
      values: Option[XZStarIndexValues],
      config: Option[GeoMesaDataStoreConfig],
      hints: Hints
  ): Boolean = true

}

object XZStarIndexKeySpace extends IndexKeySpaceFactory[XZStarIndexValues, Long] {

  override def supports(sft: SimpleFeatureType, attributes: Seq[String]): Boolean =
    attributes.lengthCompare(1) == 0 && sft.indexOf(attributes.head) != -1 &&
      classOf[Geometry].isAssignableFrom(sft.getDescriptor(attributes.head).getType.getBinding)

  override def apply(
      sft: SimpleFeatureType,
      attributes: Seq[String],
      tier: Boolean
  ): XZStarIndexKeySpace = {
    val shards = if (tier) {
      NoShardStrategy
    } else {
      ZShardStrategy(sft)
    }
    new XZStarIndexKeySpace(sft, shards, attributes.head)
  }

}

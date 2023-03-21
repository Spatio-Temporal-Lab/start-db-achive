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
package org.cupid.db.geomesa.storage.index

import org.cupid.db.geomesa.storage.index.xzstar.XZStarIndex
import org.cupid.db.geomesa.storage.index.t1.T1Index
import org.cupid.db.geomesa.storage.index.z2t.{XZ2TIndex, Z2TIndex}
import org.locationtech.geomesa.index.api.{GeoMesaFeatureIndex, GeoMesaFeatureIndexFactory}
import org.locationtech.geomesa.index.geotools.GeoMesaDataStore
import org.locationtech.geomesa.utils.conf.IndexId
import org.opengis.feature.simple.SimpleFeatureType
import scala.util.Try

class CupidFeatureIndexFactory extends GeoMesaFeatureIndexFactory {

  private val available = Seq(Z2TIndex, XZ2TIndex, XZStarIndex, T1Index)

  override def indices(sft: SimpleFeatureType, hint: Option[String]): Seq[IndexId] = {
    hint match {
      case None => available.flatMap(i => i.defaults(sft).map(IndexId(i.name, i.version, _)))
      case Some(h) =>
        fromId(h)
          .orElse(fromName(sft, h))
          .orElse(fromNameAndAttributes(sft, h))
          .getOrElse(Seq.empty)
    }
  }

  override def available(sft: SimpleFeatureType): Seq[(String, Int)] =
    available.collect {
      case i if i.defaults(sft).exists(i.supports(sft, _)) => (i.name, i.version)
    }

  override def create[T, U](
      ds: GeoMesaDataStore[_],
      sft: SimpleFeatureType,
      index: IndexId
  ): Option[GeoMesaFeatureIndex[T, U]] = {

    lazy val Seq(geom3, dtg) = index.attributes
    lazy val Seq(geom2) = index.attributes
    lazy val Seq(dtg1) = index.attributes

    val idx = (index.name, index.version) match {

      case (Z2TIndex.name, 1)  => Some(new Z2TIndex(ds, sft, geom3, dtg, index.mode))
      case (XZ2TIndex.name, 1) => Some(new XZ2TIndex(ds, sft, geom3, dtg, index.mode))

      case (XZStarIndex.name, 1) => Some(new XZStarIndex(ds, sft, geom2, index.mode))

      case (T1Index.name, 1) => Some(new T1Index(ds, sft, dtg1, index.mode))

      case _ => None
    }
    idx.asInstanceOf[Option[GeoMesaFeatureIndex[T, U]]]
  }

  private def fromId(hint: String): Option[Seq[IndexId]] = Try(Seq(IndexId.id(hint))).toOption

  private def fromName(sft: SimpleFeatureType, hint: String): Option[Seq[IndexId]] = {
    available.find(i => hint.equalsIgnoreCase(i.name)).flatMap { i =>
      val defaults = i.defaults(sft).collect {
        case attributes if i.supports(sft, attributes) => IndexId(i.name, i.version, attributes)
      }
      if (defaults.isEmpty) {
        None
      } else {
        Some(defaults)
      }
    }
  }

  private def fromNameAndAttributes(sft: SimpleFeatureType, hint: String): Option[Seq[IndexId]] = {
    val Array(name, attributes @ _*) = hint.split(":")
    available.find(i => name.equalsIgnoreCase(i.name)).flatMap { i =>
      if (i.supports(sft, attributes)) {
        Some(Seq(IndexId(i.name, i.version, attributes)))
      } else {
        None
      }
    }
  }

}

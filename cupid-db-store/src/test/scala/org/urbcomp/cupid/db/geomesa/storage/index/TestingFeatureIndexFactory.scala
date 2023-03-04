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

package org.urbcomp.cupid.db.geomesa.storage.index

import org.locationtech.geomesa.index.api.{GeoMesaFeatureIndex, GeoMesaFeatureIndexFactory}
import org.locationtech.geomesa.index.geotools.GeoMesaDataStore
import org.locationtech.geomesa.utils.conf.IndexId
import org.opengis.feature.simple.SimpleFeatureType
import org.urbcomp.cupid.db.geomesa.storage.index.t1.T1Index

import scala.util.Try

/**
  * Feature index factory providing the default indices shipped with geomesa. Note: this class is not SPI loaded
  */
class TestingFeatureIndexFactory extends GeoMesaFeatureIndexFactory {

  private val available = Seq(T1Index)

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
    lazy val Seq(dtg0) = index.attributes

    val idx = (index.name, index.version) match {
      case (T1Index.name, 1) => Some(new T1Index(ds, sft, dtg0, index.mode))
      case _                 => None
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

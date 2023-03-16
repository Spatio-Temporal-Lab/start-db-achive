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

import org.cupid.db.geomesa.storage.index.strategies.TemporalFilterStrategy
import org.locationtech.geomesa.filter.{Bounds, FilterValues}
import org.locationtech.geomesa.index.api.{GeoMesaFeatureIndex, IndexKeySpace}
import org.locationtech.geomesa.index.geotools.GeoMesaDataStore
import org.locationtech.geomesa.index.index.ConfiguredIndex
import org.locationtech.geomesa.utils.index.IndexMode.IndexMode
import org.opengis.feature.simple.SimpleFeatureType
import org.cupid.db.geomesa.storage.index.CupidShardStrategy.T1ShardStrategy

import java.time.ZonedDateTime

class T1Index protected (
    ds: GeoMesaDataStore[_],
    sft: SimpleFeatureType,
    version: Int,
    dtg: String,
    mode: IndexMode
) extends GeoMesaFeatureIndex[FilterValues[Bounds[ZonedDateTime]], Long](
      ds,
      sft,
      T1Index.name,
      version,
      Seq(dtg),
      mode
    )
    with TemporalFilterStrategy[FilterValues[Bounds[ZonedDateTime]], Long] {

  def this(ds: GeoMesaDataStore[_], sft: SimpleFeatureType, dtgField: String, mode: IndexMode) =
    this(ds, sft, T1Index.version, dtgField, mode)

  override val keySpace: T1IndexKeySpace = new T1IndexKeySpace(sft, T1ShardStrategy(sft), dtg)

  override val tieredKeySpace: Option[IndexKeySpace[_, _]] = None
}

object T1Index extends ConfiguredIndex {

  import org.locationtech.geomesa.utils.geotools.RichSimpleFeatureType.RichSimpleFeatureType

  override val name = "t1"
  override val version = 1

  override def supports(sft: SimpleFeatureType, attributes: Seq[String]): Boolean =
    T1IndexKeySpace.supports(sft, attributes)

  override def defaults(sft: SimpleFeatureType): Seq[Seq[String]] = {
    if (sft.getDtgField.isDefined) {
      Seq(Seq(sft.getDtgField.get))
    } else {
      Seq.empty
    }
  }
}

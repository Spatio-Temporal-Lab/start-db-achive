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

import org.cupid.db.geomesa.storage.index.utils.CupidIndexConfigs.IndexT1Shards
import org.locationtech.geomesa.index.api.ShardStrategy
import org.opengis.feature.simple.SimpleFeatureType

object CupidShardStrategy {

  def int(value: AnyRef): Int = value match {
    case v: String => v.toInt
    case v: Number => v.intValue()
    case _         => throw new IllegalArgumentException(s"Input $value is not a numeric type")
  }

  object T1ShardStrategy {

    def apply(sft: SimpleFeatureType): ShardStrategy = {
      // default 4 shards
      ShardStrategy(Option(sft.getUserData.get(IndexT1Shards)).map(int).getOrElse(4))
    }
  }

}

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

import org.locationtech.geomesa.index.api.ShardStrategy
import org.opengis.feature.simple.SimpleFeatureType

object CupidShardStrategy {

  def int(value: AnyRef): Int = value match {
    case v: String => v.toInt
    case v: Number => v.intValue()
    case _         => throw new IllegalArgumentException(s"Input $value is not a numeric type")
  }

  object T1ShardStrategy {

    import org.urbcomp.cupid.db.geomesa.storage.index.utils.CupidIndexConfigs.IndexT1Shards;

    def apply(sft: SimpleFeatureType): ShardStrategy = {
      // default 4 shards
      ShardStrategy(Option(sft.getUserData.get(IndexT1Shards)).map(int).getOrElse(4))
    }
  }

}

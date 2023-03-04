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

package org.urbcomp.cupid.db.geomesa.storage.index.strategies

import org.locationtech.geomesa.filter.visitor.FilterExtractingVisitor
import org.locationtech.geomesa.filter.{FilterHelper, FilterValues, andFilters}
import org.locationtech.geomesa.index.api.{FilterStrategy, GeoMesaFeatureIndex}
import org.opengis.feature.simple.SimpleFeatureType
import org.opengis.filter.Filter

trait TemporalFilterStrategy[T, U] extends GeoMesaFeatureIndex[T, U] {
  // attributes are assumed to be a geometry field and a date field
  lazy private val Seq(dtg) = attributes

  override def getFilterStrategy(
      filter: Filter,
      transform: Option[SimpleFeatureType]
  ): Option[FilterStrategy] = {
    if (filter == Filter.INCLUDE) {
      Some(FilterStrategy(this, None, None, temporal = false, Float.PositiveInfinity))
    } else {
      val (temporal, others) = FilterExtractingVisitor(filter, dtg, sft)

      val intervals =
        temporal.map(FilterHelper.extractIntervals(_, dtg)).getOrElse(FilterValues.empty)

      if (!intervals.disjoint && !intervals.exists(_.isBounded)) {
        // if there aren't any intervals then we would have to do a full table scan
        Some(FilterStrategy(this, None, Some(filter), temporal = false, Float.PositiveInfinity))
      } else {
        Some(FilterStrategy(this, temporal, others, temporal = true, 1.1f))
      }
    }
  }
}

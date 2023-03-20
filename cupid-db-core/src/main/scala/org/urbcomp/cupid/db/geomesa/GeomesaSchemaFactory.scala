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
package org.urbcomp.cupid.db.geomesa

import org.apache.calcite.schema.impl.{AggregateFunctionImpl, TableFunctionImpl}
import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}
import org.urbcomp.cupid.db.function.udaf.CollectList
import org.urbcomp.cupid.db.udtf.{
  DBSCANClustering,
  Fibonacci,
  KMeansClustering,
  StayPointDetect,
  HybridTrajectorySegment,
  StayPointTrajectorySegment,
  TimeIntervalTrajectorySegment
}

import java.util

/**
  * Schema Factory of Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaSchemaFactory extends SchemaFactory {
  override def create(
      schemaPlus: SchemaPlus,
      schemaName: String,
      operands: util.Map[String, AnyRef]
  ): Schema = {
    initTableFunction(schemaPlus)
    new GeomesaSchema
  }

  private def initTableFunction(schemaPlus: SchemaPlus): Unit = {
    schemaPlus.add("fibonacci", TableFunctionImpl.create(Fibonacci.FIBONACCI2_TABLE_METHOD))
    schemaPlus.add(
      "st_traj_timeIntervalSegment",
      TableFunctionImpl.create(TimeIntervalTrajectorySegment.TIMEINTERVALSEGMENT_TABLE_METHOD)
    )
    schemaPlus.add(
      "st_traj_stayPointSegment",
      TableFunctionImpl.create(StayPointTrajectorySegment.STAYPOINTSEGMENT_TABLE_METHOD)
    )
    schemaPlus.add(
      "st_traj_hybridSegment",
      TableFunctionImpl.create(HybridTrajectorySegment.HYBRID_SEGMENT_TABLE_METHOD)
    )
    schemaPlus.add(
      "st_traj_stayPointDetect",
      TableFunctionImpl.create(StayPointDetect.STAY_POINT_DETECTION_TABLE_METHOD)
    )
    schemaPlus.add(
      "st_dbscan_clustering",
      TableFunctionImpl.create(DBSCANClustering.DBSCAN_CLUSTERING_TABLE_METHOD)
    )
    schemaPlus.add("st_collect_list", AggregateFunctionImpl.create(classOf[CollectList]))
    schemaPlus.add(
      "st_kmeans_clustering",
      TableFunctionImpl.create(KMeansClustering.KMEANS_CLUSTERING_TABLE_METHOD)
    )
  }

}

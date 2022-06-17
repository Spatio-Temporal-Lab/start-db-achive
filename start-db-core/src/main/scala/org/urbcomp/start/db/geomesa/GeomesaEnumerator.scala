/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.geomesa

import org.apache.calcite.linq4j.Enumerator
import org.geotools.data.{DataStoreFinder, FeatureReader, Query, Transaction}
import org.geotools.filter.text.ecql.ECQL
import org.opengis.feature.simple.{SimpleFeature, SimpleFeatureType}
import org.urbcomp.start.db.common.ConfigProvider
import org.urbcomp.start.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.start.db.util.MetadataUtil

import java.util
import scala.collection.JavaConverters._

/**
  * Enumerator for Geomesa
  *
  * @param reader FeatureReader
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaEnumerator(reader: FeatureReader[SimpleFeatureType, SimpleFeature])
    extends Enumerator[Object] {

  var curr: Array[AnyRef] = _

  override def current(): Array[AnyRef] = curr

  override def moveNext(): Boolean = {
    try {
      if (!reader.hasNext) {
        return false
      }
      val roadTransformer = new RoadSegmentAndGeomesaTransformer
      val trajTransformer = new TrajectoryAndFeatureTransformer
      val name = reader.getFeatureType.getName
      if ("t_road_segment_test".equals(name.toString)) {
        tempRoadSegmentMoveNext(roadTransformer)
      } else if ("t_trajectory_test".equals(name.toString)) {
        tempTrajectoryMoveNext(trajTransformer)
      } else if ("taxitraj".equals(name.toString)) {
        tempTaxitrajMoveNext(trajTransformer)
      } else if ("road".equals(name.toString)) {
        tempRoadMoveNext(roadTransformer)
      } else {
        curr = reader.next().getAttributes.asScala.toArray
      }
    } catch {
      case _: Exception => return false
    }
    true
  }

  override def reset(): Unit = Unit

  override def close(): Unit = reader.close()

  /**
    * Temporary iteration method for He Xiang's RoadSegment test table
    * @author Wang Bohong
    * @param transformer RoadSegmentAndGeomesaTransformer instance
    */
  private def tempRoadSegmentMoveNext(transformer: RoadSegmentAndGeomesaTransformer): Unit = {
    val feature = reader.next()
    val array = feature.getAttributes.asScala.toArray
    val list = new util.ArrayList[AnyRef]
    // a 行数据
    list.add(array(0))
    list.add(transformer.toRoadSegment(feature, "b"))
    list.add(transformer.toRoadSegment(feature, "c"))
    curr = list.toArray
  }

  /**
    * Temporary iteration method for Li Zheng's Trajectory test table
    * @author Wang Bohong
    * @param transformer TrajectoryAndFeatureTransformer instance
    */
  private def tempTrajectoryMoveNext(transformer: TrajectoryAndFeatureTransformer): Unit = {
    val feature = reader.next()
    val array = feature.getAttributes.asScala.toArray
    val list = new util.ArrayList[AnyRef]
    // a 行数据
    list.add(array(0))
    list.add(transformer.toTrajectory(feature, "t1"))
    curr = list.toArray
  }

  /**
    * Temporary iteration method for Li Zheng's Trajectory test table
    * @author Wang Bohong
    * @param transformer TrajectoryAndFeatureTransformer instance
    */
  private def tempRoadMoveNext(transformer: RoadSegmentAndGeomesaTransformer): Unit = {
    val feature = reader.next()
    val array = feature.getAttributes.asScala.toArray
    val list = new util.ArrayList[AnyRef]
    // a 行数据
    list.add(array(0))
    list.add(transformer.toRoadSegment(feature, "rs"))
    curr = list.toArray
  }

  /**
    * Temporary iteration method for taxitraj table
    * @author Wang Bohong
    * @param transformer TrajectoryAndFeatureTransformer instance
    */
  private def tempTaxitrajMoveNext(transformer: TrajectoryAndFeatureTransformer): Unit = {
    val feature = reader.next()
    val array = feature.getAttributes.asScala.toArray
    val list = new util.ArrayList[AnyRef]
    // a 行数据
    list.add(array(0))
    list.add(transformer.toTrajectory(feature, "traj"))
    curr = list.toArray
  }
}

object GeomesaEnumerator {
  def apply(filter: String, tableName: String, dbName: String, user: String): GeomesaEnumerator = {
    val catalog = MetadataUtil.makeCatalog(user, dbName)
    val dataStore =
      DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(catalog).asJava)
    val query = new Query(tableName, ECQL.toFilter(filter))
    new GeomesaEnumerator(dataStore.getFeatureReader(query, Transaction.AUTO_COMMIT))
  }
}

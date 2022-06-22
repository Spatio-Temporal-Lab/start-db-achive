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
import org.urbcomp.start.db.metadata.{AccessorFactory, MetadataVerifyUtil}
import org.urbcomp.start.db.metadata.entity.Field
import org.urbcomp.start.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.start.db.util.MetadataUtil

import java.util
import java.util.{Collections, Comparator}
import scala.collection.JavaConverters._

/**
  * Enumerator for Geomesa
  *
  * @param reader FeatureReader
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaEnumerator(
    reader: FeatureReader[SimpleFeatureType, SimpleFeature],
    userName: String,
    dbName: String,
    tableName: String
) extends Enumerator[Object] {

  var curr: Array[AnyRef] = _

  override def current(): Array[AnyRef] = curr

  override def moveNext(): Boolean = {
    try {
      if (!reader.hasNext) {
        return false
      }
      // sf index
      var index = 0
      val fields = MetadataVerifyUtil.getFields(userName, dbName, tableName)
      if (fields == null) return false
      fields.toArray()
      val feature = reader.next()
      val array = feature.getAttributes.asScala.toArray
      val list = new util.ArrayList[AnyRef]
      for (i <- 0 until fields.size()) {
        val field = fields.get(i)
        if (field.getType == "RoadSegment") {
          val transformer = new RoadSegmentAndGeomesaTransformer
          list.add(transformer.toRoadSegment(feature, field.getName))
          index += 3
        } else if (field.getType == "Trajectory") {
          val transformer = new TrajectoryAndFeatureTransformer
          list.add(transformer.toTrajectory(feature, field.getName))
          index += 6
        } else {
          list.add(array(index))
          index += 1
        }
      }
      curr = list.toArray
    } catch {
      case _: Exception => return false
    }
    true
  }

  override def reset(): Unit = Unit

  override def close(): Unit = reader.close()

}

object GeomesaEnumerator {
  def apply(filter: String, tableName: String, dbName: String, user: String): GeomesaEnumerator = {
    val catalog = MetadataUtil.makeCatalog(user, dbName)
    val dataStore =
      DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(catalog).asJava)
    val query = new Query(tableName, ECQL.toFilter(filter))
    new GeomesaEnumerator(
      dataStore.getFeatureReader(query, Transaction.AUTO_COMMIT),
      user,
      dbName,
      tableName
    )
  }
}

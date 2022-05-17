package org.urbcomp.start.db.geomesa

import org.apache.calcite.linq4j.Enumerator
import org.geotools.data.{DataStoreFinder, FeatureReader, Query, Transaction}
import org.geotools.filter.text.ecql.ECQL
import org.opengis.feature.simple.{SimpleFeature, SimpleFeatureType}
import org.urbcomp.start.db.common.ConfigProvider

import scala.collection.JavaConverters._

/**
 * Enumerator for Geomesa
 *
 * @param reader FeatureReader
 *
 * @author zaiyuan
 * @since 0.1.0
 */
class GeomesaEnumerator(reader: FeatureReader[SimpleFeatureType, SimpleFeature]) extends Enumerator[Object] {

  var curr: Array[AnyRef] = _

  override def current(): Array[AnyRef] = curr

  override def moveNext(): Boolean = {
    try {
      if (!reader.hasNext) {
        return false
      }
      curr = reader.next().getAttributes.asScala.toArray
    } catch {
      case _: Exception => return false
    }
    true
  }

  override def reset(): Unit = Unit

  override def close(): Unit = reader.close()
}

object GeomesaEnumerator {
  def apply(filter: String, tableName: String, dbName: String): GeomesaEnumerator = {
    val dataStore = DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(dbName).asJava)
    val query = new Query(tableName, ECQL.toFilter(filter))
    new GeomesaEnumerator(dataStore.getFeatureReader(query, Transaction.AUTO_COMMIT))
  }
}

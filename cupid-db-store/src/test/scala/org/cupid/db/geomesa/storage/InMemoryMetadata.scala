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
package org.cupid.db.geomesa.storage

import org.locationtech.geomesa.index.metadata.GeoMesaMetadata

class InMemoryMetadata[T] extends GeoMesaMetadata[T] {

  import scala.collection.mutable.{Map => mMap}

  private val schemas = mMap.empty[String, mMap[String, T]]

  override def getFeatureTypes: Array[String] = synchronized(schemas.keys.toArray)

  override def insert(typeName: String, key: String, value: T): Unit = synchronized {
    schemas.getOrElseUpdate(typeName, mMap.empty[String, T]).put(key, value)
  }

  override def insert(typeName: String, kvPairs: Map[String, T]): Unit = synchronized {
    val m = schemas.getOrElseUpdate(typeName, mMap.empty[String, T])
    kvPairs.foreach { case (k, v) => m.put(k, v) }
  }

  override def remove(typeName: String, key: String): Unit = synchronized {
    schemas.get(typeName).foreach(_.remove(key))
  }

  override def remove(typeName: String, keys: Seq[String]): Unit = keys.foreach(remove(typeName, _))

  override def read(typeName: String, key: String, cache: Boolean): Option[T] = synchronized {
    schemas.get(typeName).flatMap(_.get(key))
  }

  override def scan(typeName: String, prefix: String, cache: Boolean): Seq[(String, T)] =
    synchronized {
      schemas.get(typeName) match {
        case None    => Seq.empty
        case Some(m) => m.filterKeys(_.startsWith(prefix)).toSeq
      }
    }

  override def delete(typeName: String): Unit = synchronized {
    schemas.remove(typeName)
  }

  override def invalidateCache(typeName: String, key: String): Unit = {}

  override def backup(typeName: String): Unit = {}

  override def close(): Unit = {}

  /**
    * table cache should be cleared up when catalog is deleted in database
    */
  override def resetCache(): Unit = {}
}

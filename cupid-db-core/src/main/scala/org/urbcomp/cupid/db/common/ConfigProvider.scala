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
package org.urbcomp.cupid.db.common

/**
  * Config Provider
  *
  * @author zaiyuan
  * @since 0.1.0
  */
object ConfigProvider {

  def getGeomesaHbaseParam(catalog: String): Map[String, String] =
    Map(
      ConfigurationConstants.GEOMESA_HBASE_CATALOG -> catalog,
      ConfigurationConstants.GEOMESA_HBASE_ZOOKEEPERS -> getHBaseZookeepers
    )

  def getHBaseZookeepers: String =
    ConfigurationFactory.getInstance.getProperty(ConfigurationConstants.GEOMESA_HBASE_ZOOKEEPERS)
}

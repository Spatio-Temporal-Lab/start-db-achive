package org.urbcomp.start.db.common

/**
 * Config Provider
 *
 * @author zaiyuan
 * @date 2022/05/01
 * @since 0.1.0
 */
object ConfigProvider {

  def getGeomesaHbaseParam(catalog: String): Map[String, String] =
    Map(ConfigurationConstants.GEOMESA_HBASE_CATALOG -> catalog,
      ConfigurationConstants.GEOMESA_HBASE_ZOOKEEPERS ->
        ConfigurationFactory.getInstance.getProperty(
          ConfigurationConstants.GEOMESA_HBASE_ZOOKEEPERS))

}

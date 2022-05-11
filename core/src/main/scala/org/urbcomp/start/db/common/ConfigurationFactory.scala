package org.urbcomp.start.db.common

import java.util.Properties

/**
 * Configuration Factory
 *
 * @author zaiyuan
 * @date 2022/05/01
 * @since 0.1.0
 */
object ConfigurationFactory {

  private lazy val properties: Properties = {
    val properties = new Properties
    val stream = this.getClass.getClassLoader.getResourceAsStream("config.properties")
    properties.load(stream)
    properties
  }

  def getInstance: Properties = properties

}

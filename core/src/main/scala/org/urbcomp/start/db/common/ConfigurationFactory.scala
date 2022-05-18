/*
 * Copyright 2022 ST-Lab

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

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

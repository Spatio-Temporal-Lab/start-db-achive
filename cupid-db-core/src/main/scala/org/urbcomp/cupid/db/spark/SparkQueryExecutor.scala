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

package org.urbcomp.cupid.db.spark

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession

object SparkQueryExecutor extends LazyLogging {
  def executeLocal(sql: String, spark: SparkSession): Unit = {
    val df = spark.sql(sql)
  }
}

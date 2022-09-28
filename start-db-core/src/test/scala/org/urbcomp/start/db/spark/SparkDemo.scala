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

package org.urbcomp.start.db.spark

import org.apache.spark.sql.SparkSession

object SparkDemo {

  val ST_DIVIDE: Int => Int = g => g / 3

  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession = SparkSession
      .builder()
      .appName("spark demo")
      .master("local[*]")
      .getOrCreate()
    sparkSession.sqlContext.udf.register("st_divide", ST_DIVIDE)

    sparkSession.sql("select st_divide(9)").show()
  }

}

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
import org.geotools.data.DataStoreFinder

import java.util
import scala.collection.JavaConverters._

object SparkQueryExecutor extends LazyLogging {
  def executeLocal(sql: String, spark: SparkSession): Unit = {
    val df = spark.sql(sql)
  }

  def main(args: Array[String]): Unit = {
    val params = Map("hbase.catalog" -> "test", "hbase.zookeepers" -> "localhost:2181")
//    val datastore = DataStoreFinder.getDataStore(params.asJava)
//    println()
    val sparkSession = SparkSession
      .builder()
      .appName("testSpark")
      .config("spark.sql.crossJoin.enabled", "true")
      .master("local[*]")
      .getOrCreate()
    sparkSession.read
      .format("geomesa")
    sparkSession.sql("select 1+1").show()
  }
}

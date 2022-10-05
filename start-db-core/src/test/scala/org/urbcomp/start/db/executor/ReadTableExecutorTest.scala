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

package org.urbcomp.start.db.executor

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.locationtech.geomesa.spark.{GeoMesaSparkKryoRegistrator, SpatialRDD}
import org.opengis.feature.simple.SimpleFeature
import org.scalatest.{BeforeAndAfterAll, FunSuite}

/**
  * @author stan
  * @date 2022/10/5 10:54
  */
class ReadTableExecutorTest extends FunSuite with BeforeAndAfterAll {

  test("read geomesa-hbase data") {
    // should insert some data before running

    val executor = new ReadTableExecutor
    val spatialRDD: SpatialRDD = executor.execute(user = "root", dbName = "*", "select * from t1")
    val features: Array[SimpleFeature] = spatialRDD.collect()

    assert(features.length != 0)
  }
}

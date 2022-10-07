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
import org.urbcomp.start.db.AbstractCalciteFunctionTest

/**
  * @author stan
  * @date 2022/10/5 10:54
  */
class ReadTableExecutorTest extends AbstractCalciteFunctionTest {

  test("read geomesa-hbase data") {
    val executor = new SparkExecutor
    executor.execute("select * from t_test")
  }
}

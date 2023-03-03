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

import org.urbcomp.cupid.db.util.{Base64Util, JacksonUtil, SparkSqlParam}

/**
  * debug test:
  * spark-submit  \
  * --class org.urbcomp.cupid.db.spark.CupidDriver \
  * --master yarn  \
  * --deploy-mode cluster \
  * --driver-memory 1g \
  * --executor-cores 1 \
  * --executor-memory 1g \
  * --num-executors 1 \
  * cupid-db.jar base64Serialized_SparkSqlParam
  */
object CupidSparkDriver {

  def deserializeParam(args: Array[String]): SparkSqlParam = {
    if (args.length < 1)
      throw new RuntimeException("Invalid args:" + args.mkString("Array(", ", ", ")"))
    val encodeParam = args(0)
    JacksonUtil.MAPPER.readValue(Base64Util.decode(encodeParam), classOf[SparkSqlParam])
  }

  def main(args: Array[String]): Unit = {
    val sqlParam = deserializeParam(args)
    SparkQueryExecutor.execute(sqlParam)
  }

}

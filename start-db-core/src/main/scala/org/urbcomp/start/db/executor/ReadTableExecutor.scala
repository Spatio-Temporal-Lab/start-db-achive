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

import org.apache.hadoop.conf.Configuration
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.geotools.data.Query
import org.locationtech.geomesa.spark.{
  GeoMesaSpark,
  GeoMesaSparkKryoRegistrator,
  SpatialRDD,
  SpatialRDDProvider
}
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.metadata.entity.Table
import org.urbcomp.start.db.parser.{Constant, SqlVisitor}
import org.urbcomp.start.db.util.MetadataUtil

import scala.collection.JavaConverters._

/**
  * @author stan
  * @date 2022/10/5 10:27
  */
class ReadTableExecutor {

  def tableNameMap(user: String, dbName: String, tableName: String): String = {
    val table: Table = MetadataAccessUtil.getTable(user, dbName, tableName)
    val mapTableName: String = MetadataUtil.makeSchemaName(table.getId)
    mapTableName
  }

  def execute(user: String, dbName: String, sql: String): SpatialRDD = {
    val visitor = new SqlVisitor[String]
    val tableName: String = tableNameMap(user, dbName, visitor.apply(sql))

    val conf: SparkConf = new SparkConf()
      .setAppName("Spark Demo")
      .setMaster("local[*]")

    conf.set(Constant.SPARK_SERIALIZER, Constant.SERIALIZER)
    conf.set(Constant.SPARK_KRYO, classOf[GeoMesaSparkKryoRegistrator].getName)

    val ss: SparkSession = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()

    val params = Map(Constant.HBASE_CATALOG -> Constant.CATALOG, Constant.HBASE_ZK -> Constant.ZK)
    val spatialRDDProvider: SpatialRDDProvider = GeoMesaSpark(params.asJava)

    val rDD: SpatialRDD = spatialRDDProvider
      .rdd(new Configuration, ss.sparkContext, params, new Query(tableName))
    rDD
  }
}

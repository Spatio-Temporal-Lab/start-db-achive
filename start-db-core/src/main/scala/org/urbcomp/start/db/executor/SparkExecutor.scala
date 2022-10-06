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

import org.apache.spark.sql.SparkSession
import org.urbcomp.start.db.metadata.MetadataAccessUtil
import org.urbcomp.start.db.metadata.entity.Table
import org.urbcomp.start.db.parser.{Constant, SqlTableDriver}
import org.urbcomp.start.db.util.{MetadataUtil, SqlParam}

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * @author stan
  * @date 2022/10/5 10:27
  */
class SparkExecutor {

  def execute(sql: String): String = {
    val param = SqlParam.CACHE.get()
    val dbName = param.getDbName
    val userName = param.getUserName
    val tableMap = new mutable.HashMap[String, String]
    // 用户的上层表名
    val driver = new SqlTableDriver
    val tableList = driver.apply(sql)

    tableList.asScala.foreach{ i =>
      val table: Table = MetadataAccessUtil.getTable(userName, dbName, i)
      val mapTableName: String = MetadataUtil.makeSchemaName(table.getId)
      tableMap.put(i, mapTableName)
    }

    val sparkSession: SparkSession = SparkSession
      .builder()
      .appName("start-db sql app")
      .master("local[*]")
      .getOrCreate()

    val params = Map(Constant.HBASE_CATALOG -> Constant.CATALOG, Constant.HBASE_ZK -> Constant.ZK)

    /**
     * _1: 上层表名
     * _2: 下层表名
     */
    tableMap.foreach{ i =>
      val userTableName = i._1
      val geomesaSftName = i._2
      sparkSession.read
        .format("geomesa")
        .options(params)
        .option("geomesa.feature", geomesaSftName)
        .load()
        .createTempView(userTableName)
    }

    val dataFrame = sparkSession.sql(sql)

    val path = "hdfs://start-db:balabal"
    dataFrame.write.option("delimiter", "||").csv(path)
    path
  }
}

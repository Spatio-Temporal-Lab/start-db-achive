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

import org.apache.calcite.sql.{SqlDialect, SqlNode}
import org.apache.spark.sql.SparkSession
import org.urbcomp.start.db.util.{MetadataUtil, SqlParam}

class SparkExecutor {

  def execute(sql: SqlNode): Unit = {
    // 获取缓存的配置信息
    val param = SqlParam.CACHE.get()

    // TODO 获取数据

    val geomesaParam = Map("" -> "")
    val sparkSession: SparkSession = SparkSession
      .builder()
      .appName("start-db sql app")
      .master("local[*]")
      .getOrCreate()

    // 读取相关的表数据
    sparkSession.read
      .format("geomesa")
      .options(geomesaParam)
      .option("geomesa.feature", "chicago")
      .load()
      .createTempView("")

    // 基于sql对读取数据进行查询
    sparkSession.sql(sql.toSqlString(new SqlDialect(SqlDialect.EMPTY_CONTEXT)).getSql)

    // 写入到中间存储介质中
  }

}

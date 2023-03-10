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

package org.urbcomp.cupid.db.spark.res

import org.apache.spark.sql.{DataFrame, SaveMode}
import org.urbcomp.cupid.db.config.DynamicConfig

/**
  * @author jimo
  * */
class SparkResult2HdfsExporter extends ISparkResultExporter {

  override def exportData(sqlId: String, data: DataFrame): Unit = {

    val hdfsPath = DynamicConfig.getSparkHdfsResultPath
    val schemaJson = data.schema.json

    import data.sparkSession.implicits._
    val schemaDf = data.sqlContext.sparkContext.parallelize(List(schemaJson))
    schemaDf
      .toDF()
      .coalesce(1)
      .write
      .mode(SaveMode.Overwrite)
      .text(hdfsPath + buildSchemaName(sqlId))

    data
      .coalesce(1)
      .write
      .mode(SaveMode.Overwrite)
      .option("header", value = false)
      .option("sep", "\001")
      .csv(hdfsPath + buildDataName(sqlId))
  }
}

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

import org.urbcomp.cupid.db.model.data.DataExportType

/**
  * @author jimo
  * */
object SparkResultExporterFactory {

  def getInstance(exportType: DataExportType): ISparkResultExporter = {
    exportType match {
      case DataExportType.PRINT => new ShowSparkResultExporter
      case DataExportType.HDFS  => new SparkResult2HdfsExporter
      case _                    => throw new IllegalArgumentException("not support type now:" + exportType)
    }
  }
}

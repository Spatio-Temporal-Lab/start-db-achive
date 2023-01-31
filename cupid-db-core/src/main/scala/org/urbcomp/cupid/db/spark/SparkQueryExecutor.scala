package org.urbcomp.cupid.db.spark

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession

object SparkQueryExecutor extends LazyLogging{
  def executeLocal(sql: String, spark: SparkSession): Unit = {
    val df = spark.sql(sql)
  }
}

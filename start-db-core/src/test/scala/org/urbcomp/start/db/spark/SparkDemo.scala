package org.urbcomp.start.db.spark

import org.apache.spark.sql.SparkSession

object SparkDemo {

  val ST_DIVIDE:      Int => Int       = g => g / 3

  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession = SparkSession.builder()
      .appName("spark demo")
      .master("local[*]")
      .getOrCreate()
    sparkSession.sqlContext.udf.register("st_divide", ST_DIVIDE)

    sparkSession.sql("select st_divide(9)").show()
  }

}

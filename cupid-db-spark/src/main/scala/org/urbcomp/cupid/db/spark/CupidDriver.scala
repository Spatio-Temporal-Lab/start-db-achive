package org.urbcomp.cupid.db.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.locationtech.geomesa.spark.GeoMesaSparkKryoRegistrator
import org.urbcomp.cupid.db.util.{MetadataUtil, SqlParam}

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
 * cupid-db.jar -i SqlId -s "select 1+1" -u zaiyuan -d default
 */
object CupidDriver {
  def main(args: Array[String]): Unit = {

  }

  def execute(param: SqlParam, sparkSession: SparkSession = null): DataFrame = {
    if (param != null) SqlParam.CACHE.set(param)
    var spark = sparkSession

    if (spark == null) spark = getSparkSession(param.isLocal, enableHiveSupport = false)

    val sql = param.getSql
    CupidSparkTableExtractVisitor.getTableList(sql).foreach { i =>
      val userName = SqlParam.CACHE.get().getUserName
      val dbName = i.split("\\.")(0)
      val tableName = i.split("\\.")(1)
      val catalogName = MetadataUtil.makeCatalog(userName, dbName)
      val sftName = MetadataUtil.combineUserDbTableKey(userName, dbName, tableName)
      loadTable(tableName, sftName, catalogName, spark)
    }
    spark.sql(sql)
  }

  def loadTable(tableName: String, baseName: String, catalogName: String, sparkSession: SparkSession): Unit = {
    sparkSession.read
      .format("geomesa")
      .options(
        Map(
          "hbase.catalog" -> catalogName,
          "hbase.zookeepers" -> "localhost:2181"))
      .option("geomesa.feature", baseName)
      .load()
      .createTempView(tableName)
  }

  def getSparkSession(isLocal: Boolean, enableHiveSupport: Boolean): SparkSession = {
    val builder = SparkSession.builder().config(buildSparkConf()).appName("Cupid-SPARK")
    if (isLocal) builder.master("local[*]")
    if (enableHiveSupport) builder.enableHiveSupport()
    builder.getOrCreate()
  }

  def buildSparkConf(): SparkConf = {
    val conf = new SparkConf()
    conf.set("spark.sql.adaptive.enabled", "true")
    conf.set("spark.sql.crossJoin.enabled", "true")
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    conf.set("spark.kryo.registrator", classOf[GeoMesaSparkKryoRegistrator].getName)
    conf.set("spark.kryoserializer.buffer.max", "256m")
    conf.set("spark.kryoserializer.buffer", "64m")
    conf
  }


}

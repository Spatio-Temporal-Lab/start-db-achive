/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.spark

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.locationtech.geomesa.spark.GeoMesaSparkKryoRegistrator
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.spark.res.SparkResultExporterFactory
import org.urbcomp.cupid.db.util.{MetadataUtil, SparkSqlParam}

object SparkQueryExecutor extends LazyLogging {

  def execute(param: SparkSqlParam, sparkSession: SparkSession = null): Unit = {
    if (param != null) SparkSqlParam.CACHE.set(param)
    var spark = sparkSession

    if (spark == null) spark = getSparkSession(param.isLocal, enableHiveSupport = false)

    val sql = param.getSql
    CupidSparkTableExtractVisitor.getTableList(sql).foreach { i =>
      val userName = SparkSqlParam.CACHE.get().getUserName
      val dbTableNames = i.split("\\.")
      val dbName = dbTableNames(0)
      val tableName = dbTableNames(1)
      val catalogName = MetadataUtil.makeCatalog(userName, dbName)
      val table = MetadataAccessUtil.getTable(userName, dbName, tableName)
      if (table == null) throw new IllegalArgumentException("Table Not Exists: " + i)
      val sft = MetadataUtil.makeSchemaName(table.getId)
      loadTable(tableName, sft, catalogName, spark, param.getHbaseZookeepers)
    }
    val df = spark.sql(sql)
    SparkResultExporterFactory.getInstance(param.getExportType).exportData(param.getSqlId, df)
  }

  def loadTable(
      tableName: String,
      baseName: String,
      catalogName: String,
      sparkSession: SparkSession,
      hbaseZookeepers: String
  ): Unit = {
    sparkSession.read
      .format("geomesa")
      .options(Map("hbase.catalog" -> catalogName, "hbase.zookeepers" -> hbaseZookeepers))
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

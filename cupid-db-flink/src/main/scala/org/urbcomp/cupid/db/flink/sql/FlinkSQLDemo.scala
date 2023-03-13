package org.urbcomp.cupid.db.flink.sql

import org.apache.flink.api.scala.createTypeInformation
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.Table
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment
import org.locationtech.jts.geom.Point
import org.sikongsphere.flink.GeometrySerializer
import org.sikongsphere.flink.function.Functions

object FlinkSQLDemo {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    env.getConfig.registerTypeWithKryoSerializer(classOf[Point], new GeometrySerializer)

    val inputStream = env.readTextFile(this.getClass.getClassLoader.getResource("spatial_tempo.csv").getPath)
    val dataStream: DataStream[Car] = inputStream.map { data =>
      val dataArray = data.split(",")
      Car(dataArray(0).toInt, dataArray(1), dataArray(2), dataArray(3), dataArray(4))
    }

    val tableEnv = StreamTableEnvironment.create(env)
    tableEnv.createTemporarySystemFunction("st_point", new Functions.ST_Point)
    val dataTable: Table = tableEnv.fromDataStream(dataStream)

    tableEnv.createTemporaryView("sourceTable", dataTable)
    //    dataTable.select("num, pt").filter("num > 3").execute().print()
    val resultTable = tableEnv.sqlQuery("select st_point(100, 45)")
    resultTable.execute().print()
  }

}

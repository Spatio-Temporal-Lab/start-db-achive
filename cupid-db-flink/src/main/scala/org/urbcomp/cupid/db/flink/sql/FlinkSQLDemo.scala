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
package org.urbcomp.cupid.db.flink.sql

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment
import org.locationtech.jts.geom.Point
import org.urbcomp.cupid.db.flink.function.Functions
import org.urbcomp.cupid.db.flink.serialize.PointSerializer

object FlinkSQLDemo {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    env.getConfig.registerTypeWithKryoSerializer(classOf[Point], new PointSerializer)

//    val inputStream =
//      env.readTextFile(this.getClass.getClassLoader.getResource("spatial_tempo.csv").getPath)
//    val dataStream: DataStream[Car] = inputStream.map { data =>
//      val dataArray = data.split(",")
//      Car(dataArray(0).toInt, dataArray(1), dataArray(2), dataArray(3), dataArray(4))
//    }

    val tableEnv = StreamTableEnvironment.create(env)
    tableEnv.createTemporarySystemFunction("st_point", new Functions.ST_Point)
//    val dataTable: Table = tableEnv.fromDataStream(dataStream)

//    tableEnv.createTemporaryView("sourceTable", dataTable)
    //    dataTable.select("num, pt").filter("num > 3").execute().print()
    val resultTable = tableEnv.sqlQuery("select st_point(100, 45)")
    resultTable.execute().print()
  }

}

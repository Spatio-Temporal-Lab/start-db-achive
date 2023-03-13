package org.urbcomp.cupid.db.flink.sql

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

object FlinkDemo {

  def main(args: Array[String]): Unit = {
    // 1. 获取stream执行环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    // 2. 初始化数据源
    val ds: DataStream[String] = env.socketTextStream("localhost", 6666)
    // 3. 数据加工
    val sumDS: DataStream[(String, Int)] = ds.filter(_.length > 3)
      .flatMap(_.split(" "))
      .map((_, 1))
      .keyBy(0)
      .sum(1)
    // 4. 数据落地
    sumDS.print()
    // 5. 触发作业执行
    env.execute("my-flink-wc")
  }

}

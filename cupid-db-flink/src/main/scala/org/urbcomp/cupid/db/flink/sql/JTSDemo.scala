package org.urbcomp.cupid.db.flink.sql

import org.locationtech.jts.io.WKTReader

object JTSDemo {

  def main(args: Array[String]): Unit = {
    val reader = new WKTReader()
    val geometry = reader.read("POINT(100 45)")
    println()
  }

}

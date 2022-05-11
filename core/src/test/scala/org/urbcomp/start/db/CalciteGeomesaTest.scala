package org.urbcomp.start.db

import org.scalatest.{BeforeAndAfterAll, FunSuite}

import java.net.URLDecoder
import java.sql.DriverManager
import java.util.Properties

/**
 * Test for Calcite and Geomesa
 *
 * @author zaiyuan
 * @since 0.1.0
 */
class CalciteGeomesaTest extends FunSuite with BeforeAndAfterAll {

  var config: Properties = _

  override protected def beforeAll(): Unit = {
    val url = this.getClass.getResource("/model.json")
    val str = URLDecoder.decode(url.toString, "UTF-8")
    config = new Properties
    config.put("model", str.replace("file:", ""))
    config.put("caseSensitive", "false")
  }

  test("calcite geomesa test") {
    val connect = DriverManager.getConnection("jdbc:calcite:", config)
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select * from test_table01 where age = 10")
    while (resultSet.next()) {
      println(resultSet.getObject(1))
    }
  }

}

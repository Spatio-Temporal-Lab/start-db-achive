package org.urbcomp.start.db

import org.junit.Assert.assertEquals

class StringFunctionTest extends CalciteGeomesaFunctionTest {
  test("concat") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select concat('1', '2')")
    resultSet.next()
    assertEquals("12", resultSet.getObject(1))
  }
}

package org.urbcomp.start.db

import org.junit.Assert.assertEquals

class GeometricConstructorFunctionTest extends CalciteGeomesaFunctionTest {
  test("st_makePoint") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select st_makePoint(1, 2)")
    resultSet.next()
    assertEquals("POINT (1 2)", resultSet.getObject(1).toString)
  }
}

/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db

import org.junit.Assert.assertEquals

/**
 * String Function test
 * @author zaiyuan, XiangHe
 */

class StringFunctionTest extends CalciteGeomesaFunctionTest {
  test("concat") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select concat('1', '2')")
    resultSet.next()
    assertEquals("12", resultSet.getObject(1))
  }

  test("reverse") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select reverse('abcde')")
    resultSet.next()
    assertEquals("edcba", resultSet.getObject(1))
  }

  test("upper") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select upper('abcde')")
    resultSet.next()
    assertEquals("ABCDE", resultSet.getObject(1))
  }

  test("lower") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select lower('ABCDE')")
    resultSet.next()
    assertEquals("abcde", resultSet.getObject(1))
  }

  test("substring1") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select substring('abcde', 2, 5)")
    resultSet.next()
    assertEquals("bcde", resultSet.getObject(1))
  }

  test("substring2") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select substring('abcde', 2)")
    resultSet.next()
    assertEquals("bcde", resultSet.getObject(1))
  }

  test("trim") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select trim('  abcde ')")
    resultSet.next()
    assertEquals("abcde", resultSet.getObject(1))
  }

  test("ltrim") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select ltrim('  abcde ')")
    resultSet.next()
    assertEquals("abcde ", resultSet.getObject(1))
  }

  test("rtrim") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select rtrim('  abcde ')")
    resultSet.next()
    assertEquals("  abcde", resultSet.getObject(1))
  }

  test("lpad1") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select lpad('abcde', 2)")
    resultSet.next()
    assertEquals("  abcde", resultSet.getObject(1))
  }

  test("lpad2") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select lpad('abcde', 2, 'a')")
    resultSet.next()
    assertEquals("aaabcde", resultSet.getObject(1))
  }

  test("rpad1") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select rpad('abcde', 1)")
    resultSet.next()
    assertEquals("abcde ", resultSet.getObject(1))
  }

  test("rpad2") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select rpad('abcde', 1, 'e')")
    resultSet.next()
    assertEquals("abcdee", resultSet.getObject(1))
  }

  //TODO 多字节字符测试
  test("length") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select length('abc')")
    resultSet.next()
    assertEquals(3, resultSet.getObject(1))
  }

  //TODO 多字节字符测试
  test("charLength") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select charLength('abc')")
    resultSet.next()
    assertEquals(3, resultSet.getObject(1))
  }

  test("locate1") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select locate('bc', 'abcabc')")
    resultSet.next()
    assertEquals(2, resultSet.getObject(1))
  }

  test("locate2") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select locate('bc', 'abcabc', 2)")
    resultSet.next()
    assertEquals(5, resultSet.getObject(1))
  }

  test("md5") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select md5('abcde')")
    resultSet.next()
    assertEquals("AB56B4D92B40713ACC5AF89985D4B786", resultSet.getObject(1))
  }

}

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
package org.urbcomp.cupid.db

import org.junit.Assert.assertEquals

/**
  * String Function test
  *
  * @author zaiyuan, XiangHe
  */
class StringFunctionTest extends AbstractCalciteFunctionTest {

  /**
    * Calcite's function
    * returns the string after converting each letter of the original string to uppercase
    */
  test("upper") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select upper('abcde')")
    resultSet.next()
    assertEquals("ABCDE", resultSet.getObject(1))
  }

  /**
    * Calcite's function
    * returns the string after converting each letter of the original string to lowercase
    */
  test("lower") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select lower('ABCDE')")
    resultSet.next()
    assertEquals("abcde", resultSet.getObject(1))
  }

  /**
    * Calcite's function
    * index start from 1
    * return the substring which start at index 2 and the length is 3
    */
  test("substring1") {
    val statement = connect.createStatement
    val resultSet = statement.executeQuery("select substring('abcde', 2, 3)")
    resultSet.next()
    assertEquals("bcd", resultSet.getObject(1))
  }

  /**
    * Calcite's function
    * index start from 1
    * return the substring which start at index 2, the end is input's end
    */
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

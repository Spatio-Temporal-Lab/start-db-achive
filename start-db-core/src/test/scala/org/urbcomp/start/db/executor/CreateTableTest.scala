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

package org.urbcomp.start.db.executor

import org.urbcomp.start.db.AbstractCalciteFunctionTest

/**
  * test for create table
  * @author Wang Bohong
  */
class CreateTableTest extends AbstractCalciteFunctionTest {

  /**
    * test for create
    * ToDO : 在一个test方法内，同时执行create与insert，insert会失败
    */
  test("create & insert_0") {
    val statement = connect.createStatement()
    statement.execute("create table t_create (tid integer, name string)")
  }

  /**
    * test for insert
    */
  ignore("create & insert_1") {
    val statement = connect.createStatement()
    statement.execute("insert into t_create values(1, 'temp')")
  }
}

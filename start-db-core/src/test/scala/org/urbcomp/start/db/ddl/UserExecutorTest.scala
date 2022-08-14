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

package org.urbcomp.start.db.ddl

import org.urbcomp.start.db.AbstractCalciteFunctionTest

class UserExecutorTest extends AbstractCalciteFunctionTest {

  private val randomNum = scala.util.Random.nextInt(100000)
  private val CREATE_USER_EXAMPLE =
    s"""CREATE USER test_user_%d IDENTIFIED BY 'password'""".format(randomNum).stripMargin

  test("test create user") {
    val stmt = connect.createStatement()
    stmt.executeUpdate(CREATE_USER_EXAMPLE)
  }

}

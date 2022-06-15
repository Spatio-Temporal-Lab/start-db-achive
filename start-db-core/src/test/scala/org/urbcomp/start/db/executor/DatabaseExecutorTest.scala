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

import org.junit.Assert.assertTrue
import org.urbcomp.start.db.AbstractCalciteFunctionTest

class DatabaseExecutorTest extends AbstractCalciteFunctionTest {

  test("test create then show databases") {
    val stmt = connect.createStatement()
    val databaseName = "test_%d".format(scala.util.Random.nextInt(100000))
    stmt.executeUpdate("CREATE DATABASE %s".format(databaseName))
    val rs = stmt.executeQuery("SHOW DATABASES")
    var databases = List[String]()
    while (rs.next()) {
      databases = databases :+ rs.getString(1)
    }
    assertTrue(databases.contains(databaseName))
  }
}

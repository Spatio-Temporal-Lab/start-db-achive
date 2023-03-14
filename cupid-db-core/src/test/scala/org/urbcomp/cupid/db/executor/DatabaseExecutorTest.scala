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
package org.urbcomp.cupid.db.executor

import org.junit.Assert.{assertFalse, assertTrue}
import org.urbcomp.cupid.db.AbstractCalciteFunctionTest

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

  test("test create then drop database") {
    val stmt = connect.createStatement()
    val databaseName = "test_%d".format(scala.util.Random.nextInt(100000))

    stmt.executeUpdate("CREATE DATABASE %s".format(databaseName))
    val rs1 = stmt.executeQuery("SHOW DATABASES")
    var databasesBefore = List[String]()
    while (rs1.next()) {
      databasesBefore = databasesBefore :+ rs1.getString(1)
    }
    assertTrue(databasesBefore.contains(databaseName))

    stmt.executeUpdate("DROP DATABASE %s".format(databaseName))
    val rs2 = stmt.executeQuery("SHOW DATABASES")
    var databasesAfter = List[String]()
    while (rs2.next()) {
      databasesAfter = databasesAfter :+ rs2.getString(1)
    }
    assertFalse(databasesAfter.contains(databaseName))
  }

  test("test create then drop if exists database") {
    val stmt = connect.createStatement()
    val databaseName = "test_%d".format(scala.util.Random.nextInt(100000))

    stmt.executeUpdate("CREATE DATABASE %s".format(databaseName))
    val rs1 = stmt.executeQuery("SHOW DATABASES")
    var databasesBefore = List[String]()
    while (rs1.next()) {
      databasesBefore = databasesBefore :+ rs1.getString(1)
    }
    assertTrue(databasesBefore.contains(databaseName))

    stmt.executeUpdate("DROP DATABASE IF EXISTS %s".format(databaseName))
    val rs2 = stmt.executeQuery("SHOW DATABASES")
    var databasesAfter = List[String]()
    while (rs2.next()) {
      databasesAfter = databasesAfter :+ rs2.getString(1)
    }
    assertFalse(databasesAfter.contains(databaseName))
  }
}

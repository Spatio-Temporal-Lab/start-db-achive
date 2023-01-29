/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.executor

import org.urbcomp.cupid.db.AbstractCalciteFunctionTest

class ExecutorScenarioTest extends AbstractCalciteFunctionTest {

  test("create then insert") {
    val randomId = scala.util.Random.nextInt(Integer.MAX_VALUE)
    val tableName = "test_create_insert_%d".format(randomId)
    val stmt = connect.createStatement()
    stmt.execute(s"create table $tableName (tid integer, name string)")
    stmt.execute(s"insert into $tableName values (1, 'tmp')")
  }
}

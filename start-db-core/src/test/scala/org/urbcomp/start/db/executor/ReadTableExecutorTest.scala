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
  * @author stan
  * @date 2022/10/5 10:54
  */
class ReadTableExecutorTest extends AbstractCalciteFunctionTest {

  test("read geomesa-hbase data") {
    val executor = new SparkExecutor
    executor.execute("select * from t_test")
  }

  test("read geomesa-hbase data2") {
    val executor = new SparkExecutor
    val statement = connect.createStatement()
    statement.execute("create table if not exists t_test_2 (a Integer, b String);")
    statement.execute("insert into t_test_2 (a, b) values (1, 'unknown');")
    executor.execute(
      "select idx, ride_id from t_test left join t_test_2 on t_test.idx = t_test_2.a"
    );
  }
}

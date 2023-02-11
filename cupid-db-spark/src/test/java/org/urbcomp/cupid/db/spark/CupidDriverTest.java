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

package org.urbcomp.cupid.db.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.Test;
import org.urbcomp.cupid.db.util.SqlParam;

public class CupidDriverTest {

    @Test
    public void testExecute() {
        final SqlParam param = new SqlParam("root", "test");
        param.setLocal(true);
        // param.setSql("select 1+1");
        // final Dataset<Row> df = CupidDriver.execute(param, null);
        // df.show();
        param.setSql("select * from jimo.test");
        final Dataset<Row> df2 = CupidDriver.execute(param, null);
        df2.show();
    }
}

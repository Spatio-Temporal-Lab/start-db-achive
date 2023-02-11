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
//        param.setSql("select 1+1");
//        final Dataset<Row> df = CupidDriver.execute(param, null);
//        df.show();
        param.setSql("select * from jimo.test");
        final Dataset<Row> df2 = CupidDriver.execute(param, null);
        df2.show();
    }
}
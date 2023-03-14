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
package org.urbcomp.cupid.db.spark;

import org.junit.Ignore;
import org.junit.Test;
import org.urbcomp.cupid.db.model.data.DataExportType;
import org.urbcomp.cupid.db.util.SparkSqlParam;

public class CupidSparkDriverTest {

    @Test
    public void testExecute() {
        final SparkSqlParam param = new SparkSqlParam();
        param.setUserName("root");
        param.setDbName("default");
        param.setSql("select * from t_test");
        param.setExportType(DataExportType.PRINT);
        param.setLocal(true);
        SparkQueryExecutor.execute(param, null);
    }

    @Test
    @Ignore // 本地要起HDFS来测试
    public void testExport2Hdfs() {
        final SparkSqlParam param = new SparkSqlParam();
        param.setUserName("root");
        param.setDbName("default");
        param.setSql("select 1+1");
        param.setExportType(DataExportType.HDFS);
        param.setLocal(true);
        param.setSqlId("testSqlId");
        SparkQueryExecutor.execute(param, null);
    }
}

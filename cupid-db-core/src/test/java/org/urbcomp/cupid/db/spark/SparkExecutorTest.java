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
import org.urbcomp.cupid.db.config.DynamicConfig;
import org.urbcomp.cupid.db.infra.MetadataResult;
import org.urbcomp.cupid.db.model.data.DataExportType;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import static org.junit.Assert.assertNotNull;
import static org.urbcomp.cupid.db.config.DynamicConfig.DB_SPARK_JARS;

@Ignore
public class SparkExecutorTest {

    @Test
    public void testExecute() {
        DynamicConfig.updateProperties(
            DB_SPARK_JARS,
            "/opt/spark/examples/jars/spark-examples_2.12-3.0.2.jar"
        );

        final SparkExecutor executor = new SparkExecutor();

        final SparkSqlParam param = new SparkSqlParam();
        param.setExportType(DataExportType.PRINT);
        param.setSql("1+1");
        final MetadataResult<Object> res = executor.execute(param);
        assertNotNull(res);
    }
}

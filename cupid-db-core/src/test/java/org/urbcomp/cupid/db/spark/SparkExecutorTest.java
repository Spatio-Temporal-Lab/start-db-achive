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

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

package org.urbcomp.cupid.db.spark.reader;

import org.junit.Ignore;
import org.junit.Test;
import org.urbcomp.cupid.db.infra.MetadataResult;

import static org.junit.Assert.assertNotNull;

// 起Hadoop
@Ignore
public class SparkDataReadHdfsTest {

    @Test
    public void testHdfsRead() {
        final SparkDataReadHdfs reader = new SparkDataReadHdfs();
        final MetadataResult<Object> res = reader.read("testSqlId");
        assertNotNull(res);
    }
}

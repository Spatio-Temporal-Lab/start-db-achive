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
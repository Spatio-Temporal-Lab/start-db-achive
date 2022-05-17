package org.urbcomp.start.db.test;

import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.apache.hadoop.hbase.coprocessor.CoprocessorHost;
import org.apache.hadoop.hbase.zookeeper.MiniZooKeeperCluster;
import org.locationtech.geomesa.hbase.data.HBaseIndexAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * start a embedded hbase cluster for unit test
 * bind ZK to 0.0.0.0/2181
 * need HADOOP_HOME
 *
 * @author jimo
 */
public class MiniHBaseCluster {

    private static final Logger logger = LoggerFactory.getLogger(MiniHBaseCluster.class);

    public static void main(String[] args) throws Exception {
        HBaseTestingUtility cluster = new HBaseTestingUtility();
        final MiniZooKeeperCluster zooKeeperCluster = cluster.startMiniZKCluster(1, 2181);
        cluster.setZkCluster(zooKeeperCluster);
        logger.info("Starting embedded ZK");
        logger.info("Starting embedded hbase");
        cluster.getConfiguration().set("hbase.superuser", "admin");
        // bind geomesa coprocessor
        cluster.getConfiguration().set(CoprocessorHost.USER_REGION_COPROCESSOR_CONF_KEY, HBaseIndexAdapter.CoprocessorClass());
        //    cluster.startMiniCluster(sys.props.get("geomesa.hbase.test.region.servers").map(_.toInt).getOrElse(2))
        cluster.startMiniHBaseCluster();
        logger.info("Started embedded hbase");
    }
}

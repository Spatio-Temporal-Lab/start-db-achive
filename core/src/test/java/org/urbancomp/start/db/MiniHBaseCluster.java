/*
 * Copyright 2022 ST-Lab

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

package org.urbancomp.start.db;

import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.apache.hadoop.hbase.coprocessor.CoprocessorHost;
import org.apache.hadoop.hbase.zookeeper.MiniZooKeeperCluster;
import org.locationtech.geomesa.hbase.data.HBaseIndexAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * start an embedded hbase cluster for unit test bind ZK to 0.0.0.0/2181 need HADOOP_HOME on windows
 *
 * @author jimo
 */
public class MiniHBaseCluster {

    private static final Logger logger = LoggerFactory.getLogger(MiniHBaseCluster.class);

    private static HBaseTestingUtility cluster;

    public static void start() throws Exception {
        cluster = new HBaseTestingUtility();
        final MiniZooKeeperCluster zooKeeperCluster = cluster.startMiniZKCluster(1, 2181);
        cluster.setZkCluster(zooKeeperCluster);
        logger.info("Starting embedded ZK");
        logger.info("Starting embedded hbase");
        cluster.getConfiguration().set("hbase.superuser", "admin");
        // bind geomesa coprocessor
        cluster.getConfiguration().set(CoprocessorHost.USER_REGION_COPROCESSOR_CONF_KEY,
                        HBaseIndexAdapter.CoprocessorClass());
        // cluster.startMiniCluster(sys.props.get("geomesa.hbase.test.region.servers").map(_.toInt).getOrElse(2))
        cluster.startMiniHBaseCluster();
        logger.info("Started embedded hbase");
    }

    public static void shutdown() throws Exception {
        if (cluster != null) {
            cluster.shutdownMiniCluster();
        }
    }
}

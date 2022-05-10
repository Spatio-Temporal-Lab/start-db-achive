package org.urbcomp.start.db

import com.typesafe.scalalogging.LazyLogging
import org.apache.hadoop.hbase.HBaseTestingUtility
import org.apache.hadoop.hbase.coprocessor.CoprocessorHost
import org.locationtech.geomesa.hbase.data.HBaseIndexAdapter

import java.util.concurrent.TimeUnit

/**
 * start a embedded hbase cluster for unit test
 * bind ZK to 0.0.0.0/2181
 *
 * @author jimo
 * */
object MiniHBaseCluster extends LazyLogging {

  lazy val cluster: HBaseTestingUtility = {
    val cluster = new HBaseTestingUtility()
    val zooKeeperCluster = cluster.startMiniZKCluster(1, 2181)
    cluster.setZkCluster(zooKeeperCluster)
    logger.info("Starting embedded ZK")
    logger.info("Starting embedded hbase")
    cluster.getConfiguration.set("hbase.superuser", "admin")
    // bind geomesa coprocessor
    cluster.getConfiguration.set(CoprocessorHost.USER_REGION_COPROCESSOR_CONF_KEY, HBaseIndexAdapter.CoprocessorClass)
    //    cluster.startMiniCluster(sys.props.get("geomesa.hbase.test.region.servers").map(_.toInt).getOrElse(2))
    cluster.startMiniHBaseCluster()
    logger.info("Started embedded hbase")
    cluster
  }

  def main(args: Array[String]): Unit = {
    cluster
    TimeUnit.SECONDS.sleep(1)
  }
}

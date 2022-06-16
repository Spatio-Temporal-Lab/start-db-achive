package org.urbcomp.start.db.executor

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.parser.dql.SqlShowCreateTable

import scala.language.higherKinds

/**
 * @author jimo
 * */
case class ShowCreateTableExecutor(n: SqlShowCreateTable) extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    // TODO temporary return
    MetadataResult.buildResult(Array("Table", "Create Table"),
      java.util.Arrays.asList(Array(n.getTableName, "create table " + n.getTableName))).asInstanceOf[MetadataResult[Array]]
  }
}

package org.urbcomp.start.db.executor

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}

import scala.language.higherKinds

/**
 * @author jimo
 * */
case class ShowStatusExecutor() extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    MetadataResult.buildResult(Array("Variable_name", "Value"),
      java.util.Arrays.asList(Array("status", "ok"))).asInstanceOf[MetadataResult[Array]]
  }
}

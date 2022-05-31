package org.urbcomp.start.db.infra

import org.apache.calcite.sql.SqlNode

abstract class BaseExecutorFactory {

  def convertExecutor(node: SqlNode): BaseExecutor

}

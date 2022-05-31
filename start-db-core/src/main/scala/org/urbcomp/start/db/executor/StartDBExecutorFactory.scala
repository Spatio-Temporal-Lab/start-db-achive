package org.urbcomp.start.db.executor

import org.apache.calcite.sql.SqlNode
import org.urbcomp.start.db.infra.{BaseExecutor, BaseExecutorFactory}
import org.urbcomp.start.db.sqlnode.SqlInsert

class StartDBExecutorFactory extends BaseExecutorFactory{
  override def convertExecutor(node: SqlNode): BaseExecutor = node match {
    case n: SqlInsert => InsertExecutor(n)
  }
}

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

package org.urbcomp.start.db.executor

import org.apache.calcite.sql._
import org.apache.calcite.sql.ddl.{SqlCreateTable, SqlDropSchema, SqlDropTable}
import org.urbcomp.start.db.infra.{BaseExecutor, BaseExecutorFactory}
import org.urbcomp.start.db.parser.dcl.SqlCreateUser
import org.urbcomp.start.db.parser.ddl.{SqlCreateDatabase, SqlTruncateTable, SqlUseDatabase}
import org.urbcomp.start.db.parser.dql.{
  SqlShowCreateTable,
  SqlShowDatabases,
  SqlShowStatus,
  SqlShowTables
}

class StartDBExecutorFactory extends BaseExecutorFactory {
  override def convertExecutor(node: SqlNode): BaseExecutor = node match {
    case n: SqlShowCreateTable => ShowCreateTableExecutor(n)
    case n: SqlUpdate          => UpdateExecutor(n)
    case n: SqlInsert          => InsertExecutor(n)
    case n: SqlDelete          => DeleteExecutor(n)
    case n: SqlCreateDatabase  => CreateDatabaseExecutor(n)
    case n: SqlCreateTable     => CreateTableExecutor(n)
    case _: SqlShowDatabases   => ShowDatabaseExecutor()
    case _: SqlShowStatus      => ShowStatusExecutor()
    case n: SqlUseDatabase     => UseDbExecutor(n)
    case n: SqlCreateUser      => CreateUserExecutor(n)
    case n: SqlShowTables      => ShowTablesExecutor(n)
    case n: SqlDropTable       => DropTableExecutor(n)
    case n: SqlDescribeTable   => DescribeTableExecutor(n)
    case n: SqlDropSchema      => DropDatabaseExecutor(n)
    case n: SqlTruncateTable   => TruncateTableExecutor(n)
    case _                     => throw new IllegalStateException("Not Support SQL")
  }
}

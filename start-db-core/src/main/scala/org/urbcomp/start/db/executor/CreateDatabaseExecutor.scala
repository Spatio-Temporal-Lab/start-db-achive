/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.executor

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.entity.Database
import org.urbcomp.start.db.parser.ddl.SqlCreateDatabase

case class CreateDatabaseExecutor(n: SqlCreateDatabase) extends BaseExecutor {
  override def execute(): MetadataResult[Int] = {
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val dbName = n.getDatabaseName.names.get(0)
    println(dbName)
    // FIXME: add load user by name in accessor, get username from sqlNode
    databaseAccessor.insert(new Database(0, 1, dbName), true);
    MetadataResult.buildDDLResult(1)
  }
}

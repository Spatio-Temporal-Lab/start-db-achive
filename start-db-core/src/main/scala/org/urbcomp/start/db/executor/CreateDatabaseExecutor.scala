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
    // TODO: get username from context
    val userName = "start_db";
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)
    val dbName = n.getDatabaseName.names.get(0)
    if (!n.isIfNotExists) {
      val found = databaseAccessor.selectByFidAndName(user.getId, dbName, true);
      if (found != null) {
        throw new IllegalArgumentException("database already exist " + dbName);
      }
    }
    databaseAccessor.insert(new Database(-1, user.getId, dbName), true);
    MetadataResult.buildDDLResult(1)
  }
}

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

import org.urbcomp.start.db.infra.MetadataResult
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor
import org.urbcomp.start.db.metadata.entity.Database
import org.urbcomp.start.db.parser.dql.SqlShowDatabases

import java.util
import java.util.stream.Collectors

class ShowDatabaseExecutor(n: SqlShowDatabases) {
  def execute: MetadataResult[Array[AnyRef]] = {
    // TODO userName context
    val userName = "start_db";
    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)

    val databaseAccessor: DatabaseAccessor = AccessorFactory.getDatabaseAccessor
    val all: util.List[Database] = databaseAccessor.selectAllByFid(user.getId, true);
    val rss: util.List[Array[AnyRef]] = all.stream
      .map[String](db => db.getName)
      .map[Array[AnyRef]]((name: String) => Array[AnyRef](name))
      .collect(Collectors.toList[Array[AnyRef]])
    MetadataResult.buildResult(Array[String]("Databases"), rss)
  }
}

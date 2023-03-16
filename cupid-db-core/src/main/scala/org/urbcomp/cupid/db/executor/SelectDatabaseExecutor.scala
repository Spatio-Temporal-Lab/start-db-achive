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

package org.urbcomp.cupid.db.executor

import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.metadata.entity.Database
import org.urbcomp.cupid.db.util.SqlParam

case class SelectDatabaseExecutor() extends BaseExecutor {
  override def execute[Array](): MetadataResult[Array] = {
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName

    val all: Database = MetadataAccessUtil.getDatabase(userName, param.getDbName)
    val dbs = Array(all.getName.asInstanceOf[AnyRef])
    MetadataResult
      .buildResult(Array("Database"), java.util.Arrays.asList(dbs))
      .asInstanceOf[MetadataResult[Array]]
  }
}

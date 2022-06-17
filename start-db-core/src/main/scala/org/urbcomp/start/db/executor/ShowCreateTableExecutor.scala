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
import org.urbcomp.start.db.parser.dql.SqlShowCreateTable

import scala.language.higherKinds

/**
  * @author jimo
  * */
case class ShowCreateTableExecutor(n: SqlShowCreateTable) extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    // TODO temporary return
    MetadataResult
      .buildResult(
        Array("Table", "Create Table"),
        java.util.Arrays.asList(Array(n.getTableName.toString, "create table " + n.getTableName))
      )
      .asInstanceOf[MetadataResult[Array]]
  }
}

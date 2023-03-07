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

import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.parser.dql.SqlShowIndex

import scala.collection.JavaConverters.asScalaBufferConverter

case class ShowIndexExecutor(n: SqlShowIndex) extends BaseExecutor {
  override def execute[Array](): MetadataResult[Array] = {
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(n.tableName)

    val indexList = MetadataAccessUtil.getIndexes(userName, dbName, tableName)
    val indexPropArray = indexList.asScala
      .map(
        indexEntity =>
          Array(
            tableName.asInstanceOf[AnyRef],
            indexEntity.getFieldsIdList.asInstanceOf[AnyRef],
            indexEntity.getIndexType.asInstanceOf[AnyRef],
            indexEntity.getIndexProperties.asInstanceOf[AnyRef]
          )
      )
      .toArray

    MetadataResult
      .buildResult(
        Array("Table", "Fields", "IndexType", "IndexProperties"),
        java.util.Arrays.asList(indexPropArray: _*)
      )
      .asInstanceOf[MetadataResult[Array]]
  }
}

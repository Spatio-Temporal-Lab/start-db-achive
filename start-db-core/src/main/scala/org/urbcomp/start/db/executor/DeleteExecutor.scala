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

import org.apache.calcite.sql.{SqlDelete, SqlIdentifier}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.geotools.filter.text.cql2.CQL
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.MetadataVerifyUtil
import org.urbcomp.start.db.util.SqlParam

import java.util

/**
  * delete executor
  * @author Wang Bohong
  * @param n one SqlNode(SqlDelete) instance
  */
case class DeleteExecutor(n: SqlDelete) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    // extract database name and table name
    val param = SqlParam.CACHE.get()
    val userName = param.getUserName
    val envDbName = param.getDbName
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }
    // metadata Verify
    if (!MetadataVerifyUtil.tableVerify(userName, dbName, tableName))
      throw new RuntimeException("There is no corresponding table!")

    // Analytic filter condition
    val condition = n.getCondition.toString.replace("`", "")

    // remove value
    var affectRows = 0
    val params = new util.HashMap[String, String]()
    // ToDO Sql Param
    val CATALOG = userName + "." + dbName
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val filter = CQL.toFilter(condition)
    WithClose(dataStore.getFeatureWriter(tableName, filter, Transaction.AUTO_COMMIT)) { writer =>
      {
        while (writer.hasNext) {
          writer.next()
          affectRows += 1
          writer.remove()
        }
      }
    }
    dataStore.dispose()
    MetadataResult.buildDDLResult(affectRows)
  }

}

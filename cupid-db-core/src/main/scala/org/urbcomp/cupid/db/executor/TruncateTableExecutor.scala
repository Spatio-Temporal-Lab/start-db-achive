/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.executor

import org.geotools.data.DataStoreFinder
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.parser.ddl.SqlTruncateTable
import org.urbcomp.cupid.db.util.MetadataUtil

case class TruncateTableExecutor(n: SqlTruncateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.getTableName
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val existedTable = MetadataAccessUtil.getTable(userName, dbName, tableName)
    if (existedTable == null) {
      throw new IllegalStateException("table does not exist " + tableName)
    }

    val tableId = existedTable.getId
    val schemaName = MetadataUtil.makeSchemaName(tableId)
    val params = ExecutorUtil.getDataStoreParams(userName, dbName)
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(schemaName)
    if (schema == null) {
      throw new IllegalStateException("schema does not exist " + schemaName)
    }

    val newSchema = schema
    dataStore.removeSchema(schemaName)
    dataStore.createSchema(newSchema)

    MetadataResult.buildDDLResult(0)
  }
}

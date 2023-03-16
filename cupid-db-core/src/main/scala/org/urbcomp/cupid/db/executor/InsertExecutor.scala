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

import org.apache.calcite.sql.{
  SqlBasicCall,
  SqlCharStringLiteral,
  SqlIdentifier,
  SqlInsert,
  SqlNode,
  SqlUnresolvedFunction
}
import org.geotools.data.{DataStoreFinder, Transaction}
import org.locationtech.geomesa.utils.io.WithClose
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.{CalciteHelper, MetadataAccessUtil}
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment
import org.urbcomp.cupid.db.model.trajectory.Trajectory
import org.urbcomp.cupid.db.util.MetadataUtil
import org.urbcomp.cupid.db.utils.SqlLiteralHandler

import java.sql.ResultSet
import java.util

/**
  * @author zaiyuan
  */
case class InsertExecutor(n: SqlInsert) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.getTargetTable.asInstanceOf[SqlIdentifier]
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)
    val table = MetadataAccessUtil.getTable(userName, dbName, tableName)
    if (table == null) {
      throw new RuntimeException("There is no corresponding table!")
    }
    val fields = MetadataAccessUtil.getFields(userName, dbName, tableName)
    if (fields == null) throw new RuntimeException("There is no corresponding fields!")
    // construct sql
    val resultObjs: Array[util.ArrayList[AnyRef]] =
      n.getSource
        .asInstanceOf[SqlBasicCall] // Values level
        .operands
        .map { i => // Row level
          val queryItem = i
            .asInstanceOf[SqlBasicCall]
            .operands
            .map(SqlLiteralHandler.handleLiteral)
            .mkString(" , ")
          val originalQuerySql =
            s"""
               |SELECT $queryItem
               |""".stripMargin
          val querySql = originalQuerySql.replace("`", "")
          WithClose(executeQuery(querySql)) { rs =>
            {
              val count = rs.getMetaData.getColumnCount
              val result = new util.ArrayList[AnyRef](count)
              rs.next()
              for (x <- 1 to count) {
                result.add(rs.getObject(x))
              }
              result
            }
          }
        }

    // insert data
    var affectRows = 0
    val params = ExecutorUtil.getDataStoreParams(userName, dbName)
    val dataStore = DataStoreFinder.getDataStore(params)
    val schemaName = MetadataUtil.makeSchemaName(table.getId)
    WithClose(dataStore.getFeatureWriterAppend(schemaName, Transaction.AUTO_COMMIT)) { writer =>
      resultObjs.foreach { i =>
        var fieldIndex = 0
        val sf = writer.next()
        val count = i.size()
        if (n.getTargetColumnList != null && n.getTargetColumnList.size() != count)
          throw new RuntimeException(
            "The number of target fields does not match the number of values!"
          )
        for (x <- 0 until count) {
          var name: String = null
          if (n.getTargetColumnList == null) {
            name = fields.get(fieldIndex).getName
          } else {
            name = n.getTargetColumnList.get(x).toString
          }
          while (fields.get(fieldIndex).getName != name) {
            fieldIndex += 1
          }
          i.get(x) match {
            case rs: RoadSegment =>
              ExecutorUtil.writeRoadSegment(name, sf, rs)
            case traj: Trajectory =>
              ExecutorUtil.writeTrajectory(name, sf, traj)
            case _ =>
              sf.setAttribute(name, i.get(x))
          }
          fieldIndex += 1
        }
        affectRows += 1
        writer.write()
      }
    }
    dataStore.dispose()
    MetadataResult.buildDDLResult(affectRows)
  }

  /**
    * Execute the SQL parsed from the contents of values
    */
  def executeQuery[R](querySql: String): ResultSet = {
    val connection = CalciteHelper.createConnection()
    val statement = connection.createStatement()
    statement.executeQuery(querySql)
  }
}

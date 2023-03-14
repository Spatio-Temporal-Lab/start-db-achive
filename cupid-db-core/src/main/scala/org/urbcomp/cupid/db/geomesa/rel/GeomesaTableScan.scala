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
package org.urbcomp.cupid.db.geomesa.rel

import com.google.common.collect.ImmutableList
import org.apache.calcite.plan.{RelOptCluster, RelOptPlanner, RelOptTable, RelTraitSet}
import org.apache.calcite.rel.core.TableScan
import org.apache.calcite.rel.hint.RelHint
import org.urbcomp.cupid.db.core.geomesa.rules.GeomesaFilterRule
import org.urbcomp.cupid.db.core.geomesa.model.GeomesaQuery
import org.urbcomp.cupid.db.core.geomesa.rules.{GeomesaFilterRule, GeomesaToEnumerableConverterRule}
import org.urbcomp.cupid.db.geomesa.GeomesaTable

/**
  * This class is used to encapsulate the geomesa table scanning logic.
  *
  * @param cluster RelOptCluster
  * @param traitSet  RelTraitSet
  * @param table RelOptTable
  * @param geomesaTable  GeomesaTable
  *
  * @author zaiyuan
  * @date 2022/05/02
  */
class GeomesaTableScan(
    cluster: RelOptCluster,
    traitSet: RelTraitSet,
    table: RelOptTable,
    val geomesaTable: GeomesaTable
) extends TableScan(cluster, traitSet, ImmutableList.of[RelHint], table)
    with IGeomesaRelNode {

  /**
    * Regist Rule into planner
    * @param planner Query Plannner
    */
  override def register(planner: RelOptPlanner): Unit = {
    planner.addRule(GeomesaToEnumerableConverterRule.INSTANCE)
    planner.addRule(GeomesaFilterRule.Config.DEFAULT.toRule)
  }

  /**
    * wrap message into query
    * @param query GeomesaQuery
    */
  override def wrap(query: GeomesaQuery): Unit = {
    query.setUserName(geomesaTable.userName)
    query.setDbName(geomesaTable.dbName)
    query.setTableName(geomesaTable.tableName)
    query.setRelOptTable(table)
  }
}

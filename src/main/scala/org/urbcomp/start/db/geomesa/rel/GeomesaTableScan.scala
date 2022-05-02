package org.urbcomp.start.db.geomesa.rel

import com.google.common.collect.ImmutableList
import org.apache.calcite.plan.{RelOptCluster, RelOptPlanner, RelOptTable, RelTraitSet}
import org.apache.calcite.rel.core.TableScan
import org.apache.calcite.rel.hint.RelHint
import org.urbcomp.start.db.core.geomesa.rules.GeomesaFilterRule
import org.urbcomp.start.db.core.geomesa.model.GeomesaQuery
import org.urbcomp.start.db.core.geomesa.rules.{GeomesaFilterRule, GeomesaToEnumerableConverterRule}
import org.urbcomp.start.db.geomesa.GeomesaTable

/**
 * This class is used to encapsulate the geomesa table scanning logic.
 *
 * @param cluster RelOptCluster
 * @param traitSet  RelTraitSet
 * @param table RelOptTable
 * @param geomesaTable  GeomesaTable
 *
 * @author zaiyuan
 * @date 2022/05/01
 */
class GeomesaTableScan(cluster: RelOptCluster,
                       traitSet: RelTraitSet,
                       table: RelOptTable,
                       val geomesaTable: GeomesaTable) extends TableScan(cluster, traitSet, ImmutableList.of[RelHint], table) with IGeomesaRelNode {

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

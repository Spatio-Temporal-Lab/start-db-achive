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
package org.urbcomp.cupid.db.geomesa

import org.apache.calcite.adapter.enumerable.{
  EnumerableRel,
  EnumerableRelImplementor,
  JavaRowFormat,
  PhysTypeImpl
}
import org.apache.calcite.linq4j.tree.{BlockBuilder, Expressions, Types}
import org.apache.calcite.plan.{ConventionTraitDef, RelOptCluster, RelTraitSet}
import org.apache.calcite.rel.AbstractRelNode.sole
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.convert.ConverterImpl
import org.geotools.filter.text.ecql.ECQL
import org.urbcomp.cupid.db.core.geomesa.model.GeomesaQuery
import org.urbcomp.cupid.db.geomesa.rel.IGeomesaRelNode

import java.lang.reflect.Method
import java.util
import scala.collection.JavaConverters._

/**
  * convert geomesa to enumerator
  *
  * @param cluster RelOptCluster
  * @param traits  RelTraitSet
  * @param input   RelNode
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaToEnumeratorConverter(cluster: RelOptCluster, traits: RelTraitSet, input: RelNode)
    extends ConverterImpl(cluster, ConventionTraitDef.INSTANCE, traits, input)
    with EnumerableRel {

  val method: Method =
    Types.lookupMethod(
      classOf[GeomesaQueryable[_]],
      "query",
      classOf[String],
      classOf[String],
      classOf[String],
      classOf[String]
    )

  override def implement(
      enumerableRelImplementor: EnumerableRelImplementor,
      prefer: EnumerableRel.Prefer
  ): EnumerableRel.Result = {
    val builder = new BlockBuilder
    val rowType = getRowType
    val physType =
      PhysTypeImpl.of(enumerableRelImplementor.getTypeFactory, rowType, JavaRowFormat.ARRAY)
    val query = new GeomesaQuery
    recursiveWrap(getInput, query)
    val tableInstance =
      builder.append("TABLE", query.getRelOptTable.getExpression(classOf[GeomesaQueryable[_]]))
    val userNameInstance = builder.append("USERNAME", Expressions.constant(query.getUserName))
    val dbNameInstance = builder.append("DBNAME", Expressions.constant(query.getDbName))
    val tableNameInstance = builder.append("TABLENAME", Expressions.constant(query.getTableName))
    val filterInstance = builder.append("FILTER", Expressions.constant(ECQL.toCQL(query.getFilter)))
    val enumeration = builder.append(
      "ENUMERATOR",
      Expressions.call(
        tableInstance,
        method,
        filterInstance,
        tableNameInstance,
        dbNameInstance,
        userNameInstance
      )
    )
    builder.add(Expressions.return_(null, enumeration))
    enumerableRelImplementor.result(physType, builder.toBlock)
  }

  def recursiveWrap(input: RelNode, query: GeomesaQuery): Unit = {
    wrap(input, query)
    input.getInputs.asScala.foreach(i => recursiveWrap(i, query))
  }

  def wrap(input: RelNode, query: GeomesaQuery): Unit = input match {
    case i: IGeomesaRelNode => i.wrap(query)
    case _                  =>
  }

  override def copy(traitSet: RelTraitSet, inputs: util.List[RelNode]): RelNode =
    new GeomesaToEnumeratorConverter(getCluster, traitSet, sole(inputs))
}

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

import org.apache.calcite.plan.{RelOptCluster, RelTraitSet}
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.`type`.RelDataType
import org.apache.calcite.rel.core.{Filter => CalciteFilter}
import org.apache.calcite.rex.{RexCall, RexInputRef, RexLiteral, RexNode}
import org.apache.calcite.sql.SqlKind._
import org.apache.calcite.sql.`type`.{BasicSqlType, SqlTypeName}
import org.apache.calcite.sql.validate.SqlValidatorUtil
import org.apache.calcite.util.NlsString
import org.opengis.filter.expression.Expression
import org.opengis.filter.{Filter => GeoToolsFilter}
import org.urbcomp.cupid.db.geomesa.ff
import org.urbcomp.cupid.db.core.geomesa.model.GeomesaQuery
import org.urbcomp.cupid.db.geomesa.GeomesaConstant
import org.urbcomp.cupid.db.util.StringUtil

import java.util
import scala.collection.JavaConverters._

/**
  * This class is specially used to convert the original filter conditions into the table
  * filter expressions required by geomesa
  *
  * @param cluster   RelOptCluster
  * @param traits    RelTraitSet
  * @param child     RelNode
  * @param condition RexNode
  * @author zaiyuan
  * @date 2022/05/21
  */
class GeomesaFilter(
    cluster: RelOptCluster,
    traits: RelTraitSet,
    child: RelNode,
    rowType: RelDataType,
    condition: RexNode
) extends CalciteFilter(cluster, traits, child, condition)
    with IGeomesaRelNode {

  val fieldList: util.List[String] =
    SqlValidatorUtil.uniquify(rowType.getFieldNames, SqlValidatorUtil.EXPR_SUGGESTER, true)

  /**
    * Convert RexNode to GeoTools Filter
    *
    * @param node RexNode
    * @return GeoTools Filter
    */
  def convertFilter(node: RexNode): GeoToolsFilter = {
    val call = node.asInstanceOf[RexCall]
    node.getKind match {
      // Unary Logic Converter
      case EQUALS => ff.equals(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case NOT_EQUALS =>
        ff.notEqual(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case LESS_THAN =>
        ff.less(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case LESS_THAN_OR_EQUAL =>
        ff.lessOrEqual(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case GREATER_THAN =>
        ff.greater(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case GREATER_THAN_OR_EQUAL =>
        ff.greaterOrEqual(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
      case LIKE    => ff.like(convertExpr(call.operands.get(0)), call.operands.get(1).toString)
      case IS_NULL => ff.isNull(convertExpr(call.operands.get(0)))
      // Binary Logic Converter
      case AND => ff.and(convertFilter(call.operands.get(0)), convertFilter(call.operands.get(1)))
      case OR  => ff.or(convertFilter(call.operands.get(0)), convertFilter(call.operands.get(1)))
      case NOT => ff.not(convertFilter(call.operands.get(0)))
      case CAST =>
        node.getType.getSqlTypeName match {
          case SqlTypeName.BOOLEAN =>
            ff.equals(convertExpr(call.operands.get(0)), ff.literal(true))
        }
      // GeoTools Spatial Function Converter
      case OTHER_FUNCTION =>
        call.op.toString match {
          case GeomesaConstant.ST_CONTAINS =>
            ff.contains(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_CROSSES =>
            ff.crosses(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_DISJOINT =>
            ff.disjoint(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_EQUALS =>
            ff.equals(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_INTERSECTS =>
            ff.intersects(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_OVERLAPS =>
            ff.overlaps(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_TOUCHES =>
            ff.touches(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
          case GeomesaConstant.ST_WITHIN =>
            ff.within(convertExpr(call.operands.get(0)), convertExpr(call.operands.get(1)))
        }
    }
  }

  /**
    * Convert RexNode to GeoTools Expression
    *
    * @param rex RexNode
    * @return Expression
    */
  private def convertExpr(rex: RexNode): Expression = rex match {
    case r: RexCall =>
      r.getKind match {
        case OTHER_FUNCTION => functionConverter(r)
        case PLUS           => ff.add(convertExpr(r.operands.get(0)), convertExpr(r.operands.get(1)))
        case MINUS          => ff.subtract(convertExpr(r.operands.get(0)), convertExpr(r.operands.get(1)))
        case TIMES          => ff.multiply(convertExpr(r.operands.get(0)), convertExpr(r.operands.get(1)))
        case DIVIDE         => ff.divide(convertExpr(r.operands.get(0)), convertExpr(r.operands.get(1)))
        // TODO
        // Cast is a basic operation of SQL, which contains many situations. However, OpenGIS itself does not support
        // cast, so some complex operations have not been implemented. Now only relatively simple logic (simple fields
        // and values) are implemented. The nested operations contained in it will be implemented later.
        case CAST => convertExpr(r.operands.get(0))
        case _    => throw new Exception("Unsupported operator")
      }
    case r: RexInputRef => ff.property(fieldList.get(r.getIndex))
    case r: RexLiteral if r.getTypeName == SqlTypeName.CHAR =>
      ff.literal(r.getValue.asInstanceOf[NlsString].getValue)
    case r: RexLiteral =>
      ff.literal(RexLiteral.value(r))
  }

  def functionConverter(r: RexCall): Expression = r.op.toString.toUpperCase match {
    case "ST_POINTFROMWKT" | "ST_LINESTRINGFROMWKT" | "ST_POLYGONFROMWKT" | "ST_MPOINTFROMWKT" |
        "ST_MLINESTRINGFROMWKT" | "ST_MPOLYGONFROMWKT" | "ST_GEOMFROMWKT" =>
      ff.literal(
        r.operands.get(0).asInstanceOf[RexLiteral].getValue.asInstanceOf[NlsString].getValue
      )
    case _ =>
      ff.function(r.op.toString, r.operands.asScala.map(convertExpr).toArray)
  }

  override def copy(traitSet: RelTraitSet, input: RelNode, condition: RexNode): CalciteFilter =
    new GeomesaFilter(cluster, traitSet, input, rowType, condition)

  override def wrap(query: GeomesaQuery): Unit = query.setFilter(convertFilter(condition))
}

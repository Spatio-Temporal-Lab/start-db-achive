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

import org.apache.calcite.adapter.java.AbstractQueryableTable
import org.apache.calcite.linq4j.{QueryProvider, Queryable}
import org.apache.calcite.plan.RelOptTable
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.{SchemaPlus, TranslatableTable}
import org.urbcomp.cupid.db.geomesa.rel.GeomesaTableScan
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.util.DataTypeUtils

import java.lang.reflect.Type

/**
  * Table of Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
case class GeomesaTable(userName: String, dbName: String, tableName: String)
    extends AbstractQueryableTable(classOf[Type])
    with TranslatableTable {

  /**
    * convert table instance to table scan instance
    */
  override def toRel(toRelContext: RelOptTable.ToRelContext, relOptTable: RelOptTable): RelNode =
    new GeomesaTableScan(
      toRelContext.getCluster,
      toRelContext.getCluster.traitSetOf(GeomesaConstant.CONVENTION),
      relOptTable,
      this
    )

  /**
    * convert to queryable instance
    */
  override def asQueryable[T](
      queryProvider: QueryProvider,
      schemaPlus: SchemaPlus,
      s: String
  ): Queryable[T] =
    new GeomesaQueryable[T](queryProvider, schemaPlus, this, s)

  /**
    * get Schema of the table
    *
    * @param relDataTypeFactory RelDataTypeFactory
    * @return RelDataType
    */
  override def getRowType(relDataTypeFactory: RelDataTypeFactory): RelDataType = {
    val builder = relDataTypeFactory.builder()
    val fields = MetadataAccessUtil.getFields(userName, dbName, tableName)
    if (fields == null)
      throw new IllegalArgumentException(s"Table[$userName.$dbName.$tableName] Not Found")
    fields.forEach { i =>
      builder.add(i.getName, relDataTypeFactory.createJavaType(DataTypeUtils.getClass(i.getType)))
    }
    builder.build()
  }
}

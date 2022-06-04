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

package org.urbcomp.start.db.geomesa

import org.apache.calcite.adapter.java.AbstractQueryableTable
import org.apache.calcite.linq4j.{QueryProvider, Queryable}
import org.apache.calcite.plan.RelOptTable
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.`type`.{RelDataType, RelDataTypeFactory}
import org.apache.calcite.schema.{SchemaPlus, TranslatableTable}
import org.geotools.data.{DataStoreFinder, Query}
import org.urbcomp.start.db.common.ConfigProvider
import org.urbcomp.start.db.geomesa.rel.GeomesaTableScan
import org.urbcomp.start.db.util.MetadataUtil

import java.lang.reflect.Type
import scala.collection.JavaConverters._

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
    val catalog = MetadataUtil.makeCatalog(userName, dbName)
    val dataStore =
      DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(catalog).asJava)
    val query = new Query(tableName)
    val sft = dataStore.getSchema(query.getTypeName)
    // TODO Geometry type should be supported
    val builder = relDataTypeFactory.builder()
    sft.getDescriptors.asScala.foreach { i =>
      builder.add(i.getName.toString, relDataTypeFactory.createJavaType(i.getType.getBinding))
    }
    dataStore.dispose()
    builder.build()
  }
}

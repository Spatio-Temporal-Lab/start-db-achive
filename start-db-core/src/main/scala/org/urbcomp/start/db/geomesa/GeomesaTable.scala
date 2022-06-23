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
import org.geojson.{GeometryCollection, MultiPoint}
import org.locationtech.jts.geom.{
  Geometry,
  LineString,
  MultiLineString,
  MultiPolygon,
  Point,
  Polygon
}
import org.urbcomp.start.db.geomesa.rel.GeomesaTableScan
import org.urbcomp.start.db.metadata.MetadataVerifyUtil
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
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
    val fields = MetadataVerifyUtil.getFields(userName, dbName, tableName)
    if (fields != null) {
      fields.forEach { i =>
        builder.add(i.getName, relDataTypeFactory.createJavaType(getClass(i.getType)))
      }
    }
    builder.build()
  }

  /**
    * convert dataType to class
    * @author Wang Bohong
    * @param dataType datatype string
    * @return class instance
    */
  def getClass(dataType: String): Class[_ <: AnyRef] = {
    dataType match {
      case "Point"              => return classOf[Point]
      case "Polygon"            => return classOf[Polygon]
      case "LineString"         => return classOf[LineString]
      case "MultiPoint"         => return classOf[MultiPoint]
      case "MultiLineString"    => return classOf[MultiLineString]
      case "MultiPolygon"       => return classOf[MultiPolygon]
      case "GeometryCollection" => return classOf[GeometryCollection]
      case "Geometry"           => return classOf[Geometry]
      case "RoadSegment"        => return classOf[RoadSegment]
      case "Trajectory"         => return classOf[Trajectory]
      case "Integer"            => return classOf[java.lang.Integer]
      case "Long"               => return classOf[java.lang.Long]
      case "Float"              => return classOf[java.lang.Float]
      case "Double"             => return classOf[java.lang.Double]
      case "String"             => return classOf[java.lang.String]
      case "Integer"            => return classOf[java.lang.Boolean]
      case "Binary"             => return classOf[Array[Byte]]
      case "Timestamp"          => return classOf[java.sql.Timestamp]
      case "Date"               => return classOf[java.sql.Date]
    }
    null
  }
}

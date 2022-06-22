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
import org.geotools.data.{DataStoreFinder, Query}
import org.locationtech.jts.geom.{Geometry, LineString, MultiLineString, MultiPolygon, Point, Polygon}
import org.urbcomp.start.db.common.ConfigProvider
import org.urbcomp.start.db.geomesa.rel.GeomesaTableScan
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.entity.Field
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.util.MetadataUtil

import java.lang.reflect.Type
import java.util.{Collections, Comparator}
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

//    val catalog = MetadataUtil.makeCatalog(userName, dbName)
//    val dataStore =
//      DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(catalog).asJava)
//    val query = new Query(tableName)
//    val sft = dataStore.getSchema(query.getTypeName)
//
//    val builder = relDataTypeFactory.builder()
//    sft.getDescriptors.asScala.foreach { i =>
//      builder.add(i.getName.toString, relDataTypeFactory.createJavaType(i.getType.getBinding))
//    }
//    dataStore.dispose()
//    builder.build()
    val builder = relDataTypeFactory.builder()
    val fields = metadataVerify()
    if (fields != null) {
      for (elem <- fields) {
        builder.add(elem.getName, relDataTypeFactory.createJavaType(getClass(elem.getType)))
      }
    }
    builder.build()
  }

//  /**
//    * Temporary method for He Xiang's RoadSegment test table
//    * @author Wang Bohong
//    * @param relDataTypeFactory  RelDataTypeFactory intance
//    * @return RelDataType instance
//    */
//  private def tempRoadSegmentGetRowType(relDataTypeFactory: RelDataTypeFactory): RelDataType = {
//    val builder = relDataTypeFactory.builder()
//    builder.add("a", relDataTypeFactory.createJavaType(Integer.TYPE))
//    builder.add("b", relDataTypeFactory.createJavaType(classOf[RoadSegment]))
//    builder.add("c", relDataTypeFactory.createJavaType(classOf[RoadSegment]))
//    builder.build()
//  }
//
//  /**
//    * Temporary method for He Xiang's RoadSegment test table
//    * @author Wang Bohong
//    * @param relDataTypeFactory  RelDataTypeFactory intance
//    * @return RelDataType instance
//    */
//  private def tempTrajectoryGetRowType(relDataTypeFactory: RelDataTypeFactory): RelDataType = {
//    val builder = relDataTypeFactory.builder()
//    builder.add("id1", relDataTypeFactory.createJavaType(Integer.TYPE))
//    builder.add("t1", relDataTypeFactory.createJavaType(classOf[Trajectory]))
//    builder.build()
//  }

  def metadataVerify (): Array[Field] = {
    val userAccessor = AccessorFactory.getUserAccessor
    val dbAccessor = AccessorFactory.getDatabaseAccessor
    val tableAccessor = AccessorFactory.getTableAccessor
    val fieldAccessor = AccessorFactory.getFieldAccessor
    val user = userAccessor.selectByFidAndName(1L /* never used*/ , userName, true)
    if (user == null) return null
    val database = dbAccessor.selectByFidAndName(user.getId, dbName, true)
    if (database == null) return null
    val table = tableAccessor.selectByFidAndName(database.getId, dbName, true)
    if (table == null) return null
    val fields = fieldAccessor.selectAllByFid(table.getId, true)
    if (fields == null) return null
    Collections.sort(fields, new Comparator[Field] {
      override def compare(o1: Field, o2: Field): Int = (o1.getId - o2.getId).asInstanceOf[Int]
    })
    fields.toArray().asInstanceOf[Array[Field]]
  }

  def getClass (dataType: String): Class[_ <: AnyRef] = {
    dataType match {
      case "class org.locationtech.jts.geom.Point"  => return classOf[Point]
      case "class org.locationtech.jts.geom.Polygon"  => return classOf[Polygon]
      case "class org.locationtech.jts.geom.LineString" => return classOf[LineString]
      case "class org.geojson.MultiPoint" => return classOf[MultiPoint]
      case "class org.locationtech.jts.geom.MultiLineString" => return classOf[MultiLineString]
      case "class org.locationtech.jts.geom.MultiPolygon" => return classOf[MultiPolygon]
      case "class org.geojson.GeometryCollection" => return classOf[GeometryCollection]
      case "class org.locationtech.jts.geom.Geometry" => return classOf[Geometry]
      case "class org.urbcomp.start.db.model.roadnetwork.RoadSegment" => return classOf[RoadSegment]
      case "class org.urbcomp.start.db.model.trajectory.Trajectory" => return classOf[Trajectory]
      case "class java.lang.Integer" => return classOf[java.lang.Integer]
      case "class java.lang.Long" => return classOf[java.lang.Long]
      case "class java.lang.Float" => return classOf[java.lang.Float]
      case "class java.lang.Double" => return classOf[java.lang.Double]
      case "class java.lang.String" => return classOf[java.lang.String]
      case "class java.lang.Integer" => return classOf[java.lang.Boolean]
      case "interface java.sql.Blob" => return classOf[java.sql.Blob]
      case "class java.sql.Timestamp" => return classOf[java.sql.Blob]
      case "class java.sql.Date" => return classOf[java.sql.Date]
    }
    null
  }
}

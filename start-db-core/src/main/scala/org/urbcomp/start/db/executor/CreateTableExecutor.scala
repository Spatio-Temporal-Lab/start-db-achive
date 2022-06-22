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

package org.urbcomp.start.db.executor

import org.apache.calcite.sql.ddl.{SqlColumnDeclaration, SqlCreateTable}
import org.geotools.data.DataStoreFinder
import org.geotools.feature.simple.SimpleFeatureTypeBuilder
import org.locationtech.jts.geom.{
  Geometry,
  GeometryCollection,
  LineString,
  MultiLineString,
  MultiPoint,
  MultiPolygon,
  Point,
  Polygon
}
import org.urbcomp.start.db.`type`.TypeHelper
import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.start.db.metadata.AccessorFactory
import org.urbcomp.start.db.metadata.entity.{Field, Table}
import org.urbcomp.start.db.model.roadnetwork.RoadSegment
import org.urbcomp.start.db.model.trajectory.Trajectory
import org.urbcomp.start.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}

import java.util

case class CreateTableExecutor(n: SqlCreateTable) extends BaseExecutor {
  override def execute[Int](): MetadataResult[Int] = {
    // TODO userName dbName context
    val userName = "start_db";
    val envDbName = "db_test";

    val targetTable = n.name
    val (dbName, tableName) = targetTable.names.size() match {
      case 2 =>
        (targetTable.names.get(0), targetTable.names.get(1))
      case 1 =>
        (envDbName, targetTable.names.get(0))
      case _ =>
        throw new RuntimeException("target table format should like dbname.tablename or tablename")
    }

    val userAccessor = AccessorFactory.getUserAccessor
    val user = userAccessor.selectByFidAndName(-1 /* not used */, userName, true)
    val databaseAccessor = AccessorFactory.getDatabaseAccessor
    val db = databaseAccessor.selectByFidAndName(user.getId, dbName, true);
    val tableAccessor = AccessorFactory.getTableAccessor
    val existedTable = tableAccessor.selectByFidAndName(db.getId, tableName, false);
    if (existedTable != null) {
      if (n.ifNotExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table already exist " + tableName);
      }
    }

    val affectedRows =
      tableAccessor.insert(new Table(0L /* unused */, db.getId, tableName, "hbase"), false);
    val createdTable = tableAccessor.selectByFidAndName(db.getId, tableName, false);
    val tableId = createdTable.getId
    val fieldAccessor = AccessorFactory.getFieldAccessor
    val sfb = new SimpleFeatureTypeBuilder
    sfb.setName("t_%d".format(tableId))
    n.columnList.forEach(column => {
      val node = column.asInstanceOf[SqlColumnDeclaration]
      val name = node.name.names.get(0);
      // TODO: unify typename when parse sql
      val dataType = TypeHelper.normalizeType(node.dataType.getTypeName.names.get(0));
      dataType match {
        // geometry types
        case Geometry.TYPENAME_POINT           => sfb.add(name, classOf[Point], 4326)
        case Geometry.TYPENAME_LINESTRING      => sfb.add(name, classOf[LineString], 4326)
        case Geometry.TYPENAME_POLYGON         => sfb.add(name, classOf[Polygon], 4326)
        case Geometry.TYPENAME_MULTIPOINT      => sfb.add(name, classOf[MultiPoint], 4326)
        case Geometry.TYPENAME_MULTILINESTRING => sfb.add(name, classOf[MultiLineString], 4326)
        case Geometry.TYPENAME_MULTIPOLYGON    => sfb.add(name, classOf[MultiPolygon], 4326)
        case Geometry.TYPENAME_GEOMETRYCOLLECTION =>
          sfb.add(name, classOf[GeometryCollection], 4326)
        case "Geometry" => sfb.add(name, classOf[Geometry], 4326)
        // start db types
        case "RoadSegment" => sfb.add(name, classOf[RoadSegment])
        case "Trajectory"  => sfb.add(name, classOf[Trajectory])
        case "RoadNetwork" => sfb.add(name, classOf[java.lang.String]) // temporary
        // base types
        case "Integer"   => sfb.add(name, classOf[java.lang.Integer])
        case "Long"      => sfb.add(name, classOf[java.lang.Long])
        case "Float"     => sfb.add(name, classOf[java.lang.Float])
        case "Double"    => sfb.add(name, classOf[java.lang.Double])
        case "String"    => sfb.add(name, classOf[java.lang.String])
        case "Boolean"   => sfb.add(name, classOf[java.lang.Boolean])
        case "Binary"    => sfb.add(name, classOf[Array[Byte]])
        case "Timestamp" => sfb.add(name, classOf[java.sql.Timestamp])
        case "Datetime"  => sfb.add(name, classOf[java.sql.Date])
      }
      fieldAccessor.insert(new Field(0, tableId, name, dataType, 1), false)
    })

    val params: util.Map[String, String] = new util.HashMap[String, String]
    val CATALOG: String = "start_db.db_test"
    params.put("hbase.catalog", CATALOG)
    params.put("hbase.zookeepers", "localhost:2181")
    val dataStore = DataStoreFinder.getDataStore(params)
    val schema = dataStore.getSchema(tableName);
    if (schema != null) {
      throw new IllegalStateException("table already exist " + tableName);
    }

    // TODO transform start db type
    var sft = sfb.buildFeatureType();
    sft = new TrajectoryAndFeatureTransformer().getGeoMesaSFT(sft)
    sft = new RoadSegmentAndGeomesaTransformer().getGeoMesaSFT(sft)

    // allow mixed geometry types for support start-db type `Geometry`
    sft.getUserData.put("geomesa.mixed.geometries", java.lang.Boolean.TRUE)

    dataStore.createSchema(sft);
    tableAccessor.commit()
    fieldAccessor.commit()
    MetadataResult.buildDDLResult(affectedRows.toInt)
  }
}

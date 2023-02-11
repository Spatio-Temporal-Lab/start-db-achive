/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.executor

import org.apache.calcite.sql.SqlIdentifier
import org.apache.calcite.sql.ddl.SqlColumnDeclaration
import org.geotools.data.DataStoreFinder
import org.geotools.feature.simple.SimpleFeatureTypeBuilder
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil
import org.urbcomp.cupid.db.infra.{BaseExecutor, MetadataResult}
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil
import org.urbcomp.cupid.db.metadata.entity.{Field, Index, Table}
import org.urbcomp.cupid.db.parser.ddl.{SqlCupidCreateTable, SqlIndexDeclaration}
import org.urbcomp.cupid.db.schema.IndexType
import org.urbcomp.cupid.db.transformer.{
  RoadSegmentAndGeomesaTransformer,
  TrajectoryAndFeatureTransformer
}
import org.urbcomp.cupid.db.util.{DataTypeUtils, MetadataUtil}

import scala.collection.JavaConverters._

case class CreateTableExecutor(n: SqlCupidCreateTable) extends BaseExecutor {

  override def execute[Int](): MetadataResult[Int] = {
    val targetTable = n.name
    val (userName, dbName, tableName) = ExecutorUtil.getUserNameDbNameAndTableName(targetTable)

    val db = MetadataAccessUtil.getDatabase(userName, dbName)
    val existedTable = MetadataAccessUtil.getTable(db.getId, tableName)
    if (existedTable != null) {
      if (n.ifNotExists) {
        return MetadataResult.buildDDLResult(0)
      } else {
        throw new IllegalArgumentException("table already exist " + tableName)
      }
    }

    var affectedRows = 0L
    MetadataAccessUtil.withRollback(
      _ => {
        affectedRows =
          MetadataAccessUtil.insertTable(new Table(0L /* unused */, db.getId, tableName, "hbase"))
        val createdTable = MetadataAccessUtil.getTable(db.getId, tableName)
        val tableId = createdTable.getId

        val sfb = new SimpleFeatureTypeBuilder
        val schemaName = MetadataUtil.makeSchemaName(tableId)
        sfb.setName(schemaName)

        val fieldMap = collection.mutable.Map[String, Field]()
        n.columnList.forEach(column => {
          val node = column.asInstanceOf[SqlColumnDeclaration]
          val name = node.name.names.get(0)
          val dataType = node.dataType.getTypeName.names.get(0)
          val classType = DataTypeUtils.getClass(dataType)
          if (DataTypeUtils.isGeometry(dataType)) {
            sfb.add(name, classType, 4326)
          } else {
            sfb.add(name, classType)
          }
          val field = new Field(0, tableId, name, dataType, 0);
          MetadataAccessUtil.insertField(new Field(0, tableId, name, dataType, 0))
          fieldMap.put(name, field)
        })

        val indexes = getIndexes(tableId, n)
        indexes.foreach(index => MetadataAccessUtil.insertIndex(fillIndexName(index)))

        val geomesaIndexDecl = indexes
          .map(index => {
            val fields = index.getFieldsIdList.split(",")
            var indexDecl = IndexType.valueOf(index.getIndexType) match {
              case IndexType.ATTRIBUTE => "attr:"
              case IndexType.SPATIAL => {
                if (fields.length < 1) {
                  throw new IllegalArgumentException(
                    s"invalid spatial index for fields (${index.getFieldsIdList})"
                  )
                }
                val gemoType = fieldMap(fields(0)).getType
                fields.length match {
                  case 1 =>
                    val gemoType = fieldMap(fields(0)).getType
                    if (DataTypeUtils.isPoint(gemoType))
                      "z2:"
                    else "xz2:"
                  case 2 =>
                    if (DataTypeUtils.isPoint(gemoType))
                      "z3:"
                    else "xz3:"
                  case _ => throw new IllegalArgumentException("index type mismatch columns")
                }
              }
              case _ =>
                throw new IllegalArgumentException("unexpected index type " + index.getIndexType)
            }
            indexDecl += fields.mkString(":")
            indexDecl
          })
          .toList
          .mkString(",")

        val params = ExecutorUtil.getDataStoreParams(userName, dbName)
        val dataStore = DataStoreFinder.getDataStore(params)
        val schema = dataStore.getSchema(schemaName)
        if (schema != null) {
          throw new IllegalStateException("schema already exist " + schemaName)
        }

        var sft = sfb.buildFeatureType()
        sft = new TrajectoryAndFeatureTransformer().getGeoMesaSFT(sft)
        sft = new RoadSegmentAndGeomesaTransformer().getGeoMesaSFT(sft)

        // allow mixed geometry types for support cupid-db type `Geometry`
        sft.getUserData.put("geomesa.mixed.geometries", java.lang.Boolean.TRUE)

        sft.getUserData.put("geomesa.indices.enabled", geomesaIndexDecl)

        dataStore.createSchema(sft)
      },
      classOf[Exception]
    )

    MetadataResult.buildDDLResult(affectedRows.toInt)
  }

  /**
    * generate index name
    */
  private def fillIndexName(index: Index): Index = {
    index.setName(index.getIndexType + "-" + index.getFieldsIdList)
    index
  }

  /**
    * get index declaration or add default index declaration
    */
  private def getIndexes(tableId: Long, n: SqlCupidCreateTable): Array[Index] = {
    if (n.indexList != null && n.indexList.size() > 0) {
      n.indexList.asScala
        .map(i => {
          val index = i.asInstanceOf[SqlIndexDeclaration]
          val fields = index.getOperandList.asScala
            .map(op => op.asInstanceOf[SqlIdentifier].names.get(0))
            .toList
            .mkString(",")
          new Index(tableId, index.indexType.name(), fields.mkString(","), "")
        })
        .toArray
    } else {
      // add default index if no index explicitly defined
      var rss = Array[Index]()
      val firstGemo = n.columnList.asScala
        .map(c => {
          val column = c.asInstanceOf[SqlColumnDeclaration]
          val dataType = column.dataType.getTypeName.names.get(0)
          if (DataTypeUtils.isGeometry(dataType)) column.name.names.get(0) else null
        })
        .find(name => name != null)
        .orNull

      if (firstGemo != null) {
        rss = rss :+ new Index(tableId, IndexType.SPATIAL.name(), firstGemo, "")
        val firstDate = n.columnList.asScala
          .map(c => {
            val column = c.asInstanceOf[SqlColumnDeclaration]
            val dataType = column.dataType.getTypeName.names.get(0)
            if (DataTypeUtils.isDate(dataType)) column.name.names.get(0) else null
          })
          .find(name => name != null)
          .orNull
        if (firstDate != null) {
          rss = rss :+ new Index(
            tableId,
            IndexType.SPATIAL.name,
            Array(firstGemo, firstDate).mkString(","),
            ""
          )
        }
      }
      rss
    }
  }

}

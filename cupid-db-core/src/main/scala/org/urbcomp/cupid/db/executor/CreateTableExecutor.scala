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
          MetadataAccessUtil.insertField(field)
          fieldMap.put(name, field)
        })

        val indexes = getIndexes(tableId, fieldMap.toMap, n)
        checkIndexNames(indexes)
        indexes.foreach(index => MetadataAccessUtil.insertIndex(index))

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

        val geomesaIndexDecl = indexes
          .map(idx => {
            s"${idx.getIndexType}:${idx.getFieldsIdList.split(",").mkString(":")}"
          })
          .mkString(",")
        sft.getUserData.put("geomesa.indices.enabled", geomesaIndexDecl)

        dataStore.createSchema(sft)
      },
      classOf[Exception]
    )

    MetadataResult.buildDDLResult(affectedRows.toInt)
  }

  private def formatName(colName: String, order: Int): String = {
    s"$colName${if (order == 1) "" else s"_$order"}"
  }

  /**
    * Check if index names duplicate
    * For index name not explicitly defined, use ${columnName}_${order} with minimum order satisfy name not duplicate
    */
  private def checkIndexNames(indexes: Array[Index]): Unit = {
    val names = collection.mutable.Set[String]()
    indexes.foreach(idx => {
      if (idx.getName == null) {
        val colName = idx.getFieldsIdList.split(",")(0)
        var order = 1
        while (names.contains(formatName(colName, order))) {
          order += 1
        }
        idx.setName(formatName(colName, order))
      }
      if (names.contains(idx.getName)) {
        throw new IllegalArgumentException(s"Duplicate index name ${idx.getName}")
      }
      names.add(idx.getName)
    })
  }

  private def getIndexType(
      indexType: IndexType,
      fields: Array[String],
      fieldMap: Map[String, Field]
  ): String = {
    if (fields.length < 1) {
      throw new IllegalArgumentException("Invalid index no fields")
    }
    indexType match {
      case IndexType.ATTRIBUTE => "attr"
      case IndexType.SPATIAL =>
        val geoType = fieldMap(fields.head).getType
        fields.length match {
          case 1 =>
            val geoType = fieldMap(fields.head).getType
            if (DataTypeUtils.isPoint(geoType))
              "z2"
            else "xz2"
          case 2 =>
            if (DataTypeUtils.isPoint(geoType))
              "z3"
            else "xz3"
          case _ => throw new IllegalArgumentException("index type mismatch columns")
        }
      case _ =>
        throw new IllegalArgumentException("unexpected index type " + indexType.name())
    }
  }

  /**
    * get index declaration or add default index declaration
    */
  private def getIndexes(
      tableId: Long,
      fieldMap: Map[String, Field],
      n: SqlCupidCreateTable
  ): Array[Index] = {
    if (n.indexList != null && n.indexList.size() > 0) {
      n.indexList.asScala
        .map(i => {
          val index = i.asInstanceOf[SqlIndexDeclaration]
          val fields = index.getOperandList.asScala
            .map(op => op.asInstanceOf[SqlIdentifier].names.get(0))
            .toArray
          val indexName: String =
            if (index.indexName != null) index.indexName.names.get(0) else null

          var indexImplType = getIndexType(index.indexType, fields, fieldMap)
          if (index.indexImplType != null) {
            indexImplType = index.indexImplType.names.get(0)
          }

          new Index(tableId, indexImplType, indexName, fields.mkString(","), "")
        })
        .toArray
    } else {
      // add default index if no index explicitly defined
      var rss = Array[Index]()
      val firstGeo = n.columnList.asScala
        .map(c => {
          val column = c.asInstanceOf[SqlColumnDeclaration]
          val dataType = column.dataType.getTypeName.names.get(0)
          if (DataTypeUtils.isGeometry(dataType)) column.name.names.get(0) else null
        })
        .find(name => name != null)
        .orNull

      if (firstGeo != null) {
        rss = rss :+
          new Index(
            tableId,
            getIndexType(IndexType.SPATIAL, Array(firstGeo), fieldMap),
            null,
            firstGeo,
            ""
          )
        val firstDate = n.columnList.asScala
          .map(c => {
            val column = c.asInstanceOf[SqlColumnDeclaration]
            val dataType = column.dataType.getTypeName.names.get(0)
            if (DataTypeUtils.isDate(dataType)) column.name.names.get(0) else null
          })
          .find(name => name != null)
          .orNull
        if (firstDate != null) {
          rss = rss :+
            new Index(
              tableId,
              getIndexType(IndexType.SPATIAL, Array(firstGeo, firstDate), fieldMap),
              null,
              Array(firstGeo, firstDate).mkString(","),
              ""
            )
        }
      }
      rss
    }
  }

}

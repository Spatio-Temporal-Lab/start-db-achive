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

import java.lang.reflect.Type
import scala.collection.JavaConverters._

/**
 * Table of Geomesa
 *
 * @author zaiyuan
 * @since 0.1.0
 * @param dataStore Geotools DataStore
 * @param query     Geotools Query
 */
case class GeomesaTable(userName: String, dbName: String, tableName: String)
  extends AbstractQueryableTable(classOf[Type]) with TranslatableTable {

  /**
   * convert table instance to table scan instance
   */
  override def toRel(toRelContext: RelOptTable.ToRelContext, relOptTable: RelOptTable): RelNode =
    new GeomesaTableScan(toRelContext.getCluster,
      toRelContext.getCluster.traitSetOf(GeomesaConstant.CONVENTION), relOptTable, this)

  /**
   * convert to queryable instance
   */
  override def asQueryable[T](queryProvider: QueryProvider, schemaPlus: SchemaPlus, s: String): Queryable[T] =
    new GeomesaQueryable[T](queryProvider, schemaPlus, this, s)

  /**
   * get Schema of the table
   *
   * @param relDataTypeFactory RelDataTypeFactory
   * @return RelDataType
   */
  override def getRowType(relDataTypeFactory: RelDataTypeFactory): RelDataType = {
    val dataStore = DataStoreFinder.getDataStore(ConfigProvider.getGeomesaHbaseParam(dbName).asJava)
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

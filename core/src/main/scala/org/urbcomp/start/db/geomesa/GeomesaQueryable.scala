package org.urbcomp.start.db.geomesa

import org.apache.calcite.linq4j.{AbstractEnumerable, Enumerable, Enumerator, QueryProvider}
import org.apache.calcite.schema.SchemaPlus
import org.apache.calcite.schema.impl.AbstractTableQueryable

/**
 * Queryable for Geomesa
 *
 * @param provider  QueryProvider
 * @param schema  SchemaPlus
 * @param table geomesa table
 * @param tableName table name
 * @tparam T  type
 *
 * @author zaiyuan
 * @since 0.1.0
 */
class GeomesaQueryable[T](provider: QueryProvider,
                          schema: SchemaPlus,
                          table: GeomesaTable,
                          tableName: String) extends AbstractTableQueryable[T](provider, schema, table, tableName){
  override def enumerator(): Enumerator[T] =
    query(null, null, null).asInstanceOf[Enumerable[T]].enumerator()

  def query(filter: String, tableName: String, dbName: String): Enumerable[AnyRef] = {
    new AbstractEnumerable[AnyRef] {
      override def enumerator(): Enumerator[AnyRef] = GeomesaEnumerator(filter, tableName, dbName)
    }
  }
}

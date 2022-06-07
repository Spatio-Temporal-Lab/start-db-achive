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

import org.apache.calcite.linq4j.{AbstractEnumerable, Enumerable, Enumerator, QueryProvider}
import org.apache.calcite.schema.SchemaPlus
import org.apache.calcite.schema.impl.AbstractTableQueryable

/**
  * Queryable for Geomesa
  *
  * @param provider  QueryProvider
  * @param schema    SchemaPlus
  * @param table     geomesa table
  * @param tableName table name
  * @tparam T type
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaQueryable[T](
    provider: QueryProvider,
    schema: SchemaPlus,
    table: GeomesaTable,
    tableName: String
) extends AbstractTableQueryable[T](provider, schema, table, tableName) {
  override def enumerator(): Enumerator[T] =
    query(null, null, null, null).asInstanceOf[Enumerable[T]].enumerator()

  def query(filter: String, tableName: String, dbName: String, user: String): Enumerable[AnyRef] = {
    new AbstractEnumerable[AnyRef] {
      override def enumerator(): Enumerator[AnyRef] =
        GeomesaEnumerator(filter, tableName, dbName, user)
    }
  }
}

/*
 * Copyright 2022 ST-Lab

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

package org.urbcomp.start.db.geomesa

import org.apache.calcite.schema.Table
import org.apache.calcite.schema.impl.AbstractSchema

import java.util
import java.util.Collections

/**
  * Schema of Geomesa
  *
  * @param userName  user name
  * @param dbName  db name
  * @param tableName table name
  *
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaSchema(userName: String, dbName: String, tableName: String) extends AbstractSchema {
  override def getTableMap: util.Map[String, Table] =
    Collections.singletonMap(tableName, GeomesaTable(userName, dbName, tableName))
}

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
class GeomesaSchema(userName: String, dbName: String, tableName: String) extends AbstractSchema{
  override def getTableMap: util.Map[String, Table] =
    Collections.singletonMap(tableName, GeomesaTable(userName, dbName, tableName))
}

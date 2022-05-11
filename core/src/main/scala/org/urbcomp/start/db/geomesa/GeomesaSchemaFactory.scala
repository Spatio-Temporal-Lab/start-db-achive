package org.urbcomp.start.db.geomesa

import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}

import java.util

/**
 * Schema Factory of Geomesa
 *
 * @author zaiyuan
 * @since 0.1.0
 */
class GeomesaSchemaFactory extends SchemaFactory {
  override def create(schemaPlus: SchemaPlus,
                      schemaName: String,
                      operands: util.Map[String, AnyRef]): Schema =
    new GeomesaSchema(String.valueOf(operands.get("userName")),
      String.valueOf(operands.get("dbName")),
      String.valueOf(operands.get("tableName")))
}

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

import org.apache.calcite.schema.{Schema, SchemaFactory, SchemaPlus}

import java.util

/**
  * Schema Factory of Geomesa
  *
  * @author zaiyuan
  * @since 0.1.0
  */
class GeomesaSchemaFactory extends SchemaFactory {
  override def create(
      schemaPlus: SchemaPlus,
      schemaName: String,
      operands: util.Map[String, AnyRef]
  ): Schema = new GeomesaSchema
}

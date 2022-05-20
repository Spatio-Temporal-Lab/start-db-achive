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

package org.urbcomp.start.db.geomesa.rel

import org.apache.calcite.rel.RelNode
import org.urbcomp.start.db.core.geomesa.model.GeomesaQuery

/**
  * RelNode Trait for Geomesa.
  *
  * @author zaiyuan
  * @date 2022/05/01
  */
trait IGeomesaRelNode extends RelNode {
  def wrap(query: GeomesaQuery): Unit
}

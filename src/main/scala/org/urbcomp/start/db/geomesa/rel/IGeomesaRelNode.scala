package org.urbcomp.start.db.geomesa.rel

import org.apache.calcite.rel.RelNode
import org.urbcomp.start.db.core.geomesa.model.GeomesaQuery

/**
 * RelNode Trait for Geomesa.
 *
 * @author zaiyuan
 * @date 2022/02/27
 */
trait IGeomesaRelNode extends RelNode {
  def wrap(query: GeomesaQuery): Unit
}

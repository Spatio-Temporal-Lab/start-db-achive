package org.urbcomp.start.db.geomesa

import org.apache.calcite.plan.Convention
import org.urbcomp.start.db.geomesa.rel.IGeomesaRelNode

object GeomesaConstant {

  val CONVENTION = new Convention.Impl("Geomesa", classOf[IGeomesaRelNode])

  val ST_WITHIN = "st_within"
  val ST_TOUCHES = "st_touches"
  val ST_OVERLAPS = "st_overlaps"
  val ST_INTERSECTS = "st_intersects"
  val ST_EQUALS = "st_equals"
  val ST_DISJOINT = "st_disjoint"
  val ST_COVERS = "st_covers"
  val ST_CROSSES = "st_crosses"
  val ST_CONTAINS = "st_contains"
}

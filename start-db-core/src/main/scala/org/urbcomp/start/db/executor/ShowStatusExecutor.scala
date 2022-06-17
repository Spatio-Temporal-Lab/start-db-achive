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

package org.urbcomp.start.db.executor

import org.urbcomp.start.db.infra.{BaseExecutor, MetadataResult}

import scala.language.higherKinds

/**
  * @author jimo
  * */
case class ShowStatusExecutor() extends BaseExecutor {

  override def execute[Array](): MetadataResult[Array] = {
    MetadataResult
      .buildResult(Array("Variable_name", "Value"), java.util.Arrays.asList(Array("status", "ok")))
      .asInstanceOf[MetadataResult[Array]]
  }
}

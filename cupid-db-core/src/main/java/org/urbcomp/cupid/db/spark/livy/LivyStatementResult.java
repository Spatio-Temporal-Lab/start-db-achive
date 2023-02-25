/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.spark.livy;

import com.esotericsoftware.kryo.io.Output;
import lombok.Builder;
import lombok.Data;

/**
 * @author jimo
 **/
@Data
@Builder
public class LivyStatementResult {
    private int id;
    private double progress;
    private String state;
    private Output output;
}

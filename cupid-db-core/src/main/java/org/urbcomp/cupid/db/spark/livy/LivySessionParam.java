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

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.Data;
import org.urbcomp.cupid.db.util.JacksonUtil;

import java.util.List;

/**
 * https://livy.apache.org/docs/latest/rest-api.html
 *
 * @author jimo
 **/
@Data
@Builder
public class LivySessionParam {
    private String kind;
    private String name;
    private List<String> jars;
    private String driverMemory;
    private int driverCores;
    private String executorMemory;
    private int executorCores;
    private int numExecutors;

    public String toJsonBody() throws JsonProcessingException {
        return JacksonUtil.MAPPER.writeValueAsString(this);
    }
}

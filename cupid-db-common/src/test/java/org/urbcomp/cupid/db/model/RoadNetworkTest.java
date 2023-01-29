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

package org.urbcomp.cupid.db.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;

import static org.junit.Assert.*;

public class RoadNetworkTest {
    private final RoadNetwork rn = ModelGenerator.generateRoadNetwork();

    @Test
    public void toGeoJSON() throws JsonProcessingException {
        String geoJsonStr = rn.toGeoJSON();
        RoadNetwork rn1 = RoadNetwork.fromGeoJSON(geoJsonStr);
        assertEquals(rn, rn1);
    }
}

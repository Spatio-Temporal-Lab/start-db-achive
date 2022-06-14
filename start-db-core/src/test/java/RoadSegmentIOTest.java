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

import org.geotools.filter.text.cql2.CQLException;
import org.junit.Test;
import org.urbcomp.start.db.io.RoadSegmentGeoMesaIO;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.sample.ModelGenerator;

import java.io.IOException;

public class RoadSegmentIOTest {
    private final RoadSegment rs = ModelGenerator.generateRoadSegment();

    @Test
    public void toGeoJSON() throws IOException, CQLException {
        RoadSegmentGeoMesaIO io = new RoadSegmentGeoMesaIO();
        io.RoadSegmentToGeoMesaObject(rs);
        io.RoadSegmentFromGeoMesaObject();
    }
}

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

package org.urbcomp.start.db.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;

import java.io.IOException;

public class RoadSegmentDeserializer extends StdDeserializer<RoadSegment> {
    protected RoadSegmentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public RoadSegment deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return RoadSegment.fromGeoJSON(p.getValueAsString());
    }
}

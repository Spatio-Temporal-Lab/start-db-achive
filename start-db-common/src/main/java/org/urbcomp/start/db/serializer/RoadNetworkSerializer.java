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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.urbcomp.start.db.model.roadnetwork.RoadNetwork;

import java.io.IOException;

public class RoadNetworkSerializer extends StdSerializer<RoadNetwork> {

    protected RoadNetworkSerializer(Class<RoadNetwork> t) {
        super(t);
    }

    @Override
    public void serialize(RoadNetwork value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeString(value.toGeoJSON());
    }
}

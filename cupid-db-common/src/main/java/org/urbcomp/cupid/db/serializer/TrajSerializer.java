/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.io.IOException;

public class TrajSerializer extends StdSerializer<Trajectory> {

    public TrajSerializer() {
        this(null);
    }

    protected TrajSerializer(Class<Trajectory> t) {
        super(t);
    }

    @Override
    public void serialize(Trajectory traj, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeString(traj.toGeoJSON());
    }
}

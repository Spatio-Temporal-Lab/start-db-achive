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
package org.urbcomp.cupid.db.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;

import static org.junit.Assert.assertEquals;

public class RoadSegmentTest {
    private final RoadSegment rs = ModelGenerator.generateRoadSegment();

    @Test
    public void toGeoJSON() throws JsonProcessingException {
        String jsonStr = rs.toGeoJSON();
        RoadSegment rs1 = RoadSegment.fromGeoJSON(jsonStr);
        assertEquals(rs, rs1);
    }
}

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

import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TrajectoryTest {
    private final Trajectory trajectory = ModelGenerator.generateTrajectory();

    @Test
    public void toGeoJsonWithExtraAttribute() throws IOException {
        String[] namesArray = new String[] { "int", "str", "double", "point" };
        String[] typeArray = new String[] { "Integer", "String", "Double", "Point" };
        Trajectory trajectory1 = ModelGenerator.generateTrajectory(
            Arrays.asList(namesArray),
            Arrays.asList(typeArray)
        );
        String geoJson = trajectory1.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(1, traj.getAttribute("int"));
        assertEquals("2", traj.getAttribute("str"));
        assertEquals(3.0, traj.getAttribute("double"));
        GeometryFactory factory = new GeometryFactory();
        assertEquals(factory.createPoint(new Coordinate(1, 2)), trajectory1.getAttribute("point"));
        assertEquals(trajectory1, traj);
    }

    @Test
    public void toGeoJSON() throws IOException, ClassNotFoundException {
        String geoJson = trajectory.toGeoJSON();
        Trajectory traj = Trajectory.fromGeoJSON(geoJson);
        assertEquals(trajectory, traj);
    }
}

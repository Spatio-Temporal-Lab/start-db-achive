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
package org.urbcomp.cupid.db.algorithm.trajectorysegment;

import org.junit.Before;
import org.junit.Test;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HybridSegmentTest {

    private static Trajectory trajectory;

    @Before
    public void setup() {
        trajectory = ModelGenerator.generateTrajectory("./data/stayPointSegmentationTraj.txt");

    }

    @Test
    public void hybridSegmentTest() {
        HybridSegment trajectorySegment = new HybridSegment(10, 10, 10);
        List<Trajectory> subTrajectory = trajectorySegment.segment(trajectory);
        int totalSize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(subTrajectory.size(), 5);
        // 8 gps points belong to stay points
        assertEquals(trajectory.getGPSPointList().size() - 8, totalSize);

        trajectorySegment = new HybridSegment(10, 10, 11);
        subTrajectory = trajectorySegment.segment(trajectory);
        totalSize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(subTrajectory.size(), 4);
        assertEquals(trajectory.getGPSPointList().size() - 8, totalSize);

        trajectorySegment = new HybridSegment(10, 10, 15);
        subTrajectory = trajectorySegment.segment(trajectory);
        totalSize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(subTrajectory.size(), 4);
        assertEquals(trajectory.getGPSPointList().size() - 8, totalSize);

        trajectorySegment = new HybridSegment(10, 10, 16);
        subTrajectory = trajectorySegment.segment(trajectory);
        totalSize = subTrajectory.stream().mapToInt(o -> o.getGPSPointList().size()).sum();
        assertEquals(subTrajectory.size(), 3);
        assertEquals(trajectory.getGPSPointList().size() - 8, totalSize);

    }
}

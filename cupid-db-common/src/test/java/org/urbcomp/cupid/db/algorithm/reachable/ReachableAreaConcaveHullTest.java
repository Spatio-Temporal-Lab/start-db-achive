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
package org.urbcomp.cupid.db.algorithm.reachable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNode;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.util.GeoFunctions;

public class ReachableAreaConcaveHullTest {
    private static ReachableAreaConcaveHull concaveHull;
    private RoadNetwork roadNetwork;
    private SpatialPoint startPt;

    @Before
    public void setup() {
        startPt = new SpatialPoint(108.98897, 34.25815);
        this.roadNetwork = ModelGenerator.generateRoadNetwork();
        concaveHull = new ReachableAreaConcaveHull(roadNetwork, startPt, 360, "Walk");
    }

    @Test
    public void reachableAreaTest() {
        Polygon hull = concaveHull.getConcaveHull();
        CandidatePoint startCandidatePoint = CandidatePoint.getNearestCandidatePoint(
            startPt,
            roadNetwork,
            100
        );
        RoadNode startNode = roadNetwork.getRoadSegmentById(startCandidatePoint.getRoadSegmentId())
            .getStartNode();
        SpatialPoint startNodePoint = new SpatialPoint(startNode.getLng(), startNode.getLat());

        for (Coordinate coordinate : hull.getCoordinates()) {
            SpatialPoint endPt = new SpatialPoint(coordinate.y, coordinate.x);
            double dis = GeoFunctions.getDistanceInM(startNodePoint, endPt);
            Assert.assertTrue(dis < 5000.0);
        }
    }
}

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

import org.locationtech.jts.algorithm.hull.ConcaveHull;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;

import java.util.*;

public class ReachableAreaConcaveHull {
    private SpatialPoint startPt;
    private double timeBudgetInS;
    private String travelMode;
    private final RoadNetwork roadNetwork;

    public ReachableAreaConcaveHull(
        RoadNetwork roadNetwork,
        SpatialPoint startPt,
        double timeBudgetInS,
        String travelMode
    ) {
        this.startPt = startPt;
        this.roadNetwork = roadNetwork;
        this.timeBudgetInS = timeBudgetInS;
        this.travelMode = travelMode;

    }

    public Polygon getConcaveHull() {
        Polygon concaveHull = null;
        ReachableArea reachableArea = new ReachableArea(
            this.roadNetwork,
            this.startPt,
            this.timeBudgetInS,
            this.travelMode
        );
        ArrayList<SpatialPoint> researchable = reachableArea.calReachableArea();
        if (!researchable.isEmpty()) {
            List<Coordinate> points = new ArrayList<>();
            researchable.stream()
                .forEach(pt -> points.add(new Coordinate(pt.getLat(), pt.getLng())));
            GeometryFactory geometryFactory = new GeometryFactory();
            CoordinateSequence sequence = new CoordinateArraySequence(
                points.toArray(new Coordinate[0])
            );
            MultiPoint pts = geometryFactory.createMultiPoint(sequence);
            ConcaveHull ch = new ConcaveHull(pts);
            concaveHull = (Polygon) ch.concaveHullByLengthRatio(pts, 0.6);
        }

        return concaveHull;

    }
}

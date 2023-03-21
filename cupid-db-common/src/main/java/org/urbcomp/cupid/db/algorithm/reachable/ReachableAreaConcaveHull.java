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

public class ReachableAreaConcaveHull extends AbstractReachableArea {

    public ReachableAreaConcaveHull(
        RoadNetwork roadNetwork,
        SpatialPoint startPt,
        double timeBudgetInS,
        String travelMode
    ) {
        super(roadNetwork, startPt, timeBudgetInS, travelMode);

    }

    @Override
    public Polygon getHull() {
        ArrayList<SpatialPoint> researchable = calReachableArea();
        if (!researchable.isEmpty()) {
            List<Coordinate> points = new ArrayList<>();
            researchable.forEach(pt -> points.add(new Coordinate(pt.getLat(), pt.getLng())));
            GeometryFactory geometryFactory = new GeometryFactory();
            CoordinateSequence sequence = new CoordinateArraySequence(
                points.toArray(new Coordinate[0])
            );
            MultiPoint pts = geometryFactory.createMultiPoint(sequence);
            return (Polygon) ConcaveHull.concaveHullByLengthRatio(pts, 0.6);
        } else {
            return null;
        }

    }

}

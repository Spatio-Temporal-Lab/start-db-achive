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

import org.locationtech.jts.algorithm.ConvexHull;
import org.locationtech.jts.geom.*;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.*;

import java.util.*;

public class ReachableAreaConvexHull extends AbstractReachableArea {

    public ReachableAreaConvexHull(
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
            GeometryFactory geometryFactory = new GeometryFactory();
            List<Coordinate> points = new ArrayList<>();
            researchable.forEach(pt -> points.add(new Coordinate(pt.getLat(), pt.getLng())));
            ConvexHull convexHull = new ConvexHull(
                points.toArray(new Coordinate[0]),
                geometryFactory
            );
            return (Polygon) convexHull.getConvexHull();
        } else {
            return null;
        }

    }

}

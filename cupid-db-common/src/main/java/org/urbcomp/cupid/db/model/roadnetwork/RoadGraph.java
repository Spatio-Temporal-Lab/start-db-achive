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
package org.urbcomp.cupid.db.model.roadnetwork;

import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultGraphType;
import org.jgrapht.util.SupplierUtil;

public class RoadGraph extends AbstractBaseGraph<RoadNode, RoadSegment> {
    public RoadGraph(boolean directed) {
        super(
            null,
            SupplierUtil.createSupplier(RoadSegment.class),
            new DefaultGraphType.Builder(directed, !directed).weighted(true)
                .allowMultipleEdges(false)
                .allowSelfLoops(true)
                .build()
        );
    }

    public void addEdge(RoadSegment roadSegment) {
        addVertex(roadSegment.getStartNode());
        addVertex(roadSegment.getEndNode());
        super.addEdge(roadSegment.getStartNode(), roadSegment.getEndNode(), roadSegment);
        setEdgeWeight(roadSegment, roadSegment.getLengthInMeter());
    }
}

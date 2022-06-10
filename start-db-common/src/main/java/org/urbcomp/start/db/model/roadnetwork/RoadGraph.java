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

package org.urbcomp.start.db.model.roadnetwork;

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

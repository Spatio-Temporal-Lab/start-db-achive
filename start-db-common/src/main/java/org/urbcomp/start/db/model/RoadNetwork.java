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

package org.urbcomp.start.db.model;

import java.util.ArrayList;
import java.util.List;

public class RoadNetwork {
    private List<RoadSegment> roadSegments;

    public RoadNetwork(List<RoadSegment> roadSegments) {
        this.roadSegments = roadSegments;
    }

    public RoadNetwork() {
        this(new ArrayList<>());
    }

    public RoadNetwork addRoadSegment(RoadSegment roadSegment) {
        this.roadSegments.add(roadSegment);
        return this;
    }

    public List<RoadSegment> getRoadSegments() {
        return roadSegments;
    }

    public RoadNetwork setRoadSegments(List<RoadSegment> roadSegments) {
        this.roadSegments = roadSegments;
        return this;
    }
}

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

package org.urbcomp.start.db.algorithm.shortestpath;

import org.urbcomp.start.db.model.roadsegment.RoadSegment;

import java.util.List;

public class ShortestPathResult {
    private final double length;

    private final List<RoadSegment> roadSegmentList;

    public ShortestPathResult(double length, List<RoadSegment> roadSegmentList) {
        this.length = length;
        this.roadSegmentList = roadSegmentList;
    }

    public double getLength() {
        return length;
    }

    public List<RoadSegment> getRoadSegmentList() {
        return roadSegmentList;
    }
}

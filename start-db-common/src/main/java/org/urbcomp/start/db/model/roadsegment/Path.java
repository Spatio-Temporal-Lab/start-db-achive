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

package org.urbcomp.start.db.model.roadsegment;

import org.locationtech.jts.geom.Point;

import java.util.List;

/**
 * {@link Path} is different from {@link RoadSegment}.
 * It contains the points from one position to another, and specifies the cost.
 * It also contains the corresponding {@link RoadSegment} ids.
 */
public class Path {
    /**
     * maybe distance, or time costs
     */
    private double costs;

    /**
     * the points the route crosses. This is very useful for display.
     */
    private List<Point> points;

    /**
     * the road segment ids that this route crosses
     */
    private List<Integer> roadSegmentIds;

    public Path(double costs, List<Point> points, List<Integer> roadSegmentIds) {
        this.costs = costs;
        this.points = points;
        this.roadSegmentIds = roadSegmentIds;
    }

    public double getCosts() {
        return costs;
    }

    public Path setCosts(double costs) {
        this.costs = costs;
        return this;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Path setPoints(List<Point> points) {
        this.points = points;
        return this;
    }

    public List<Integer> getRoadSegmentIds() {
        return roadSegmentIds;
    }

    public Path setRoadSegmentIds(List<Integer> roadSegmentIds) {
        this.roadSegmentIds = roadSegmentIds;
        return this;
    }

    public Path addPath(Path path) {
        this.costs += path.costs;
        this.points.addAll(path.getPoints());
        this.roadSegmentIds.addAll(path.getRoadSegmentIds());
        return this;
    }
}

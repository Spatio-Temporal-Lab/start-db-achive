/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.algorithm.clustering;

import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.util.GeoFunctions;
import org.urbcomp.cupid.db.util.GeometryFactoryUtils;

import java.util.*;

public class DBSCANClustering extends AbstractClustering {
    private final double distanceInM;
    private final int minPoints;

    public DBSCANClustering(List<SpatialPoint> pointList, double distanceInM, int minPoints) {
        super(pointList);
        this.distanceInM = distanceInM;
        this.minPoints = minPoints;
    }

    public List<SpatialPoint> rangeQuery(SpatialPoint point) {
        List<SpatialPoint> neighbors = new ArrayList<>();
        for (SpatialPoint p : pointList)
            if (GeoFunctions.getDistanceInM(p, point) < distanceInM) {
                neighbors.add(p);
            }
        return neighbors;
    }

    @Override
    public List<MultiPoint> cluster() {
        HashMap<SpatialPoint, Integer> label = new HashMap<>();
        int clusterId = 0;
        for (SpatialPoint p : pointList) {
            if (label.containsKey(p)) continue;
            List<SpatialPoint> neighbors = rangeQuery(p);
            if (neighbors.size() < minPoints) {
                label.put(p, -1); // Noise label
                continue;
            }
            clusterId++;
            label.put(p, clusterId);
            HashSet<SpatialPoint> seedSet = new HashSet<>(neighbors);
            seedSet.remove(p);
            while (!seedSet.isEmpty()) {
                SpatialPoint q = seedSet.iterator().next();
                seedSet.remove(q);
                if (label.containsKey(q) && label.get(q) == -1) label.put(q, clusterId);
                if (label.containsKey(q)) continue;
                label.put(q, clusterId);
                neighbors = rangeQuery(q);
                if (neighbors.size() >= minPoints) seedSet.addAll(neighbors);
            }
        }
        HashMap<Integer, List<SpatialPoint>> clusters = new HashMap<>();
        for (int i = 1; i <= clusterId; i++)
            clusters.put(i, new ArrayList<>());
        label.forEach((point, cluster) -> { if (cluster >= 1) clusters.get(cluster).add(point); });
        List<MultiPoint> ret = new ArrayList<>();
        for (Map.Entry<Integer, List<SpatialPoint>> entry : clusters.entrySet()) {
            List<SpatialPoint> points = entry.getValue();
            SpatialPoint[] arr = new SpatialPoint[points.size()];
            ret.add(
                new MultiPoint(points.toArray(arr), GeometryFactoryUtils.defaultGeometryFactory())
            );
        }
        return ret;
    }
}

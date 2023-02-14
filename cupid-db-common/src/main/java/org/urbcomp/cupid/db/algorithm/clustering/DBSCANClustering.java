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

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.util.GeoFunctions;
import org.urbcomp.cupid.db.util.GeometryFactoryUtils;
import com.github.davidmoten.grumpy.core.Position;
import rx.Observable;

import java.util.*;
import java.util.stream.Collectors;

public class DBSCANClustering extends AbstractClustering {
    private final double distanceInM;
    private final int minPoints;
    private RTree<SpatialPoint, Point> pointRTree;

    public DBSCANClustering(List<SpatialPoint> pointList, double distanceInM, int minPoints) {
        super(pointList);
        this.pointRTree = RTree.star().create();
        for (SpatialPoint p : pointList)
            this.pointRTree = this.pointRTree.add(p, Geometries.point(p.getLng(), p.getLat()));
        this.distanceInM = distanceInM;
        this.minPoints = minPoints;
    }

    private static Rectangle createBounds(final Position from, final double distanceKm) {
        // this calculates a pretty accurate bounding box. Depending on the
        // performance you require you wouldn't have to be this accurate because
        // accuracy is enforced later
        Position north = from.predict(distanceKm, 0);
        Position south = from.predict(distanceKm, 180);
        Position east = from.predict(distanceKm, 90);
        Position west = from.predict(distanceKm, 270);
        return Geometries.rectangle(west.getLon(), south.getLat(), east.getLon(), north.getLat());
    }

    private Observable<Entry<SpatialPoint, Point>> search(Point lonLat) {
        // First we need to calculate an enclosing lat long rectangle for this
        // distance then we refine on the exact distance
        final Position from = Position.create(lonLat.y(), lonLat.x());
        Rectangle bounds = createBounds(from, distanceInM / 1000);

        return pointRTree
            // do the first search using the bounds
            .search(bounds)
            // refine using the exact distance
            .filter(entry -> {
                Point p = entry.geometry();
                Position position = Position.create(p.y(), p.x());
                return from.getDistanceToKm(position) < distanceInM / 1000;
            });
    }

    private List<SpatialPoint> rangeQuery(SpatialPoint point) {
        List<Entry<SpatialPoint, Point>> list = search(
            Geometries.point(point.getLng(), point.getLat())
        ).toList().toBlocking().single();
        return list.stream().map(Entry::value).collect(Collectors.toList());
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

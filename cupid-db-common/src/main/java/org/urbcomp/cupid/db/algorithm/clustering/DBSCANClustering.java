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
package org.urbcomp.cupid.db.algorithm.clustering;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Point;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.util.GeoFunctions;
import org.urbcomp.cupid.db.util.GeometryFactoryUtils;
import rx.Observable;

import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBSCANClustering extends AbstractClustering {
    private final double distanceInM;
    private final int minPoints;
    private RTree<SpatialPoint, Point> pointRTree;

    public DBSCANClustering(List<SpatialPoint> pointList, double distanceInM, int minPoints) {
        super(pointList);
        this.distanceInM = distanceInM;
        this.minPoints = minPoints;
    }

    private Rectangle createBounds(final SpatialPoint point) {
        // Get a bounding box around point
        Envelope envelope = GeoFunctions.getExtendedBBox(point, distanceInM);
        return Geometries.rectangle(
            envelope.getMinX(),
            envelope.getMinY(),
            envelope.getMaxX(),
            envelope.getMaxY()
        );
    }

    private Observable<Entry<SpatialPoint, Point>> search(SpatialPoint point) {
        // First we need to calculate an enclosing lat long rectangle for this
        // distance then we refine on the exact distance
        return pointRTree.search(createBounds(point)).filter(entry -> {
            Point p = entry.geometry();
            return GeoFunctions.getDistanceInM(point, new SpatialPoint(p.x(), p.y())) < distanceInM;
        });
    }

    private List<SpatialPoint> rangeQuery(SpatialPoint point) {
        List<Entry<SpatialPoint, Point>> list = search(point).toList().toBlocking().single();
        return list.stream().map(Entry::value).collect(Collectors.toList());
    }

    @Override
    public List<MultiPoint> cluster() {
        log.warn("enter cluster");
        if (pointRTree == null) {
            pointRTree = RTree.star().create();
            for (SpatialPoint p : pointList)
                pointRTree = pointRTree.add(p, Geometries.point(p.getLng(), p.getLat()));
        }
        HashMap<SpatialPoint, Integer> label = new HashMap<>();
        int clusterId = 0;
        for (SpatialPoint p : pointList) {
            if (label.containsKey(p)) continue;
            List<SpatialPoint> neighbors = rangeQuery(p);
            if (neighbors.size() < minPoints) {
                // Noise label
                label.put(p, -1);
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

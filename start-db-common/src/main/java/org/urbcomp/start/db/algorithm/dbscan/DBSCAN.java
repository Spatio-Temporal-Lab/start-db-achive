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

package org.urbcomp.start.db.algorithm.dbscan;

import com.github.davidmoten.grumpy.core.Position;
import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Geometry;
import com.github.davidmoten.rtree.geometry.Point;
import com.github.davidmoten.rtree.geometry.Rectangle;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

@Slf4j
public class DBSCAN {

    /**
     * 空间DBSCAN聚类
     *
     * @param radius 半径参数      (单位：km)
     * @param minPts 领域密度阈值   (单位：个)
     */
    private final double radius;
    private final int minPts;

    public DBSCAN(double radius, int minPts) {
        this.radius = radius;
        this.minPts = minPts;
    }

    /**
     * 创建MBR
     * @param from 当前点
     * @param distanceKm 距离
     */
    private static Rectangle createBounds(final Position from, final double distanceKm) {
        Position north = from.predict(distanceKm, 0);
        Position south = from.predict(distanceKm, 180);
        Position east = from.predict(distanceKm, 90);
        Position west = from.predict(distanceKm, 270);

        return Geometries
                .rectangle(
                        west.getLon(),
                        south.getLat(),
                        east.getLon(),
                        north.getLat());
    }

    /**
     * R*树空间搜索
     * @param tree R*树
     * @param lonlat 当前点
     * @param distanceKm 距离
     */
    public static <T> Observable<Entry<T, Point>> search(RTree<T,Point> tree, Point lonlat, final double distanceKm) {
        final Position from = Position.create(lonlat.y(),lonlat.x());
        Rectangle bounds = createBounds(from, distanceKm);

        return tree
                .search(bounds)
                .filter(entry -> {
                    Point p = entry.geometry();
                    Position position = Position.create(p.y(), p.x());
                    return from.getDistanceToKm(position) <= distanceKm;
                });
    }

    /**
     * 读取数据，并添加R*树索引
     * @param csvFile csv路径
     */
    public ArrayList<Object> getRtreeData(String csvFile) throws IOException {
        ArrayList<Object> list = new ArrayList<>();

        ArrayList<ClusterPoint> clusterPoints = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        bufferedReader.readLine();

        String line;
        int idx = 0;

        RTree<Object, Geometry> rTree = RTree.star().create();

        while ((line = bufferedReader.readLine()) != null) {

            String[] split = line.split(",");

            double lon = Double.parseDouble(split[0]);
            double lat = Double.parseDouble(split[1]);

            clusterPoints.add(
                    new ClusterPoint(Timestamp.valueOf(LocalDateTime.now()),
                            lon,
                            lat));

            rTree = rTree.add(String.valueOf(idx),Geometries.point(lon,lat));
            idx++;
        }
        list.add(clusterPoints);
        list.add(rTree);

        return list;
    }

    /**
     * DBSCAN空间聚类
     * @param points 所有点
     * @return 聚类结果
     */
    public ArrayList<ClusterPoint> process(ArrayList<ClusterPoint> points,RTree<String,Point> rTree) throws InterruptedException {
        int size = points.size();
        int idx = 0;
        int cluster = 1;

        while (idx < size) {
            log.info("Doing " + idx);
            ClusterPoint point = points.get(idx++);

            if (!point.isVisited()) {
                point.setVisited(true);

                List<Entry<String, Point>> adjacentPoints = search(
                        rTree,
                        Geometries.point(point.getLng(),point.getLat()),
                        this.radius)
                        .toList()
                        .toBlocking()
                        .single();

                if (adjacentPoints != null && adjacentPoints.size() < this.minPts) {
                    point.setNoised(true);
                } else {
                    point.setCluster(cluster);
                    for (int i = 0; i < adjacentPoints.size(); i++) {
                        Entry<String, Point> adjacentPoint = adjacentPoints.get(i);
                        ClusterPoint adjPoint = points.get(Integer.parseInt(adjacentPoint.value()));

                        if (!adjPoint.isVisited()) {
                            adjPoint.setVisited(true);

                            List<Entry<String, Point>> adjPointsTemp = search(
                                    rTree,
                                    Geometries.point(adjPoint.getLng(),adjPoint.getLat()),
                                    this.radius)
                                    .toList()
                                    .toBlocking()
                                    .single();

                            if (adjPointsTemp != null && adjPointsTemp.size() >= minPts) {
                                adjacentPoints.addAll(adjPointsTemp);
                                    }
                                }

                        if (adjPoint.getCluster() == 0) {
                            adjPoint.setCluster(cluster);

                            if (adjPoint.isNoised()) {
                                adjPoint.setNoised(false);
                            }
                        }
                    }
                    cluster++;
                }
            }
        }
        return points;
    }
}

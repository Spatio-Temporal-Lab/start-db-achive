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

import org.geotools.referencing.GeodeticCalculator;
import org.geotools.referencing.crs.DefaultGeographicCRS;

import java.util.ArrayList;

public class DBSCAN {

    /**
     * 空间DBSCAN聚类
     *
     * @param radius 半径参数
     * @param minPts 领域密度阈值
     */
    private final double radius;
    private final int minPts;

    public DBSCAN(double radius, int minPts) {
        this.radius = radius;
        this.minPts = minPts;
    }

    /**
     * 计算两个经纬度点之间的距离
     * @param pointA 起点
     * @param pointB 终点
     * @return 点距
     */
    private Double getDistance(ClusterPoint pointA, ClusterPoint pointB) {
        GeodeticCalculator geodeticCalculator = new GeodeticCalculator(DefaultGeographicCRS.WGS84);

        geodeticCalculator.setStartingGeographicPoint(pointA.getLng(), pointA.getLat());
        geodeticCalculator.setDestinationGeographicPoint(pointB.getLng(), pointB.getLat());

        return geodeticCalculator.getOrthodromicDistance();

    }

    /**
     * 计算中心点与其余点之间的距离，并返回满足半径参数条件下的点
     * @param centerPoint 中心点
     * @param points      其余点
     * @return            满足条件点
     */
    private ArrayList<ClusterPoint> getAdjacentPoints(
        ClusterPoint centerPoint,
        ArrayList<ClusterPoint> points
    ) {

        ArrayList<ClusterPoint> adjacentPoints = new ArrayList<>();

        for (ClusterPoint point : points) {
            Double distance = getDistance(centerPoint, point);

            if (distance <= this.radius) {
                adjacentPoints.add(point);
            }
        }

        return adjacentPoints;
    }

    /**
     * DBSCAN空间聚类
     * @param points 所有点
     * @return 聚类结果
     */
    public ArrayList<ClusterPoint> process(ArrayList<ClusterPoint> points) {
        int size = points.size();
        int idx = 0;
        int cluster = 1;

        while (idx < size) {
            System.out.println("Doing " + idx);
            ClusterPoint point = points.get(idx++);

            if (!point.isVisited()) {
                point.setVisited(true);
                ArrayList<ClusterPoint> adjacentPoints = getAdjacentPoints(point, points);

                if (adjacentPoints != null && adjacentPoints.size() < this.minPts) {
                    point.setNoised(true);
                } else {
                    point.setCluster(cluster);
                    for (int i = 0; i < adjacentPoints.size(); i++) {
                        ClusterPoint adjacentPoint = adjacentPoints.get(i);

                        if (!adjacentPoint.isVisited()) {
                            adjacentPoint.setVisited(true);
                            ArrayList<ClusterPoint> adjacentPoints2 = getAdjacentPoints(
                                adjacentPoint,
                                points
                            );

                            if (adjacentPoints2 != null && adjacentPoints2.size() >= minPts) {

                                for (ClusterPoint pp : adjacentPoints2) {
                                    if (!adjacentPoints.contains(pp)) {
                                        adjacentPoints.add(pp);
                                    }
                                }
                            }
                        }

                        if (adjacentPoint.getCluster() == 0) {
                            adjacentPoint.setCluster(cluster);

                            if (adjacentPoint.isNoised()) {
                                adjacentPoint.setNoised(false);
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

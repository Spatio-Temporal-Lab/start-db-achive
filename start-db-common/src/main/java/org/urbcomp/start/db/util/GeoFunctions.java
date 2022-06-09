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

package org.urbcomp.start.db.util;

import org.locationtech.jts.geom.Envelope;
import org.urbcomp.start.db.model.point.ProjectionPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import scala.Tuple2;

import java.util.List;

public class GeoFunctions {

    /**
     * 地球长半径
     */
    private static final double EARTH_RADIUS_IN_METER = 6378137.0;

    /**
     * 将球面距离转化为度（在地理坐标系下做缓冲区时使用）
     *
     * @param distance 距离，单位m
     * @return 弧度
     */
    public static double getDegreeFromM(double distance) {
        double perimeter = 2 * Math.PI * EARTH_RADIUS_IN_METER;
        double degreePerM = 360 / perimeter;
        return distance * degreePerM;
    }

    /**
     * @param point     point
     * @param thresholdInMeter MBR扩展的宽度（M）
     * @return 扩展后的MBR
     */
    public static Envelope getExtendedBBox(SpatialPoint point, double thresholdInMeter) {
        double perimeter = 2 * Math.PI * EARTH_RADIUS_IN_METER;
        double latPerMeter = 360 / perimeter;
        double latBuffLen = thresholdInMeter * latPerMeter;
        double minLngPerMeter = 360 / (perimeter * Math.cos(Math.toRadians(point.getY())));
        double lngBuffLen = thresholdInMeter * minLngPerMeter;
        return new Envelope(point.getX() - lngBuffLen,
            point.getX() + lngBuffLen,
            point.getY() - latBuffLen,
            point.getY() + latBuffLen);
    }

    /**
     * 计算两经纬度间距离
     *
     * @param lng1 经度1
     * @param lat1 纬度1
     * @param lng2 经度2
     * @param lat2 纬度2
     * @return meter，有误差
     */
    public static double getDistanceInM(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);
        double radLatDistance = radLat1 - radLat2;
        double radLngDistance = Math.toRadians(lng1) - Math.toRadians(lng2);
        return 2 * Math.asin(
            Math.sqrt(
                Math.pow(Math.sin(radLatDistance / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
                    * Math.pow(Math.sin(radLngDistance / 2), 2)
            )
        ) * EARTH_RADIUS_IN_METER;
    }

    public static double getDistanceInM(SpatialPoint point1, SpatialPoint point2) {
        return getDistanceInM(point1.getLng(), point1.getLat(), point2.getLng(), point2.getLat());
    }

    public static double getDistanceInM(List<SpatialPoint> points) {
        double distance = 0;
        for(int i = 1; i < points.size(); i++){
            distance += GeoFunctions.getDistanceInM(points.get(i - 1), points.get(i));
        }
        return distance;
    }

    /**
     * 二分法快速查找映射点
     *
     * @param pt     原始点
     * @param points 映射路段的point list
     * @param start  起始index
     * @param end    结束index
     * @return 投影点, 投影点对应的point list 的index
     */
    public static Tuple2<ProjectionPoint, Integer> calProjection(SpatialPoint pt, List<SpatialPoint> points, int start, int end) {
        if (end - start == 1) {
            return new Tuple2<>(projectPtToSegment(points.get(start), points.get(end), pt), start);
        }
        int mid = (start + end) / 2;
        ProjectionPoint projectionPoint = projectPtToSegment(points.get(start), points.get(mid), pt);
        double rate = projectionPoint.getRate();
        if (rate > 1.0) {
            start = mid;
        } else {
            end = mid;
        }
        return calProjection(pt, points, start, end);
    }

    /**
     * 将点投影到线， 如果点在 ab组成这个线段的左边， 投影为a， 如果在右边，投影为b， 如果在中间，按照rate求出对应投影点的经纬度
     *
     * @param startPt 点 一个rs上的起始点
     * @param endPt   点 一个rs上的终点
     * @param pt      待投影的点
     * @return 投影到segment上的点
     */
    public static ProjectionPoint projectPtToSegment(SpatialPoint startPt, SpatialPoint endPt, SpatialPoint pt) {
        double abAngle = bearing(startPt, endPt);
        double atAngle = bearing(startPt, pt);
        double abLength = getDistanceInM(startPt, endPt);
        double atLength = getDistanceInM(startPt, pt);
        double deltaAngle = atAngle - abAngle;
        double metersAlong = atLength * Math.cos(Math.toRadians(deltaAngle));
        double rate;
        SpatialPoint projection;
        if (abLength == 0.0) {
            rate = 0.0;
        } else {
            rate = metersAlong / abLength;
        }
        if (rate > 1.0) {
            projection = new SpatialPoint(endPt.getLng(), endPt.getLat());
        } else if (rate < 0) {
            projection = new SpatialPoint(startPt.getLng(), startPt.getLat());
        } else {
            projection = calLocAlongLine(startPt, endPt, rate);
        }
        double dist = getDistanceInM(pt, projection);
        return new ProjectionPoint(projection, dist, rate);
    }

    /**
     * 计算两个点之间的倾斜角度
     *
     * @param startPt 点
     * @param endPt   点
     * @return 倾斜角度
     */
    private static double bearing(SpatialPoint startPt, SpatialPoint endPt) {
        double ptALatRad = Math.toRadians(startPt.getLat());
        double ptALngRad = Math.toRadians(startPt.getLng());
        double ptBLatRad = Math.toRadians(endPt.getLat());
        double ptBLngRad = Math.toRadians(endPt.getLng());
        double y = Math.sin(ptBLngRad - ptALngRad) * Math.cos(ptBLatRad);
        double x = Math.cos(ptALatRad) * Math.sin(ptBLatRad) - Math.sin(ptALatRad) * Math.cos(ptBLatRad) * Math.cos(ptBLngRad - ptALngRad);
        double bearingRad = Math.atan2(y, x);
        return (Math.toDegrees(bearingRad) + 360.0) % 360.0;
    }

    /**
     * 根据rate 求出投影点的经纬度
     *
     * @param startPt 起始点
     * @param endPt   终点
     * @param rate    a到投影点距离 / ab距离
     * @return 投影点
     */
    private static SpatialPoint calLocAlongLine(SpatialPoint startPt, SpatialPoint endPt, double rate) {
        double lat = startPt.getLat() + rate * (endPt.getLat() - startPt.getLat());
        double lng = startPt.getLng() + rate * (endPt.getLng() - startPt.getLng());
        return new SpatialPoint(lng, lat);
    }
}

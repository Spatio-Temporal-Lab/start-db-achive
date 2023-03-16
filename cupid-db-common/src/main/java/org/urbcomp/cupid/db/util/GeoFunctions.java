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
package org.urbcomp.cupid.db.util;

import org.locationtech.jts.geom.*;
import org.urbcomp.cupid.db.model.point.SpatialPoint;

import java.util.ArrayList;
import java.util.List;

public class GeoFunctions {

    /**
     * 地球长半径
     */
    public static final double EARTH_RADIUS_IN_METER = 6378137.0;

    /**
     * 扁率
     */
    public static final double FLATTENING = 0.00669342162296594323;

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
     * @param point            point
     * @param thresholdInMeter MBR扩展的宽度（M）
     * @return 扩展后的MBR
     */
    public static Envelope getExtendedBBox(SpatialPoint point, double thresholdInMeter) {
        double perimeter = 2 * Math.PI * EARTH_RADIUS_IN_METER;
        double latPerMeter = 360 / perimeter;
        double latBuffLen = thresholdInMeter * latPerMeter;
        double minLngPerMeter = 360 / (perimeter * Math.cos(Math.toRadians(point.getY())));
        double lngBuffLen = thresholdInMeter * minLngPerMeter;
        return new Envelope(
            point.getX() - lngBuffLen,
            point.getX() + lngBuffLen,
            point.getY() - latBuffLen,
            point.getY() + latBuffLen
        );
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
        for (int i = 1; i < points.size(); i++) {
            distance += GeoFunctions.getDistanceInM(points.get(i - 1), points.get(i));
        }
        return distance;
    }

    public static Envelope getBBox(List<SpatialPoint> points) {
        double minLng = Double.MAX_VALUE;
        double minLat = Double.MAX_VALUE;
        double maxLng = Double.MIN_VALUE;
        double maxLat = Double.MIN_VALUE;
        for (SpatialPoint point : points) {
            minLng = Math.min(minLng, point.getLng());
            minLat = Math.min(minLat, point.getLat());
            maxLng = Math.max(maxLng, point.getLng());
            maxLat = Math.max(maxLat, point.getLat());
        }
        return new Envelope(minLng, maxLng, minLat, maxLat);
    }

    public static Polygon bboxFromEnvelopeToPolygon(Envelope e) {
        GeometryFactory geometryFactory = GeometryFactoryUtils.defaultGeometryFactory();
        double minX = e.getMinX();
        double maxX = e.getMaxX();
        double minY = e.getMinY();
        double maxY = e.getMaxY();
        List<Point> points = new ArrayList<>(5);
        points.add(geometryFactory.createPoint(new Coordinate(minX, minY)));
        points.add(geometryFactory.createPoint(new Coordinate(maxX, minY)));
        points.add(geometryFactory.createPoint(new Coordinate(maxX, maxY)));
        points.add(geometryFactory.createPoint(new Coordinate(minX, maxY)));
        points.add(geometryFactory.createPoint(new Coordinate(minX, minY)));
        return geometryFactory.createPolygon(
            geometryFactory.createLinearRing(
                geometryFactory.createLineString(
                    points.stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
                ).getCoordinateSequence()
            )
        );
    }
}

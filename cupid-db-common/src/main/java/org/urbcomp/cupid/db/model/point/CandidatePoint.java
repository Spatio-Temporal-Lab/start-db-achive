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
package org.urbcomp.cupid.db.model.point;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandidatePoint extends SpatialPoint {
    /**
     * matched road segment id
     */
    private final int roadSegmentId;
    /**
     * the distance from the start point of the matched road segment, meter
     */
    private final double offsetInMeter;

    /**
     * the matched position index in the road segment geo
     */
    private final int matchedIndex;

    /**
     * the distance between the matched point and the gps point
     */
    private final double errorDistanceInMeter;

    public int getRoadSegmentId() {
        return roadSegmentId;
    }

    public double getOffsetInMeter() {
        return offsetInMeter;
    }

    public int getMatchedIndex() {
        return matchedIndex;
    }

    public double getErrorDistanceInMeter() {
        return errorDistanceInMeter;
    }

    public CandidatePoint(
        SpatialPoint matchedPoint,
        RoadSegment roadSegment,
        int matchedIndex,
        double errorDistanceInMeter
    ) {
        super(matchedPoint.getLng(), matchedPoint.getLat());
        this.roadSegmentId = roadSegment.getRoadSegmentId();
        this.matchedIndex = matchedIndex;
        this.errorDistanceInMeter = errorDistanceInMeter;
        this.offsetInMeter = calOffsetInMeter(roadSegment, matchedIndex);
    }

    private double calOffsetInMeter(RoadSegment roadSegment, int matchedIndex) {
        double offset = 0;

        // 路段开始到matchedIndex点的距离
        List<SpatialPoint> points = roadSegment.getPoints();
        for (int i = 0; i < matchedIndex; i++) {
            offset += GeoFunctions.getDistanceInM(points.get(i), points.get(i + 1));
        }

        // matched point到matchedIndex的距离
        offset += GeoFunctions.getDistanceInM(
            new SpatialPoint(roadSegment.getPoints().get(matchedIndex).getCoordinate()),
            this
        );

        return offset;
    }

    @Override
    public String toString() {
        return this.roadSegmentId
            + "|"
            + this.offsetInMeter
            + "|"
            + this.matchedIndex
            + "|"
            + this.errorDistanceInMeter;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatePoint other = (CandidatePoint) o;
        return this.roadSegmentId == other.getRoadSegmentId()
            && offsetInMeter == other.offsetInMeter
            && matchedIndex == other.matchedIndex
            && errorDistanceInMeter == other.errorDistanceInMeter
            && super.equals(other);
    }

    @Override
    public boolean equals(Geometry g) {
        if (this == g) return true;
        if (g == null || getClass() != g.getClass()) return false;
        CandidatePoint other = (CandidatePoint) g;
        return Math.abs(roadSegmentId) == Math.abs(other.getRoadSegmentId())
            && errorDistanceInMeter == errorDistanceInMeter
            && super.equals(g);
    }

    /**
     * 找到离原始点最近的candidate point
     *
     * @param pt          原始点
     * @param roadNetwork 路网索引
     * @param dist        搜索距离
     * @return candidate point
     */
    public static CandidatePoint getNearestCandidatePoint(
        SpatialPoint pt,
        RoadNetwork roadNetwork,
        double dist
    ) {
        List<CandidatePoint> candidates = getCandidatePoint(pt, roadNetwork, dist);
        if (candidates.size() != 0) {
            return Collections.min(
                candidates,
                Comparator.comparingDouble(CandidatePoint::getErrorDistanceInMeter)
            );
        } else {
            return null;
        }
    }

    /**
     * 给定一个点 和一个搜索距离 返回range query的roadSegment
     *
     * @param pt          点
     * @param roadNetwork 路网索引
     * @param dist        搜索的距离
     * @return 这个点在搜索范围内，所有可能对应的 candidate points
     */
    public static List<CandidatePoint> getCandidatePoint(
        SpatialPoint pt,
        RoadNetwork roadNetwork,
        double dist
    ) {
        Envelope bbox = GeoFunctions.getExtendedBBox(pt, dist);
        Rectangle rec = Geometries.rectangleGeographic(
            bbox.getMinX(),
            bbox.getMinY(),
            bbox.getMaxX(),
            bbox.getMaxY()
        );
        Iterable<RoadSegment> roadSegmentIterable = roadNetwork.getRoadRTree()
            .search(rec)
            .map(Entry::value)
            .toBlocking()
            .toIterable();
        List<CandidatePoint> result = new ArrayList<>();
        roadSegmentIterable.forEach(rs -> {
            CandidatePoint candiPt = calCandidatePoint(pt, rs);
            if (candiPt.errorDistanceInMeter <= dist) {
                result.add(candiPt);
            }
        });
        return result;
    }

    /**
     * 给一个点，路网，加上对应的roadSegment，找出candidate point
     *
     * @param rawPoint 原始点
     * @param rs       路段
     * @return 对应在该路段上的candidate point
     */
    private static CandidatePoint calCandidatePoint(SpatialPoint rawPoint, RoadSegment rs) {
        List<SpatialPoint> points = rs.getPoints();
        ProjectionPoint projectionPoint = ProjectionPoint.calProjection(
            rawPoint,
            points,
            0,
            points.size() - 1
        );
        return new CandidatePoint(
            projectionPoint,
            rs,
            projectionPoint.getMatchedIndex(),
            projectionPoint.getErrorDistanceInMeter()
        );
    }

    static class ProjectionPoint extends SpatialPoint {
        /**
         * 误差距离，单位为m
         */
        private final double errorDistanceInMeter;
        /**
         * 投影的斜率
         */
        private final double rate;

        private final int matchedIndex;

        /**
         * 构造函数
         *
         * @param point         映射点
         * @param errorDistance 匹配误差
         * @param rate          斜率
         */
        public ProjectionPoint(
            SpatialPoint point,
            double errorDistance,
            double rate,
            int matchedIndex
        ) {
            super(point.getLng(), point.getLat());
            this.errorDistanceInMeter = errorDistance;
            this.rate = rate;
            this.matchedIndex = matchedIndex;
        }

        public double getErrorDistanceInMeter() {
            return errorDistanceInMeter;
        }

        public double getRate() {
            return rate;
        }

        public int getMatchedIndex() {
            return matchedIndex;
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
        private static ProjectionPoint calProjection(
            SpatialPoint pt,
            List<SpatialPoint> points,
            int start,
            int end
        ) {
            if (end - start == 1) {
                return projectPtToSegment(points.get(start), points.get(end), pt, start);
            }
            int mid = (start + end) / 2;
            ProjectionPoint projectionPoint = projectPtToSegment(
                points.get(start),
                points.get(mid),
                pt,
                -1 // this value is not used
            );
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
        private static ProjectionPoint projectPtToSegment(
            SpatialPoint startPt,
            SpatialPoint endPt,
            SpatialPoint pt,
            int matchedIndex
        ) {
            double abAngle = bearing(startPt, endPt);
            double atAngle = bearing(startPt, pt);
            double abLength = GeoFunctions.getDistanceInM(startPt, endPt);
            double atLength = GeoFunctions.getDistanceInM(startPt, pt);
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
            double dist = GeoFunctions.getDistanceInM(pt, projection);
            return new ProjectionPoint(projection, dist, rate, matchedIndex);
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
            double x = Math.cos(ptALatRad) * Math.sin(ptBLatRad) - Math.sin(ptALatRad) * Math.cos(
                ptBLatRad
            ) * Math.cos(ptBLngRad - ptALngRad);
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
        private static SpatialPoint calLocAlongLine(
            SpatialPoint startPt,
            SpatialPoint endPt,
            double rate
        ) {
            double lat = startPt.getLat() + rate * (endPt.getLat() - startPt.getLat());
            double lng = startPt.getLng() + rate * (endPt.getLng() - startPt.getLng());
            return new SpatialPoint(lng, lat);
        }
    }
}

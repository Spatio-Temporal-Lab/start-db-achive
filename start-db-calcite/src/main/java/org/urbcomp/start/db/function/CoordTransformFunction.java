package org.urbcomp.start.db.function;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.trajectory.Trajectory;
import org.urbcomp.start.db.util.CoordTransformUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordTransformFunction {

    @StartDBFunction("st_BD09ToWGS84")
    public Point st_BD09ToWGS84(Point point) {
        GeometryFactory geometryFactory = new GeometryFactory();
        double[] WGSLngLat = CoordTransformUtils.bd09Towgs84(point.getX(), point.getY());
        return (geometryFactory.createPoint(new Coordinate(WGSLngLat[0], WGSLngLat[1])));
    }

    @StartDBFunction("st_BD09ToWGS84")
    public LineString st_BD09ToWGS84(LineString lineString) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] coordinates = lineString.getCoordinates();
        Coordinate[] res = new Coordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            double[] WGSLngLat = CoordTransformUtils.bd09Towgs84(
                coordinates[i].getX(),
                coordinates[i].getY()
            );
            res[i] = new Coordinate(WGSLngLat[0], WGSLngLat[1]);
        }
        return (geometryFactory.createLineString(res));
    }

    @StartDBFunction("st_BD09ToWGS84")
    public Polygon st_BD09ToWGS84(Polygon polygon) {
        GeometryFactory geometryFactory = new GeometryFactory();
        LinearRing shell = geometryFactory.createLinearRing(
            st_BD09ToWGS84(polygon.getExteriorRing()).getCoordinateSequence()
        );

        LinearRing[] holes = new LinearRing[polygon.getNumInteriorRing()];
        for (int i = 0; i < polygon.getNumInteriorRing(); i++) {
            LinearRing linearRing = polygon.getInteriorRingN(i);
            LineString lineString = st_BD09ToWGS84(linearRing);
            holes[i] = geometryFactory.createLinearRing(lineString.getCoordinateSequence());
        }
        return geometryFactory.createPolygon(shell, holes);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public MultiPolygon st_BD09ToWGS84(MultiPolygon mPolygon) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Polygon[] polygons = new Polygon[mPolygon.getNumGeometries()];
        for (int i = 0; i < mPolygon.getNumGeometries(); i++) {
            Polygon polygon = (Polygon) mPolygon.getGeometryN(i);
            polygons[i] = st_BD09ToWGS84(polygon);
        }
        return geometryFactory.createMultiPolygon(polygons);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public Trajectory st_BD09ToWGS84(Trajectory trajectory) {
        List<GPSPoint> wgs84Points = trajectory.getGPSPointList().stream().map(o -> {
            double[] coords = CoordTransformUtils.bd09Towgs84(o.getLng(), o.getLat());
            return new GPSPoint(o.getTime(), coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new Trajectory(trajectory.getTid(), trajectory.getOid(), wgs84Points);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public RoadSegment st_BD09ToWGS84(RoadSegment rs) {
        List<SpatialPoint> wgs84Points = rs.getPoints().stream().map(o -> {
            double[] coords = CoordTransformUtils.bd09Towgs84(o.getLng(), o.getLat());
            return new SpatialPoint(coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new RoadSegment(
            rs.getRoadSegmentId(),
            rs.getStartNode().getNodeId(),
            rs.getEndNode().getNodeId(),
            wgs84Points
        );
    }

}

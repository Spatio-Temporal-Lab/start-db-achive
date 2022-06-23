package org.urbcomp.start.db.function.coordtransform;

import org.locationtech.jts.geom.*;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.trajectory.Trajectory;
import org.urbcomp.start.db.util.GeometryFactoryUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCoordTransformer {
    public Point pointTransform(Point point) {
        GeometryFactory geometryFactory = GeometryFactoryUtils.defaultGeometryFactory();
        double[] WGSLngLat = transform(point.getX(), point.getY());
        return geometryFactory.createPoint(new Coordinate(WGSLngLat[0], WGSLngLat[1]));
    }

    public LineString lineStringTransform(LineString lineString) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] coordinates = lineString.getCoordinates();
        Coordinate[] res = new Coordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            double[] WGSLngLat = transform(coordinates[i].getX(), coordinates[i].getY());
            res[i] = new Coordinate(WGSLngLat[0], WGSLngLat[1]);
        }
        return geometryFactory.createLineString(res);
    }

    public Polygon polygonTransform(Polygon polygon) {
        GeometryFactory geometryFactory = new GeometryFactory();
        LinearRing shell = geometryFactory.createLinearRing(
            lineStringTransform(polygon.getExteriorRing()).getCoordinateSequence()
        );

        LinearRing[] holes = new LinearRing[polygon.getNumInteriorRing()];
        for (int i = 0; i < polygon.getNumInteriorRing(); i++) {
            LinearRing linearRing = polygon.getInteriorRingN(i);
            LineString lineString = lineStringTransform(linearRing);
            holes[i] = geometryFactory.createLinearRing(lineString.getCoordinateSequence());
        }
        return geometryFactory.createPolygon(shell, holes);
    }

    public MultiPolygon multiPolygonTransform(MultiPolygon mPolygon) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Polygon[] polygons = new Polygon[mPolygon.getNumGeometries()];
        for (int i = 0; i < mPolygon.getNumGeometries(); i++) {
            Polygon polygon = (Polygon) mPolygon.getGeometryN(i);
            polygons[i] = polygonTransform(polygon);
        }
        return geometryFactory.createMultiPolygon(polygons);
    }

    public Trajectory trajectoryTransform(Trajectory trajectory) {
        List<GPSPoint> points = trajectory.getGPSPointList().stream().map(o -> {
            double[] coords = transform(o.getLng(), o.getLat());
            return new GPSPoint(o.getTime(), coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new Trajectory(trajectory.getTid(), trajectory.getOid(), points);
    }

    public RoadSegment roadSegmentTransform(RoadSegment rs) {
        List<SpatialPoint> points = rs.getPoints().stream().map(o -> {
            double[] coords = transform(o.getLng(), o.getLat());
            return new SpatialPoint(coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new RoadSegment(
            rs.getRoadSegmentId(),
            rs.getStartNode().getNodeId(),
            rs.getEndNode().getNodeId(),
            points
        );
    }

    protected abstract double[] transform(double lng, double lat);
}

package org.urbcomp.start.db.algorithm.shortestpath;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.urbcomp.start.db.exception.AlgorithmExecuteException;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.Path;
import org.urbcomp.start.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.start.db.model.sample.ModelGenerator;
import org.urbcomp.start.db.util.WKTUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BiDijkstraShortestPathTest {

    private static BiDijkstraShortestPath algo;

    @Before
    public void setUp() {
        RoadNetwork roadNetwork = ModelGenerator.generateRoadNetwork();
        algo = new BiDijkstraShortestPath(roadNetwork);
    }

    @Test
    public void findShortestPathWithSameStartAndEndPoint() throws AlgorithmExecuteException {
        SpatialPoint startPoint = new SpatialPoint(108.88,34.16);
        Path path = algo.findShortestPath(startPoint, startPoint);
        List<SpatialPoint> points = path.getPoints();
        assertEquals(points.size(), 2);
        assertEquals(points.get(0), points.get(1));
    }

    @Test
    public void findShortestPathNormal() throws AlgorithmExecuteException, JsonProcessingException {
        SpatialPoint startPoint = new SpatialPoint(108.869833,34.175913);
        SpatialPoint endPoint = new SpatialPoint(108.880433,34.172418);
        Path path = algo.findShortestPath(startPoint, endPoint);
        System.out.println(path.toGeoJSON());
        LineString lineString = new LineString(path.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new), new PrecisionModel(), 4326);
        System.out.println(WKTUtils.write(lineString));
    }
}
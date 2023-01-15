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

package org.urbcomp.start.db.algorithm.mapmatch.tihmm;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.urbcomp.start.db.algorithm.mapmatch.routerecover.ShortestPathPathRecover;
import org.urbcomp.start.db.algorithm.shortestpath.BiDijkstraShortestPath;
import org.urbcomp.start.db.exception.AlgorithmExecuteException;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.start.db.model.sample.ModelGenerator;
import org.urbcomp.start.db.model.trajectory.MapMatchedTrajectory;
import org.urbcomp.start.db.model.trajectory.PathOfTrajectory;
import org.urbcomp.start.db.model.trajectory.Trajectory;
import org.urbcomp.start.db.util.CoordTransformUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TiHmmMapMatcherTest {

    private Trajectory trajectory;
    private TiHmmMapMatcher mapMatcher;
    private ShortestPathPathRecover recover;

    @Before
    public void setUp() {
        trajectory = ModelGenerator.generateTrajectory();
        RoadNetwork roadNetwork = ModelGenerator.generateRoadNetwork();
        mapMatcher = new TiHmmMapMatcher(roadNetwork, new BiDijkstraShortestPath(roadNetwork));
        recover = new ShortestPathPathRecover(roadNetwork, new BiDijkstraShortestPath(roadNetwork));
    }

    @Test
    public void matchTrajToMapMatchedTraj() throws AlgorithmExecuteException,
        JsonProcessingException {
        MapMatchedTrajectory mmTrajectory = mapMatcher.mapMatch(trajectory);
        assertEquals(trajectory.getGPSPointList().size(), mmTrajectory.getMmPtList().size());
        List<PathOfTrajectory> pTrajectories = recover.recover(mmTrajectory);

        System.out.println("原始轨迹\n" + TransformCoordsToWGS84(trajectory).toGeoJSON());
        System.out.println("匹配后的轨迹\n" + mmTrajectory.toGeoJSON());
        System.out.println("连接后的轨迹");
        for (PathOfTrajectory pt : pTrajectories) {
            System.out.println(TransformCoordsToWGS84(pt).toGeoJSON());
        }
    }

    private Trajectory TransformCoordsToWGS84(Trajectory traj) {
        List<GPSPoint> wgs84Points = traj.getGPSPointList().stream().map(o -> {
            double[] coords = CoordTransformUtils.gcj02Towgs84(o.getLng(), o.getLat());
            return new GPSPoint(o.getTime(), coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new Trajectory(traj.getTid(), traj.getOid(), wgs84Points);
    }

    private PathOfTrajectory TransformCoordsToWGS84(PathOfTrajectory traj) {
        List<SpatialPoint> wgs84Points = traj.getPoints().stream().map(o -> {
            double[] coords = CoordTransformUtils.gcj02Towgs84(o.getLng(), o.getLat());
            return new SpatialPoint(coords[0], coords[1]);
        }).collect(Collectors.toList());
        return new PathOfTrajectory(
            traj.getTid(),
            traj.getOid(),
            wgs84Points,
            traj.getRoadSegmentIds()
        );
    }
}

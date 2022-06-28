package org.urbcomp.start.db.model.sample;

import com.alibaba.fastjson.JSON;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.model.point.SpatialPoint;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.trajectory.Trajectory;
import org.urbcomp.start.db.util.CoordTransformUtils;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SigspatialDemoDataGenerator {
    public static void main(String[] args) {
        generateTrajectory();
    }

    public static void generateRoadSegment(){
        String inFileName = "C:\\Users\\Leo\\Desktop\\roadgcj.sql";
        File inFile = new File(inFileName);
        List<RoadSegment> roadSegments = new ArrayList<>();
        try (
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr)
        ) {
            String rsStr;
            while ((rsStr = br.readLine()) != null) {
                String correctStr = rsStr.substring(rsStr.indexOf("{\"type\":\"Feature\""), rsStr.length() - 4);
                RoadSegment rs = RoadSegment.fromGeoJSON(correctStr);
                List<SpatialPoint> points = rs.getPoints().stream().map(o -> {
                    double[] lngLat = CoordTransformUtils.gcj02Towgs84(o.getLng(), o.getLat());
                    return new SpatialPoint(lngLat[0], lngLat[1]);
                }).collect(Collectors.toList());
                rs.setPoints(points);
                // 路段至少一个点在给定范围里面
                if (points.stream().anyMatch(SigspatialDemoDataGenerator::isInMBR)) {
                    roadSegments.add(rs);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("generateRoadSegment: " + e.getMessage());
        }

        String outFileName = "C:\\Users\\Leo\\Desktop\\road.sql";
        File outFile = new File(outFileName);
        try (
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ){
            roadSegments.forEach(o-> {
                try {
                    bw.write("insert into road (rsid, rs) values (" + o.getRoadSegmentId() + ", st_rs_fromGeoJSON('" + o.toGeoJSON() + "'));\r\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateTrajectory() {
        String inFileName = "C:\\Users\\Leo\\Desktop\\clean_traj .txt";
        File inFile = new File(inFileName);
        List<Trajectory> trajectories = new ArrayList<>();
        try (
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr)
        ) {
            String trajStr;
            while ((trajStr = br.readLine()) != null) {
                String correctStr = trajStr.replaceFirst("\\[", "[\"").replaceFirst(",", "\",");
                List<String> result = JSON.parseArray(correctStr, String.class);
                String oid = result.get(0);
                List<String> pointsStrList = JSON.parseArray(result.get(1), String.class);
                List<GPSPoint> pointsList = pointsStrList.stream()
                    .map(o -> JSON.parseArray(o, String.class))
                    .map(
                        o -> {
                            double[] lngLat = CoordTransformUtils.gcj02Towgs84(Double.parseDouble(o.get(1)), Double.parseDouble(o.get(2)));
                            return new GPSPoint(Timestamp.valueOf(o.get(0)), lngLat[0], lngLat[1]);
                        }
                    )
                    .collect(Collectors.toList());
                // 轨迹所有点都在给定范围里面
                if (pointsList.stream().allMatch(SigspatialDemoDataGenerator::isInMBR)) {
                    trajectories.add(new Trajectory(oid + pointsList.get(0).getTime(), oid, pointsList));
                    if (trajectories.size() >= 100) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("generateTrajectory: " + e.getMessage());
        }

        String outFileName = "C:\\Users\\Leo\\Desktop\\diditraj.sql";
        File outFile = new File(outFileName);
        try (
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ){
            trajectories.forEach(o-> {
                try {
                    bw.write("insert into diditraj (tid, traj) values ('" + o.getTid() + "', st_traj_fromGeoJSON('" + o.toGeoJSON() + "'));\r\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isInMBR(SpatialPoint point) {
        double minLng = 108.94901275634764;
        double maxLng = 109.01046752929688;
        double minLat = 34.20030278238033;
        double maxLat = 34.24586516842103;
        return point.getLng() >= minLng && point.getLng() <= maxLng && point.getLat() >= minLat && point.getLat() <= maxLat;
    }
}

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

package org.urbcomp.start.db.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.urbcomp.start.db.util.FeatureCollectionWithProperties;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Trajectory {
    private String tid;
    private String oid;
    private List<GPSPoint> gpsPointList;

    /**
     * Constructor of Trajectory class
     * @param tid the id of Trajectory, should be unique in a trajectory database
     * @param oid the object id of a trajectory, such as plate number
     * @param gpsPointList the gps point list of the trajectory
     */
    public Trajectory(String tid, String oid, List<GPSPoint> gpsPointList) {
        this.tid = tid;
        this.oid = oid;
        this.gpsPointList = gpsPointList;
    }

    /**
     * the constructor of Trajectory class. The time list and point list will be initialized empty
     * @param tid the id of Trajectory, should be unique in a trajectory database
     * @param oid the object id of a trajectory, such as plate number
     */
    public Trajectory(String tid, String oid) {
        this(tid, oid, new ArrayList<>());
    }

    /**
     * get trajectory id
     * @return trajectory id
     */
    public String getTid() {
        return tid;
    }

    /**
     * set trajectory id
     * @param tid trajectory id
     * @return this object
     */
    public Trajectory setTid(String tid) {
        this.tid = tid;
        return this;
    }

    /**
     * get object id
     * @return object id
     */
    public String getOid() {
        return oid;
    }

    /**
     * set object id
     * @param oid object id
     * @return this object
     */
    public Trajectory setOid(String oid) {
        this.oid = oid;
        return this;
    }

    /**
     * get point list
     * @return point list of GPS point
     */
    public List<GPSPoint> getGPSPointList() {
        return gpsPointList;
    }

    /**
     * set point list
     * @param gpsPointList GPSPoint list of trajectory
     * @return this object
     */
    public Trajectory setPointList(List<GPSPoint> gpsPointList) {
        this.gpsPointList = gpsPointList;
        return this;
    }

    /**
     * add a GPSPoint to the trajectory
     * @param gpsPoint the GPSPoint to be added
     * @return this object
     */
    public Trajectory addGPSPoint(GPSPoint gpsPoint) {
        this.gpsPointList.add(gpsPoint);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!Objects.equals(this.oid, ((Trajectory) o).oid)
            || !Objects.equals(this.tid, ((Trajectory) o).tid)) {
            return false;
        }
        return this.gpsPointList.equals(((Trajectory) o).gpsPointList);
    }

    /**
     * Convert this trajectory to GeoJSON String
     * @return GeoJSON String
     */
    public String toGeoJSON() throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new FeatureCollectionWithProperties();
        fcp.setProperty("oid", oid);
        fcp.setProperty("tid", tid);
        for (GPSPoint gp : gpsPointList) {
            Feature f = new Feature();
            f.setProperty("time", gp.getTime().toString());
            f.setGeometry(new org.geojson.Point(gp.getPoint().getX(), gp.getPoint().getY()));
            fcp.add(f);
        }
        return new ObjectMapper().writeValueAsString(fcp);
    }

    public static Trajectory fromGeoJSON(String geoJsonStr) throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new ObjectMapper().readValue(
            geoJsonStr,
            FeatureCollectionWithProperties.class
        );
        Trajectory traj = new Trajectory(fcp.getProperty("tid"), fcp.getProperty("oid"));
        GeometryFactory gf = new GeometryFactory();
        for (Feature f : fcp.getFeatures()) {
            LngLatAlt lngLatAlt = ((org.geojson.Point) f.getGeometry()).getCoordinates();
            Point p = gf.createPoint(
                new Coordinate(lngLatAlt.getLongitude(), lngLatAlt.getLatitude())
            );
            traj.addGPSPoint(new GPSPoint(Timestamp.valueOf((String) f.getProperty("time")), p));
        }
        return traj;
    }

//    public Trajectory st_traj_makeTrajectory(String oid, String tid, List[Datetime]) {
//
//
//
//    }

    public  String st_traj_asGeoJSON(Trajectory traj) throws JsonProcessingException {
        return traj.toGeoJSON();
    }

//    public Trajectory st_traj_fromGeoJSON(String str) {
//
//
//
//
//    }

    public String st_traj_oid(Trajectory traj) {
        return traj.getOid();
    }

    public String st_traj_tid(Trajectory traj) {
        return traj.getTid();
    }

    public Date st_traj_startTime(Trajectory traj) {
        return traj.getGPSPointList().get(0).getTime();
    }

    public Date st_traj_endTime(Trajectory traj) {
        return traj.getGPSPointList().get(gpsPointList.size() - 1).getTime();
    }

    public Point st_traj_startPoint(Trajectory traj) { return traj.getGPSPointList().get(0).getPoint(); }

   public Point st_traj_endPoint(Trajectory traj) {return traj.getGPSPointList().get(gpsPointList.size() - 1).getPoint();}

    public Integer st_traj_numOfPoints(Trajectory tarj) {
        return tarj.getGPSPointList().size();
    }

    public Point st_traj_pointN(Trajectory traj, Integer n) {
        return traj.getGPSPointList().get(n - 1).getPoint();
    }

    public Date Dst_traj_timeN(Trajectory traj, Integer n) {
        return traj.getGPSPointList().get(gpsPointList.size() - 1).getTime();
    }

    public Double st_traj_lengthInKM(Trajectory traj) {
        final double EARTH_RADIUS_IN_METER = 6378137.0;
        double all = 0;
        for (int i = 0; i < gpsPointList.size() - 1; i++){
            for (int j = 1; j < gpsPointList.size(); j++){
                double radLat1 = Math.toRadians(traj.getGPSPointList().get(j).getPoint().getY());
                double radLat2 = Math.toRadians(traj.getGPSPointList().get(i).getPoint().getY());
                double radLatDistance = radLat1 - radLat2;
                double radLngDistance = Math.toRadians(traj.getGPSPointList().get(j).getPoint().getX()) - Math.toRadians(traj.getGPSPointList().get(i).getPoint().getX());
                all += 2 * Math.asin(
                        Math.sqrt(
                                Math.pow(Math.sin(radLatDistance / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
                                        * Math.pow(Math.sin(radLngDistance / 2), 2)
                        )
                ) * EARTH_RADIUS_IN_METER;

            }
        }
        return all;
    }

//    public double st_traj_speedInKMPerHour(Trajectory traj) {
//
//
//    }

   public LineString st_traj_geom(Trajectory traj) {
        LineString lineString = new LineString((LngLatAlt) gpsPointList);
        return lineString;
   }


}

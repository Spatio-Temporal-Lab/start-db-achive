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
import org.geojson.LngLatAlt;
import org.urbcomp.start.db.model.point.GPSPoint;
import org.urbcomp.start.db.util.FeatureCollectionWithProperties;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trajectory {
    private String tid;
    private String oid;
    private List<GPSPoint> gpsPointList;

    /**
     * Constructor of Trajectory class
     *
     * @param tid          the id of Trajectory, should be unique in a trajectory database
     * @param oid          the object id of a trajectory, such as plate number
     * @param gpsPointList the gps point list of the trajectory
     */
    public Trajectory(String tid, String oid, List<GPSPoint> gpsPointList) {
        this.tid = tid;
        this.oid = oid;
        this.gpsPointList = gpsPointList;
    }

    /**
     * the constructor of Trajectory class. The time list and point list will be initialized empty
     *
     * @param tid the id of Trajectory, should be unique in a trajectory database
     * @param oid the object id of a trajectory, such as plate number
     */
    public Trajectory(String tid, String oid) {
        this(tid, oid, new ArrayList<>());
    }

    /**
     * get trajectory id
     *
     * @return trajectory id
     */
    public String getTid() {
        return tid;
    }

    /**
     * set trajectory id
     *
     * @param tid trajectory id
     * @return this object
     */
    public Trajectory setTid(String tid) {
        this.tid = tid;
        return this;
    }

    /**
     * get object id
     *
     * @return object id
     */
    public String getOid() {
        return oid;
    }

    /**
     * set object id
     *
     * @param oid object id
     * @return this object
     */
    public Trajectory setOid(String oid) {
        this.oid = oid;
        return this;
    }

    /**
     * get point list
     *
     * @return point list of GPS point
     */
    public List<GPSPoint> getGPSPointList() {
        return gpsPointList;
    }

    /**
     * set point list
     *
     * @param gpsPointList GPSPoint list of trajectory
     * @return this object
     */
    public Trajectory setPointList(List<GPSPoint> gpsPointList) {
        this.gpsPointList = gpsPointList;
        return this;
    }

    /**
     * add a GPSPoint to the trajectory
     *
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
     *
     * @return GeoJSON String
     */
    public String toGeoJSON() throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new FeatureCollectionWithProperties();
        fcp.setProperty("oid", oid);
        fcp.setProperty("tid", tid);
        for (GPSPoint gp : gpsPointList) {
            Feature f = new Feature();
            f.setProperty("time", gp.getTime().toString());
            f.setGeometry(new org.geojson.Point(gp.getX(), gp.getY()));
            fcp.add(f);
        }
        return new ObjectMapper().writeValueAsString(fcp);
    }

    /**
     * create a trajectory object from GeoJSON string
     *
     * @param geoJsonStr the GeoJSON string
     * @return a Trajectory instance
     * @throws JsonProcessingException if parse error
     */
    public static Trajectory fromGeoJSON(String geoJsonStr) throws JsonProcessingException {
        FeatureCollectionWithProperties fcp = new ObjectMapper().readValue(
            geoJsonStr,
            FeatureCollectionWithProperties.class
        );
        Trajectory traj = new Trajectory(fcp.getProperty("tid"), fcp.getProperty("oid"));
        for (Feature f : fcp.getFeatures()) {
            LngLatAlt lngLatAlt = ((org.geojson.Point) f.getGeometry()).getCoordinates();
            traj.addGPSPoint(
                new GPSPoint(
                    Timestamp.valueOf((String) f.getProperty("time")),
                    lngLatAlt.getLongitude(),
                    lngLatAlt.getLatitude()
                )
            );
        }
        return traj;
    }
}

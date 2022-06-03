package org.urbcomp.start.db.model;

import java.util.ArrayList;
import java.util.List;

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
     */
    public void setTid(String tid) {
        this.tid = tid;
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
     */
    public void setOid(String oid) {
        this.oid = oid;
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
     */
    public void setPointList(List<GPSPoint> gpsPointList) {
        this.gpsPointList = gpsPointList;
    }

    /**
     * add a GPSPoint to the trajectory
     * @param gpsPoint the GPSPoint to be added
     */
    public void addGPSPoint(GPSPoint gpsPoint) {
        this.gpsPointList.add(gpsPoint);
    }
}

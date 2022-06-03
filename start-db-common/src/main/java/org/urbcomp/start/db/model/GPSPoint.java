package org.urbcomp.start.db.model;

import org.locationtech.jts.geom.Point;

import java.sql.Timestamp;

public class GPSPoint {
    private Timestamp time;
    private Point point;
    public GPSPoint(Timestamp time, Point point) {
        this.time = time;
        this.point = point;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

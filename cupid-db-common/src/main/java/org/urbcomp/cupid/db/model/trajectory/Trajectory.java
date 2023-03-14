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
package org.urbcomp.cupid.db.model.trajectory;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.geojson.Feature;
import org.geojson.LngLatAlt;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.*;
import org.urbcomp.cupid.db.model.Attribute;
import org.urbcomp.cupid.db.model.point.GPSPoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.serializer.TrajDeserializer;
import org.urbcomp.cupid.db.serializer.TrajSerializer;
import org.urbcomp.cupid.db.util.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@JsonSerialize(using = TrajSerializer.class)
@JsonDeserialize(using = TrajDeserializer.class)
public class Trajectory {
    private String tid;
    private String oid;
    private List<GPSPoint> gpsPointList;
    private Map<String, Attribute> attributes = new HashMap<>();

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

    public Trajectory(
        String tid,
        String oid,
        List<GPSPoint> gpsPointList,
        Map<String, Attribute> attributes
    ) {
        this.tid = tid;
        this.oid = oid;
        this.gpsPointList = gpsPointList;
        this.attributes = attributes;
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

    public Object getAttribute(String name) {
        switch (name) {
            case "Oid":
                return getOid();
            case "Tid":
                return getTid();
            case "GPSPointList":
                return getGPSPointList();
            default:
                return attributes.get(name).getValue();
        }
    }

    public void setAttribute(String name, Object obj) {
        switch (name) {
            case "Oid": {
                setOid((String) obj);
                break;
            }
            case "Tid": {
                setTid((String) obj);
                break;
            }
            case "GPSPointList": {
                setPointList((List<GPSPoint>) obj);
                break;
            }
            default: {
                String typeName = attributes.get(name).getType();
                attributes.put(name, new Attribute(typeName, obj));
            }
        }
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
        return MapUtil.additionalAttributesEquals(attributes, ((Trajectory) o).attributes)
            && this.gpsPointList.equals(((Trajectory) o).gpsPointList);
    }

    /**
     * get trajectory start point
     *
     * @return start point
     */
    public Point getStartPoint() {
        return gpsPointList.get(0);
    }

    /**
     * get trajectory end point
     *
     * @return end point
     */
    public Point getEndPoint() {
        return gpsPointList.get(gpsPointList.size() - 1);
    }

    /**
     * get gps point start time
     *
     * @return start timestamp
     */
    public Timestamp getStartTime() {
        return gpsPointList.get(0).getTime();
    }

    /**
     * get the end of gpsPoint time
     *
     * @return end timestamp
     */
    public Timestamp getEndTime() {
        return gpsPointList.get(gpsPointList.size() - 1).getTime();
    }

    /**
     * get MBR
     *
     * @return MBR
     */
    public Envelope getBBox() {
        return GeoFunctions.getBBox(
            gpsPointList.stream()
                .map(o -> new SpatialPoint(o.getLng(), o.getLat()))
                .collect(Collectors.toList())
        );
    }

    /**
     * get the length of the trajectory(km)
     *
     * @return length of the trajectory
     */
    public double getLengthInKm() {
        return GeoFunctions.getDistanceInM(
            gpsPointList.stream()
                .map(o -> new SpatialPoint(o.getLng(), o.getLat()))
                .collect(Collectors.toList())
        ) / 1000;
    }

    /**
     * Get the average speed of the trajectory (km/h)
     *
     * @return speed (km/h)
     */
    public double getSpeedInKMPerHour() {
        return getLengthInKm() / ((getEndTime().getTime() - getStartTime().getTime()) / 3600000.0);
    }

    /**
     * Get the Linestring corresponding to this trajectory
     *
     * @return Linestring
     */
    public LineString getLineString() {
        GeometryFactory geometryFactory = GeometryFactoryUtils.defaultGeometryFactory();
        return geometryFactory.createLineString(
            gpsPointList.stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
        );
    }

    /**
     * Convert this trajectory to GeoJSON String
     *
     * @return GeoJSON String
     */
    public String toGeoJSON() throws JsonProcessingException {
        GeometryJSON geometryJSON = new GeometryJSON();
        FeatureCollectionWithProperties fcp = new FeatureCollectionWithProperties();
        fcp.setProperty("oid", oid);
        fcp.setProperty("tid", tid);
        for (GPSPoint gp : gpsPointList) {
            Feature f = new Feature();
            f.setProperty("time", gp.getTime().toString());
            for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
                String typeName = entry.getValue().getType();
                Class type = DataTypeUtils.getClass(typeName);
                if (Geometry.class.isAssignableFrom(type)) {
                    f.setProperty(
                        entry.getKey(),
                        geometryJSON.toString((Geometry) (entry.getValue().getValue()))
                    );
                } else {
                    f.setProperty(entry.getKey(), JSONObject.toJSONString(entry.getValue()));
                }
            }
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
    public static Trajectory fromGeoJSON(String geoJsonStr) throws IOException {
        FeatureCollectionWithProperties fcp = new ObjectMapper().readValue(
            geoJsonStr,
            FeatureCollectionWithProperties.class
        );
        Trajectory traj = new Trajectory(fcp.getProperty("tid"), fcp.getProperty("oid"));
        GeometryJSON geometryJSON = new GeometryJSON();
        for (Feature f : fcp.getFeatures()) {
            LngLatAlt lngLatAlt = ((org.geojson.Point) f.getGeometry()).getCoordinates();
            Map<String, Attribute> attributeMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : f.getProperties().entrySet()) {
                if (!entry.getKey().equals("time")) {
                    JSONObject jsonObj = JSONObject.parseObject((String) entry.getValue());
                    String typeName = jsonObj.getString("type");
                    Class type = DataTypeUtils.getClass(typeName);
                    attributeMap.put(
                        entry.getKey(),
                        new Attribute(
                            typeName,
                            Geometry.class.isAssignableFrom(type)
                                ? type.cast(geometryJSON.read(jsonObj.toString()))
                                : JSONObject.parseObject(jsonObj.getString("value"), type)
                        )
                    );
                }
            }
            traj.attributes = attributeMap;
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

    @Override
    public String toString() {
        try {
            return this.toGeoJSON();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

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

package org.urbcomp.start.db.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.geotools.data.*;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.filter.text.cql2.CQLException;
import org.geotools.filter.text.ecql.ECQL;
import org.geotools.util.factory.Hints;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoadSegmentGeoMesaIO implements Closeable {
    private DataStore dataStore;
    private SimpleFeatureType sft;
    private final String tableName;

    public RoadSegmentGeoMesaIO(String tableName, Map<String, String> params) throws IOException {
        this.tableName = tableName;
        getDataStore(params);
        if (checkTable()) {
            createTable();
        } else {
            System.out.println("Table " + tableName + " already exists!");
        }
    }

    public void RoadSegmentToGeoMesaObject(RoadSegment rs) throws IOException {
        SimpleFeature sf = getFeature(rs);
        writeFeature(dataStore, sft, sf);
    }

    /**
     * @param bbox Query spatial region
     * */
    public List<String> RoadSegmentFromGeoMesaObject(String bbox) throws IOException, CQLException {
        // define query statement
        Query query = new Query(tableName, ECQL.toFilter(bbox));

        List<String> result = new ArrayList<>();
        FeatureReader<SimpleFeatureType, SimpleFeature> reader = dataStore.getFeatureReader(
            query,
            Transaction.AUTO_COMMIT
        );
        while (reader.hasNext()) {
            SimpleFeature feature = reader.next();
            result.add(feature.getAttribute("geom").toString());
        }
        return result;
    }

    /**
     * 这个方法主要设定了表名"RoadSegment"和schema结构
     *
     * @return SimpleFeatureType，即建表的schema表结构
     */
    private void createTable() throws IOException {
        sft = SimpleFeatureTypes.createType(
            tableName,
            "rsId:int, *geom:LineString:srid=4326, geoJson:String"
        );
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
        dataStore.createSchema(sft);
    }

    private void writeFeature(DataStore dataStore, SimpleFeatureType sft, SimpleFeature feature)
        throws IOException {
        try (
            FeatureWriter<SimpleFeatureType, SimpleFeature> writer = dataStore
                .getFeatureWriterAppend(sft.getTypeName(), Transaction.AUTO_COMMIT)
        ) {
            SimpleFeature toWrite = writer.next();
            toWrite.setAttributes(feature.getAttributes());
            ((FeatureIdImpl) toWrite.getIdentifier()).setID(feature.getID());
            toWrite.getUserData().put(Hints.USE_PROVIDED_FID, Boolean.TRUE);
            toWrite.getUserData().putAll(feature.getUserData());
            writer.write();
        }
    }

    private SimpleFeature getFeature(RoadSegment rs) throws JsonProcessingException {
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(sft);
        builder.set("rsId", rs.getRoadSegmentId());
        builder.set(
            "geom",
            new GeometryFactory().createLineString(
                rs.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
            )
        );
        builder.set("geoJson", rs.toGeoJSON());
        builder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);
        return builder.buildFeature(String.valueOf(rs.getRoadSegmentId()));
    }

    private void getDataStore(Map<String, String> params) throws IOException {
        dataStore = DataStoreFinder.getDataStore(params);
    }

    private boolean checkTable() throws IOException {
        return dataStore.getSchema(tableName) == null;
    }

    @Override
    public void close() {
        if (dataStore != null) {
            dataStore.dispose();
        }
    }

}

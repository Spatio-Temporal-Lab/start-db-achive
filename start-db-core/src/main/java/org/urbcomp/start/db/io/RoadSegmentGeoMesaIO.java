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
import org.junit.jupiter.api.Test;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.util.Assert;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.sample.ModelGenerator;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadSegmentGeoMesaIO implements Closeable {
    private DataStore dataStore;
    private SimpleFeatureType sft;
    final String TABLE_NAME = "RoadSegment";

    public RoadSegmentGeoMesaIO() throws IOException {
        getDataStore();
        dropTable();
        createTable();
    }

    private void dropTable(String tableName) throws IOException {
        if (dataStore.getSchema(tableName) != null) {
            dataStore.removeSchema(tableName);
        }
    }

    /**
     * 这个方法主要设定了表名"RoadSegment"和schema结构
     *
     * @return SimpleFeatureType，即建表的schema表结构
     */
    public void createTable() throws IOException {
        sft = SimpleFeatureTypes.createType(
            TABLE_NAME,
            "rsId:int, *geom:LineString:srid=4326, geoJson:String"
        );
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
        dataStore.createSchema(sft);
    }

    public void RoadSegmentToGeoMesaObject(RoadSegment rs) throws IOException {
        SimpleFeature sf = getFeature(rs);
        writeFeature(dataStore, sft, sf);
    }

    public List<String> RoadSegmentFromGeoMesaObject() throws IOException, CQLException {
        // define query statement
        String bbox = "bbox (geom, -180.0, -90.0, 180.0, 90.0)";
        Query query = new Query(TABLE_NAME, ECQL.toFilter(bbox));

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

    public SimpleFeature getFeature(RoadSegment rs) throws JsonProcessingException {
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

    private void getDataStore() throws IOException {
        Map<String, String> params = new HashMap<>();
        String CATALOG = "start_db.db_test";
        params.put("hbase.catalog", CATALOG);
        params.put("hbase.zookeepers", "localhost:2181");
        dataStore = DataStoreFinder.getDataStore(params);
    }

    private void dropTable() throws IOException {
        if (dataStore.getSchema(TABLE_NAME) != null) {
            dataStore.removeSchema(TABLE_NAME);
        }
    }

    @Override
    public void close() throws IOException {
        if (dataStore != null) {
            dataStore.dispose();
        }
    }

    @Test
    public void roadSegmentIOTest() throws IOException, CQLException {
        final RoadSegment rs = ModelGenerator.generateRoadSegment();
        RoadSegmentGeoMesaIO io = new RoadSegmentGeoMesaIO();
        io.RoadSegmentToGeoMesaObject(rs);
        List<String> result = io.RoadSegmentFromGeoMesaObject();
        Assert.equals(
            "LINESTRING (111.37939453125 54.00776876193478, 116.3671875 53.05442186546102)",
            result.get(0)
        );
    }

}

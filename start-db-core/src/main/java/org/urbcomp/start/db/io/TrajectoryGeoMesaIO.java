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
import org.geotools.util.factory.Hints;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.geom.*;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.urbcomp.start.db.model.trajectory.Trajectory;
import org.urbcomp.start.db.util.GeoFunctions;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrajectoryGeoMesaIO implements Closeable {
    private FeatureWriter<SimpleFeatureType, SimpleFeature> writer;
    private final DataStore dataStore;
    private SimpleFeatureType sft;
    private String TABLE_NAME;

    public TrajectoryGeoMesaIO(String tableName, Map<String, String> params) throws IOException {
        this.dataStore = DataStoreFinder.getDataStore(params);
        this.TABLE_NAME = tableName;
    }

    public TrajectoryGeoMesaIO(String tableName) throws IOException {
        Map<String, String> params = new HashMap<>();
        String CATALOG = "start_db.db_test";
        params.put("hbase.catalog", CATALOG);
        params.put("hbase.zookeepers", "localhost:2181");
        this.dataStore = DataStoreFinder.getDataStore(params);
        this.TABLE_NAME = tableName;
    }

    public void dropTable() throws IOException {
        if (dataStore.getSchema(TABLE_NAME) != null) {
            dataStore.removeSchema(TABLE_NAME);
        }
    }

    /**
     * used to set up a simple feature type
     */
    public void createTable() throws IOException {
        if (this.dataStore.getSchema(TABLE_NAME) != null) {
            System.out.println("Table " + TABLE_NAME + " already exists!");
            return;
        }
        this.sft = org.locationtech.geomesa.utils.geotools.SimpleFeatureTypes.createType(
            TABLE_NAME,
            "idx:Integer,"
                + "tid:String,"
                + "oid:String,"
                + "start_time:Timestamp,"
                + "end_time:Timestamp,"
                + "*geom:Polygon:srid=4326,"
                + "geoJson:String"
        );
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
        this.dataStore.createSchema(this.sft);
    }

    /**
     * used to ingest data into geomesa-hbase
     */
    private void writeFeature(DataStore dataStore, SimpleFeatureType sft, SimpleFeature feature)
        throws IOException {
        this.writer = dataStore.getFeatureWriterAppend(sft.getTypeName(), Transaction.AUTO_COMMIT);
        SimpleFeature toWrite = this.writer.next();
        toWrite.setAttributes(feature.getAttributes());
        ((FeatureIdImpl) toWrite.getIdentifier()).setID(feature.getID());
        toWrite.getUserData().put(Hints.USE_PROVIDED_FID, Boolean.TRUE);
        toWrite.getUserData().putAll(feature.getUserData());

        this.writer.write();
    }

    /**
     * used to close datastore of geomesa-hbase
     */
    public void writeClose() throws IOException {
        this.writer.close();
    }

    /**
     * used to create simpleFeature
     */
    public SimpleFeature dataSetUp(Trajectory tra) throws JsonProcessingException {
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(this.sft);
        builder.set("tid", tra.getTid());
        builder.set("oid", tra.getOid());
        builder.set("start_time", tra.getStartTime());
        builder.set("end_time", tra.getEndTime());
        Polygon mbr = GeoFunctions.bboxFromEnvelopeToPolygon(tra.getBBox());
        builder.set("geom", mbr);
        builder.set("geoJson", tra.toGeoJSON());
        builder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);
        return builder.buildFeature(String.valueOf(tra.getTid()));
    }

    public void trajectoryToGeoMesaObject(Trajectory t) throws IOException {
        SimpleFeature sf = dataSetUp(t);
        dataStore.createSchema(sft);
        writeFeature(dataStore, sft, sf);
    }

    public List<Object> trajectoryFromGeoMesaObject(Query query) throws IOException, CQLException {
        FeatureReader<SimpleFeatureType, SimpleFeature> reader = dataStore.getFeatureReader(
            query,
            Transaction.AUTO_COMMIT
        );
        List<Object> result = new ArrayList<>();
        while (reader.hasNext()) {
            SimpleFeature f = reader.next();
            result.add(f);
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        if (dataStore != null) {
            dataStore.dispose();
        }
    }

}

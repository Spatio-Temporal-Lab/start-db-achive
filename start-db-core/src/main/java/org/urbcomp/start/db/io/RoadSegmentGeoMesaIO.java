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
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.util.factory.Hints;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoadSegmentGeoMesaIO {

    /**
     * 这个方法主要设定了表名"index-text02"，
     * 和schema结构"taxiId:String,dtg:Date,*geom:Point:srid=4326"
     *
     * @return SimpleFeatureType，即建表的schema表结构
     */
    public SimpleFeatureType getSimpleFeatureType() {
        SimpleFeatureType sft = SimpleFeatureTypes.createType(
            "RoadSegment",
            "rsId:int,"
                + ""
                + "geoJson:String"
        );
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
        return sft;
    }

    private void writeFeature(DataStore dataStore, SimpleFeatureType sft, SimpleFeature feature) {
        try {
            System.out.println("write test data");
            FeatureWriter<SimpleFeatureType, SimpleFeature> writer = dataStore
                .getFeatureWriterAppend(sft.getTypeName(), Transaction.AUTO_COMMIT);
            SimpleFeature toWrite = writer.next();
            toWrite.setAttributes(feature.getAttributes());
            ((FeatureIdImpl) toWrite.getIdentifier()).setID(feature.getID());
            toWrite.getUserData().put(Hints.USE_PROVIDED_FID, Boolean.TRUE);
            toWrite.getUserData().putAll(feature.getUserData());
            writer.write();
            // 关闭流
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SimpleFeature getData(RoadSegment rs, SimpleFeatureType sft) throws JsonProcessingException, JsonProcessingException {
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(sft);
        builder.set("rsId", rs.getRoadSegmentId());
        builder.set("direction", rs.getDirection().value());
        builder.set("speedLimit", rs.getSpeedLimit());
        builder.set("level", rs.getLevel().value());
        builder.set("startId", rs.getStartNode().getNodeId());
        builder.set("endId", rs.getEndNode().getNodeId());
        builder.set("lengthInMeter", rs.getLengthInMeter());
        builder.set("geoJson", rs.toGeoJSON());
        builder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);

        return builder.buildFeature(String.valueOf(rs.getRoadSegmentId()));
    }

    public void RoadSegmentToGeoMesaObject(RoadSegment rs) throws IOException {

        Map<String, String> params = new HashMap<>();
        String CATALOG = "start_db.db_test";
        params.put("hbase.catalog", CATALOG);
        params.put("hbase.zookeepers", "localhost:2181");

        DataStore dataStore = DataStoreFinder.getDataStore(params);

        SimpleFeatureType sft = getSimpleFeatureType();
        SimpleFeature sf = getData(rs, sft);
        dataStore.createSchema(sft);

        writeFeature(dataStore, sft, sf);
    }
}

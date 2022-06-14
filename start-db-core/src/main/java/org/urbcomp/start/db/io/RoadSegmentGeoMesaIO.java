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
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.filter.text.cql2.CQLException;
import org.geotools.filter.text.ecql.ECQL;
import org.geotools.util.factory.Hints;
import org.jaitools.imageutils.iterator.SimpleIterator;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
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
                        + "*geom:LineString:srid=4326,"
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
//            System.out.println(sft);
            writer.write();
            // 关闭流
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SimpleFeature getData(RoadSegment rs, SimpleFeatureType sft) throws JsonProcessingException {
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(sft);
        builder.set("rsId", rs.getRoadSegmentId());
        builder.set("geom", new GeometryFactory().createLineString(
                rs.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
        ));
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
        System.out.println(sf);
        dataStore.createSchema(sft);

        writeFeature(dataStore, sft, sf);
    }

    public void RoadSegmentFromGeoMesaObject() throws IOException, CQLException {

        Map<String, String> params = new HashMap<>();
        String CATALOG = "start_db.db_test";
        params.put("hbase.catalog", CATALOG);
        params.put("hbase.zookeepers", "localhost:2181");

        //先定义查询语句
        String bbox = "bbox (geom, -180.0, -90.0, 180.0, 90.0)";

        //声明Query查询对象
        Query query = new Query("RoadSegment", ECQL.toFilter(bbox));

        DataStore dataStore = DataStoreFinder.getDataStore(params);

        //获取读取器reader
        SimpleFeatureSource featureSource = dataStore.getFeatureSource("RoadSegment");
        SimpleFeatureCollection sfc = featureSource.getFeatures();
        SimpleFeatureIterator iterator = sfc.features();

        while (iterator.hasNext()) {
            SimpleFeature sf = iterator.next();
            System.out.println(sf);
        }

//        FeatureReader<SimpleFeatureType, SimpleFeature> reader =
//                dataStore.getFeatureReader(query, Transaction.AUTO_COMMIT);
//        System.out.println(reader.getFeatureType());
//        while (reader.hasNext()) {
//            SimpleFeature feature = reader.next();
//            String locationWKT = feature.getAttribute("geom").toString();
//            System.out.println(locationWKT);
//        }

    }
}

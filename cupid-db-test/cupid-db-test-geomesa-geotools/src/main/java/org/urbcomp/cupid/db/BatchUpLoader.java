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
package org.urbcomp.cupid.db;

import org.geotools.data.*;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.util.factory.Hints;
import org.junit.Test;
import org.locationtech.geomesa.utils.geotools.SimpleFeatureTypes;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This is used to ingest data into geomesa-hbase with geotools. The data used is about bike-trip
 * (https://s3.amazonaws.com/tripdata/index.html), include: idx, ride_id, rideable_type, started_at,
 * ended_at, start_station_name, start_station_id, end_station_name, end_station_id start_lat,
 * start_lng, end_lat, end_lng, member_casual, which can be described as Integer, Point, String,
 * Double, LineString, TimeStamp in conclusion.
 *
 * @author stan
 * @date 2022/05/21 0:46
 * @since 0.1.0
 */

public class BatchUpLoader implements Closeable {

    private final SimpleDateFormat sdf = new SimpleDateFormat(Constant.TIME_STAMP_PARSER);
    private FeatureWriter<SimpleFeatureType, SimpleFeature> writer;
    private DataStore dataStore;
    private SimpleFeatureType sft;
    private final String TABLE_NAME = "t_1"; // t_test tableId is 1, mapped to schema name t_1

    public BatchUpLoader() throws IOException {
        mkConnection();
        dropTable();
        createTable();
    }

    /**
     * used to change type 'date' into 'timestamp'
     */
    private Long date2time(String date) throws ParseException {
        Date time = this.sdf.parse(date);

        return time.getTime();
    }

    /**
     * used to make connection with geomesa-hbase datastore
     */
    private void mkConnection() throws IOException {
        Map<String, String> params = new HashMap<>();
        String CATALOG = "root.default";
        params.put("hbase.catalog", CATALOG);
        params.put("hbase.zookeepers", "localhost:2181");

        this.dataStore = DataStoreFinder.getDataStore(params);
    }

    private void dropTable() throws IOException {
        if (this.dataStore.getSchema(TABLE_NAME) != null) {
            this.dataStore.removeSchema(TABLE_NAME);
        }
    }

    /**
     * used to set up a simple feature type
     */
    private void createTable() throws IOException {
        if (this.dataStore.getSchema(TABLE_NAME) != null) {
            return;
        }
        this.sft = SimpleFeatureTypes.createType(
            TABLE_NAME,
            "idx:Integer,"
                + "ride_id:String,"
                + "rideable_type:String,"
                + "started_at:Timestamp,"
                + "ended_at:Timestamp,"
                + "start_station_name:String,"
                + "start_station_id:Double,"
                + "start_point:Point:srid=4326,"
                + "end_station_name:String,"
                + "end_station_id:Double,"
                + "end_point:Point:srid=4326,"
                + "track:LineString:srid=4326,"
                + "member_casual:String"
        );
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
    private void writeClose() throws IOException {
        this.writer.close();
    }

    /**
     * used to read csv file
     */
    private BufferedReader readCsv(String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(csvFile), StandardCharsets.UTF_8)
        );
        System.out.println("Header : \n" + reader.readLine());

        return reader;
    }

    /**
     * used to create simpleFeature
     */
    private SimpleFeature dataSetUp(
        String idx,
        String ride_id,
        String rideable_type,
        String started_at,
        String ended_at,
        String start_station_name,
        String start_station_id,
        String start_lng,
        String start_lat,
        String end_station_name,
        String end_station_id,
        String end_lng,
        String end_lat,
        String member_casual
    ) throws ParseException {

        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(this.sft);
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        featureBuilder.set("idx", Integer.parseInt(idx));
        featureBuilder.set("ride_id", ride_id);
        featureBuilder.set("rideable_type", rideable_type);

        featureBuilder.set("started_at", this.date2time(started_at));
        featureBuilder.set("ended_at", this.date2time(ended_at));

        featureBuilder.set("start_station_name", start_station_name);
        featureBuilder.set("start_station_id", Double.parseDouble(start_station_id));

        Point startPoint = geometryFactory.createPoint(
            new Coordinate(Double.parseDouble(start_lng), Double.parseDouble(start_lat))
        );
        featureBuilder.set("start_point", startPoint);

        featureBuilder.set("end_station_name", end_station_name);
        featureBuilder.set("end_station_id", Double.parseDouble(end_station_id));

        Point endPoint = geometryFactory.createPoint(
            new Coordinate(Double.parseDouble(end_lng), Double.parseDouble(end_lat))
        );
        featureBuilder.set("end_point", endPoint);

        Coordinate[] coordinates = { startPoint.getCoordinate(), endPoint.getCoordinate() };
        LineString lineString = geometryFactory.createLineString(coordinates);

        featureBuilder.set("track", lineString);

        featureBuilder.set("member_casual", member_casual);

        featureBuilder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);

        return featureBuilder.buildFeature(String.valueOf(Integer.parseInt(idx)));
    }

    public void readData() throws IOException {
        final FeatureReader<SimpleFeatureType, SimpleFeature> reader = dataStore.getFeatureReader(
            new Query(TABLE_NAME),
            Transaction.AUTO_COMMIT
        );

        while (reader.hasNext()) {
            final SimpleFeature f = reader.next();
            System.out.println(f);
        }
    }

    @Override
    public void close() throws IOException {
        if (dataStore != null) {
            dataStore.dispose();
        }
    }

    /**
     * 若取消对应的注释，则为插入至geomesa-hbase，否则只构建并打印geotools要素
     */
    @Test
    public void insert() throws ParseException, IOException {
        // 数据量有点多，测试时插一部分
        int n = 100;
        try (BatchUpLoader upLoader = new BatchUpLoader()) {
            BufferedReader reader = upLoader.readCsv(Constant.CSV_FILE);

            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                i++;
                String[] split = line.split(Constant.COMMA_STR);

                SimpleFeature feature = upLoader.dataSetUp(
                    split[0],
                    split[1],
                    split[2],
                    split[3],
                    split[4],
                    split[5],
                    split[6],
                    split[10],
                    split[9],
                    split[7],
                    split[8],
                    split[12],
                    split[11],
                    split[13]
                );

                System.out.println(feature);
                upLoader.writeFeature(upLoader.dataStore, upLoader.sft, feature);
                upLoader.writeClose();
                if (i > n) {
                    break;
                }
            }
        }
    }

    @Test
    public void read() throws IOException {
        try (BatchUpLoader upLoader = new BatchUpLoader()) {
            upLoader.readData();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        final BatchUpLoader loader = new BatchUpLoader();
        loader.insert();
    }
}

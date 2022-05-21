package org.urbcomp.start.db;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.util.StringUtils;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.util.factory.Hints;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This is used to ingest data into geomesa-hbase with geotools
 * The data used is about bike-trip (https://s3.amazonaws.com/tripdata/index.html), include:
 * idx, ride_id, rideable_type, started_at, ended_at, start_station_name, start_station_id, end_station_name, end_station_id
 * start_lat, start_lng, end_lat, end_lng, member_casual, which can be described as Integer, Point, String, Double, LineString, TimeStamp in conclusion.
 *
 * @author stan
 * @since 0.1.0
 * @date 2022/05/21 0:46
 */
@Slf4j
public class BatchUpLoader {

    private SimpleFeatureType sft;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private FeatureWriter<SimpleFeatureType, SimpleFeature> writer;
    private DataStore dataStore;

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

        Map<String,String> params = new HashMap<>();
        params.put("hbase.catalog", "bike-data");
        params.put("hbase.zookeepers", "xxx:xxxx,xxx:xxxx....");

        this.dataStore = DataStoreFinder.getDataStore(params);
    }

    /**
     * used to set up a simple feature type
     */
    private void setTable() throws IOException {

        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();

        builder.setName("citibike-tripdata");
        builder.setCRS(DefaultGeographicCRS.WGS84);

        builder.add("idx",Integer.class);
        builder.add("ride_id",String.class);
        builder.add("rideable_type", String.class);
        builder.add("started_at", Timestamp.class);
        builder.add("ended_at",Timestamp.class);
        builder.add("start_station_name",String.class);
        builder.add("start_station_id",Double.class);
        builder.add("start_point", Point.class);
        builder.add("end_station_name",String.class);
        builder.add("end_station_id",Double.class);
        builder.add("end_point",Point.class);
        builder.add("track", LineString.class);
        builder.add("member_casual", String.class);

        this.sft = builder.buildFeatureType();
//        this.dataStore.createSchema(this.sft);

    }

    /**
     * used to ingest data into geomesa-hbase
     */
    private void writeFeature(DataStore dataStore, SimpleFeatureType sft, SimpleFeature feature) throws IOException {
        this.writer = dataStore.getFeatureWriterAppend(sft.getTypeName(), Transaction.AUTO_COMMIT);
        SimpleFeature toWrite = this.writer.next();
        toWrite.setAttributes(feature.getAttributes());
        ((FeatureIdImpl) toWrite.getIdentifier()).setID(feature.getID());
        toWrite.getUserData().put(Hints.USE_PROVIDED_FID,Boolean.TRUE);
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
     * used to set up  simple features (lineString)
     */
    public void mkBatchUpload() throws ParseException, IOException {
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(this.sft);
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test/geomesa-geotools/src/main/resources/202204-citibike-tripdata_clip.csv"), StandardCharsets.UTF_8));
        System.out.println("Header: \n" + reader.readLine());

        String line;
        int idx = 0;

        while((line = reader.readLine())!= null) {
            String[] split = line.split(StringUtils.COMMA_STR);

            featureBuilder.add(Integer.parseInt(split[0]));
            featureBuilder.add(split[1]);
            featureBuilder.add(split[2]);
            featureBuilder.add(this.date2time(split[3]));
            featureBuilder.add(this.date2time(split[4]));
            featureBuilder.add(split[5]);
            featureBuilder.add(split[6]);

            Point startPoint = geometryFactory.createPoint(new Coordinate(Double.parseDouble(split[10]),Double.parseDouble(split[9])));
            featureBuilder.add(startPoint);

            featureBuilder.add(split[7]);
            featureBuilder.add(split[8]);

            Point endPoint = geometryFactory.createPoint(new Coordinate(Double.parseDouble(split[12]),Double.parseDouble(split[11])));
            featureBuilder.add(endPoint);

            Coordinate[] coordinates = {new Coordinate(Double.parseDouble(split[10]), Double.parseDouble(split[9])), new Coordinate(Double.parseDouble(split[12]), Double.parseDouble(split[11]))};
            LineString lineString = geometryFactory.createLineString(coordinates);

            featureBuilder.add(lineString);
            featureBuilder.add(split[13]);

            featureBuilder.featureUserData(Hints.USE_PROVIDED_FID,Boolean.TRUE);
            SimpleFeature feature = featureBuilder.buildFeature(String.valueOf(idx));

//            this.writeFeature(dataStore,this.sft,feature);
//            this.writeClose();
            System.out.println((idx + "---- Data-ingestion Successful! \n"));
            System.out.println(feature + "\n");
            idx++;
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        BatchUpLoader mkData = new BatchUpLoader();

        mkData.setTable();
        mkData.mkBatchUpload();
    }
}

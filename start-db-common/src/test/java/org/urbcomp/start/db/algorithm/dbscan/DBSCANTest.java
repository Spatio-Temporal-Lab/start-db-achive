package org.urbcomp.start.db.algorithm.dbscan;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBSCANTest {

    ArrayList<ClusterPoint> clusterPoints = new ArrayList<>();

    @Before
    public void getData() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
            new FileReader("src/main/resources/data/points.csv")
        );

        String line;
        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");

            clusterPoints.add(
                new ClusterPoint(
                    Timestamp.valueOf(LocalDateTime.now()),
                    Double.parseDouble(split[0]),
                    Double.parseDouble(split[1])
                )
            );
        }
    }

    @Test
    public void process() {
        DBSCAN dbscan = new DBSCAN(300, 5);
        ArrayList<ClusterPoint> result = dbscan.process(this.clusterPoints);

        System.out.println(result.get(264).getCluster());
        System.out.println(result.get(264).isNoised());
    }
}

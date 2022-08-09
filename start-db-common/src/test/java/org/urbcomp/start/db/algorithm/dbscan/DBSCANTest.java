package org.urbcomp.start.db.algorithm.dbscan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Point;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

@Slf4j
public class DBSCANTest {

    DBSCAN dbscan = new DBSCAN(0.4,5);
    ArrayList<ClusterPoint> clusterPoints;
    RTree<String, Point> rTree;

    @Before
    public void setData() throws IOException {
        ArrayList<Object> list = this.dbscan.getRtreeData("src/test/resources/gz_2021101500.csv");
        this.clusterPoints = (ArrayList<ClusterPoint>) list.get(0);
        this.rTree = (RTree<String, Point>) list.get(1);
    }

    @Test
    public void process() throws InterruptedException {
        ArrayList<ClusterPoint> points = dbscan.process(this.clusterPoints, this.rTree);
        assertEquals(5,points.get(30000).getCluster());
        assertTrue(points.get(0).isNoised());
    }

    @After
    public void writeData() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/result.csv"));
        bufferedWriter.write("lon,lat,cluster,noise" + "\n");
        for (ClusterPoint point : clusterPoints) {
            bufferedWriter.write(point.getLng() +
                    "," + point.getLat() +
                    "," + point.getCluster() +
                    "," + point.isNoised() + "\n");
        }
        bufferedWriter.close();
    }
}

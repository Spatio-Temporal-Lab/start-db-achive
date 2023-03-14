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
package org.urbcomp.cupid.db.algorithm.clustering;

import org.junit.Before;
import org.junit.Test;
import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.model.point.GPSPoint;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KMeansClusteringTest {
    private static KMeansClustering kMeansClustering;

    @Before
    public void setup() {

        List<GPSPoint> points = ModelGenerator.generateTrajectory().getGPSPointList();

        kMeansClustering = new KMeansClustering(new ArrayList<>(points), 4);
    }

    @Test
    public void kMeansTest() {
        List<MultiPoint> list = kMeansClustering.cluster();
        for (MultiPoint multiPoint : list) {
            System.out.println(multiPoint.toString());
        }
        assertEquals(list.size(), 4);
        assertEquals(
            list.get(0).toString(),
            "MULTIPOINT ((108.99553 34.27859), (108.99552 34.27822), (108.99552 34.27786), (108.99552 34.27748), (108.99551 34.27708), (108.99551 34.27668), (108.9955 34.27629), (108.99549 34.2759), (108.99549 34.27552), (108.99549 34.27514), (108.99549 34.27476), (108.99548 34.2744), (108.99549 34.27407), (108.99548 34.27375), (108.99548 34.27354), (108.99548 34.27343))"
        );
        assertEquals(
            list.get(1).toString(),
            "MULTIPOINT ((108.99548 34.27323), (108.99547 34.27303), (108.99547 34.27279), (108.99547 34.27257), (108.99547 34.27233), (108.99546 34.27206), (108.99547 34.27177), (108.99546 34.2715), (108.99546 34.27122), (108.99545 34.27093), (108.99545 34.27068), (108.99545 34.27054), (108.99546 34.2703), (108.99545 34.27007), (108.99546 34.2698), (108.99547 34.26946), (108.99546 34.26891), (108.99546 34.26882), (108.9955 34.26832))"
        );
        assertEquals(
            list.get(2).toString(),
            "MULTIPOINT ((108.99551 34.26807), (108.9955 34.2678), (108.9955 34.26754), (108.9955 34.26731), (108.99549 34.26714), (108.9955 34.26707), (108.99549 34.26704), (108.99549 34.26691), (108.99549 34.26675), (108.99549 34.26662), (108.99548 34.26644), (108.99548 34.26623), (108.99548 34.26607), (108.99548 34.26591), (108.99547 34.2657), (108.99544 34.26549), (108.99543 34.26528), (108.99543 34.26506), (108.99542 34.26484), (108.99542 34.26467), (108.9954 34.2645), (108.9954 34.26429), (108.99541 34.26406), (108.99542 34.2638), (108.99542 34.26349), (108.99542 34.26318), (108.99542 34.26286), (108.99541 34.26256), (108.99541 34.2623))"
        );

    }

}

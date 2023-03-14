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

import org.geotools.data.Query;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.junit.Test;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.util.Assert;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil;
import org.urbcomp.cupid.db.io.GeoMesaIO;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;
import org.urbcomp.cupid.db.transformer.TrajectoryAndFeatureTransformer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TrajectoryAndFeatureTransformerTest {

    @Test
    public void test() throws IOException, FactoryException, ClassNotFoundException {
        // TODO: move global table to environment setup
        // t_trajectory_test tableId is 3, mapped to schema name t_3
        String tableName = "trajectory_test";

        // init GeoMesa table
        Map<String, String> params = ExecutorUtil.getDataStoreParams("root", "default");
        GeoMesaIO geoMesaIO = new GeoMesaIO(tableName, params);
        geoMesaIO.dropTable();

        // build test sft
        TrajectoryAndFeatureTransformer transformer = new TrajectoryAndFeatureTransformer();
        SimpleFeatureTypeBuilder builderSFT = new SimpleFeatureTypeBuilder();
        builderSFT.setName(geoMesaIO.getTableName());
        builderSFT.add("id1", Integer.class);
        builderSFT.add("t1", Trajectory.class);
        SimpleFeatureType sft = builderSFT.buildFeatureType();
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");

        // transfer origin sft to GeoMesa sft
        sft = transformer.getGeoMesaSFT(sft);

        // add parameter to the SimpleFeature
        SimpleFeatureBuilder builderSF = new SimpleFeatureBuilder(sft);
        builderSF.set("id1", 1);
        Trajectory t = ModelGenerator.generateTrajectory();
        builderSF = transformer.setGeoMesaSFBuilder(builderSF, "t1", t);

        // the id here can be set to the id of the row
        SimpleFeature sf = builderSF.buildFeature(null);

        // build GeoMesa table
        geoMesaIO.createTable(sft);

        // write feature to GeoMesa
        geoMesaIO.writeFeature(sft, sf);

        // build query
        Query query = new Query(tableName);
        List<SimpleFeature> result = geoMesaIO.readData(query);

        // check result
        Assert.equals(
            "[AttributeTypeImpl id1<Integer>, AttributeTypeImpl t1.tid<String>, "
                + "AttributeTypeImpl t1.oid<String>, AttributeTypeImpl t1.start_time<Timestamp>, "
                + "AttributeTypeImpl t1.end_time<Timestamp>, GeometryTypeImpl t1.geom<Polygon>,"
                + " AttributeTypeImpl t1.geoJson<String>]",
            sft.getTypes().toString()
        );
        Assert.equals(
            "2018-10-09 07:28:21.0",
            transformer.toTrajectory(result.get(0), "t1").getStartTime().toString()
        );

    }
}

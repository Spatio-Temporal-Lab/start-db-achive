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
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.util.factory.Hints;
import org.junit.Test;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.locationtech.jts.util.Assert;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.urbcomp.cupid.db.executor.utils.ExecutorUtil;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.model.sample.ModelGenerator;
import org.urbcomp.cupid.db.transformer.RoadSegmentAndGeomesaTransformer;

import java.io.IOException;
import java.util.Map;

public class RoadSegmentAndGeoMesaTransformerTest {
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

    @Test
    public void test() throws IOException, FactoryException {
        // TODO: move global table to environment setup
        // t_road_segment_test tableId is 2, mapped to schema name t_2
        String tableName = "road_segment_test";

        // build test sft
        RoadSegmentAndGeomesaTransformer transformer = new RoadSegmentAndGeomesaTransformer();
        SimpleFeatureTypeBuilder builder1 = new SimpleFeatureTypeBuilder();
        builder1.setName(tableName);
        builder1.add("a", Integer.class);
        builder1.add("b", RoadSegment.class);
        builder1.add("c", RoadSegment.class);
        SimpleFeatureType sft = builder1.buildFeatureType();
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");

        // transfer origin sft to GeoMesa sft
        sft = transformer.getGeoMesaSFT(sft);
        Assert.equals(
            "[AttributeTypeImpl a<Integer>, AttributeTypeImpl b.rsId<Integer>, GeometryTypeImpl "
                + "b.geom<LineString>, AttributeTypeImpl b.rsGeoJson<String>, AttributeTypeImpl c.rsId<Integer>, "
                + "GeometryTypeImpl c.geom<LineString>, AttributeTypeImpl c.rsGeoJson<String>]",
            sft.getTypes().toString()
        );

        // add parameter to the SimpleFeature
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(sft);
        builder.set("a", 1);
        RoadSegment rs = ModelGenerator.generateRoadSegment();
        builder = transformer.setGeoMesaSFBuilder(builder, "b", rs);
        builder = transformer.setGeoMesaSFBuilder(builder, "c", rs);

        // the id here can be set to the id of the row
        SimpleFeature sf = builder.buildFeature(null);

        // build GeoMesa table
        Map<String, String> params = ExecutorUtil.getDataStoreParams("root", "default");
        DataStore dataStore = DataStoreFinder.getDataStore(params);
        if (dataStore.getSchema(tableName) == null) {
            dataStore.createSchema(sft);
        }

        // write feature to GeoMesa
        writeFeature(dataStore, sft, sf);

        // build query
        Query query = new Query(tableName);
        FeatureReader<SimpleFeatureType, SimpleFeature> reader = dataStore.getFeatureReader(
            query,
            Transaction.AUTO_COMMIT
        );

        // check result
        SimpleFeature feature = reader.next();
        Assert.equals(
            "[POINT (111.37939453125 54.00776876193478), POINT (116.3671875 53.05442186546102)]",
            transformer.toRoadSegment(feature, "b").getPoints().toString()
        );

    }
}

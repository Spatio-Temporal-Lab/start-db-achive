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
package org.urbcomp.cupid.db.io;

import org.geotools.data.*;
import org.geotools.filter.identity.FeatureIdImpl;
import org.geotools.util.factory.Hints;
import org.locationtech.geomesa.utils.interop.SimpleFeatureTypes;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeoMesaIO {
    private FeatureWriter<SimpleFeatureType, SimpleFeature> writer;
    private final DataStore dataStore;
    private String TABLE_NAME;

    public GeoMesaIO(String tableName, Map<String, String> params) throws IOException {
        this.dataStore = DataStoreFinder.getDataStore(params);
        this.TABLE_NAME = tableName;
    }

    public void dropTable() throws IOException {
        if (dataStore.getSchema(TABLE_NAME) != null) {
            dataStore.removeSchema(TABLE_NAME);
        }
    }

    public void createTable(SimpleFeatureType sft) throws IOException {
        if (this.dataStore.getSchema(TABLE_NAME) != null) {
            System.out.println("Table " + TABLE_NAME + " already exists!");
            return;
        }
        sft.getUserData().put(SimpleFeatureTypes.DEFAULT_DATE_KEY, "dtg");
        this.dataStore.createSchema(sft);
    }

    public void writeFeature(SimpleFeatureType sft, SimpleFeature feature) throws IOException {
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

    public List<SimpleFeature> readData(Query query) throws IOException {
        final FeatureReader<SimpleFeatureType, SimpleFeature> reader = dataStore.getFeatureReader(
            query,
            Transaction.AUTO_COMMIT
        );
        List<SimpleFeature> result = new ArrayList<>();
        while (reader.hasNext()) {
            result.add(reader.next());
        }
        return result;
    }

    public String getTableName() {
        return TABLE_NAME;
    }
}

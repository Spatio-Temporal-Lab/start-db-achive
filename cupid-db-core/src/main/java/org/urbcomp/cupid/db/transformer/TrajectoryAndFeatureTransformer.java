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
package org.urbcomp.cupid.db.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.util.factory.Hints;
import org.locationtech.jts.geom.*;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.PropertyDescriptor;
import org.urbcomp.cupid.db.model.trajectory.Trajectory;
import org.urbcomp.cupid.db.util.GeoFunctions;

import java.io.IOException;
import java.sql.Timestamp;

public class TrajectoryAndFeatureTransformer {

    /**
     * Get Trajectory from Geomesa
     *
     * @param sf A Simple feature in Geomesa
     * @param name Field corresponding to the trajectory to be converted
     * @return Trajectory data obtained from the name field
     * @throws JsonProcessingException
     */
    public Trajectory toTrajectory(SimpleFeature sf, String name) throws IOException {
        return Trajectory.fromGeoJSON((String) sf.getAttribute(name + ".geoJson"));
    }

    /**
     * Extend the track data type field;
     * Expand the trajectory data type field to obtain the schema of the table in GeoMesa
     *
     * @param sft simple feature type for user
     * @return simple feature type in GeoMesa; actual Schema of the table
     */
    public SimpleFeatureType getGeoMesaSFT(SimpleFeatureType sft) {
        SimpleFeatureTypeBuilder sftBuilder = new SimpleFeatureTypeBuilder();
        sftBuilder.setName(sft.getName());
        for (PropertyDescriptor i : sft.getDescriptors()) {
            if (i.getType().getBinding().equals(Trajectory.class)) {
                sftBuilder.add(i.getName() + ".tid", String.class);
                sftBuilder.add(i.getName() + ".oid", String.class);
                sftBuilder.add(i.getName() + ".start_time", Timestamp.class);
                sftBuilder.add(i.getName() + ".end_time", Timestamp.class);
                sftBuilder.add(i.getName() + ".geom", Polygon.class, DefaultGeographicCRS.WGS84);
                sftBuilder.add(i.getName() + ".geoJson", String.class);
            } else {
                sftBuilder.add(i.getName().toString(), i.getType().getBinding());
            }
        }
        return sftBuilder.buildFeatureType();
    }

    /**
     * Set the expanded field corresponding to the track data
     * @param builder Simple Feature Builder to be set up
     * @param name Trajectory data corresponding field name
     * @param tra Trajectory data
     * @return Builder after setting trajectory data
     * @throws JsonProcessingException
     */
    public SimpleFeatureBuilder setGeoMesaSFBuilder(
        SimpleFeatureBuilder builder,
        String name,
        Trajectory tra
    ) throws JsonProcessingException {
        builder.set(name + ".tid", tra.getTid());
        builder.set(name + ".oid", tra.getOid());
        builder.set(name + ".start_time", tra.getStartTime());
        builder.set(name + ".end_time", tra.getEndTime());
        Polygon mbr = GeoFunctions.bboxFromEnvelopeToPolygon(tra.getBBox());
        builder.set(name + ".geom", mbr);
        builder.set(name + ".geoJson", tra.toGeoJSON());
        builder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);
        return builder;
    }
}

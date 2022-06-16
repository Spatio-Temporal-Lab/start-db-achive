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

package org.urbcomp.start.db.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.util.factory.Hints;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.PropertyDescriptor;
import org.opengis.referencing.FactoryException;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;

public class RoadSegmentAndGeomesaTransformer {

    /**
     * @param sft SimpleFeatureType without roadSegment field
     * @return SimpleFeatureType with roadSegment field
     */
    public SimpleFeatureType getGeoMesaSFT(SimpleFeatureType sft) {
        SimpleFeatureTypeBuilder sftBuilder = new SimpleFeatureTypeBuilder();
        sftBuilder.setName(sft.getName());
        for (PropertyDescriptor i : sft.getDescriptors()) {
            if (i.getType().getBinding().equals(RoadSegment.class)) {
                sftBuilder.add(i.getName() + ".rsId", Integer.class);
                sftBuilder.add(i.getName() + ".geom", LineString.class, 4326);
                sftBuilder.add(i.getName() + ".rsGeoJson", String.class);
            } else {
                sftBuilder.add(i.getName().toString(), i.getType().getBinding());
            }
        }
        return sftBuilder.buildFeatureType();
    }

    /**
     * @param builder Origin SimpleFeatureBuilder without roadSegmentInformation
     * @param name    The name of the field to add a RoadSegment
     * @param rs      RoadSegment to be added to SimpleFeature
     * @return SimpleFeature with roadSegment information
     */
    public SimpleFeatureBuilder setGeoMesaSFBuilder(
        SimpleFeatureBuilder builder,
        String name,
        RoadSegment rs
    ) throws JsonProcessingException {
        builder.set(name + ".rsId", rs.getRoadSegmentId());
        builder.set(
            name + ".geom",
            new GeometryFactory().createLineString(
                rs.getPoints().stream().map(Point::getCoordinate).toArray(Coordinate[]::new)
            )
        );
        builder.set(name + ".rsGeoJson", rs.toGeoJSON());
        builder.featureUserData(Hints.USE_PROVIDED_FID, Boolean.TRUE);
        return builder;
    }

    /**
     * @param sf SimpleFeature obtained from GeoMesa
     * @param name The field to be converted to RoadSegment
     * @return RoadSegment converted from sf
     */
    public RoadSegment toRoadSegment(SimpleFeature sf, String name) throws JsonProcessingException {
        return RoadSegment.fromGeoJSON((String) sf.getAttribute(name + ".rsGeoJson"));
    }

}

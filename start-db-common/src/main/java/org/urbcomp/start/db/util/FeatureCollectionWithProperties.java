/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.util;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.geojson.FeatureCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Here this class disguise itself as feature collection
@JsonTypeName(value = "FeatureCollection")
public class FeatureCollectionWithProperties extends FeatureCollection {
    private Map<String, Object> properties = new HashMap<String, Object>();

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key) {
        return (T) properties.get(key);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureCollectionWithProperties fc = (FeatureCollectionWithProperties) o;
        if (!Objects.equals(properties, fc.properties)) return false;
        return this.getFeatures().equals(fc.getFeatures());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeatureCollection{properties="
            + properties
            + ", features="
            + this.getFeatures()
            + '}';
    }
}

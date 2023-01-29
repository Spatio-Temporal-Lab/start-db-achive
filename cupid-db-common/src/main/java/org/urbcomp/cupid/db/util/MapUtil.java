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

package org.urbcomp.cupid.db.util;

import org.urbcomp.cupid.db.model.Attribute;

import java.util.Map;

public class MapUtil {
    public static boolean additionalAttributesEquals(
        Map<String, Attribute> attributeMap1,
        Map<String, Attribute> attributeMap2
    ) {
        if (attributeMap1.size() != attributeMap2.size()) {
            return false;
        }
        for (Map.Entry<String, Attribute> entry : attributeMap1.entrySet()) {
            if (!attributeMap2.containsKey(entry.getKey())) {
                return false;
            }
            if (!attributeMap2.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}

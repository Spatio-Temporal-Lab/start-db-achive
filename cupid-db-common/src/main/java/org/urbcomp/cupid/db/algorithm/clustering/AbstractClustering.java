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

package org.urbcomp.cupid.db.algorithm.clustering;

import org.locationtech.jts.geom.MultiPoint;
import org.urbcomp.cupid.db.model.point.SpatialPoint;

import java.util.*;

public abstract class AbstractClustering {
    protected final List<SpatialPoint> pointList;

    public AbstractClustering(List<SpatialPoint> pointList) {
        this.pointList = pointList;
    }

    public abstract List<MultiPoint> cluster();
}

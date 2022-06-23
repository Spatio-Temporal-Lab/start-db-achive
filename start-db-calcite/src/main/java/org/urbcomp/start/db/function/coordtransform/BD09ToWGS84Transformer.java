package org.urbcomp.start.db.function.coordtransform;

import org.urbcomp.start.db.util.CoordTransformUtils;

public class BD09ToWGS84Transformer extends AbstractCoordTransformer{
    @Override
    protected double[] transform(double lng, double lat) {
        return CoordTransformUtils.bd09Towgs84(lng, lat);
    }
}

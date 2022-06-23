package org.urbcomp.start.db.function;

import org.locationtech.jts.geom.Point;
import org.urbcomp.start.db.function.coordtransform.AbstractCoordTransformer;
import org.urbcomp.start.db.function.coordtransform.BD09ToWGS84Transformer;

public class CoordTransformFunction {
    @StartDBFunction("st_BD09ToWGS84")
    public Point st_BD09ToWGS84(Point point) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.pointTransform(point);
    }
}

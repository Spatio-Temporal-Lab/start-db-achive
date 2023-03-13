package org.urbcomp.cupid.db.flink.function;

import org.apache.flink.table.annotation.DataTypeHint;
import org.apache.flink.table.functions.ScalarFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class Functions {
    public static class ST_Point extends ScalarFunction {
        @DataTypeHint(value = "RAW", bridgedTo = Geometry.class)
        public Geometry eval(@DataTypeHint("Double") Double x, @DataTypeHint("Double") Double y) {
            Coordinate coordinates = new Coordinate(x, y);
            GeometryFactory geometryFactory = new GeometryFactory();
            return geometryFactory.createPoint(coordinates);
        }
    }
}

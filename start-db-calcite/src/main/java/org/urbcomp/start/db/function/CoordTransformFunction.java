/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.start.db.function;

import org.locationtech.jts.geom.*;
import org.urbcomp.start.db.function.coordtransform.AbstractCoordTransformer;
import org.urbcomp.start.db.function.coordtransform.BD09ToWGS84Transformer;
import org.urbcomp.start.db.function.coordtransform.WGS84ToBD09Transformer;
import org.urbcomp.start.db.model.roadnetwork.RoadSegment;
import org.urbcomp.start.db.model.trajectory.Trajectory;

public class CoordTransformFunction {
    @StartDBFunction("st_BD09ToWGS84")
    public Point st_BD09ToWGS84(Point point) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.pointTransform(point);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public LineString st_BD09ToWGS84(LineString lineString) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.lineStringTransform(lineString);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public Polygon st_BD09ToWGS84(Polygon polygon) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.polygonTransform(polygon);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public MultiPolygon st_BD09ToWGS84(MultiPolygon mPolygon) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.multiPolygonTransform(mPolygon);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public Trajectory st_BD09ToWGS84(Trajectory trajectory) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.trajectoryTransform(trajectory);
    }

    @StartDBFunction("st_BD09ToWGS84")
    public RoadSegment st_BD09ToWGS84(RoadSegment rs) {
        AbstractCoordTransformer transformer = new BD09ToWGS84Transformer();
        return transformer.roadSegmentTransform(rs);
    }

    @StartDBFunction("st_WGS84ToBD09")
    public Point st_WGS84ToBD09(Point point) {
        AbstractCoordTransformer transformer = new WGS84ToBD09Transformer();
        return transformer.pointTransform(point);
    }

}

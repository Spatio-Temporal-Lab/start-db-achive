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

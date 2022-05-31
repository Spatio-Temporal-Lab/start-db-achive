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

public class MathFunction {
    // TODO by Zheng Li
    /**
     * Returns the natural logarithm (base) of a double value (num).
     *
     * @param base  base double
     * @param num   num double
     * @return log result
     */
    @StartDBFunction("log")
    public double log(double base, double num) {
        return Math.log(num) / Math.log(base);
    }

    /**
     * The double value that is closer than any other to pi
     * the ratio of the circumference of a circle to its diameter.
     *
     * @return PI double.
     */
    @StartDBFunction("pi")
    public double pi() {
        return Math.PI;
    }

    @StartDBFunction("log2")
    public double log2(double num) {
        return Math.log(num) / Math.log(2);
    }

    @StartDBFunction("log1p")
    public double log1p(double num) {
        return Math.log1p(num);
    }

    @StartDBFunction("ln")
    public double ln(double num) {
        return Math.log(num);
    }

    @StartDBFunction("log10")
    public double log10(double num) {
        return Math.log10(num);
    }
}

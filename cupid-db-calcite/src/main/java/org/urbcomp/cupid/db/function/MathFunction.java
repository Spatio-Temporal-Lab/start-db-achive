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

package org.urbcomp.cupid.db.function;

public class MathFunction {
    /**
     * The double value that is closer than any other to e,
     * the base of the natural logarithms.
     */
    public static final double E = 2.7182818284590452354;

    /**
     * The double value that is closer than any other to pi,
     * the ratio of the circumference of a circle to its diameter.
     */
    public static final double PI = 3.14159265358979323846;

    /**
     * Returns the (base) logarithm of a double value (num).
     *
     * @param base double
     * @param num  double
     * @return log result
     */
    @CupidDBFunction("log")
    public double log(double base, double num) {
        return Math.log(num) / Math.log(base);
    }

    /**
     * The double value that is closer than any other to pi
     *
     * @return PI double.
     */
    @CupidDBFunction("pi")
    public double pi() {
        return Math.PI;
    }

    /**
     * Returns the base 2 logarithm of a double value (num).
     *
     * @param num double
     * @return double
     */
    @CupidDBFunction("log2")
    public double log2(double num) {
        return Math.log(num) / Math.log(2.0D);
    }

    /**
     * Returns the natural logarithm of a double value (num) + 1.
     *
     * @param num double
     * @return double
     */
    @CupidDBFunction("log1p")
    public double log1p(double num) {
        return Math.log1p(num);
    }

    /**
     * Returns the value of the first argument raised to the power of the second argument.
     *
     * @param a double
     * @param b double
     * @return double
     */
    @CupidDBFunction("pow")
    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    /**
     * Converts an angle measured in degrees to an approximately equivalent angle measured in radians.
     * The conversion from degrees to radians is generally inexact.
     *
     * @param angDeg double
     * @return double
     */
    @CupidDBFunction("toRadians")
    public double toRadians(double angDeg) {
        return Math.toRadians(angDeg);
    }

    /**
     * Converts an angle measured in radians to an approximately equivalent angle measured in degrees.
     * The conversion from radians to degrees is generally inexact;
     * users should not expect cos(toRadians(90.0)) to exactly equal 0.0.
     *
     * @param angRad double
     * @return double
     */
    @CupidDBFunction("toDegrees")
    public double toDegrees(double angRad) {
        return Math.toDegrees(angRad);
    }

}

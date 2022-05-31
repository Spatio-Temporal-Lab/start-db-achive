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

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    @StartDBFunction("log")
    public double log(double base, double num) {
        return Math.log(num) / Math.log(base);
    }

    /**
     * The double value that is closer than any other to pi
     *
     * @return PI double.
     */
    @StartDBFunction("pi")
    public double pi() {
        return Math.PI;
    }

    /**
     * Returns the base 2 logarithm of a double value (num).
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("log2")
    public double log2(double num) {
        return Math.log(num) / Math.log(2.0D);
    }

    /**
     * Returns the natural logarithm of a double value (num) + 1.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("log1p")
    public double log1p(double num) {
        return Math.log1p(num);
    }

    /**
     * Returns the natural logarithm of a double value (num)
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("ln")
    public double ln(double num) {
        return Math.log(num);
    }

    /**
     * Returns the base 10 logarithm of a double value (num).
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("log10")
    public double log10(double num) {
        return Math.log10(num);
    }

    /**
     * Returns the absolute value of an int value.
     *
     * @param num int
     * @return int
     */
    @StartDBFunction("abs")
    public int abs(int num) {
        return (num < 0) ? -num : num;
    }

    /**
     * Returns the absolute value of a long value.
     *
     * @param num long
     * @return long
     */
    @StartDBFunction("abs")
    public long abs(long num) {
        return (num < 0) ? -num : num;
    }

    /**
     * Returns the absolute value of a float value.
     *
     * @param num float
     * @return float
     */
    @StartDBFunction("abs")
    public float abs(float num) {
        return (num <= 0.0F) ? 0.0F - num : num;
    }

    /**
     * Returns the absolute value of a double value.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("abs")
    public double abs(double num) {
        return (num <= 0.0D) ? 0.0D - num : num;
    }

    /**
     * Returns the smallest (closest to negative infinity) double value that is
     * greater than or equal to the argument and is equal to a mathematical integer.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("ceil")
    public double ceil(double num) {
        return Math.ceil(num);
    }

    /**
     * Returns the largest (closest to positive infinity) double value that is
     * less than or equal to the argument and is equal to a mathematical integer.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("floor")
    public double floor(double num) {
        return Math.floor(num);
    }

    /**
     * Returns the rounded value of the precision(num_digits)
     *
     * @param num        double
     * @param num_digits int
     * @return double
     */
    @StartDBFunction("round")
    public double round(double num, int num_digits) {
        BigDecimal bd = new BigDecimal(num);

        return bd.setScale(num_digits, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Returns the signum function of the argument; zero if the argument is zero,
     * 1.0f if the argument is greater than zero, -1.0f if the argument is less than zero.
     *
     * @param num float
     * @return float
     */
    @StartDBFunction("signum")
    public float signum(float num) {
        return Math.signum(num);
    }

    /**
     * Returns the signum function of the argument; zero if the argument is zero,
     * 1.0f if the argument is greater than zero, -1.0f if the argument is less than zero.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("signum")
    public double signum(double num) {
        return Math.signum(num);
    }

    /**
     * Returns the floor modulus of the int arguments.
     * x%y
     *
     * @param num1 int x
     * @param num2 int y
     * @return int
     */
    @StartDBFunction("mod")
    public int mod(int num1, int num2) {
        return Math.floorMod(num1, num2);
    }

    /**
     * Returns the trigonometric sine of an angle.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("sin")
    public double sin(double num) {
        return Math.sin(num);
    }

    /**
     * Returns the trigonometric cosine of an angle.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("cos")
    public double cos(double num) {
        return Math.cos(num);
    }

    /**
     * Returns the trigonometric tangent of an angle.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("tan")
    public double tan(double num) {
        return Math.tan(num);
    }

    /**
     * Returns the trigonometric cotangent of an angle.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("cot")
    public double cot(double num) {
        return 1 / Math.tan(num);
    }

    /**
     * Returns the arc sine of a value; the returned angle is in the range -pi/2 through pi/2.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("asin")
    public double asin(double num) {
        return Math.asin(num);
    }

    /**
     * Returns the arc cosine of a value; the returned angle is in the range -pi/2 through pi/2.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("acos")
    public double acos(double num) {
        return Math.acos(num);
    }

    /**
     * Returns the correctly rounded positive square root of a double value.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("sqrt")
    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    /**
     * Returns the cube root of a double value.
     *
     * @param num double
     * @return double
     */
    @StartDBFunction("cbrt")
    public double cbrt(double num) {
        return Math.cbrt(num);
    }

    /**
     * Returns the value of the first argument raised to the power of the second argument.
     *
     * @param a double
     * @param b double
     * @return double
     */
    @StartDBFunction("pow")
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
    @StartDBFunction("toRadians")
    public double toRadians(double angDeg) {
        return angDeg / 180.0 * PI;
    }
}

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
    /**
     * Returns the natural logarithm (base) of a double value (num).
     *
     * @param base base double
     * @param num  num double
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

    @StartDBFunction("log2")
    public double log2(double num) {
        return Math.log(num) / Math.log(2.0D);
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

    @StartDBFunction("abs")
    public int abs(int num) {
        return (num < 0) ? -num : num;
    }

    @StartDBFunction("abs")
    public long abs(long num) {
        return (num < 0) ? -num : num;
    }

    @StartDBFunction("abs")
    public float abs(float num) {
        return (num <= 0.0F) ? 0.0F - num : num;
    }

    @StartDBFunction("abs")
    public double abs(double num) {
        return (num <= 0.0D) ? 0.0D - num : num;
    }

    @StartDBFunction("ceil")
    public double ceil(double num) {
        return Math.ceil(num);
    }

    @StartDBFunction("floor")
    public double floor(double num) {
        return Math.floor(num);
    }

    @StartDBFunction("signum")
    public float signum(float num) {
        return Math.signum(num);
    }

    @StartDBFunction("signum")
    public double signum(double num) {
        return Math.signum(num);
    }

    @StartDBFunction("mod")
    public int mod(int num1, int num2) {
        return Math.floorMod(num1, num2);
    }

    @StartDBFunction("sin")
    public double sin(double num) {
        return Math.sin(num);
    }

    @StartDBFunction("cos")
    public double cos(double num) {
        return Math.cos(num);
    }

    @StartDBFunction("tan")
    public double tan(double num) {
        return Math.tan(num);
    }

    @StartDBFunction("asin")
    public double asin(double num) {
        return Math.asin(num);
    }

    @StartDBFunction("acos")
    public double acos(double num) {
        return Math.acos(num);
    }
}

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

public class DataTypeConversionFunction {

    @CupidDBFunction("castToInteger")
    public Integer castToInteger(String str) {
        return Integer.valueOf(str);
    }

    @CupidDBFunction("castToLong")
    public Long castToLong(String str) {
        return Long.valueOf(str);
    }

    @CupidDBFunction("castToFloat")
    public Float castToFloat(String str) {
        return Float.valueOf(str);
    }

    @CupidDBFunction("castToDouble")
    public Double castToDouble(String str) {
        return Double.valueOf(str);
    }

    @CupidDBFunction("castToBoolean")
    public Boolean castToBoolean(String str) {
        return Boolean.valueOf(str);
    }

    @CupidDBFunction("castToString")
    public String castToString(Object any) {
        return any.toString();
    }

    @CupidDBFunction("parseInteger")
    public Integer parseInteger(Object num) {
        return Integer.valueOf(num.toString());
    }

    @CupidDBFunction("parseLong")
    public Long parseLong(Object num) {
        return Long.valueOf(num.toString());
    }

    @CupidDBFunction("parseDouble")
    public Double parseDouble(Object num) {
        return Double.valueOf(num.toString());
    }

}

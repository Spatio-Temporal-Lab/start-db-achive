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

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Time UDF functions
 * @author Wang Bohong
 * @Date  2022-05-29
 */
public class TimeFunction {

    /**
     * default time format
     */
    String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Converts a date string to a timestamp
     * @param dateString    date(time) String
     * @param format    date format
     * @return timestamp
     * @throws ParseException parse exception
     */
    @StartDBFunction("toTimestamp")
    public Timestamp toTimestamp(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = simpleDateFormat.parse(dateString);
        long time = date.getTime();
        return new Timestamp(time);
    }

    /**
     * Converts a date string to a timestamp
     * @param dateString date(time) String
     * @return timestamp
     * @throws ParseException parse exception
     */
    @StartDBFunction("toTimestamp")
    public Timestamp toTimestamp(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        Date date = simpleDateFormat.parse(dateString);
        long time = date.getTime();
        return new Timestamp(time);
    }

    /**
     * get current timestamp
     * @return current timestamp
     */
    @StartDBFunction("currentTimestamp")
    public Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Convert the timestamp to a Long instance
     * @param ts timestamp
     * @return long instance
     */
    @StartDBFunction("timestampToLong")
    public Long timestampToLong(Timestamp ts) {
        return ts.getTime();
    }

    /**
     * Converts a long instance to a timestamp
     * @param num one long instance
     * @return timestamp instance
     */
    @StartDBFunction("longToTimestamp")
    public Timestamp longToTimestamp(Long num) {
        return new Timestamp(num);
    }

    /**
     * Formats the timestamp in the specified format
     * @param ts    timestamp
     * @param string  time format
     * @return the specified format instance
     */
    @StartDBFunction("timestampFormat")
    public String timestampFormat(Timestamp ts, String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        return simpleDateFormat.format(new Date(ts.getTime()));
    }
}

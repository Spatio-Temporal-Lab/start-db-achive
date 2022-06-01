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
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * Time UDF functions
 *
 * @author Wang Bohong
 * @Date 2022-05-29
 */
public class TimeFunction {

    /**
     * default time format, the order is important
     */
    private final String[] DEFAULT_FORMATS = new String[] {
        "yyyy-MM-dd HH:mm:ss.SSS",
        "yyyy-MM-dd HH:mm:ss",
        "yyyy-MM-dd" };
    //
    // /**
    // * Converts a date string to a timestamp
    // *
    // * @param dateString date(time) String
    // * @param format date format
    // * @return timestamp
    // * @throws ParseException parse exception
    // */
    // @StartDBFunction("toTimestamp")
    // public Timestamp toTimestamp(String dateString, String format) throws ParseException {
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    // Date date = simpleDateFormat.parse(dateString);
    // long time = date.getTime();
    // return new Timestamp(time);
    // }
    //
    // /**
    // * Converts a date string to a timestamp
    // *
    // * @param dateString date(time) String
    // * @return timestamp
    // * @throws ParseException parse exception
    // */
    // @StartDBFunction("toTimestamp")
    // public Timestamp toTimestamp(String dateString) throws ParseException {
    // long time = 0;
    // boolean isCorrect = false;
    // ParseException pe = null;
    // for (String format : DEFAULT_FORMATS) {
    // try {
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    // Date date = simpleDateFormat.parse(dateString);
    // time = date.getTime();
    // isCorrect = true;
    // break;
    // } catch (ParseException ex) {
    // pe = ex;
    // }
    // }
    // if (!isCorrect && pe != null) {
    // throw new ParseException(
    // "Date format is error. Only receive " + String.join(",", DEFAULT_FORMATS),
    // pe.getErrorOffset()
    // );
    // }
    // return new Timestamp(time);
    // }
    //
    // /**
    // * get current timestamp
    // *
    // * @return current timestamp
    // */
    // @StartDBFunction("currentTimestamp")
    // public Timestamp currentTimestamp() {
    // return new Timestamp(System.currentTimeMillis());
    // }
    //
    // /**
    // * Convert the timestamp to a Long instance
    // *
    // * @param ts timestamp
    // * @return long instance
    // */
    // @StartDBFunction("timestampToLong")
    // public long timestampToLong(Timestamp ts) {
    // return ts.getTime();
    // }
    //
    // /**
    // * Convert the timestamp string to a Long instance
    // *
    // * @param tsStr timestamp string
    // * @return long instance
    // */
    // @StartDBFunction("timestampToLong")
    // public long timestampToLong(String tsStr) throws ParseException {
    // Timestamp timestamp = toTimestamp(tsStr);
    // return timestamp.getTime();
    // }
    //
    // /**
    // * Converts a long instance to a timestamp
    // *
    // * @param num one long instance
    // * @return timestamp instance
    // */
    // @StartDBFunction("longToTimestamp")
    // public Timestamp longToTimestamp(long num) {
    // return new Timestamp(num);
    // }
    //
    // /**
    // * Formats the timestamp in the specified format
    // *
    // * @param ts timestamp
    // * @param string time format
    // * @return the specified format instance
    // */
    // @StartDBFunction("timestampFormat")
    // public String timestampFormat(Timestamp ts, String string) {
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
    // return simpleDateFormat.format(new Date(ts.getTime()));
    // }

    /**
     * 以下为区分Datetime与Timestamp的Demo（不需要合并）
     * 初步思路为采用java8中的java.time包下的类替代java.sql.Timestamp去实现日期时间的类型
     * 用LocalDateTime实现datetime类型 （只存储时间值，不存储时区）
     * 用ZonedDateTime实现timestamp （保留时区）
     * ToDO：当前获取时区的方法是用“TimeZone.getDefault();“ 获取用户时区，该时区为jvm启动时的系统时区，并非实时的系统时区。这种处理是否符合使用需求？
     */

    /**
     * Converts a String to Datetime as the given format
     * @param dateString date(time) String
     * @param format date format
     * @return datetime
     * @throws DateTimeException parse exception
     */
    @StartDBFunction("toDatetime")
    public LocalDateTime toDatetime(String dateString, String format) throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateString, formatter);
    }

    /**
     * Converts a String to Datetime
     * @param dateString date(time) String
     * @return Datetime instance
     * @throws DateTimeParseException parse exception
     */
    @StartDBFunction("toDatetime")
    public LocalDateTime toDateTime(String dateString) throws DateTimeParseException {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        boolean isCorrect = false;
        DateTimeParseException pe = null;
        for (String format : DEFAULT_FORMATS) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                localDateTime = LocalDateTime.parse(dateString, formatter);
                isCorrect = true;
                break;
            } catch (DateTimeParseException exception) {
                pe = exception;
            }
        }
        if (!isCorrect && pe != null) {
            throw new DateTimeParseException(
                "Date format is error. Only receive ",
                String.join(",", DEFAULT_FORMATS),
                pe.getErrorIndex()
            );
        }
        return localDateTime;
    }

    /**
     * Converts a String to a timestamp(with TimeZone)
     * @param dateString date(time) String
     * @param format date format String
     * @param test  used to distinguish between two methods
     * @return timestamp
     * @throws DateTimeException parse exception
     */
    @StartDBFunction("toTimestamp")
    public ZonedDateTime toTimeStamp(String dateString, String format, String test)
        throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        return ZonedDateTime.of(localDateTime, zoneId);
    }

    /**
     * Converts a Datetime instance to timestamp(with TimeZone)
     * @param dtString datetime String
     * @return timestamp
     */
    @StartDBFunction("datetimeToTimestamp")
    public ZonedDateTime datetimeToTimestamp(String dtString) {
        LocalDateTime dt = toDateTime(dtString);
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        return ZonedDateTime.of(dt, zoneId);
    }
}

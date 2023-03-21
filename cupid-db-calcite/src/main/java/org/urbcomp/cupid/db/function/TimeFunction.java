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

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Date;

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

    /**
     * Converts a date string to a timestamp
     *
     * @param dateString date(time) String
     * @param format date format
     * @return timestamp
     * @throws ParseException parse exception
     */
    @CupidDBFunction("toTimestamp")
    public Timestamp toTimestamp(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.trim());
        Date date = simpleDateFormat.parse(dateString);
        long time = date.getTime();
        return new Timestamp(time);
    }

    /**
     * Converts a date string to a timestamp
     *
     * @param dateString date(time) String
     * @return timestamp
     * @throws ParseException parse exception
     */
    @CupidDBFunction("toTimestamp")
    public Timestamp toTimestamp(String dateString) throws ParseException {
        long time = 0;
        boolean isCorrect = false;
        ParseException pe = null;
        for (String format : DEFAULT_FORMATS) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                Date date = simpleDateFormat.parse(dateString);
                time = date.getTime();
                isCorrect = true;
                break;
            } catch (ParseException ex) {
                pe = ex;
            }
        }
        if (!isCorrect && pe != null) {
            throw new ParseException(
                "Date format is error. Only receive " + String.join(",", DEFAULT_FORMATS),
                pe.getErrorOffset()
            );
        }
        return new Timestamp(time);
    }

    /**
     * get current timestamp
     *
     * @return current timestamp
     */
    @CupidDBFunction("currentTimestamp")
    public Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Convert the timestamp to a Long instance
     *
     * @param ts timestamp
     * @return long instance
     */
    @CupidDBFunction("timestampToLong")
    public long timestampToLong(Timestamp ts) {
        return ts.getTime();
    }

    /**
     * Convert the timestamp string to a Long instance
     *
     * @param tsStr timestamp string
     * @return long instance
     */
    @CupidDBFunction("timestampToLong")
    public long timestampToLong(String tsStr) throws ParseException {
        Timestamp timestamp = toTimestamp(tsStr);
        return timestamp.getTime();
    }

    /**
     * Converts a long instance to a timestamp
     *
     * @param num one long instance
     * @return timestamp instance
     */
    @CupidDBFunction("longToTimestamp")
    public Timestamp longToTimestamp(long num) {
        return new Timestamp(num);
    }

    /**
     * Formats the timestamp in the specified format
     *
     * @param ts timestamp
     * @param string time format
     * @return the specified format instance
     */
    @CupidDBFunction("timestampFormat")
    public String timestampFormat(Timestamp ts, String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        return simpleDateFormat.format(new Date(ts.getTime()));
    }

    /**
     * Converts a String to Datetime as the given format
     * @param dateString date(time) String
     * @param format date format
     * @return datetime datetime instance
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("toDatetime")
    public LocalDateTime toDatetime(String dateString, String format) throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.trim());
        return LocalDateTime.parse(dateString, formatter);
    }

    /**
     * Converts a String to Datetime
     * @param dateString date(time) String
     * @return Datetime instance
     * @throws DateTimeParseException parse exception
     */
    @CupidDBFunction("toDatetime")
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
     * Converts a Datetime string to timestamp(with TimeZone)
     * @param dtString datetime String
     * @return timestamp timestamp instance
     */
    @CupidDBFunction("datetimeToTimestamp")
    public Timestamp datetimeToTimestamp(String dtString) throws ParseException {
        return toTimestamp(dtString);
    }

    /**
     * Converts a Datetime instance to timestamp(with TimeZone)
     * @param dateTime datetime instance
     * @return timestamp timestamp instance
     * @throws ParseException parse exception
     */
    @CupidDBFunction("datetimeToTimestamp")
    public Timestamp datetimeToTimestamp(LocalDateTime dateTime) throws ParseException {
        String dtString = dateTime.toString();
        return datetimeToTimestamp(dtString);
    }

    /**
     * Convert datetime to timestamp
     * @param timestamp Timestamp instance
     * @return datetime instance
     */
    @CupidDBFunction("timestampToDatetime")
    public LocalDateTime timestampToDatetime(Timestamp timestamp) {
        return toDateTime(timestamp.toString());
    }

    /**
     * Convert timestamp to datetime
     * @param tsString Timestamp String
     * @return datetime datetime instance
     * @throws ParseException parse exception
     */
    @CupidDBFunction("timestampToDatetime")
    public LocalDateTime timestampToDatetime(String tsString) throws ParseException {
        Timestamp timestamp = toTimestamp(tsString);
        return timestampToDatetime(timestamp);
    }

    /**
     * get current datetime
     * @return datetime instance
     */
    @CupidDBFunction("currentDatetime")
    public LocalDateTime currentDatetime() {
        return LocalDateTime.now();
    }

    /**
     * Formats one datetime instance into the specified format
     * @param dt datetime instance
     * @param format format string
     * @return datetime string
     */
    @CupidDBFunction("datetimeFormat")
    public String datetimeFormat(LocalDateTime dt, String format) throws DateTimeException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format.trim());
        return dateTimeFormatter.format(dt);
    }

    /**
     * Formats one datetime string into the specified format
     * @param dtStr datetime String
     * @param format format string
     * @return datetime string
     */
    @CupidDBFunction("datetimeFormat")
    public String datetimeFormat(String dtStr, String format) throws DateTimeException {
        LocalDateTime localDateTime = toDateTime(dtStr);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format.trim());
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * get hour value of datetime
     * @param localDateTime datetime
     * @return hour value
     */
    @CupidDBFunction("hour")
    public int hour(LocalDateTime localDateTime) {
        return localDateTime.getHour();
    }

    /**
     * get hour value of datetime
     * @param dtString datetime string
     * @return hour value
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("hour")
    public int hour(String dtString) throws DateTimeException {
        return toDateTime(dtString).getHour();
    }

    /**
     * get minute value of datetime
     * @param localDateTime datetime
     * @return minute value
     */
    @CupidDBFunction("minute")
    public int minute(LocalDateTime localDateTime) {
        return localDateTime.getMinute();
    }

    /**
     * get minute value of datetime
     * @param dtString datetime string
     * @return minute value
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("minute")
    public int minute(String dtString) throws DateTimeException {
        return toDateTime(dtString).getMinute();
    }

    /**
     * get second value of datetime
     * @param localDateTime datetime
     * @return second value
     */
    @CupidDBFunction("second")
    public int second(LocalDateTime localDateTime) {
        return localDateTime.getSecond();
    }

    /**
     * get second value of datetime
     * @param dtString datetime string
     * @return second value
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("second")
    public int second(String dtString) throws DateTimeException {
        return toDateTime(dtString).getSecond();
    }

    /**
     * get week value of the year
     * @param localDateTime datetime
     * @return week of the year
     */
    @CupidDBFunction("week")
    public int week(LocalDateTime localDateTime) {
        WeekFields weekFields = WeekFields.ISO;
        return localDateTime.get(weekFields.weekBasedYear());
    }

    /**
     * get week value of the year
     * @param dtString datetime string
     * @return week of the year
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("week")
    public int week(String dtString) throws DateTimeException {
        WeekFields weekFields = WeekFields.ISO;
        return toDateTime(dtString).get(weekFields.weekOfYear());
    }

    /**
     * get month of the year
     * @param localDateTime datetime
     * @return month of the year
     */
    @CupidDBFunction("month")
    public int month(LocalDateTime localDateTime) {
        return localDateTime.getMonth().getValue();
    }

    /**
     * get month of the year
     * @param dtString datetime instance
     * @return month of the year
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("month")
    public int month(String dtString) throws DateTimeException {
        return toDateTime(dtString).getMonth().getValue();
    }

    /**
     * get year value
     * @param localDateTime datetime
     * @return year value
     */
    @CupidDBFunction("year")
    public int year(LocalDateTime localDateTime) {
        return localDateTime.getYear();
    }

    /**
     * get year value
     * @param dtString datetime string
     * @return year value
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("year")
    public int year(String dtString) throws DateTimeException {
        return toDateTime(dtString).getYear();
    }

    /**
     * get day of month
     * @param localDateTime datetime
     * @return day of month
     */
    @CupidDBFunction("dayOfMonth")
    public int dayOfMonth(LocalDateTime localDateTime) {
        return localDateTime.getDayOfMonth();
    }

    /**
     * get day of month
     * @param dtString datetime string
     * @return day of month
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("dayOfMonth")
    public int dayOfMonth(String dtString) throws DateTimeException {
        return toDateTime(dtString).getDayOfMonth();
    }

    /**
     * get day of week
     * @param localDateTime datetime
     * @return day of week
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("dayOfWeek")
    public int dayOfWeek(LocalDateTime localDateTime) {
        return localDateTime.getDayOfWeek().getValue();
    }

    /**
     * get day of week
     * @param dtString datetime string
     * @return day of week
     * @throws DateTimeException parse exception
     */
    @CupidDBFunction("dayOfWeek")
    public int dayOfWeek(String dtString) throws DateTimeException {
        return toDateTime(dtString).getDayOfWeek().getValue();
    }

    /**
     * get day of year
     * @param localDateTime datetime
     * @return day of year
     */
    @CupidDBFunction("dayOfYear")
    public int dayOfYear(LocalDateTime localDateTime) {
        return localDateTime.getDayOfYear();
    }

    /**
     * get day of year
     * @param dtString datetime string
     * @return day of year
     * @throws DateTimeException parse Exception
     */
    @CupidDBFunction("dayOfYear")
    public int dayOfYear(String dtString) throws DateTimeException {
        return toDateTime(dtString).getDayOfYear();
    }

    @CupidDBFunction("now")
    public String now() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMATS[1]);
        return LocalDateTime.now().format(formatter);
    }
}

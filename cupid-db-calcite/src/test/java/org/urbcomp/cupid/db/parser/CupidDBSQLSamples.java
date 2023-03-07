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

package org.urbcomp.cupid.db.parser;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * CUPID-DB sql samples used in tests.
 */
public class CupidDBSQLSamples {

    // Show databases
    public static final String SHOW_DATABASES = "SHOW DATABASES";

    // Show tables
    public static final String SHOW_TABLES = "SHOW TABLES";

    // Show index
    public static final String SHOW_INDEX = "SHOW INDEX FROM table_name";

    // Describe
    public static final String DESCRIBE_TABLE_SAMPLE = "DESCRIBE table_name";

    // Truncate
    public static final String TRUNCATE_TABLE_SAMPLE = "TRUNCATE TABLE table_name";

    // Create database
    public static final String CREATE_DATABASE_SAMPLE = "CREATE DATABASE database_name;";
    public static final String CREATE_DATABASE_IF_NOT_EXISTS_SAMPLE =
        "CREATE DATABASE IF NOT EXISTS database_name;";

    // Use database
    public static final String USE_DATABASE_SAMPLE = "USE DATABASE database_name;";

    // Drop database
    public static final String DROP_DATABASE_SAMPLE = "DROP DATABASE database_name;";

    // Drop table
    public static final String DROP_TABLE_IF_EXISTS_SAMPLE = "DROP TABLE IF EXISTS table_name;";

    // Delete sample
    public static final String DELETE_SAMPLE =
        "DELETE FROM table_name WHERE attribute='attribute_value'";

    // Show create table
    public static final String SHOW_CREATE_TABLE_SAMPLE = "SHOW CREATE TABLE table_name";

    // Update table
    public static final String UPDATE_SAMPLE = loadSample("update-table");

    // Create table
    public static final String CREATE_TABLE_SAMPLE = loadSample("create-table");

    // Create table with index
    public static final String CREATE_TABLE_WITH_INDEX = loadSample("create-table-with-index");

    // Create user
    public static final String CREATE_USER_SAMPLE =
        "CREATE USER test_user IDENTIFIED BY 'password'";

    private static String loadSample(String resource) {
        String path = "/sql/samples/" + resource + ".sample.sql";
        try {
            InputStream input = CupidDBSQLSamples.class.getResourceAsStream(path);
            if (input == null) {
                throw new IllegalArgumentException("resource not found " + resource);
            }
            BufferedInputStream bis = new BufferedInputStream(input);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            for (int result = bis.read(); result != -1; result = bis.read()) {
                buf.write((byte) result);
            }
            return buf.toString(StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            throw new IllegalArgumentException("resource read error " + resource, e);
        }
    }
}

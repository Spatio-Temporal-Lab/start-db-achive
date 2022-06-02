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

package org.urbcomp.start.db.util;

import org.locationtech.jts.util.Assert;

/**
 * @author jimo
 **/
public class MetadataUtil {

    private static final String UDT_SPLITTER = ".";

    /**
     * combine to an unique key
     */
    public static String combineUserDbTableKey(String user, String db, String table) {
        return user + UDT_SPLITTER + db + UDT_SPLITTER + table;
    }

    /**
     * split the user db table key
     */
    public static UserDbTable splitUserDbTable(String key) {
        Assert.isTrue(key != null && key.length() > 0, "key is empty");
        final String[] items = key.split("\\" + UDT_SPLITTER);
        switch (items.length) {
            case 1:
                return new UserDbTable(null, null, items[0]);
            case 2:
                return new UserDbTable(null, items[0], items[1]);
            default:
                return new UserDbTable(
                    items[items.length - 3],
                    items[items.length - 2],
                    items[items.length - 1]
                );
        }
    }

    /**
     * geomesa catalog
     */
    public static String makeCatalog(String user, String db) {
        return user + UDT_SPLITTER + db;
    }
}

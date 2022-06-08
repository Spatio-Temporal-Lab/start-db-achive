/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
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
     * combine to a user-db key
     */
    public static String combineUserDbKey(String user, String db) {
        return user + UDT_SPLITTER + db;
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

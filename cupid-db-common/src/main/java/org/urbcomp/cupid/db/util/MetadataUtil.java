/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.util;

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

    /**
     * Internal schema name spec
     */
    public static String makeSchemaName(long tableId) {
        return String.format("t_%d", tableId);
    }
}

package org.urbcomp.start.db.metadata;

import org.locationtech.jts.util.Assert;
import org.urbcomp.start.db.metadata.entity.UserDbTable;

/**
 * @author jimo
 **/
public class MetadataUtil {

    private static final String UDT_SPLITTER = "\\.";

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
        final String[] items = key.split(UDT_SPLITTER);
        switch (items.length) {
            case 1:
                return new UserDbTable(null, null, items[0]);
            case 2:
                return new UserDbTable(null, items[0], items[1]);
            default:
                return new UserDbTable(items[items.length - 3], items[items.length - 2], items[items.length - 1]);
        }
    }
}

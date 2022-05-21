package org.urbcomp.start.db.metadata;

import org.urbcomp.start.db.metadata.accessor.DatabaseAccessor;
import org.urbcomp.start.db.metadata.accessor.FieldAccessor;
import org.urbcomp.start.db.metadata.accessor.TableAccessor;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;

/**
 * This is a class that manages accessor instances through factory mode.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class AccessorFactory {

    /**
     * get UserAccessor
     * @return  UserAccessor
     */
    public static UserAccessor getUserAccessor() {
        return new UserAccessor();
    }

    /**
     * get DatabaseAccessor
     * @return  DatabaseAccessor
     */
    public static DatabaseAccessor getDatabaseAccessor() { return new DatabaseAccessor(); }

    /**
     * get TableAccessor
     * @return  TableAccessor
     */
    public static TableAccessor getTableAccessor() { return new TableAccessor(); }

    /**
     * get FieldAccessor
     * @return  FieldAccessor
     */
    public static FieldAccessor getFieldAccessor() { return new FieldAccessor(); }
}

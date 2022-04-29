package org.urbcomp.start.db.metadata;

import org.urbcomp.start.db.metadata.accessor.UserAccessor;

/**
 * This is a class that manages accessor instances through factory mode.
 *
 * @author zaiyuan
 * @date 2022-03-27 15:17:07
 */
public class AccessorFactory {

    /**
     * get UserAccessor
     * @return  UserAccessor
     */
    public static UserAccessor getUserAccessor() {
        return new UserAccessor();
    }
}

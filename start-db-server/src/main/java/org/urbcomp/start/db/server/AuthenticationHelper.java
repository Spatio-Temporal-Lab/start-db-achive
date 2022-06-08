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

package org.urbcomp.start.db.server;

import org.urbcomp.start.db.metadata.AccessorFactory;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;
import org.urbcomp.start.db.metadata.entity.User;
import org.urbcomp.start.db.util.DigestUtil;

/**
 * @author jimo
 **/
public class AuthenticationHelper {

    public static boolean auth(String username, String password) {
        // TODO cache
        try (final UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            final User user = userAccessor.selectByFidAndName(0, username, true);
            return user != null && user.getPassword().equals(DigestUtil.md5(password));
        }
    }
}

/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.server;

import org.urbcomp.cupid.db.metadata.MetadataAccessUtil;
import org.urbcomp.cupid.db.metadata.entity.User;
import org.urbcomp.cupid.db.util.DigestUtil;

/**
 * @author jimo
 **/
public class AuthenticationHelper {

    public static boolean auth(String username, String password) {
        final User user = MetadataAccessUtil.getUser(username);
        return user != null && user.getPassword().equals(DigestUtil.md5(password));
    }
}

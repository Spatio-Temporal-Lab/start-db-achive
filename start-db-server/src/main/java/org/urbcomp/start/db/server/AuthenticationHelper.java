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

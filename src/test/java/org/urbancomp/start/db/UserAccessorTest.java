package org.urbancomp.start.db;

import org.junit.Test;
import org.urbcomp.start.db.metadata.AccessorFactory;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;

import static org.junit.Assert.assertTrue;

public class UserAccessorTest {
    @Test
    public void userTest() {
        try (UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            userAccessor.selectAll();
            assertTrue(true);
        }
    }
}

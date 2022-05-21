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

package org.urbancomp.start.db;

import org.junit.Test;
import org.urbcomp.start.db.metadata.AccessorFactory;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;

import static org.junit.Assert.assertTrue;

public class UserAccessorTest {

    @Test
    public void userTest() {
        try (UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            // Online MySQL server is not ready.
            // userAccessor.selectAll();
            assertTrue(true);
        }
    }
}

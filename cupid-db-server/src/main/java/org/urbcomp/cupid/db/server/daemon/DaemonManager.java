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

package org.urbcomp.cupid.db.server.daemon;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * daemon thread manager
 *
 * @author jimo
 **/
@Slf4j
public class DaemonManager {

    private final static ExecutorService POOL = Executors.newFixedThreadPool(
        1,
        new ThreadFactoryBuilder().setNameFormat("DB-DAEMON-%d").build()
    );

    public static void start() {
        POOL.execute(new CleanMetadataTask());
        log.info("clean metadata task started");
    }
}

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

package org.urbcomp.start.db.server.daemon;

import lombok.extern.slf4j.Slf4j;
import org.urbcomp.start.db.metadata.MetadataAccessUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jimo
 **/
@Slf4j
public class CleanMetadataTask implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void run() {
        while (running.get()) {
            try {
                doClean();
                int intervalS = 30;
                TimeUnit.SECONDS.sleep(intervalS);
            } catch (InterruptedException e) {
                // ignore
            } catch (Exception e) {
                log.warn("Clean Task Error", e);
            }
        }
    }

    void doClean() {
        // clean must obey the order: user,db,table,(field | index)
        log.info("Clean User Record:{}", MetadataAccessUtil.cleanUser());
        log.info("Clean DB Record:{}", MetadataAccessUtil.cleanDatabase());
        log.info("Clean Table Record:{}", MetadataAccessUtil.cleanTable());
        log.info("Clean Field Record:{}", MetadataAccessUtil.cleanField());
        log.info("Clean Index Record:{}", MetadataAccessUtil.cleanIndex());
    }
}

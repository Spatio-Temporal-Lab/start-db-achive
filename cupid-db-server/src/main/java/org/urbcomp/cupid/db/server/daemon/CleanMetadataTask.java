/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.server.daemon;

import lombok.extern.slf4j.Slf4j;
import org.urbcomp.cupid.db.metadata.MetadataAccessUtil;

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

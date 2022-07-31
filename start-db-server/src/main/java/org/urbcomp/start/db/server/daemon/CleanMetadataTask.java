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
        // clean must obey the order: user,db,table,(field | index)
        while (running.get()) {
            try {
                MetadataAccessUtil.cleanUser();
                MetadataAccessUtil.cleanDatabase();
                MetadataAccessUtil.cleanTable();
                MetadataAccessUtil.cleanFiled();
                MetadataAccessUtil.cleanIndex();
                int intervalS = 30;
                TimeUnit.SECONDS.sleep(intervalS);
            } catch (InterruptedException e) {
                // ignore
            } catch (Exception e) {
                log.warn("Clean Task Error", e);
            }
        }
    }
}

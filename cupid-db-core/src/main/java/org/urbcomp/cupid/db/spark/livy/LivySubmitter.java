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

package org.urbcomp.cupid.db.spark.livy;

import lombok.extern.slf4j.Slf4j;
import org.urbcomp.cupid.db.spark.ISparkSubmitter;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 维持至少有一个livy session运行
 *
 * @author jimo
 **/
@Slf4j
public class LivySubmitter implements ISparkSubmitter {

    private int sessionId;
    private final String DEFAULT_KIND = "spark";
    private final String SPLITTER = "_";
    /**
     * 每次轮询的间隔时长
     */
    private final int sleepMs;
    /**
     * 最大同步等待时长
     */
    private final int maxWaitTimeMs;

    private final LivyRestApi restApi;

    /**
     * 控制在session更新或不可用时，执行语句必须等待
     */
    private final ReentrantReadWriteLock sessionLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock sessionReadLock = sessionLock.readLock();
    private final ReentrantReadWriteLock.WriteLock sessionWriteLock = sessionLock.writeLock();

    public LivySubmitter() {
        this(new LivyRestApi(), true);
    }

    public LivySubmitter(LivyRestApi restApi, boolean checkSession) {
        this.sleepMs = 300;
        this.maxWaitTimeMs = 120 * 1000;
        this.restApi = restApi;

        if (checkSession) {
            ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
            pool.scheduleAtFixedRate(new CheckSessionTask(), 0, 3, TimeUnit.SECONDS);
        }
    }

    private class CheckSessionTask implements Runnable {

        @Override
        public void run() {
            System.out.println("执行：" + sessionId + "," + restApi);
            try {
                final LivySessionResult session = restApi.getSession(sessionId);
                final LivySessionState state = LivySessionState.valueOf(session.getState());
                if (!state.ok()) {
                    // 先锁住，然后重新选择或创建一个session
                    sessionWriteLock.lock();
                    try {
                        boolean chosen = false;
                        final List<LivySessionResult> sessions = restApi.getSessions();
                        for (LivySessionResult s : sessions) {
                            final LivySessionState theState = LivySessionState.valueOf(
                                s.getState()
                            );
                            if (theState.ok()) {
                                sessionId = s.getId();
                                chosen = true;
                                break;
                            }
                        }
                        if (!chosen) {
                            // TODO
                            final LivySessionResult res = restApi.createSession(
                                LivySessionParam.builder()
                                    .kind(DEFAULT_KIND)
                                    .driverCores(1)
                                    .driverMemory("1G")
                                    .numExecutors(1)
                                    .executorCores(1)
                                    .executorMemory("1G")
                                    .jars(Arrays.asList("", ""))
                                    .build()
                            );
                            waitSessionOk(res.getId());
                            sessionId = res.getId();
                        }
                    } finally {
                        sessionWriteLock.unlock();
                    }
                }
            } catch (Exception e) {
                log.warn("Check Livy Session Error", e);
            }
        }

        private void waitSessionOk(int id) {

        }
    }

    private String buildSqlId(int statementId) {
        return System.currentTimeMillis() + SPLITTER + statementId;
    }

    private int extractStatementId(String sqlId) {
        final String[] items = sqlId.split(SPLITTER);
        if (items.length == 2) {
            return Integer.parseInt(items[1]);
        }
        throw new IllegalArgumentException("InValid SqlId:" + sqlId);
    }

    @Override
    public String submit(SparkSqlParam param) {
        sessionReadLock.lock();
        try {
            String code = ""; // TODO
            final LivyStatementResult res = restApi.executeStatement(
                sessionId,
                LivyStatementParam.builder().kind(DEFAULT_KIND).code(code).build()
            );
            return buildSqlId(res.getId());
        } finally {
            sessionReadLock.unlock();
        }
    }

    @Override
    public void waitToFinish(String id) throws TimeoutException {
        final int statementId = extractStatementId(id);

        int attemptTime = 0;
        try {
            while (attemptTime < maxWaitTimeMs) {
                sessionReadLock.lock();
                final LivyStatementResult res;
                try {
                    res = restApi.getStatement(sessionId, statementId);
                } finally {
                    sessionReadLock.unlock();
                }
                final LivyStatementState state = LivyStatementState.valueOf(res.getState());
                switch (state) {
                    case available:
                        return;
                    case error:
                    case cancelling:
                    case cancelled:
                        throw new RuntimeException("Execute Failed: " + res);
                    default:
                }
                attemptTime += sleepMs;
                TimeUnit.MILLISECONDS.sleep(sleepMs);
            }
            throw new TimeoutException("Exceed maxWaitTime:" + maxWaitTimeMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

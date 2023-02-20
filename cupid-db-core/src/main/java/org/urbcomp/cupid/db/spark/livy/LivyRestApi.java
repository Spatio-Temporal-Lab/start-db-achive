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
import org.urbcomp.cupid.db.config.DynamicConfig;
import org.urbcomp.cupid.db.util.HTTPUtil;
import org.urbcomp.cupid.db.util.JacksonUtil;

import java.io.IOException;

/**
 * @author jimo
 **/
@Slf4j
public class LivyRestApi {
    private static final String livyUrl = DynamicConfig.getLivyUrl();

    public static LivySessionResult createSession(LivySessionParam param) {
        try {
            final String s = HTTPUtil.post(livyUrl + "/sessions", param.toJsonBody());
            final LivySessionResult res = JacksonUtil.MAPPER.readValue(s, LivySessionResult.class);
            if (res != null) {
                return res;
            }
        } catch (IOException e) {
            log.error("create livy session failed", e);
        }
        throw new RuntimeException("create session failed");
    }

    public static LivyStatementResult executeStatement(int sessionId, LivyStatementParam param) {
        try {
            final String s = HTTPUtil.post(
                livyUrl + "/" + sessionId + "/statements",
                param.toJsonBody()
            );
            final LivyStatementResult res = JacksonUtil.MAPPER.readValue(
                s,
                LivyStatementResult.class
            );
            if (res != null) {
                return res;
            }
        } catch (IOException e) {
            log.error("create livy statement failed", e);
        }
        throw new RuntimeException("create statement failed");
    }

    public static LivyStatementResult getStatement(int sessionId, int statementId) {
        try {
            final String s = HTTPUtil.get(
                String.format("%s/sessions/%s/statements/%s", livyUrl, sessionId, statementId)
            );
            final LivyStatementResult res = JacksonUtil.MAPPER.readValue(
                s,
                LivyStatementResult.class
            );
            if (res != null) {
                return res;
            }
        } catch (IOException e) {
            log.error("get livy statement failed", e);
        }
        throw new RuntimeException("get statement failed");
    }

}

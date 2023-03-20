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
package org.urbcomp.cupid.db.spark.livy;

import lombok.extern.slf4j.Slf4j;
import org.urbcomp.cupid.db.config.DynamicConfig;
import org.urbcomp.cupid.db.util.HTTPUtil;
import org.urbcomp.cupid.db.util.JacksonUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author jimo
 **/
@Slf4j
public class LivyRestApi {
    private final String livyUrl = DynamicConfig.getLivyUrl();

    public List<LivySessionResult> getSessions() {
        try {
            final String s = HTTPUtil.get(livyUrl + "/sessions?from=0&size=10");
            final LivySessionsResult res = JacksonUtil.MAPPER.readValue(
                s,
                LivySessionsResult.class
            );
            if (res != null) {
                return res.getSessions();
            }
        } catch (IOException e) {
            log.error("get livy sessions failed", e);
        }
        throw new RuntimeException("get sessions failed");
    }

    public LivySessionResult getSession(int sessionId) {
        try {
            final String s = HTTPUtil.get(livyUrl + "/sessions/" + sessionId);
            final LivySessionResult res = JacksonUtil.MAPPER.readValue(s, LivySessionResult.class);
            if (res != null) {
                return res;
            }
        } catch (IOException e) {
            log.error("get livy sessions failed", e);
        }
        throw new RuntimeException("get sessions failed");
    }

    public LivySessionResult createSession(LivySessionParam param) {
        try {
            final String s = HTTPUtil.post(livyUrl + "/sessions/", param.toJsonBody());
            final LivySessionResult res = JacksonUtil.MAPPER.readValue(s, LivySessionResult.class);
            if (res != null) {
                return res;
            }
        } catch (IOException e) {
            log.error("create livy session failed", e);
        }
        throw new RuntimeException("create session failed");
    }

    public LivyStatementResult executeStatement(int sessionId, LivyStatementParam param) {
        try {
            final String s = HTTPUtil.post(
                livyUrl + "/sessions/" + sessionId + "/statements",
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

    public LivyStatementResult getStatement(int sessionId, int statementId) {
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

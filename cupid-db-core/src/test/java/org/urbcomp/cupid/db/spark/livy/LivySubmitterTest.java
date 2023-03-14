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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.urbcomp.cupid.db.spark.SubmitResult;
import org.urbcomp.cupid.db.util.SparkSqlParam;

import java.util.concurrent.TimeoutException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class LivySubmitterTest {

    @Mock
    private LivyRestApi livyRestApi;

    @Test
    public void test() throws TimeoutException, InterruptedException {
        LivySubmitter submitter = new LivySubmitter(livyRestApi, false);
        final int sessionId = 0;
        final int statementId = 1;
        doReturn(LivyStatementResult.builder().id(statementId).state("available").build()).when(
            livyRestApi
        ).executeStatement(anyInt(), any(LivyStatementParam.class));
        final SubmitResult submitResult = submitter.submit(new SparkSqlParam());

        doReturn(LivyStatementResult.builder().id(statementId).state("available").build()).when(
            livyRestApi
        ).getStatement(sessionId, statementId);
        submitter.waitToFinish(submitResult);
    }
}

package org.urbcomp.cupid.db.spark.livy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
        doReturn(LivySessionResult.builder().id(sessionId).state("idle").build()).when(livyRestApi).getSession(anyInt());

        final int statementId = 1;
        doReturn(LivyStatementResult.builder()
                .id(statementId)
                .state("available")
                .build()).when(livyRestApi).executeStatement(anyInt(), any(LivyStatementParam.class));
        final String sqlId = submitter.submit(new SparkSqlParam());

        doReturn(LivyStatementResult.builder()
                .id(statementId)
                .state("available")
                .build()).when(livyRestApi).getStatement(sessionId, statementId);
        submitter.waitToFinish(sqlId);
    }
}
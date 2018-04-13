package by.dm13y.sketch.concurrency.forkjointhreadpool.recursive_action;

import org.junit.Test;

public class RecursiveExecutorTest {
    @Test
    public void executeTask() throws Exception {
        new ForkJoinPollExecutor().executeTask();
    }

}
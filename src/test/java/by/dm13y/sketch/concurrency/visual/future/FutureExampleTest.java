package by.dm13y.sketch.concurrency.visual.future;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class FutureExampleTest {
    FutureExample futureExample;

    @Before
    public void init(){
        futureExample = new FutureExample();
    }

    public Callable<Integer> getCallable(){
        Callable<Integer> future = () -> {
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception ex) {;
                ex.printStackTrace();
            }
            return 1000;
        };

        return future;
    }

    @Test
    public void execFutureSample1() throws Exception {
        Callable<Integer> callable = getCallable();

        futureExample.execFutureSample1(callable);
        System.out.println("task_sample1_is_done:" + callable.call());

    }

    @Test
    public void execFutureSample2() throws Exception {
        Callable<Integer> callable = getCallable();

        futureExample.execFutureSample2(getCallable());
        System.out.println("task_sample2_is_done:" + callable.call());
    }

}
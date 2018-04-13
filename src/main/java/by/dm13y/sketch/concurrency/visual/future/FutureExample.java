package by.dm13y.sketch.concurrency.visual.future;


import java.util.concurrent.*;

public class FutureExample {
    private final Executor executor = Executors.newCachedThreadPool();

    public void execFutureSample1(Callable someCallable){
        System.out.println("task_sample1_is_start");
        FutureTask<Callable> future =
                new FutureTask<Callable>(someCallable);
        Thread thread = new Thread(future);
        thread.start();
    }

    public void execFutureSample2(Callable<Integer> someCallable){
        System.out.println("task_sample2_is_start");
        ((ThreadPoolExecutor) executor).submit(someCallable);
    }
}

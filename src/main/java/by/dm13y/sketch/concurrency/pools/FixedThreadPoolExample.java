package by.dm13y.sketch.concurrency.pools;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExample {
    public final Executor executor;

    public FixedThreadPoolExample(int poolCapacity, boolean prestartAllCore){
        executor = Executors.newFixedThreadPool(poolCapacity);
        if(prestartAllCore) {
            ((ThreadPoolExecutor) executor).prestartAllCoreThreads();
        }
    }

    public FixedThreadPoolExample(){
        this(4, true);
    }

    public void execTask(Runnable runnable){
        executor.execute(runnable);
    }

    public boolean isActive(){
        return ((ThreadPoolExecutor) executor).getActiveCount() > 0;
    }


}


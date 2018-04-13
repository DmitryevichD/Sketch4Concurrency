package by.dm13y.sketch.concurrency.forkjointhreadpool.recursive_action;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPollExecutor {
    private final ForkJoinPool pool = new ForkJoinPool(4);

    public void executeTask() throws Exception{
        RecursiveTaSKExample task1 = new RecursiveTaSKExample(1000, "task1");
        RecursiveTaSKExample task2 = new RecursiveTaSKExample(1000, "task2");
        RecursiveTaSKExample task3 = new RecursiveTaSKExample(5000, "task3");
        RecursiveTaSKExample task4 = new RecursiveTaSKExample(7000, "task4");
        ForkJoinTask<Integer> task5 = ForkJoinTask.adapt(() -> {
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return 1000;
        });
        ForkJoinTask<Integer> task6 = ForkJoinTask.adapt(() -> {
            try {
                Thread.currentThread().sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return 4000;
        });


        pool.submit(task1);
        System.out.println("recursiveAction1 is submit (current thread is not wait execution)");
        pool.invoke(task2);
        System.out.println("recursiveAction2 is invoke (current thread is wait execution)");

        pool.submit(task5);
        Integer val = task5.get();
        System.out.println("forkjointask1 is done " + val);
        pool.invoke(task6);
        Integer val1 = task6.get();
        System.out.println("forkjointask2 is done " + val1);

    }
}

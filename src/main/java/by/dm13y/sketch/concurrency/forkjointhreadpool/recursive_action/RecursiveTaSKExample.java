package by.dm13y.sketch.concurrency.forkjointhreadpool.recursive_action;

import java.util.concurrent.RecursiveAction;

public class RecursiveTaSKExample extends RecursiveAction{
    private final int pause;
    private final String name;

    public RecursiveTaSKExample(int pause, String name) {
        this.pause = pause;
        this.name = name;
    }

    @Override
    protected void compute() {
        try {
            System.out.println("name:" + name);
            Thread.currentThread().sleep(pause);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

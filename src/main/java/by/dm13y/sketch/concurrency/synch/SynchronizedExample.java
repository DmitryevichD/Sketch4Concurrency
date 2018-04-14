package by.dm13y.sketch.concurrency.synch;

public class SynchronizedExample {
    public synchronized void synchTest(){
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        if (name.contains("wait")) {
            System.out.println("start_wait_sync_thread:" + id);
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("interrupted_thread:" + id);
            }
            System.out.println("end_wait_sync_thread:" + id);
        }

        if(name.contains("notify")){
            System.out.println("start_notify_sync_thread:" + id);
            notify();
            System.out.println("end_notify_sync_thread:" + id);
        }
    }

    public static void main(String[] args) throws Exception {
        SynchronizedExample tst = new SynchronizedExample();
        Thread thread1 = new Thread(() -> tst.synchTest());
        thread1.setName("wait1");
        thread1.start();
        Thread thread2 = new Thread(() -> tst.synchTest());
        thread2.setName("notify1");
        thread2.start();

        Thread threadInterrupt = new Thread(() -> tst.synchTest());
        threadInterrupt.setName("waitInterrupt");
        threadInterrupt.start();
        System.out.printf("\n");
        Thread.currentThread().sleep(1000);
        threadInterrupt.interrupt();

    }
}

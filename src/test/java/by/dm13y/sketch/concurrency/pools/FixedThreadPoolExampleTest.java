package by.dm13y.sketch.concurrency.pools;

import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class FixedThreadPoolExampleTest {
    @Test
    public void execTask() throws Exception {
        FixedThreadPoolExample pool = new FixedThreadPoolExample();
        for (int i = 0; i < 10; i++) {
            final int numThread = i;
            pool.execTask(() -> {
                try {
                    System.out.println("start:" + numThread);
                    sleep(1000);
                    System.out.println("  end:" + numThread);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        }

        while(pool.isActive()){
            sleep(10);
        }

    }

}
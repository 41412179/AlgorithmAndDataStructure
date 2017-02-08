package java并发学习.countDownLatchDemo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by h on 17-2-8.
 */
public class CountDownLatchDemo implements Runnable {
    private CountDownLatch countDownLatch = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getName() + " done");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatchDemo c = new CountDownLatchDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(c).start();
        }
        try {
            c.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all done!");
    }
}

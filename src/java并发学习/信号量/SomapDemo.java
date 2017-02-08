package java并发学习.信号量;

import java.util.concurrent.Semaphore;

/**
 * Created by h on 17-2-8.
 */
public class SomapDemo implements Runnable {
    private final Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {

    }

    @Override
    public void run() {
        try {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            semaphore.release();
        }
    }
}

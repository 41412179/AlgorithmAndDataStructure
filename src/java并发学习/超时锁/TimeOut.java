package java并发学习.超时锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by h on 17-2-8.
 */
public class TimeOut implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t = new Thread(new TimeOut());
        Thread t1 = new Thread(new TimeOut());

        t.start();
        t1.start();

    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("Time out");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            } else {
            }
        }
    }
}

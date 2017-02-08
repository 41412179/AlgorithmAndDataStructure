package java并发学习.可中断的Ｌｏｃｋ;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by h on 17-2-7.
 */
class IntruptReentrantLock implements Runnable {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int lock = 0;

    IntruptReentrantLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (1 == lock) {
            try {
                lock1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new IntruptReentrantLock(1));
        Thread t2 = new Thread(new IntruptReentrantLock(2));
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

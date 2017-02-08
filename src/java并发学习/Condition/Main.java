package java并发学习.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition con = lock.newCondition();

    public static void main(String[] args) {
        Thread t = new Thread(new Main());
        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println("Main thread sleep 1s");
        con.signal();//con只有在拿到锁后才能使用！
        lock.unlock();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            con.await();
            //Thread.sleep(1000);
            System.out.println("this thread sleep 1s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}

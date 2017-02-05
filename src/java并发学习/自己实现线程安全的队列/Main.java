package java并发学习.自己实现线程安全的队列;

import java.util.LinkedList;

/**
 * Created by h on 17-2-2.
 */
class MyQueue {
    int sum = 100;
    LinkedList<Integer> lls = new LinkedList<>();

    public Integer get() {
        synchronized (lls) {
            while (lls.size() <= 0) {
                try {
                    lls.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lls.notify();
        }

        return lls.remove(0);
    }

    public void put(int i) {
        synchronized (lls) {
            while (lls.size() >= sum) {
                try {
                    lls.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lls.notify();
            lls.add(i);
            System.out.println("put " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("get " + q.get());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    q.put(i);

                }
            }
        });
        t1.start();
        t2.start();
    }
}

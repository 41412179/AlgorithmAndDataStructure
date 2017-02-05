package java并发学习.实现一个无锁的栈;

import java.util.LinkedList;

class MyStack {
    private volatile LinkedList<Integer> lls = new LinkedList<>();
    private static final int UP_LIMIT = 100;

    public void push(int i) {
        for (; ; ) {
            if (lls.size() < UP_LIMIT) {

            }
        }
    }


}

public class Main {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                }
            }
        }).start();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {

                    }
                }
            }).start();
        }
    }
}

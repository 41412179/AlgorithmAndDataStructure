package java并发学习.汇智网;


public class Main {
    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + " T1 waite");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T1 end");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T2 start");
                object.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T2 end");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new T1();
        Thread thread2 = new T2();
        thread1.start();
        thread2.start();
    }
}

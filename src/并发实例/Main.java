package 并发实例;

class Test implements Runnable {
    private UnsafeSequence us = new UnsafeSequence();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(us.getNext());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}

public class Main {

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.run();

        t2.run();


    }

}

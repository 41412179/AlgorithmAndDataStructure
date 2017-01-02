package vectorTest;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by h on 16-12-24.
 */
public class VectorTest {
    private Vector vector = new Vector();
    public void add(int data1,int data2) throws InterruptedException {
        vector.add(data1);
        Thread.sleep(1000);
        vector.add(data2);
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"-get[0]:"+vector.get(0));
        System.out.println(Thread.currentThread().getName()+"-get[1]:"+vector.get(1));
        vector.clear();
    }
    public static void main(String[] args) throws InterruptedException {
        final VectorTest demo = new VectorTest();
        //demo = new VectorTest();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.add(1,2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.add(3,4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
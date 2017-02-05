package java并发学习.生产者消费者;

import java.util.HashSet;

class Ticket {
    static HashSet<Ticket> hs = new HashSet<>();
    static int start = 0;
    int id = 0;

    Ticket() {
        id = start++;
        System.out.println(id + " is created");
    }
}

class Shengchan implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Ticket.hs.isEmpty()) {
                Ticket.hs.add(new Ticket());
            }
        }
    }
}

class Xiaofei implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (!Ticket.hs.isEmpty()) {
                for (Ticket t :
                        Ticket.hs) {
                    Ticket.hs.remove(t);
                    System.out.println(t.id + " is removed");
                    break;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Thread(new Shengchan(), "shengchan").start();
        new Thread(new Xiaofei(), "xiaofei").start();
    }
}

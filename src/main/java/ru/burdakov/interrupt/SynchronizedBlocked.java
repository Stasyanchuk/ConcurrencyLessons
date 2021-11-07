package ru.burdakov.interrupt;

public class SynchronizedBlocked implements Runnable {

    public SynchronizedBlocked() {
        new Thread(this::f).start();
    }

    public  void f() {
        while (true) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run");
        System.out.println();
    }
}

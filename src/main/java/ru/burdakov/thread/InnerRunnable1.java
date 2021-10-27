package ru.burdakov.thread;

import java.util.concurrent.TimeUnit;

/**
 * Наркоманская реализация 3
 *
 * Использование именованной реализации Runnable:
 */
public class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }
}

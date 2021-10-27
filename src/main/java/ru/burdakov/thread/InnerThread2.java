package ru.burdakov.thread;

import java.util.concurrent.TimeUnit;

/**
 * Еще одна наркоманская реализация
 * Эккель курил, когда писал это
 *
 * Использование анонимного внутреннего класса
 */
public class InnerThread2 {

    private int countDown = 5;
    public Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
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
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }


}

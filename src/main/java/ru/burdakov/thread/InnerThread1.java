package ru.burdakov.thread;

import java.util.concurrent.TimeUnit;

/**
 * Реализация для наркоманов
 *
 * Использование именованного внутреннего класса
 */
public class InnerThread1 {

    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {

        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(this);
                    if(--countDown == 0){
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
    }
}

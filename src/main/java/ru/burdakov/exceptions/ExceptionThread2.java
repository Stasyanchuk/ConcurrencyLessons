package ru.burdakov.exceptions;

public class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        if (System.currentTimeMillis() % 2 == 0)
            throw new RuntimeException();
        else
            throw new IllegalArgumentException();

    }
}

package ru.burdakov.exceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new ExceptionThread());

        Thread t = new Thread(new ExceptionThread());
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t.start();
    }

}

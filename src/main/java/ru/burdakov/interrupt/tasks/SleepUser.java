package ru.burdakov.interrupt.tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SleepUser implements Runnable{

    private SleepClazz sleepClazz;

    public SleepUser() {
        sleepClazz = new SleepClazz();
    }

    @Override
    public void run() {
        sleepClazz.doSomething();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepUser());
        thread.start();

        TimeUnit.SECONDS.sleep(2);

        thread.interrupt();

        ExecutorService service = Executors.newCachedThreadPool();

        System.out.println();
        service.submit(new SleepUser());

        TimeUnit.SECONDS.sleep(2);

//        service.shutdownNow();


        System.out.println();
        Future<?> fut = service.submit(new SleepUser());

        TimeUnit.SECONDS.sleep(2);

        fut.cancel(true);

        service.shutdown();

    }
}

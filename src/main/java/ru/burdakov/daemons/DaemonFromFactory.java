package ru.burdakov.daemons;

import ru.burdakov.daemons.util.DaemonThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) {
        //Собственная реализация ThreadPoolExecutor, которая выполняет только потоки демоны
        ExecutorService executor = new DaemonThreadPoolExecutor();

        for (int i = 0; i < 20; i++) {
            executor.execute(new DaemonFromFactory());
        }

        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

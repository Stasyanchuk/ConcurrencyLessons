package ru.burdakov.daemons;

public class Daemon implements Runnable {

    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + threads[i].isDaemon() + ", ");
        }

        while (true)
            Thread.yield();
    }
}

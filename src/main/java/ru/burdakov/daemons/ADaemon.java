package ru.burdakov.daemons;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("Start ADaemon");
            TimeUnit.SECONDS.sleep(1);
            sayHello();
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }

    }

    private void sayHello(){
        try {
            System.out.println("HELLO");
        } finally {
            System.out.println("BYE BYE");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package ru.burdakov.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoreBasicThreads {

    public static void main(String[] args) {
        startThread();
    }


    private static void startThread(){
        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("Waiting LiftOff");
    }

    private static void startExecutor(){
        ExecutorService exec = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}

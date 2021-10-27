package ru.burdakov.example1;

import ru.burdakov.example1.util.RndmUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff{

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            try {

                TimeUnit.SECONDS.sleep(RndmUtil.getRandom0to10());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executor.execute(new SleepingTask());
        }
        executor.shutdown();
    }
}

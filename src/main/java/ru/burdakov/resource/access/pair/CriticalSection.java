package ru.burdakov.resource.access.pair;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {

    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService executor = Executors.newCachedThreadPool();

        PairManipulator pm1 = new PairManipulator(pman1);
        PairManipulator pm2 = new PairManipulator(pman2);

        PairChecker pcheck1 = new PairChecker(pman1);
        PairChecker pcheck2 = new PairChecker(pman2);

        executor.execute(pm1);
        executor.execute(pm2);
        executor.execute(pcheck1);
        executor.execute(pcheck2);

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pman1 = new PairManager1();
        PairManager pman2 = new PairManager2();

        testApproaches(pman1, pman2);
    }

}

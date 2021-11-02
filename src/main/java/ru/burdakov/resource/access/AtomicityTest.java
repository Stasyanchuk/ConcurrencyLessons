package ru.burdakov.resource.access;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 930. Ekkel Bryus - Java Philosophy
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        // я хз почему в этой книге всегда так while (true)
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        service.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}

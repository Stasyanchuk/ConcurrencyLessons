package ru.burdakov.resource.access;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private final ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
            System.out.println("in untimed() isLocked(): " + lock.isLocked());
            System.out.println();
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
            System.out.println("in timed() isLocked(): " + lock.isLocked());
            System.out.println();
        } finally {
            if (captured)
                lock.unlock();
        }
    }


    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("in run() isLocked(): " + al.lock.isLocked());
                System.out.println("acquired");
                System.out.println();
            }
        }.start();

        Thread.yield();

        al.untimed();
        al.timed();
    }
}

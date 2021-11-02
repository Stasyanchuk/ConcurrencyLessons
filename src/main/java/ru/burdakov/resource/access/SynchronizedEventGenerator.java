package ru.burdakov.resource.access;

/**
 * Правильное использование общедоступных ресурсов потоками
 * @see synchronized
 */
public class SynchronizedEventGenerator extends IntGenerator {

    private int currantValue = 0;

    @Override
    public synchronized int next() {
        ++currantValue;
        Thread.yield();
        ++currantValue;
        return currantValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedEventGenerator());
    }
}

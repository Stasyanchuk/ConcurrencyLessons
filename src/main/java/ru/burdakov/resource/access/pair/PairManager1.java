package ru.burdakov.resource.access.pair;

public class PairManager1 extends PairManager{

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

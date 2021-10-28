package ru.burdakov.resource.access;

public class EventGenerator extends IntGenerator{

    private int currentValue = 0;

    @Override
    public int next() {
        ++currentValue;
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EventGenerator());
    }
}

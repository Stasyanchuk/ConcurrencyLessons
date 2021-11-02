package ru.burdakov.resource.access.pair;

public class Pair {

    private int x, y;

    public Pair() {
        this(0, 0);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public void checkState(){
        if (x != y)
            throw new PairValuesNotEqualsException();
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualsException  extends RuntimeException{

        public PairValuesNotEqualsException() {
            super("Pair values not equal: " + Pair.this);
        }
    }
}

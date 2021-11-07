package ru.burdakov.interrupt;

public class CounterBlocked implements Runnable{


    @Override
    public void run() {
        int i = 0;
        while (true){
            System.out.println(i++);
        }
    }
}

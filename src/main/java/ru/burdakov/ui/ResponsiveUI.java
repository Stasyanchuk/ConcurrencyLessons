package ru.burdakov.ui;

import java.io.IOException;

public class ResponsiveUI extends Thread{

    private static volatile double d = 1;

    private static volatile boolean stop = false;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (!stop){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) {
        new ResponsiveUI();
//        new UnresponsiveUI(10);
        try {
            int read = System.in.read();
            System.out.println(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

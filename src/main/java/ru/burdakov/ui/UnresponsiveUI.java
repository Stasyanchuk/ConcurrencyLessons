package ru.burdakov.ui;

import java.io.IOException;

public class UnresponsiveUI {

    private volatile double d = 1;

    public UnresponsiveUI(double d) {
       while (d > 0) {
           d = d + (Math.PI + Math.E) / d;
       }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

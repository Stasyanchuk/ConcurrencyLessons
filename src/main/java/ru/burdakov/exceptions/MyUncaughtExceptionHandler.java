package ru.burdakov.exceptions;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (e instanceof IllegalArgumentException)
            System.out.println("ЧЕ ТА КАКАЯ ТО АШИБКА");
        else
            System.out.println("Thread: " + t + " caught " + e);
    }
}

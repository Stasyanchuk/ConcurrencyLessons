package ru.burdakov.interrupt.tasks;

import java.util.concurrent.TimeUnit;

public class SleepClazz {

    public void doSomething(){
        System.out.println("Start doSomething()");

        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Сработало прерывание");
        }

        System.out.println("Закончил выполнение");
    }

}

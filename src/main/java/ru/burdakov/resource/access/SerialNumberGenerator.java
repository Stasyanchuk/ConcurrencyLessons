package ru.burdakov.resource.access;

public class SerialNumberGenerator{

    private static volatile int serialNumber;

    /**
     * Не атомарная операция для volatile переменной
     * Лечится ключевым словом synchronized
     *
     * @return
     */
    public static int nextSerialNumber(){
        return serialNumber++;
    }

    public synchronized static int syncNextSerialNumber(){
        return serialNumber++;
    }

}

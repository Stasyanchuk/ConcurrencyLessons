package ru.burdakov.example1.util;

import java.util.Random;

public class RndmUtil {

    private static Random random = new Random();

    public static int getRandom0to10(){
        return random.nextInt(10);
    }

}

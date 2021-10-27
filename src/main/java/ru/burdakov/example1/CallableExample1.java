package ru.burdakov.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample1 implements Callable<Integer> {

    private int prevNumber1;
    private int prevNumber2;

    public CallableExample1(int prevNumber1, int prevNumber2) {
        this.prevNumber1 = prevNumber1;
        this.prevNumber2 = prevNumber2;
    }

    @Override
    public Integer call() throws Exception {
        int res = prevNumber1 + prevNumber2;
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<Integer>> result = new ArrayList<>();

        result.add(executor.submit(new CallableExample1(0, 1)));
        try {
            result.add(executor.submit(new CallableExample1(result.get(0).get(), 1)));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 20; i++) {
            try {
                result.add(executor.submit(new CallableExample1(result.get(i - 1).get(), result.get(i).get())));
//                result.add(executor.submit(new CallableExample1(2, 2)));
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        /*List<Integer> res = new ArrayList<>();
        res.add(fibonachi(0, 1));
        res.add(fibonachi(res.get(0), 1));

        for (int i = 1; i < 20; i++) {
            res.add(fibonachi(res.get(i-1), res.get(i)));
        }*/
    }

    private static int fibonachi(int x, int y){
        int i = x + y;
        System.out.println(i);
        return i;
    }
}

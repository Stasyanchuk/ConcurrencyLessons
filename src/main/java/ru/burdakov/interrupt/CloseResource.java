package ru.burdakov.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Прерывание заблокированной задачи посредством
 * закрытия ресурса, по которому она блокируется:
 * {RunByHand>
 */
public class CloseResource {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            ServerSocket server = new ServerSocket(8080);
            InputStream socketInput = new Socket("localhost", 8080).getInputStream();
            executor.execute(new IOBlocked(socketInput));
            executor.execute(new IOBlocked(System.in));

            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("Shutting down all threads");
            executor.shutdownNow();

            TimeUnit.SECONDS.sleep(1);
            System.out.println("Closing " + socketInput.getClass().getName());
            socketInput.close();

            TimeUnit.SECONDS.sleep(1);
            System.out.println("Closing " + System.in.getClass().getName());
            System.in.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
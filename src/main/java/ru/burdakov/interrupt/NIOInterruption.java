package ru.burdakov.interrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NIOInterruption {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            ServerSocket server = new ServerSocket(8080);

            InetSocketAddress isa = new InetSocketAddress("localhost", 8080);

            SocketChannel sc1 = SocketChannel.open(isa);
            SocketChannel sc2 = SocketChannel.open(isa);

            Future<?> f = service.submit(new NIOBlocked(sc1));
            service.execute(new NIOBlocked(sc2));

            service.shutdown();
            TimeUnit.SECONDS.sleep(1);
            f.cancel(true);

            TimeUnit.SECONDS.sleep(1);
            sc2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

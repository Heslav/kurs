package pl.programming4you.lectures5.lecture12.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

public class MyHttpServerStarter {
    private static final Logger logger = Logger.getLogger(HttpServer.class.getName());

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
            httpServer.createContext("/movie", new MyHttpHandler());
            httpServer.setExecutor(threadPoolExecutor);
            httpServer.start();
            logger.info("Server started on port: 8001");
        } catch (IOException e) {
            logger.info("Cannot create server. Make sure your internet connection and server values are good and try again.");
        }
    }
}

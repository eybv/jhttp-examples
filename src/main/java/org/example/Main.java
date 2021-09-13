package org.example;

import com.github.eybv.jhttp.HttpServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        try {
            HttpServer server = new HttpServer(8080);
            server.autoConfigure("com.github.eybv.jhttp", "org.example");
            server.serveForever();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

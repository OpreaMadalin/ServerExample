package com.company;

import com.company.server.ExampleServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ExampleServer exampleServer = new ExampleServer(31333);

        try {
            exampleServer.serveForever();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

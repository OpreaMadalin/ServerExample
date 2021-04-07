package com.company;

import com.company.client.ExampleClient;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ExampleClient exampleClient = new ExampleClient("localhost", 31333);

        try {
            exampleClient.sendStdinForever();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

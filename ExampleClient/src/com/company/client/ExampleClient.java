package com.company.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ExampleClient {

    private final String ip;
    private final int port;


    public ExampleClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void sendStdinForever() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while (true) {
            System.out.println("Connected!");
            System.out.println("Waiting for input...");
            String input = stdin.nextLine();
            System.out.println("Input received: " + input);
            dos.writeUTF(input);
            System.out.println("Input sent to server!");
            String str = dis.readUTF();
            System.out.println("Message received: " + str);

            if (input.equals("STOP")) {
                break;
            }
        }

        System.out.println("Stopping client...");
        dos.flush();
        dos.close();
        dis.close();
        socket.close();

    }

}

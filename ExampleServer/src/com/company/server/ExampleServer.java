package com.company.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ExampleServer {

    private final int port;

    public ExampleServer(int port) {
        this.port = port;
    }

    public void serveForever() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("Create server socket");
        System.out.println("Wait for a client!");
        Scanner stdin = new Scanner(System.in);
        Socket socket = serverSocket.accept();
        System.out.println("Connection established");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("Server listening at port: " + this.port);

        while (true) {

            String str = dis.readUTF();
            System.out.println("Message received: " + str);
            System.out.println("Waiting for input...");
            String input = stdin.nextLine();
            System.out.println("Input received: " + input);
            System.out.println("Input sent to client!");
            dos.writeUTF(input);

            if (str.equals("STOP")) {
                break;
            }
        }

        System.out.println("Stopping server...");
        dos.flush();
        dos.close();
        dis.close();
        serverSocket.close();

    }

}

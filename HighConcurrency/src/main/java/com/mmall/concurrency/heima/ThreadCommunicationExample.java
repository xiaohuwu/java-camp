package com.mmall.concurrency.heima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadCommunicationExample {

    static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server is waiting for connections...");
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Server received: " + inputLine);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread clientThread = new Thread(() -> {
            try (Socket socket = new Socket("localhost", PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                System.out.println("Client is sending a message...");
                out.println("Hello from the client thread!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        // Ensure the server starts first
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clientThread.start();
        System.in.read();
    }
}
